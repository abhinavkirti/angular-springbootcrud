import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HospitalService {

  private baseUrl = 'http://localhost:8080/info/hospital';

  constructor(private http: HttpClient) { }

  getHospital(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
}
createHospital(employee: Object): Observable<Object> {
  return this.http.post(`${this.baseUrl}`, employee);
}
updateHospital(id: number, value: any): Observable<Object> {
  return this.http.put(`${this.baseUrl}/${id}`, value);
}
deleteHospital(id: number): Observable<any> {
  return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
}
getHospitalList(): Observable<any> {
  return this.http.get(`${this.baseUrl}`);
}
}
