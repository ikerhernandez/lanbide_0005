// var texto = "Persona1";

// datos = {
//     nombre : texto
// }
// console.log(datos);

function arrays() {
    const arr = Array(3);

    arr[0]=1;
    arr[1]=2;
    arr[2]=3;
    
    console.log(arr);
}

function Objetos(){
    const objeto = new Object();

    objeto.nombre = "Javier";
    objeto.apellidos = "Lete";
    objeto["dato"] = "Valor";

    objeto.otro = { profesion: "profesor", materias: ["Java", ".NET"] };

    objeto.apellido = "Lete";
    
    // console.log(objeto.nombreCompleto);      
    console.log(objeto);
    
    objeto.nombreCompleto = function(){
        return `${this.nombre} ${this.apellidos}`;
    }
}

