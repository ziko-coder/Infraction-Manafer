import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, retry} from "rxjs";
import {ValidationErrors} from "@angular/forms";
import {Vehicle} from "../models/vehicle.model";
import { OwnerDetails } from "../models/ownerDetails.model";

//http://localhost:8080/vehicules
const baseUrl = "http://localhost:8080/vehicules/";
@Injectable({
  providedIn: 'root'
})
export class VehiclesService {

  private vehicles! : Vehicle[];
  private errMessage! : string;

  constructor(private http : HttpClient) {
    this.http.get(`http://localhost:8080/vehicules`).subscribe({
      next : data => {
        this.vehicles = data as Vehicle[];
      },
      error : err => {
        this.errMessage = err;
      }
    });
  }

   // http://localhost:8080/vehicules/{regestrationNumber}

   // http://localhost:8080/vehicules/matricules/{12AABB}
   public getOwnerDetailsByRegistrationNumber(regestrationNumber: string): Observable<OwnerDetails> {
    return this.http.get<OwnerDetails>(`http://localhost:8080/vehicules/matricules/${regestrationNumber}`);
  }

  getAllVehicles():Observable<Vehicle[]>{
    return this.http.get<Vehicle[]>(`http://localhost:8080/vehicules`).pipe(retry(1))
  }

  // http://localhost:8080/vehicules
  addVehicle(vehicle : Vehicle): Observable<Vehicle>{
    return this.http.post<Vehicle>(`http://localhost:8080/vehicules`,vehicle);
  }

// http://localhost:8080/vehicules
  editVehicle(vehicle : Vehicle): Observable<Vehicle> {
    return this.http.put<Vehicle>(`http://localhost:8080/vehicules/${vehicle.id}`, vehicle);
  }

  // http://localhost:8080/vehicules
  public deleteVehicle(id: number): Observable<boolean> {
    return this.http.delete<boolean>(`http://localhost:8080/vehicules/${id}`);
  }

  // http://localhost:8080/vehicules/pageVehiculeName/{toyota}
  public searchVehicle(keyword : string) : Observable<any>{
    return this.http.get<any>(`http://localhost:8080/vehicules/PageVehiculeName/${keyword}`);
  }

  // http://localhost:8080/vehicules
  getVehicle(id: number): Observable<Vehicle> {
    return this.http.get<Vehicle>(`http://localhost:8080/vehicules/${id}`);
  }

  getErrorMessage(field: string, error: ValidationErrors) {
    if(error['required']){
      return field + " is Required !";
    } else if(error['maxlength']){
      return field+" should have no more than " + error['maxlength']['requiredLength'] + " Characters !";
    } else if(error['min']) {
      return field + " must be more than " + error['min']['min'] ;
    }else return "Invalid Input!";
  }

  // http://localhost:8080/vehicules/pageVehicule
  // example: http://localhost:8080/vehicules/pageVehicule?page=2&size=2
  getAllVehiclesPages(page: number, size: number) : Observable<any>{
    return this.http.get<any>(`http://localhost:8080/vehicules/pageVehicule?page=${page}&size=${size}`);
  }

  // http://localhost:8080/vehicules/count
  getVehiclesCount(): Observable<number> {
    return this.http.get<number>('http://localhost:8080/vehicules/count');

  }

    // http://localhost:8080/proprietaires/registration/{registrationNumber}
    public getOwnerIdByRegistrationNumber(registrationNumber: string): Observable<number> {
      return this.http.get<number>(`http://localhost:8080/proprietaires/registration/${registrationNumber}`);
    }

      // http://localhost:8080/vehicules/{ownerId}
  public getOwnerById(ownerId: number): Observable<OwnerDetails> {
    return this.http.get<OwnerDetails>(`http://localhost:8080/proprietaires/${ownerId}`);
  }
  

}
