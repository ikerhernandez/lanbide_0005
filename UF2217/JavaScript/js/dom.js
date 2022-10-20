'use strict';

window.addEventListener('DOMContentLoaded', async function(){

    const h1 = document.querySelector('h1');

    // console.log(h1);

    h1.innerText = 'Modificado desde JavaScript';

    const p = this.document.querySelector('p');

    p.style.display = 'none';

    const form = document.querySelector('form');

    form.addEventListener('submit', (evento) => {
        evento.preventDefault();

        const inputNombre = document.getElementById('nombre');
        const spanSaludo = document.getElementById('saludo');

        // console.log(inputNombre);
        // console.log(spanSaludo);

        spanSaludo.innerText = 'Hola ' + inputNombre.value;
    });

    // const bdd = [
    //     {id : 1, nombre : "Javier"},
    //     {id : 2, nombre : "Pepe"},
    //     {id : 3, nombre : "Prueba"}
    // ]

    const respuesta = await fetch('http://localhost:3000/personas');

    console.log(respuesta);

    const bdd = await respuesta.json();

    console.log(bdd);

 

    let ul = document.getElementById('lista');

    let li;

    for (let fila of bdd){
        li = document.createElement('li');

        li.innerHTML = fila.id + ' ' + fila.nombre;

        // console.log(li);

        ul.appendChild(li);
    }
});