<!--
Author: Steeve Issac Saju
Author Email: steeveissacsaju@gmail.com
License: To Be Used Only By Approval Of Author
-->
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate"/>
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>
<meta name="viewport" content="width=device-width, initial-scale=1">
 
 
<!-- CDN REFERENCE-->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  
  <!-- CDN END -->
  <style type="text/css">
  body{
  background-color: "";
 
  
  }
  div {
    border-radius: 5px;
    
    padding: 20px;
}
  select {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
     background-color: #f0f4c3;
}
input[type=submit] {
    width: 100%;
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}


input {
    border: 0;
     background-color: #f0f4c3;
}
  </style>
  <script>
  
  $(document).ready(function(){
	  
	$("#usr").blur(function(){
		
		
	var a =document.getElementById("usr");
  	var xh=new XMLHttpRequest();
	var ul="ajax.html?vala="+a.value;

	xh.open("POST", ul, true);
	xh.send();
	//$.get('GetUserServlet', {userName : name}, function(responseText) {$('#ajaxGetUserServletResponse').text(responseText);
   //    });
//alert("dwf");
	xh.onreadystatechange=function(){
	if(xh.readyState==4 && xh.status==200)

		{
		
		var b=this.responseText.trim();
		
		if(b=="Available")
			{
			
			document.getElementById("avl").innerHTML = "<font color=green>"+b+"</font>";
				
			}  else{
				
			document.getElementById("avl").innerHTML = "<font color=red>"+b+"</font>";
			a.value = "";
				
			}
		}
               };
    
});  });


  
function f1(id,ip,xx)
{	
var a =document.getElementById(ip);
//a.value = a.value.toUpperCase();
if(a.value!="")
	{
	document.getElementById(xx).innerHTML ="";
	document.getElementById(id).style.backgroundColor= '#e3f2fd';
	}
else if(a.value=="")	
	{ 	 
	document.getElementById(xx).innerHTML ="Please enter a valid text";
	document.getElementById(id).style.backgroundColor= '#ffcdd2';
	document.getElementById("avl").innerHTML ="";
	  //var h2s =	document.getElementByById("one");
	  //h2s[0].style.backgroundColor = 'blue';0
	}	
}


  function f2(e) {
    if (e.shiftKey === true ) {
        if (e.which == 9) {
            return true;
        }
       return false;
    }
   if (e.which > 57) {
       return false;
    }
   if (e.which==32) {
       return false;
    }
          return true;
} 

</script>
</head>
<body>
<div class="container">

<h2>Enter Your Details</h2>
 <form action="index.jsp" >
    <div class="form-group">
    <div id="one">
    
      <p>Name:</p><span id="nn"></span><br>
      <input type="text" oninput="f1('one',this.id,'nn')" class="form-control" id="usr" name="name" required="required" placeholder="Enter Name">
      <p id="avl"></p>
      </div>
    
    <div id="two">
      <p>Password:</p><span id="pp"></span><br>
      <input type="password" oninput="f1('two',this.id,'pp')" class="form-control" placeholder="Enter Password" id="pwd" name="pass" required="required">
      </div>
      
      <div id="three">
      <p>Country</p>
    <select id="country" name="country">
      <option value="India">India</option>
      <option value="canada">Canada</option>
      <option value="usa">USA</option>
    </select>
    </div>
    <div>
  <label class="radio-inline"> 
      <input type="radio" name="optradio" checked="checked" value="Male">Male
    </label>
    <label class="radio-inline"> 
      <input type="radio" name="optradio" value="Female">Female
   </label></div>
 
    <div id="four">
     <p>Email:</p><span id="ee"></span><br> <input type="email" oninput="f1('four',this.id,'ee')" class="form-control" id="email" placeholder="Enter email" name="email">
     </div>

  <div id="five">
  <p>Phone</p><span id="pn"></span><br><input type="text" class="form-control" id="inputPhone" onkeydown="return f2(event)"  maxlength="10" name="phone" required="required"  pattern="[0-9]{10}" placeholder="Enter PhoneNumber">
            </div>
    <div class="checkbox">
      <label><input type="checkbox" name="remember"> Remember me</label>
    </div>
    </div>
     <input type="submit" VALUE="SUBMIT" class="btn btn-info">
  </form>
</div>

</body>
</html>