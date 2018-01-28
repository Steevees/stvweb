/**
 * 
 * Author Steeve
 * 
 * For Displaying Sent Comment Popup
 * 
 *Created On 1/19/2018
 */




	function popup()
	{
		
	var modal = document.getElementById('myModal');
	var span = document.getElementsByClassName("close")[0];
	document.getElementById('alrt').innerHTML="Thanks For Sending Feedback";

	modal.style.display = "block";

	span.onclick = function() {
	    modal.style.display = "none";
	}

	window.onclick = function(event) {
		var modal = document.getElementById('myModal');
	    if (event.target == modal) {
	        modal.style.display = "none";
	    }
	}

	}
	
	




