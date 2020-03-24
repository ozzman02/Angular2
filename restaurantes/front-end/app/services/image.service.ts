import { Injectable } from "angular2/core";
import { Observable } from "rxjs/Observable";
import { Http, Response, Headers } from "angular2/http";
import "rxjs/add/operator/map";

@Injectable()
export class ImageService {

    constructor(private _http:Http) {}

    getImage(id) {
        return this._http.get("http://localhost:8080/api/v1/images/"+id).map(res => res.json());
    }
    
}