import { Component } from "angular2/core";
import { RestaurantesListComponent } from "./components/restaurantes-list.component";
import { ROUTER_DIRECTIVES, RouteConfig, Router } from "angular2/router";

@Component({
    selector: "mi-app",
    templateUrl: "app/view/home.html",
    directives: [
        RestaurantesListComponent,
        ROUTER_DIRECTIVES
    ]
}) 

export class AppComponent {
    public titulo:string = "Restaurantes";
}