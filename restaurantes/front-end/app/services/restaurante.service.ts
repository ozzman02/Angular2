import { Injectable } from "angular2/core";
import { Observable } from "rxjs/Observable";
import { Http, Response, Headers } from "angular2/http";
import { Restaurante } from "../model/restaurante";
import "rxjs/add/operator/map";

@Injectable() 
export class RestauranteService {

    constructor(private _http:Http) {}

    getRestaurantes() {
        return this._http.get("http://localhost:8080/api/v1/restaurantes").map(res => res.json());
    }

    getRestaurante(id:string) {
        return this._http.get("http://localhost:8080/api/v1/restaurantes/"+id).map(res => res.json());
    }

    addRestaurante(restaurante:Restaurante) {
        delete restaurante.id;
        let body = JSON.stringify(restaurante);
        let headers = new Headers({"Content-Type":"application/json"});
        return this._http
            .post("http://localhost:8080/api/v1/restaurantes", body, {headers:headers})
            .map(res => res.json());
    }

    editRestaurante(id:string, restaurante:Restaurante) {
        console.log(restaurante);
        let body = JSON.stringify(restaurante);
        let headers = new Headers({"Content-Type":"application/json"});
        return this._http
            .put("http://localhost:8080/api/v1/restaurantes", body, {headers:headers})
            .map(res => res.json());
    }

    deleteRestaurante(id:string) {
        return this._http.delete("http://localhost:8080/api/v1/restaurantes/"+id).map(res => res.json());
    }
}