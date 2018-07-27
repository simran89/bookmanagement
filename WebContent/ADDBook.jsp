<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta name="viewport" content="width=device-width, initial-scale=1"/>

<title>Add Book</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"/>
<link rel ="stylesheet" href="StyleSheet.css"/>
<!--   <script src="http://code.jquery.com/jquery-latest.min.js"></script>
   <script src="http://code.jquery.com/jquery-1.9.0.js"></script>

  <script src="http://code.jquery.com/jquery-migrate-1.1.0.js"> -->
  
</head>

<body>

 
<div class= "outer">
    
  
    	<div class= "inner1top" id ="Header">
        
        	<center>
			<h2>Welcome to our Public Library</h2>
			</center>
    	</div>
    	<div class ="middle">
        <form action = "AddBook" method ="get"><br/><br/><br/><br/>
			Enter Book ID<br></br><input type = "text"   id ="bookid" name ="bookid" onblur="myfunction()"/><div id= "mydiv"> </div><br></br>
			Book Title<br></br><input type = "text" value ="BookTitle" id ="BookTitle" name ="BookTitle" /><br></br>

			
			
	AuthorName<br></br><input type = "text" value ="AuthorName" name="AuthorName"/><br></br>
	publisher<br></br><input type = "text" value ="publisher" name ="publisher"/><br></br>
	Edition<br></br><input type = "text" value ="Edition" name ="Edition"/><br></br>
	InvoiceNo<br></br><input type = "text" value ="InvoiceNo" name ="InvoiceNo"/><br></br>
	invoiceDate<br></br><input type = "text" value ="invoiceDate" name ="invoiceDate"/><br></br>
	cost<br></br><input type = "text" value ="cost" name ="cost"/><br></br>
		<input type = "submit" class ="button" value ="Add Book" name="action"/><br></br>
	</form>
        
    </div>
    <div class= "innerBottom">
        this is bottom
    </div>
         
    
</div>


<script type="text/javascript">
var xmlHttp;
 function myfunction(){
  	 var value = document.getElementById("bookid").value;

  	xmlHttp=GetXmlHttpObject()
  	var url="exist.jsp";
  	url=url+"?bookid="+value;
  	
  	xmlHttp.onreadystatechange=stateChanged;
  	xmlHttp.open("GET",url,true);
  	xmlHttp.send(null);
  	}
  function stateChanged(){ 
  if(xmlHttp.readyState==4 || xmlHttp.readyState=="complete")
  { 
  var showdata = xmlHttp.responseText; 
  alert('ajax response result :'+showdata);
  document.getElementById("mydiv").innerHTML= showdata;
  } 
  }
  function GetXmlHttpObject()
  {
  var xmlHttp=null;
  try{
  xmlHttp=new XMLHttpRequest();
  }
  catch (e) {
  		try {
  	xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
  	}
  	catch (e){
  	xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
  	}
  }
  return xmlHttp;
  }
  </script>
</body>
</html>