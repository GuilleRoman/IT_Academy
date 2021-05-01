let pers1 = new Persona ("Marta", 30, "Amable");

/////////////////////////////
//////accedim a les propietats
/////////////////////////////
console.log(pers1._nom);
pers1._nom = "Nom hackejat";    //això no es deuria permitir!!!!
console.log(pers1._nom);



/////////////////////////////
//accedim als mètodes
////////////////////////////
console.log("////////////////US DE METODES");
pers1.parlar("Soc un objecte de JS");
pers1.caminar();
pers1.creixer(10);

