import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Personel } from './../model/personel';

@Injectable({
  providedIn: 'root'
})
export class PersonelService {
  constructor(private http: HttpClient) { }


  getPersoneller(): Observable<Personel[]> {
    return this.http.get<Personel[]>('http://localhost:8080/personeller');
  }
  personellerSil(idler: number[]) {
    return this.http.delete('http://localhost:8080/personel', { body: { idler } });
  }
}
