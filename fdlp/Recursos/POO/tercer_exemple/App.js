let pers1 = new Persona ("Marta", 30, "Amable");

/////////////////////////////
//Utilitzant metodes de la classe
////////////////////////////
console.log("////////////////US DE METODES");
pers1.parlar("Soc un objecte de JS");
pers1.caminar();
pers1.creixer(10);


////////////////////////////////
//Utilitzan l'herencia
////////////////////////////////
console.log("////////////////HERENCIA");
let pers2 =  new Nado("Dani", 1, "Nervios", false);

console.log(pers2.edat);
pers2.dents = true;                 //accedim a una propietat només de nadons
console.log("te ara dents? " +pers2.dents);

console.log(pers2.plorar());                     //accedim a un metode nomes de nado

pers2.parlar("Soc un Nado");        //accedim a mètodes del pare
pers2.creixer(10);

pers2.caminar();  // accedim a un mètode sobreescrit del pare


pers1.parlar("SOY UNA PERSONA");
pers2.parlar("SOY UN NADO");