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
var RestaurantesListComponent = (function () {
    function RestaurantesListComponent(_restauranteService) {
        this._restauranteService = _restauranteService;
        this.titulo = "Listado de restaurantes";
    }
    RestaurantesListComponent.prototype.ngOnInit = function () {
        this.loading = 'show';
        this.getRestaurantes();
    };
    RestaurantesListComponent.prototype.getRestaurantes = function () {
        var _this = this;
        this._restauranteService.getRestaurantes()
            .subscribe(function (result) {
            _this.restaurantes = result.data;
            _this.status = result.status;
            if (_this.status !== "success") {
                console.log("Error en el servidor");
            }
            _this.loading = 'hide';
        }, function (error) {
            _this.errorMessage = error;
            if (_this.errorMessage != null) {
                console.log(_this.errorMessage);
            }
        });
    };
    RestaurantesListComponent.prototype.onBorrarRestaurante = function (id) {
        var _this = this;
        this._restauranteService.deleteRestaurante(id)
            .subscribe(function (result) {
            _this.status = result.status;
            if (_this.status !== "success") {
                console.log("Error en el servidor");
            }
            _this.getRestaurantes();
        }, function (error) {
            _this.errorMessage = error;
            if (_this.errorMessage != null) {
                console.log(_this.errorMessage);
            }
        });
    };
    RestaurantesListComponent.prototype.onBorrarConfirm = function (id) {
        this.confirmado = id;
    };
    RestaurantesListComponent.prototype.onCancelarConfirm = function (id) {
        this.confirmado = null;
    };
    RestaurantesListComponent = __decorate([
        core_1.Component({
            selector: "restaurantes-list",
            templateUrl: "app/view/restaurantes-list.html",
            directives: [router_deprecated_1.ROUTER_DIRECTIVES],
            providers: [restaurante_service_1.RestauranteService]
        }), 
        __metadata('design:paramtypes', [restaurante_service_1.RestauranteService])
    ], RestaurantesListComponent);
    return RestaurantesListComponent;
}());
exports.RestaurantesListComponent = RestaurantesListComponent;
//# sourceMappingURL=restaurantes-list.component.js.map