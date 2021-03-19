/*-----------------------------------------------------------------------------
* UTILS.JS
*
* validarTeclatNum(evt)     input només números
* anyTraspas(any)           param int 4 dígits, return true any de traspàs
*
-----------------------------------------------------------------------------*/


   // ---------------------------------------------------
  // validar entrades per teclat només números ----------
 // -----------------------------------------------------
// onkeypress="return validarTeclaNum(event);"
function validarTeclatNum(evt){
    // code es la representació ASCII de la tecla pitjada.
    var code = (evt.which) ? evt.which : evt.keyCode;
                
    if(code==8) { // espai en blanc.
        return false;
    } else if(code>=48 && code<=57) { // Si és un nombre.
        return true;
    } else{ // altres tecles.
        return false;
    }
}

     // ---------------------------------------------------
    // any de traspàs                            ----------
   // @param any     integer de 4 xifres
  // @return true(any de traspàs) false
 // -----------------------------------------------------
 function anyTraspas(any){
    let traspas=false;

    if((any%4==0 && any%100!=0) || (any%400==0)){
        traspas=true;
    }

    return traspas
}



