let pers1 = new Persona ("Marta", 30, "Amable");
let pers2 =  new Nado("Dani", 1, "Nervios", false);


////////////////////////////////
//Utilitzan el polimorfisme
////////////////////////////////
console.log("////////////////POLIMORFISME");

pers1.caminar();		        //utilitzant un mètode
pers1.caminar(10, "nike");		//utilitzant el mateix mètode però sobrecàrregat (no funciona a JS)
pers1.caminar("nike", 10);      //utilitzant el mateix mètode però sobrecàrregat (no funciona a JS)



//polimorfisme dinàmic si que funciona a JS
pers2.parlar("hola");
pers2.caminar();