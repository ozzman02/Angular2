import { Component, OnInit } from "angular2/core";
import { RestauranteService } from "../services/restaurante.service";
import { ROUTER_DIRECTIVES, RouteConfig, Router } from "angular2/router";
import { Restaurante } from "../model/restaurante";

@Component({
    selector: "restaurantes-list",
    templateUrl: "app/view/restaurantes-list.html",
    providers: [RestauranteService]
}) 

export class RestaurantesListComponent implements OnInit {
    
    public titulo:string = "Listado de restaurantes";
    public restaurantes:Restaurante[];
    public errorMessage;

    constructor(private _restauranteService:RestauranteService) {}

    ngOnInit() {
        console.log("restaurantes list component cargado");
        this.getRestaurantes();
    }

    getRestaurantes() {
        this._restauranteService.getRestaurantes()
            .subscribe(
                result => {
                    this.restaurantes = result;
                    if (result == null) {
                        console.log("Error en el servidor");
                    }
                    console.log(this.restaurantes);
                }, 
                error => {
                    this.errorMessage = <any>error;
                    if (this.errorMessage != null) {
                        console.log(this.errorMessage.toString());
                    }
                }
            );
    }
}