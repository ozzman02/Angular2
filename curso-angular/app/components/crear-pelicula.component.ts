import { Component } from "angular2/core";
import { Pelicula } from "../model/pelicula";
import { PeliculasService } from "../services/peliculas.service";
import { Router } from "angular2/router";

@Component({
    templateUrl: "app/view/crear-pelicula.html",
    providers: [PeliculasService]
})

export class CrearPeliculaComponent {
    
    constructor(private _peliculasService:PeliculasService, private _router:Router) {}

    onCrearPelicula(titulo, director, anio) {
        let pelicula:Pelicula = new Pelicula(77, titulo, director, anio);
        this._peliculasService.insertPelicula(pelicula);
        this._router.navigate(['Peliculas']);
    }
}

