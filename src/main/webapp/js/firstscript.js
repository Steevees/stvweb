/**
 * Send Feddback fn
 * 
 * Nxt page fn
 */

$(document).ready(function(){
	
	
    $("#btsbt").on("click", function(){
    	
    	var Email=document.getElementById("email");
    	var Comment=document.getElementById("comment");
    	
       
        
    	var cmt=  document.getElementById("comment").value;
    	var userid= document.getElementById("usr").value;
    	var email= document.getElementById("email").value;
    	
    	
    	
    	
    	if(cmt==="")
    		{
    		
    		document.getElementById("commenttrue").innerHTML = "<font color=red>"+"Drop A FeedBack !"+"</font>";
    		document.getElementById("mailtrue").innerHTML = "";
    		
    		}
    	
    	else if(Email.validity.valueMissing||Email.validity.typeMismatch) {
    		

    		document.getElementById("commenttrue").innerHTML ="";
    		
    		document.getElementById("mailtrue").innerHTML = "<font color=red>"+"Enter A Valid Email Address !"+"</font>";
    		  
    		}
    	
    	else{
    		
            document.getElementById("commenttrue").innerHTML ="";
    		
    		document.getElementById("mailtrue").innerHTML = ""; 	
    		
    		document.getElementById("btsbt").style.display = "none";
    		
    		document.getElementById("btsndng").style.display = "block";
    		
  
        	$.ajax({
    	      type: "POST",
    	      url: "EmailServlet",
    	      data:'cmnt='+cmt+'&userid=' + userid + '&email=' +email,
    	      dataType: "text",
    	      success: function() { 
    	    	  
    	    	  document.getElementById("comment").value="";
    	    	  document.getElementById("usr").value="";
    	    	  document.getElementById("email").value="";
    	    	 
    	    	
    	    	  
    	      }
    	}).done(function(data) { console.log(data); 
    	
    	 popup();
    	
    	document.getElementById("btsbt").style.display = "block";
    		
    	document.getElementById("btsndng").style.display = "none";
    	 })
    	
        .fail(function() { alert("Error"); });
        
    }
        
    });
    
    $("#comment").on("input",function(){
    	
    	var cmt=  document.getElementById("comment").value;
    	
    	if(cmt!="")
		{
		
		document.getElementById("commenttrue").innerHTML = "";
	
		
		}
    	else
    		{
    		
    		document.getElementById("commenttrue").innerHTML = "<font color=red>"+"Drop A FeedBack !"+"</font>";
    		}
        
    });
    	
    	 $("#email").focusout(function(){
    		 
    	 
    	var Email=document.getElementById("email");
    	
    	if((Email.validity.valueMissing||Email.validity.typeMismatch)!=1)
    		{
    		
    		document.getElementById("mailtrue").innerHTML = "";
    		} else
    			{
    			
    			document.getElementById("mailtrue").innerHTML = "<font color=red>"+"Enter A Valid Email Address !"+"</font>";
    			
    			}
        
    });

    $("#btnxt").on("click", function(){
    	
    	
    	window.location.href = "example.html";
        
        
    });
    
    
});
