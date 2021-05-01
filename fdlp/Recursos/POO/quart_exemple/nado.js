class Nado extends Persona{

    constructor(nom, edat, caracter, dents){
        super(nom, edat, caracter);         //crida al constructor pare
        this._dents = dents;
    }


    
    //GETTERS i SETTERS
    get dents(){
        return this._dents;
    }

    set dents (teDents){
        this._dents = teDents;
    }


    //METODES DE LA CLASSE
    plorar(){
        return "Estic plorant!!!!!";
    }


    //Metodes sobreescrits de la clase pare

    parlar(paraula){
        console.log("ESTOY LLAMANDO AL METODO DEL HIJO");
        super.parlar(paraula);
        console.log("Pero en realitat no se dir res");
    }

    caminar() {
        console.log("Encara NO se caminar");

    }
}