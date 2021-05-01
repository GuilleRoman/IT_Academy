class Persona{
    
    constructor(nom, edat, caracter){
        this._nom = nom;
        this._edat = edat;
        this._caracter = caracter 
        this._bonaGent = true;
    }
    
    
    //GETTERS i SETTERS
    
    
    getNom(){
        return this._nom;
    }
    
    setNom(x){
        this._nom = x;
    }

    getEdat(){
        return this._edat;
    }

    setEdat(edat){
        this._edat = edat;
    }
    
    //get getEdat(){                     //el nom del get, definirà el objecte.nom
    //    return this._edat;
    //}




    //set setEdat(edat){
    //    this._edat = edat;
    //}
    




    set setEdat(e){                //el nom del get, definirà el objecte.nom
        this._edat = e;
    }
    
    get caracter(){
        return this._caracter;
    }

    //set setCaracter(formaDeActuar){
    //    this._caracter = formaDeActuar;
    //}

    setCaracter(formaDeActuar){
    this._caracter = formaDeActuar;
    }
   
    //METODES DE LA CLASSE
    parlar(paraula){
        console.log("Estic dient: " +paraula);
    }
    
    caminar(){
        return "Estic caminant";
    }

    creixer(numAnys){
        console.log("Abans tenia " + this._edat+ " anys");
        this._edat +=  numAnys;
        console.log("Ara tinc " + this._edat+ " anys");
    }

}