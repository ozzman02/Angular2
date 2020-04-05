import { Pipe, PipeTransform } from "@angular/core";

@Pipe({ name:"pruebas" })
export class PruebasPipes implements PipeTransform {
    
    transform(value: number, por: number) : string {
        
        //let porv = parseInt(por);
        //let valuev = parseInt(value);

        let result = "La multiplicacion: " + value + " x " + por + " = " + (value * por);

        return result;

    }

}