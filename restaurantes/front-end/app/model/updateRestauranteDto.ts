import { Restaurante } from "./restaurante";

export class UpdateRestauranteDto {
    constructor(
        public id:number,
        public restaurante:Restaurante
    ){} 
}   