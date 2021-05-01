class Persona{ 

    constructor(nom, edat, caracter){
        this._nom = nom;
        this._edat = edat;
        this._caracter = caracter 
        this._bonaGent = true;
    }
    
    
    //METODES DE LA CLASSE
    parlar(paraula){
        console.log("Estic dient: " +paraula);
    }
    
    caminar(){
        console.log("Estic caminant");
    }

    creixer(numAnys){
        console.log("Abans tenia " + this._edat+ " anys");
        this._edat +=  numAnys;
        console.log("Ara tinc " + this._edat+ " anys");
    }

}