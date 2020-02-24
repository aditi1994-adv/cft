<%@include file="header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<style>
.chat-open-set form button {
	    color: #fff;
    background: #12c8fc;
    padding: 3px 10px 2px 10px;
    border-radius: 15px;
    border: none;
}
</style>
<main>
  <h3 class="mt-50 head-bg text-center" data-aos="fade-down">Service
    Login
  </h3>
  <div class="container success">
    <div class="row">
      <div class="login-section-form">
        <div class="table-responsive">
          <table class="table table-stripte">
            <thead>
              <tr>
                <th>Shipment Number</th>
                <th>Shipment Current Status</th>
                <th>Created Date/Time</th>
                <th>Chat</th>
              </tr>
            </thead>
            <tbody class="trrepeat">
              <c:forEach  items="${shipmentRecord}" var="lang">
                <tr>
                <tr class="trtremove">
                  <td> ${lang.shipmentId}</td>
                  <td> ${lang.shipmentStatusValue}</td>
                  <td>
                    ${lang.createdOn}
                  </td>
                  <td class="chat-open-set">
                   <%--  <a href="#" onclick="return false; "  id="${lang.shipmentId}"><i class="zmdi zmdi-comment "></i></a>
                 --%>
                 
               <%--   <form action="customerdashboard" method="post">
                 <input type="hidden" value="${lang.shipmentId}" name="shipmentId"> --%>
                 <!--   <a href="#"><i class="zmdi zmdi-comment "></i></a>
                  -->  
                  <a href="customerdashboard?shipmentId=${lang.shipmentId}"><i class="zmdi zmdi-comment "></i></a>
                  <!--  <button type="submit"><i class="zmdi zmdi-comment "></i></button>
                 </form> -->
                 
            
                  </td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
  <div id="chat-popup_one">
    <i class="zmdi zmdi-comment"></i><i
      class="zmdi zmdi-close zmdi-close01 transform-zero01"></i>
  </div>
 <%--  <div id="chat-room01">
    <h4 class="chat-heading01">
      Chat With Agent<i class="zmdi zmdi-close zmdi-close01"></i>
    </h4>
    <div class="chat-login-box01 text-center">
      <p class="text-center">We will reply here,Or, by mail</p>
      <div class="alert alert-success" id="forMsgDisplay01"
        style="display: none;">
        <span style="padding-left: 1%;" id="successMessage01"> </span> <i
          class="zmdi zmdi-face zmdi-face01"></i>
        <button type="button" class="close01" aria-label="Close">
        <span aria-hidden="true">Thank you</span>
        </button>
      </div>
      <div class="form-group" id="forMsgDisplayError01">
        <div class="alert alert-danger"
          style="display: none; margin-bottom: 0px;">
          <span style="padding-left: 1%;" id="errorMessage01"> </span>
          <button type="button" class="close01" aria-label="Close">
          <span aria-hidden="true">×</span>
          </button>
        </div>
      </div>
      <div class="relative01">
        <textarea placeholer="Your Message" id="msg01" required="required"
          autocomplete="Off"></textarea>
        <span id="errorMsg01"></span>
      </div>
      <div class="relative01">
        <input type="text" placeholder="Name" autocomplete="Off" id="name01"
          required="required"> <span id="errorName01"></span>
      </div>
      <div class="relative01">
        <input type="text" placeholder="Shipment Id" autocomplete="Off" id="shipmentId01"
          required="required"> <span id="shipmentIderror01"></span>
      </div>
      <div class="relative01">
        <input autocomplete="Off" type="email" placeholder="Email"
          id="emailid01" required="required"> <span id="errorEmail01"></span>
      </div>
      <button type="button" class="mail-submit01"
        onclick="sendTokenAgent();">send</button>
      <a href="javascript:void(0)">Already have token? Direct chat</a>
    </div>
    <div class="direct-chat01">
      <p class="chat-close-direct01 text-center">
        <i class="zmdi zmdi-close zmdi-close01"></i>
      </p>
      <p>
        Do you wont to chat so please submit your <strong>TOKEN</strong>
      </p>
      <form>
        <div class="relative01">
          	<input type="text" placeholder="Enter your TOKEN"
            required="required" onselectstart="return false"
            onpaste="return false;" oncopy="return false" oncut="return false"
            ondrag="return false" ondrop="return false" autocomplete="off"
            onkeypress="return event.charCode >= 48 &amp;&amp; event.charCode <= 57 &amp;&amp; event.charCode != 8"
            id="token"> <span id="spanId"></span>
          <input type="text" placeholder="Enter your TOKEN"
            required="required" maxlength="10"
            autocomplete="off"
            onkeypress="return event.charCode >= 48 &amp;&amp; event.charCode <= 57 &amp;&amp; event.charCode != 8"
            id="token01"> <span id="spanId01"></span>
        </div>
        <button type="button" class="" onclick="loginUsingToken();">Submit</button>
      </form>
    </div>
  </div>
  --%>
 
 <%--  <div class="direct-chat-popup_one ">
    <h4 class="chat-heading01">
      Chat <a href="#" class="out01"><i class="zmdi zmdi-close zmdi-close01"></i></a>
    </h4>
    <div class="chat-login-box01 chat-scroll" id="chat-ajax-loader">
      <ul class="chat-list-details01 chat-user-list01">
      </ul>
    </div>
    <div class="message-box01">
      <form:form action="checkToken" modelAttribute="chatApp">
      <input type="text" placeholder="Send a message" name="message"
        autocomplete="Off" id="sendMessageToAgent">
      <!-- <input type="button" onclick="chatWithAdmin()"> -->
      </form:form>
    </div>
  </div> --%>
  <script>
  
    function checkEmail() {
    	var email = $("#email").val();
    	if(email==""){
    		$("#emailError").css('display', 'none');
    		$("#emailError").text("");
    		return true;
    	}
    	
    }
  </script>
  <script>
    function getUserDetail() {
    	var email = $("#email").val();
    	alert(email);
    	if(email==""){
    		$("#emailError").css('display', 'block');
    		$("#emailError").text("blank field");
    		return true;
    	}
    	else{
    		var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    
    		if (re.test(email)) {
    			$("#emailError").text("");
    		}
    		else{
    			$("#emailError").text("Invalid Email Id");
    			return true;
    		}
    		
    	
    	}
    
    $.ajax({
    		url : "custRegisteration",
    		async : true,
    		crossDomain : true,
    		type : "POST",
    		data : "email="+email,
    
    		
    		/*  headers : {
    	           "content-type":"application/json;"
    	             }, */
    		success : function(mssg) {
    			debugger;
    			var myObj = JSON.parse(mssg);
    			var myJSON = JSON.stringify(myObj);
    
    			/* if (Array.isArray(myJSON)) { */
    				
    				console.log(myJSON.length);
    				if (myJSON.length>0) { 
    
    				debugger;
    				$("#pwd").prop("disabled", false);
    				$("#name").prop("disabled", false);
    				$("#emailError").css('display', 'none');
    			}
    			else{
    				debugger;
    				$("#emailError").text("No record found");
    				$("#emailError").css('display', 'block');
    			}
    		}
    	});
    }
  </script> <script src="https://code.jquery.com/jquery-3.2.1.min.js"
    integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
    crossorigin="anonymous" defer></script> <script
    src="resource/js/client_captcha.js" defer></script> <script>
    document.addEventListener("DOMContentLoaded", function() {
    	document.body.scrollTop; //force css repaint to ensure cssom is ready
    
    	var timeout; //global timout variable that holds reference to timer
    
    	var captcha = new $.Captcha({
    		onFailure : function() {
    			$(".captcha-chat .wrong").show(
    					{
    						duration : 30,
    						done : function() {
    							var that = this;
    							clearTimeout(timeout);
    							$(this).removeClass("shake");
    							$(this).css("animation");
    							//Browser Reflow(repaint?): hacky way to ensure removal of css properties after removeclass
    							$(this).addClass("shake");
    							var time = parseFloat($(this).css(
    									"animation-duration")) * 1000;
    							timeout = setTimeout(function() {
    								$(that).removeClass("shake");
    							}, time);
    						}
    					});
    
    		},
    
    		onSuccess : function() {
    			alert("CORRECT!!!");
    		}
    	});
    
    	captcha.generate();
    });
  </script> 
</main>
<%@include file="footer.jsp"%>