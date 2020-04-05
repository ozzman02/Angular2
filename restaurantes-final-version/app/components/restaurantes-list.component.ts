import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { RestauranteService } from "../services/restaurante.service";
import { Restaurante } from "../model/restaurante";

@Component({
    selector: "restaurantes-list",
    templateUrl: "app/view/restaurantes-list.html",
    providers: [RestauranteService]
}) 

export class RestaurantesListComponent implements OnInit {
    
    public titulo:string = "Listado de restaurantes";
    public restaurantes:Restaurante[];
    public errorMessage:any;
    public loading:any;
    public status:any;
    public confirmado:any;

    constructor(
        private _restauranteService:RestauranteService,
        private _route:ActivatedRoute,
        private _router:Router
    ) {}

    ngOnInit() {
        this.loading = 'show';
        this.getRestaurantes();
    }

    getRestaurantes() {
        this._restauranteService.getRestaurantes()
            .subscribe(
                result => {
                    this.restaurantes = result.data;
                    this.status = result.status;
                    if (this.status !== "success") {
                        console.log("Error en el servidor");
                    }
                    this.loading = 'hide';
                }, 
                error => {
                    this.errorMessage = <any>error;
                    if (this.errorMessage != null) {
                        console.log(this.errorMessage);
                    }
                }
            );
    }

    onBorrarRestaurante(id) {
        this._restauranteService.deleteRestaurante(id)
            .subscribe(
                result => {
                    this.status = result.status;
                    if (this.status !== "success") {
                        console.log("Error en el servidor");
                    }
                    this.getRestaurantes();
                }, 
                error => {
                    this.errorMessage = <any>error;
                    if (this.errorMessage != null) {
                        console.log(this.errorMessage);
                    }
                }
            );
    }

    onBorrarConfirm(id) {
        this.confirmado = id;
    }

    onCancelarConfirm(id) {
        this.confirmado = null;
    }

}