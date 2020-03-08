import {Component} from "angular2/core";
import {PeliculasListComponent} from "./components/peliculas-list.component";
import {PeliculasFooterComponent} from "./components/peliculas-footer.component";
import {ROUTER_DIRECTIVES, RouteConfig, Router} from "angular2/router";
import { ContactoComponent } from "./components/contacto.component";

@Component({
    selector: "mi-app",
    templateUrl: "app/view/peliculas.html",
    directives: [
        PeliculasListComponent, 
        PeliculasFooterComponent,
        ContactoComponent,
        ROUTER_DIRECTIVES
    ]
    //styleUrls: ["../assets/css/styles.css"]
}) 

@RouteConfig([
    {path: "/peliculas", name: "Peliculas", component: PeliculasListComponent, useAsDefault: true},
    {path: "/contacto", name: "Contacto", component: ContactoComponent}
])

export class AppComponent {
    public titulo:string = "Peliculas con Angular2";
}