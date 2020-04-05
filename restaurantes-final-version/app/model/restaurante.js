"use strict";
var Restaurante = (function () {
    function Restaurante(id, nombre, direccion, descripcion, imagenId, precio) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.imagenId = imagenId;
        this.precio = precio;
    }
    return Restaurante;
}());
exports.Restaurante = Restaurante;
//# sourceMappingURL=restaurante.js.map