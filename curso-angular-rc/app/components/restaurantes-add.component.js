"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require("@angular/core");
var router_deprecated_1 = require("@angular/router-deprecated");
var restaurante_service_1 = require("../services/restaurante.service");
var restaurante_1 = require("../model/restaurante");
var RestauranteAddComponent = (function () {
    function RestauranteAddComponent(_restauranteService, _routeParams, _router) {
        this._restauranteService = _restauranteService;
        this._routeParams = _routeParams;
        this._router = _router;
        this.titulo = "Crear nuevo restaurante";
    }
    RestauranteAddComponent.prototype.onSubmit = function () {
        var _this = this;
        console.log(this.restaurante);
        this._restauranteService.addRestaurante(this.restaurante)
            .subscribe(function (response) {
            _this.status = response.status;
            if (_this.status !== "success") {
                console.log("Error en el servidor");
            }
        }, function (error) {
            _this.errorMessage = error;
            if (_this.errorMessage !== null) {
                console.log(_this.errorMessage);
            }
        });
        this._router.navigate(["Home"]);
    };
    RestauranteAddComponent.prototype.ngOnInit = function () {
        this.restaurante = new restaurante_1.Restaurante(0, this._routeParams.get("nombre"), this._routeParams.get("direccion"), this._routeParams.get("descripcion"), parseInt(this._routeParams.get("imagenId")), "bajo");
    };
    RestauranteAddComponent.prototype.callPrecio = function (value) {
        this.restaurante.precio = value;
    };
    RestauranteAddComponent.prototype.fileChangeEvent = function (event) {
        var _this = this;
        var url = "http://localhost:8080/api/v1/images/upload";
        this.selectedFile = event.target.files[0];
        this.makeFileRequest(url, []).then(function (result) {
            _this.resultUpload = result;
            _this.restaurante.imagenId = _this.resultUpload;
        }, function (error) {
            console.log(error);
        });
    };
    RestauranteAddComponent.prototype.makeFileRequest = function (url, params) {
        var _this = this;
        return new Promise(function (resolve, reject) {
            var uploadImageData = new FormData();
            var xhr = new XMLHttpRequest();
            uploadImageData.append('imageFile', _this.selectedFile, _this.selectedFile.name);
            xhr.onreadystatechange = function () {
                if (xhr.readyState == 4) {
                    if (xhr.status == 200) {
                        resolve(JSON.parse(xhr.response));
                    }
                    else {
                        reject(xhr.response);
                    }
                }
            };
            xhr.open("POST", url, true);
            xhr.send(uploadImageData);
        });
    };
    RestauranteAddComponent = __decorate([
        core_1.Component({
            selector: "restaurante-add",
            templateUrl: "app/view/restaurante-add.html",
            providers: [restaurante_service_1.RestauranteService]
        }), 
        __metadata('design:paramtypes', [restaurante_service_1.RestauranteService, router_deprecated_1.RouteParams, router_deprecated_1.Router])
    ], RestauranteAddComponent);
    return RestauranteAddComponent;
}());
exports.RestauranteAddComponent = RestauranteAddComponent;
//# sourceMappingURL=restaurantes-add.component.js.map