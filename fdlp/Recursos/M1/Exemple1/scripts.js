function miFuncion(){
    
    //////////////////
    ////////////INPUTS

    ////////////  1 - Recoger valor a traves de un prompt
    var mensaje = window.prompt("Recollint un valor");   
    
    ////////////  2 - Recoger valor de un input text
    let mensaje = document.getElementById("cajaTexto").value;   // IMPLICA TENIR UNA FUNCIO!!!
    
    
    
    /////////////////////
    ///////////// OUTPUTS 

    ////////////  1 - escribir valor en la consola
    console.log(mensaje); 


    ////////////  2 - Dara valor por ejemplo  un párrafo
    document.getElementById("demo").innerHTML = mensaje;
    
    ///////////  3 - Lanzar pop-up
    alert(mensaje);  //podemos prescindir de la palabra "window"



    /////////////////////////////////////////////////////////////////
    //Otra manera de seleccionar el objeto mostrarDatos
    //document.querySelector('#mostrarDatos').innerHTML = "HOLAHOLA";

    //Otra manera de insertar texto
    //document.querySelector('#mostrarDatos').textContent = "HOLAHOLA";

}
