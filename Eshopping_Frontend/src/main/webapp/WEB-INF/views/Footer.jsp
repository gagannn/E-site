
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<meta charset="ISO-8859-1">
<style>

*{
margin:0;
padding:0;
}
.footer-background{

background-color:#213236;
color:white;
padding:30px;
}
#myBtn {
  display: none; /* Hidden by default */
  position: fixed; /* Fixed/sticky position */
  bottom: 20px; /* Place the button at the bottom of the page */
  right: 30px; /* Place the button 30px from the right */
 
  border: none; /* Remove borders */
  outline: none; /* Remove outline */
  background-color: #4e666f; /* Set a background color */
  color: white; /* Text color */
  cursor: pointer; /* Add a mouse pointer on hover */
  padding: 15px; /* Some padding */
  border-radius: 10px; /* Rounded corners */
  font-size: 18px; /* Increase font size */
}

#myBtn:hover {
  background-color: #555; /* Add a dark-grey background on hover */
}
</style>
</head>
<body>
<footer class="container-fluid footer-background " id="footer">

                <h4 class="h1 ">Contact</h4>
                <div class="rte-setting"><p>A-37 Bawana, New Delhi, India 110039</p>
<p>7532992250</p>
<p>gagany400@gmail.com</p></div>
              
              
              <button onclick="topFunction()" id="myBtn" title="Go to top"><i class="glyphicon glyphicon-arrow-up"></i></button>
</footer>

<script>
//When the user scrolls down 20px from the top of the document, show the button
window.onscroll = function() {scrollFunction()};

function scrollFunction() {
  if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
    document.getElementById("myBtn").style.display = "block";
  } else {
    document.getElementById("myBtn").style.display = "none";
  }
}

// When the user clicks on the button, scroll to the top of the document
$("#myBtn").click(function() {
	    $('html, body').animate({
	        scrollTop: $("#header").offset().top
	    }, 2000);
	});
</script>
</body>
</html>