import { Component, OnInit } from "angular2/core";
import { Router, RouteParams } from "angular2/router";
import { RestauranteService } from "../services/restaurante.service";
import { Restaurante } from "../model/restaurante";

@Component({
    selector: "restaurante-edit",
    templateUrl: "app/view/restaurante-add.html",
    providers: [RestauranteService]
})

export class RestauranteEditComponent implements OnInit {
    
    public titulo:string = "Editar restaurante";
    public restaurante:Restaurante;
    public errorMessage:string;
    public status:string;
    public filesToUpload:Array<File>;
    public resultUpload;
    public selectedFile:File;

    constructor(
        private _restauranteService:RestauranteService,
        private _routeParams:RouteParams,
        private _router:Router
    ) {}

    onSubmit() {
        let id = this._routeParams.get("id");
        console.log("Restaurante modificado: " + this.restaurante);
        this._restauranteService.editRestaurante(id, this.restaurante)
            .subscribe(
                response => {
                    this.status = response.status;
                    if (this.status !== "success") {
                        console.log("Error en el servidor")
                    }
                }, 
                error => {
                    this.errorMessage = <any>error;
                    if (this.errorMessage !== null) {
                        console.log(this.errorMessage);
                    }
                }
            );
        this._router.navigate(["Home"]);
    }

    ngOnInit() {
        this.restaurante = new Restaurante(
            parseInt(this._routeParams.get("id")),    
            this._routeParams.get("nombre"), 
            this._routeParams.get("direccion"),
            this._routeParams.get("descripcion"),
            parseInt(this._routeParams.get("imagenId")),
            this._routeParams.get("precio")
        );
        this.getRestaurante();
    }

    callPrecio(value) {
        this.restaurante.precio = value;
    }

    getRestaurante() {
        let id = this._routeParams.get("id");
        this._restauranteService.getRestaurante(id)
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

    fileChangeEvent(event) {
        let url = "http://localhost:8080/api/v1/images/upload";
        this.selectedFile = event.target.files[0];
        this.makeFileRequest(url, []).then(
            (result) => {
                this.resultUpload = result;
                this.restaurante.imagenId = this.resultUpload;
            }, 
            (error) => {
                console.log("Error:" + error);
            }
        );
    } 

    makeFileRequest(url:string, params:Array<string>) {
        return new Promise((resolve, reject) => {
            const uploadImageData = new FormData();
            const xhr = new XMLHttpRequest();
            uploadImageData.append('imageFile', this.selectedFile, this.selectedFile.name);
            xhr.onreadystatechange = function() {
                if (xhr.readyState == 4) {
                    if (xhr.status == 200) {
                        resolve(JSON.parse(xhr.response));
                    } else {
                        reject(xhr.response);
                    }
                }
            }
            xhr.open("POST", url, true);
            xhr.send(uploadImageData);
        });
    }
        
}