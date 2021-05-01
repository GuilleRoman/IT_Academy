function printarMensaje() {
    
  /// VAR
  var v = 31;
  
  if (v > 1) {
    var v = 71;  // ¡misma variable!
    console.log("var: " + v);  // 71
  }
  console.log("var: " + v);  // 71


  ////// LET
  let l = 31;
  if (l > 1) {
    let l = 71;  // variable diferente
    console.log("let: " + l);  // 71
  }
  console.log("let: " + l);  // 31



  var a = 5;
  var b = 10;

  if (a === 5) {
    let a = 4; // El alcance es dentro del bloque if
    var b = 1; // El alcance es global

    console.log("a: " + a);  // 4
    console.log("b: " + b);  // 1
  }

  console.log("a: " + a); // 5
  console.log("b: " + b); // 1
}

