import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { RestauranteService } from "../services/restaurante.service";
import { Restaurante } from "../model/restaurante";

@Component({
    selector: "restaurante-add",
    templateUrl: "app/view/restaurante-add.html",
    providers: [RestauranteService]
})

export class RestauranteAddComponent implements OnInit {
    
    public titulo:string = "Crear nuevo restaurante";
    public restaurante:Restaurante;
    public errorMessage:string;
    public status:string;
    public filesToUpload:Array<File>;
    public resultUpload;
    public selectedFile:File;

    constructor(
        private _restauranteService:RestauranteService,
        private _router:Router,
        private _route:ActivatedRoute,
    ) {}

    onSubmit() {
        this._restauranteService.addRestaurante(this.restaurante)
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
            this._router.navigate(["/"]);   
    }
    
    ngOnInit() {
        this.restaurante = new Restaurante(0, "", "", "", 0, "bajo");
    }

    callPrecio(value) {
        this.restaurante.precio = value;
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
                console.log(error);
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