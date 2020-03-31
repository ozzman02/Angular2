import { Component, OnInit } from "@angular/core";
import { RouteParams, Router } from "@angular/router-deprecated";
import { RestauranteService } from "../services/restaurante.service";
import { Restaurante } from "../model/restaurante";

@Component({
    selector: "restaurantes-detail",
    templateUrl: "app/view/restaurantes-detail.html",
    providers: [RestauranteService]
}) 

export class RestaurantesDetailComponent implements OnInit {
    
    public parametro:any;
    public restaurante:Restaurante;
    public errorMessage:any;
    public loading:any;
    public status:any;

    constructor(
        private _routeParams:RouteParams, 
        private _router:Router,
        private _restauranteService:RestauranteService
    ) {}
    
    ngOnInit() {
        this.loading = 'show';
        this.getRestaurante();
    }

    getRestaurante() {
        let id = this._routeParams.get("id");
        let random = this._routeParams.get("random");
        this._restauranteService.getRestaurante(id, random)
            .subscribe(
                response => {
                    this.restaurante = response.data;
                    this.status = response.status;
                    if (this.status !== "success") {
                        this._router.navigate(["Home"]);
                    }
                }, 
                error => {
                    this.errorMessage = <any>error;
                    if (this.errorMessage !== null) {
                        console.log(this.errorMessage);
                    }
                }
            );
    }
}
    