function includeHTML() {
  var z, i, elmnt, file, xhttp;
  /* Loop through a collection of all HTML elements: */
  z = document.getElementsByTagName("*");
  for (i = 0; i < z.length; i++) {
    elmnt = z[i];
    /*search for elements with a certain atrribute:*/
    file = elmnt.getAttribute("w3-include-html");
    if (file) {
      /* Make an HTTP request using the attribute value as the file name: */
      xhttp = new XMLHttpRequest();
      xhttp.onreadystatechange = function() {
        if (this.readyState == 4) {
          if (this.status == 200) {elmnt.innerHTML = this.responseText;}
          if (this.status == 404) {elmnt.innerHTML = "Page not found.";}
          /* Remove the attribute, and call this function once more: */
          elmnt.removeAttribute("w3-include-html");
          includeHTML();
        }
      }
      xhttp.open("GET", file, true);
      xhttp.send();
      /* Exit the function: */
      return;
    }
  }
}
$(document).ready(function(){
  $("#inputUsuario").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#tabla tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});

function confirmarEliminacion(id){
  document.getElementById("userId").value = id;
  document.getElementById("modalEliminar").style.display = 'block';
}

function eliminarPrenda(idGuardarropas, idPrenda){
    $.ajax({
        method: "DELETE",
        url: "prendas/" + idPrenda,
        success: function(){
            window.location.reload();
        },
    });
}
function aceptarAtuendo(idEvento, idAtuendo){
  $.ajax({
    method: "POST",
    url: "/eventos/" + idEvento + "/atuendos/" + idAtuendo + "/aceptar",
    success: function(){
      window.location.reload();
    },
  });
}
function rechazarAtuendo(idEvento, idAtuendo){
  $.ajax({
    method: "POST",
    url: "/eventos/" + idEvento + "/atuendos/" + idAtuendo + "/rechazar",
    success: function(){
      window.location.reload();
    },
  });
}

function cerrarModal(){
  document.getElementsByClassName("modal")[0].style.display = 'none';
}
