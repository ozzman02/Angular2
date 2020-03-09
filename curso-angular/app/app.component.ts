import { Component } from "angular2/core";
import { PeliculasListComponent } from "./components/peliculas-list.component";
import { PeliculasFooterComponent } from "./components/peliculas-footer.component";
import { ContactoComponent } from "./components/contacto.component";
import { CrearPeliculaComponent } from "./components/crear-pelicula.component";
import { ROUTER_DIRECTIVES, RouteConfig, Router } from "angular2/router";

@Component({
    selector: "mi-app",
    templateUrl: "app/view/peliculas.html",
    directives: [
        PeliculasListComponent, 
        PeliculasFooterComponent,
        ContactoComponent,
        CrearPeliculaComponent,
        ROUTER_DIRECTIVES
    ]
    //styleUrls: ["../assets/css/styles.css"]
}) 

@RouteConfig([
    {path: "/peliculas", name: "Peliculas", component: PeliculasListComponent, useAsDefault: true},
    {path: "/crear-pelicula", name: "CrearPelicula", component: CrearPeliculaComponent},
    {path: "/crear-pelicula/:titulo", name: "CrearPeliculaBasadaEnOtra", component: CrearPeliculaComponent},
    {path: "/contacto", name: "Contacto", component: ContactoComponent}
])

export class AppComponent {
    public titulo:string = "Peliculas con Angular2";
}