import { Injectable } from "@angular/core";
import { Observable } from "rxjs/Observable";
import { Http, Response, Headers } from "@angular/http";
import { Restaurante } from "../model/restaurante";
import "rxjs/add/operator/map";

@Injectable() 
export class RestauranteService {

    constructor(private _http:Http) {}

    private url = "http://localhost:8080/api/v1/restaurantes";

    getRestaurantes() {
        return this._http.get(this.url).map(res => res.json());
    }

    getRestaurante(id:string, random = null) {
        if (random == null) {
            return this._http.get(this.url+"/"+id).map(res => res.json());
        } else {
            return this._http.get(`${this.url}/random`).map(res => res.json());
        }
    }

    addRestaurante(restaurante:Restaurante) {
        delete restaurante.id;
        let body = JSON.stringify(restaurante);
        let headers = new Headers({"Content-Type":"application/json"});
        return this._http
            .post(this.url, body, {headers:headers})
            .map(res => res.json());
    }

    editRestaurante(id:string, restaurante:Restaurante) {
        console.log(restaurante);
        let body = JSON.stringify(restaurante);
        let headers = new Headers({"Content-Type":"application/json"});
        return this._http
            .put(this.url, body, {headers:headers})
            .map(res => res.json());
    }

    deleteRestaurante(id:string) {
        return this._http.delete(this.url+"/"+id).map(res => res.json());
    }
}