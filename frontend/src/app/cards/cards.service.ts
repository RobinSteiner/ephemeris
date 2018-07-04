import { Injectable } from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Card} from './card';

// we can now access environment.apiUrl
const API_URL = environment.apiUrl;

@Injectable({
  providedIn: 'root'
})
export class CardsService {

  constructor(private http: HttpClient) { }

  public getCards(date: Date): Observable<Card[]> {
    const params = new HttpParams().set('date', date.toISOString().substring(0, 10));
    console.log(date.toISOString());
    return this.http.get<Card[]>(API_URL + '/card', {params: params});
  }

  public addCards(card: Card): void {
    this.http.put(API_URL + '/card', card);
  }
}
