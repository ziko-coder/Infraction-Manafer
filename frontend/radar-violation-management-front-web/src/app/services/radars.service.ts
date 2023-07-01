import { Injectable } from '@angular/core';
import {Observable, of, retry, throwError} from "rxjs";
import {PageRadar, Radar} from "../models/radar.model";
import {HttpClient, HttpParams} from "@angular/common/http";
import {ValidationErrors} from "@angular/forms";



const baseUrl = "http://localhost:8082/radars/";

@Injectable({
  providedIn: 'root'
})
export class RadarsService {
  private radars! : Radar[];
  private errMessage! : string;

  // all radars: http://localhost:8082/radars
  constructor(private http : HttpClient) {
    this.http.get("http://localhost:8082/radars").subscribe({ 
      next : data => {
        this.radars = data as Radar[];
      },
      error : err => {
        this.errMessage = err;
      }
    });
  }

  // READ: http://localhost:8082/radars
  getAllRadars():Observable<Radar[]>{
    return this.http.get<Radar[]>(baseUrl).pipe(retry(1))
  }

  // CREATE: http://localhost:8082/radars
  addRadar(radar : Radar): Observable<Radar>{
    return this.http.post<Radar>(`http://localhost:8082/radars`,radar);
  }

  // EDIT: http://localhost:8082/radars/${id}
  editRadar(radar : Radar): Observable<Radar> {
    return this.http.put<Radar>(`http://localhost:8082/radars/${radar.id}`,radar);
  }

  // DELETE: http://localhost:8082/radars/${id}
  public deleteRadar(id: number): Observable<boolean> {
    return this.http.delete<boolean>(`http://localhost:8082/radars/${id}`);
  }


  public searchRadar(keyword : string) : Observable<any>{
    return this.http.get<any>(`http://localhost:8082/radars/pageRadarName/${keyword}`);
  }


  getRadar(id: number): Observable<Radar> {
    return this.http.get<Radar>(`http://localhost:8082/radars/${id}`);
  }

  getErrorMessage(field: string, error: ValidationErrors) {
    if(error['required']){
      return field + " is Required !";
    } else if(error['maxlength']){
      return field+" should have no more than " + error['maxlength']['requiredLength'] + " Characters !";
    } else if(error['min']) {
      return field + " must be more than " + error['min']['min'] + " km/h !";
    }else return "Invalid Input!";
  }


  getAllRadarsPages(page: number, size: number) : Observable<any>{
    return this.http.get<any>(`http://localhost:8082/radars/pageRadar?page=${page}&size=${size}`);
  }
  //http://localhost:8082/radars/${id}
  getRadarsCount(): Observable<number> {
    return this.http.get<number>('http://localhost:8082/radars/count');
  }
}
