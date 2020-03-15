import { Component } from "angular2/core";
import { RestaurantesListComponent } from "./components/restaurantes-list.component";
import { RestaurantesDetailComponent } from "./components/restaurantes-detail.component";
import { ROUTER_DIRECTIVES, RouteConfig, Router } from "angular2/router";
import { RestauranteAddComponent } from "./components/restaurantes-add.component";

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
    { path: '/crear-restaurante/', name: "CrearRestaurante", component: RestauranteAddComponent }
])

export class AppComponent {
    public titulo:string = "Restaurantes";
}