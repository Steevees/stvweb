/**
 * Comments Js fn
 * 
 * Nxt page fn
 */

function  sm() {
	
	

var xhttp = new XMLHttpRequest();
var cmt=  document.getElementById("comment").value;
var userid= document.getElementById("usr").value;




xhttp.onreadystatechange = function() {
if (this.readyState == 4 && this.status == 200) {

	document.getElementById("respon").innerHTML =
	      this.responseText;
document.getElementById("comment").value="";
document.getElementById("usr").value="";
}
};
xhttp.open("POST", "webcmt?cmnt="+cmt+'&userid=' + userid, true);
xhttp.send();


}

function  nxt() {
	
	window.location.href = "example.html";
	
	
}

