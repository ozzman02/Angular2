import {Component} from "angular2/core";
import {Pelicula} from "../model/pelicula";
import {PeliculasService} from "../services/peliculas.service";

@Component({
    selector: "peliculas-list",
    templateUrl: "app/view/peliculas-list.html",
    providers: [PeliculasService]
})

export class PeliculasListComponent {
    
    public pelicula:Pelicula;
    public mostrarDatos:boolean;
    public peliculas:Array<Pelicula>;
    public peliculaElegida:Pelicula;

    constructor(private _peliculasService:PeliculasService) {
        this.mostrarDatos = false;
        this.peliculas = this._peliculasService.getPeliculas();
        this.pelicula = this.peliculas[0];
        this.peliculaElegida = this.peliculas[0];
    }
    
    debug() {
        console.log(this.pelicula);
    }

    onShowHide(value) {
        this.mostrarDatos = value;
    }

    onCambiarPelicula(pelicula) {
        this.pelicula = pelicula;
        this.peliculaElegida = pelicula;
    }
}