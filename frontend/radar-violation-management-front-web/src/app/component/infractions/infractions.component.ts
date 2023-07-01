import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, NgForm, ValidationErrors } from '@angular/forms';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { Infraction } from '../../models/infraction.model';
import {InfractionsService} from "../../services/infractions.service";
import {VehiclesService} from "../../services/vehicles.service";
import { OwnerDetails } from 'src/app/models/ownerDetails.model';
import { HttpClient } from '@angular/common/http';

import pdfMake from "pdfmake/build/pdfmake";
import pdfFonts from "pdfmake/build/vfs_fonts";
import {AuthentificationsService} from "../../services/authentifications.service";
pdfMake.vfs = pdfFonts.pdfMake.vfs;


@Component({
  selector: 'app-infractions',
  templateUrl: './infractions.component.html',
  styleUrls: ['./infractions.component.css']
})
export class InfractionsComponent implements OnInit {
  infractions!: Infraction[];
  errMessage: string = 'Data Not Found!';

  currentPage: number = 0;
  size: number = 4;
  totalPages: number = 0;
  currentAction: string = 'all';
  ownerDetails!: OwnerDetails;

  searchFormGroup!: FormGroup;
  isVehicleInfoVisible: boolean = false;
  selectedVehicleInfraction: any;
  isRadarInfoVisible: boolean = false;
  selectedRadarInfraction: any;
  isInfraInfoVisible: boolean = false;
  selectedInfraInfraction: any;
  ownerIds: { [matricule: string]: number } = {};
  ownerNames: { [matricule: string]: string } = {};

  constructor(
    private infractionsService: InfractionsService,
    private vehiclesService : VehiclesService,
    private fb: FormBuilder,
    private router: Router,
    public authService : AuthentificationsService,
    private http: HttpClient,
  ) {}

  ngOnInit(): void {
    this.searchFormGroup = this.fb.group({
      keyword: this.fb.control(null)
    });
  
    this.infractionsService.getAllInfractions().subscribe(
      (data: Infraction[]) => {
        this.infractions = data;
  
        this.infractions.forEach(infraction => {
          this.vehiclesService.getOwnerIdByRegistrationNumber(infraction.matriculeVehicule).subscribe(
            (ownerId: number) => {
              this.ownerIds[infraction.matriculeVehicule] = ownerId;
              console.log("found Id");
              this.vehiclesService.getOwnerById(ownerId).subscribe(
                (ownerDetails: OwnerDetails) => {
                  this.ownerNames[infraction.matriculeVehicule] = ownerDetails.name;
                },
                error => {
                  console.log('Error fetching owner details for matricule:', infraction.matriculeVehicule);
                }
              );
            },
            error => {
              console.log('Error fetching owner ID for matricule:', infraction.matriculeVehicule);
            }
          );
        });
      },
      (error) => {
        console.error(error);
      }
    );
  }
  
  
  
  onSubmit(form: NgForm) {
    const formData = new FormData();
    formData.append('matricule', form.value.matricule);
    formData.append('id', form.value.id);
    formData.append('vitesseVehicule', form.value.vitesseVehicule);

    this.http.post<any>('http://localhost:8082/radars/generateInfraction', formData)
      .subscribe(
        response => {
          // handle success response
          console.log(response);
        },
        error => {
          // handle error response
          console.error(error);
        }
      );
  }

  getInfractions(): void {
    this.infractionsService
      .getAllInfractions()
  }

  nextPage() {
    if (this.currentPage < this.totalPages - 1) {
      this.currentPage++;
      this.currentPage = this.currentPage++;
      if (this.currentAction === 'all') this.getInfractions();
      else this.handleSearchInfraction();
    }
  }

  previousPage() {
    if (this.currentPage > 0) {
      this.currentPage--;
      this.currentPage = this.currentPage--;
      if (this.currentAction === 'all') this.getInfractions();
      else this.handleSearchInfraction();
    }
  }

  handledeleteInfraction(infraction: Infraction) {
    Swal.fire({
      title: 'Are you sure?',
      text: "You won't be able to revert this!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
      if (result.isConfirmed) {
        Swal.fire('Deleted!', 'Your file has been deleted.', 'success');

        this.infractionsService.deleteInfraction(infraction.id).subscribe({
          next: (data) => {
            let index = this.infractions.indexOf(infraction);
            this.infractions.splice(index, 1);
          }
        });
      }
    });
  }

  handleSearchInfraction() {
    this.currentAction = 'search';
    let keyword = this.searchFormGroup.value.keyword;

    this.infractionsService.searchInfractions(keyword).subscribe({
      next: (data) => {
        this.infractions = data.content;
        this.totalPages = data.totalPages;
      }
    });
  }

  handleNewInfraction() {
    this.router.navigateByUrl('/newInfraction');
  }

  handleEditInfraction(infraction: Infraction) {
    this.router.navigateByUrl('/editInfraction/' + infraction.id);
  }

  showVehicle(i: any) {
    this.isVehicleInfoVisible = true;
    this.selectedVehicleInfraction = i.vehicle;
  }

  showInfraction(i:any){
    this.isVehicleInfoVisible = true;
    this.selectedVehicleInfraction = i.vehicle;
    this.isRadarInfoVisible = true;
    this.selectedRadarInfraction = i.radar;
  }
  showRadar(i: any) {
    this.isRadarInfoVisible = true;
    this.selectedRadarInfraction = i.radar;
  }

  generatePDF(data : any) {
    // Define the document definition
    // Create the document definition
    let documentDefinition = {
      content: [


        { text: '___________________ Infraction Report  ___________________', style: 'header'},

        { text: `ID: ${data.id}` },
        { text: `Date: ${data.date}` },
        { text: `Vehicle Matricule: ${data.vehicleMatricule}` },
        { text: `Vehicle Speed: ${data.vehicleSpeed}` },
        { text: `Radar Max Speed: ${data.radarMaxSpeed}` },
        { text: `Infraction Amount: ${data.infractionAmount}` },

        { text: ` ________________________________________________________________________  ` ,style: 'bigger'},
        { text: `Owne Info :` ,style: 'bigger'},
        { text: `Name : ${data.vehicle.owner.name}`},
        { text: `email : ${data.vehicle.owner.email}` },

        { text: ` ________________________________________________________________________  ` ,style: 'bigger'},

        { text: ` ________________________________________________________________________  ` ,style: 'bigger'},

        { text: `Radar Infos :`, style: 'bigger' },
        {
          layout: 'lightHorizontalLines', // optional
          table: {

            body: [
              [ 'RADAR ID', 'NAME', 'LONGITUDE', 'LATITUDE' ],
              [ { text: `${data.radarId}` }, { text: `${data.radar.name}` }, { text: `${data.radar.longitude}` }, { text: ` ${data.radar.latitude}` }, ],
            ]
          }
        },
        { text: ` ________________________________________________________________________  ` ,style: 'bigger'},

      ],
      styles: {
        header: {
          fontSize: 20,
          bold: true,

        },
        bigger: {
          fontSize: 14,
          bold: true,
        },

      }

    };

// Generate the PDF
    const pdfDocGenerator = pdfMake.createPdf(documentDefinition);
    pdfDocGenerator.download('infraction_report.pdf');

  }


  handleSetPayed(i: any) {
    let p = i.paid;
   i.paid = !p;
  }
}
