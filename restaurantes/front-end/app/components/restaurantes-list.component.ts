import { Component, OnInit } from "angular2/core";
import { RestauranteService } from "../services/restaurante.service";
import { ROUTER_DIRECTIVES, RouteConfig, Router } from "angular2/router";

@Component({
    selector: "restaurantes-list",
    templateUrl: "app/view/restaurantes-list.html",
    providers: [RestauranteService]
}) 

export class RestaurantesListComponent implements OnInit {
    
    public titulo:string = "Listado de restaurantes";
    
    constructor(private _restauranteService:RestauranteService) {

    }

    ngOnInit() {
        console.log("restaurantes list component cargado");
    }
}