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
var core_1 = require('@angular/core');
var router_1 = require('@angular/router');
var restaurante_service_1 = require("../services/restaurante.service");
var restaurante_1 = require("../model/restaurante");
var RestauranteEditComponent = (function () {
    function RestauranteEditComponent(_restauranteService, _router, _route) {
        this._restauranteService = _restauranteService;
        this._router = _router;
        this._route = _route;
        this.titulo = "Editar restaurante";
    }
    RestauranteEditComponent.prototype.onSubmit = function () {
        var _this = this;
        this._route.params.forEach(function (params) {
            var id = params["id"];
            _this._restauranteService.editRestaurante(id, _this.restaurante)
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
            _this._router.navigate(["/"]);
        });
    };
    RestauranteEditComponent.prototype.ngOnInit = function () {
        this.restaurante = new restaurante_1.Restaurante(0, "", "", "", 0, "");
        this.getRestaurante();
    };
    RestauranteEditComponent.prototype.callPrecio = function (value) {
        this.restaurante.precio = value;
    };
    RestauranteEditComponent.prototype.getRestaurante = function () {
        var _this = this;
        this._route.params.forEach(function (params) {
            var id = params["id"];
            _this._restauranteService.getRestaurante(id)
                .subscribe(function (response) {
                _this.restaurante = response.data;
                _this.status = response.status;
                if (_this.status !== "success") {
                    _this._router.navigate(["/"]);
                }
            }, function (error) {
                _this.errorMessage = error;
                if (_this.errorMessage !== null) {
                    console.log(_this.errorMessage);
                }
            });
        });
    };
    RestauranteEditComponent.prototype.fileChangeEvent = function (event) {
        var _this = this;
        var url = "http://localhost:8080/api/v1/images/upload";
        this.selectedFile = event.target.files[0];
        this.makeFileRequest(url, []).then(function (result) {
            _this.resultUpload = result;
            _this.restaurante.imagenId = _this.resultUpload;
        }, function (error) {
            console.log("Error:" + error);
        });
    };
    RestauranteEditComponent.prototype.makeFileRequest = function (url, params) {
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
    RestauranteEditComponent = __decorate([
        core_1.Component({
            selector: "restaurante-edit",
            templateUrl: "app/view/restaurante-add.html",
            providers: [restaurante_service_1.RestauranteService]
        }), 
        __metadata('design:paramtypes', [restaurante_service_1.RestauranteService, router_1.Router, router_1.ActivatedRoute])
    ], RestauranteEditComponent);
    return RestauranteEditComponent;
}());
exports.RestauranteEditComponent = RestauranteEditComponent;
//# sourceMappingURL=restaurantes-edit.component.js.map