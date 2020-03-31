import { Component } from "@angular/core";
import { ROUTER_DIRECTIVES, RouteConfig, Router } from "@angular/router-deprecated";
import { RestaurantesListComponent } from "./components/restaurantes-list.component";
import { RestaurantesDetailComponent } from "./components/restaurantes-detail.component";
import { RestauranteAddComponent } from "./components/restaurantes-add.component";
import { RestauranteEditComponent } from "./components/restaurantes-edit.component";

@Component({
    selector: "mi-app",
    templateUrl: "app/view/home.html",
    directives: [
        RestaurantesListComponent,
        ROUTER_DIRECTIVES
    ]
}) 

@RouteConfig([
    { path: '/', name: "Home", component: RestaurantesListComponent, useAsDefault: true },
    { path: '/restaurante/:id', name: "Restaurante", component: RestaurantesDetailComponent },
    { path: '/crear-restaurante/', name: "CrearRestaurante", component: RestauranteAddComponent },
    { path: '/editar-restaurante/:id', name: "EditarRestaurante", component: RestauranteEditComponent },
    { path: '/donde-como-hoy/:random', name: "DondeComoHoy", component: RestaurantesDetailComponent },
])

export class AppComponent {
    public titulo:string = "Restaurantes";
}