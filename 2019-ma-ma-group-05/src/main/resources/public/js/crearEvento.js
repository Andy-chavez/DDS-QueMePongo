$(document).ready(function(){
$("#submit").click(function(){
var name = $("#name").val();
var email = $("#email").val();
var password = $("#password").val();
var contact = $("#contact").val();
// AJAX Code To Submit Form.
$.ajax({
type: "POST",
url: "/crearEvento",
data: dataString,
cache: false,
success: function(result){
alert(result);
}
});
}
return false;
});
});