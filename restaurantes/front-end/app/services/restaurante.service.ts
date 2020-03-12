import { Injectable } from "angular2/core";
import { Observable } from "rxjs/Observable";
import { Http, Response } from "angular2/http";
import { Restaurante } from "../model/restaurante";
import "rxjs/add/operator/map";

@Injectable() 
export class RestauranteService {

    constructor(private _http:Http) {}

    getRestaurantes() {
        return this._http
            .get("http://localhost/slim/restaurantes-api.php/restaurantes")
            .map(res => res.json());
    }
}