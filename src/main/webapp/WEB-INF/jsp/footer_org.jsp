<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page isELIgnored="false"%>


<style>
.closenw {
	display: none;
}
</style>

<div id="chat-room">
	<h4 class="chat-heading">
		Chat With Admin <i class="zmdi zmdi-close"></i>

	</h4>


	<div class="chat-login-box text-center">
		<p class="text-center">We will reply here  by mail</p>

		<!-- success message -->
		<%-- <c:choose>
				<c:when test="${not empty successMessage}"> --%>
		<div class="alert alert-success" id="forMsgDisplay">
			<span style="padding-left: 1%;" id="successMessage"> <%--  ${successMessage} --%>
			</span> <i class="zmdi zmdi-face"></i>
			<button type="button" class="close" aria-label="Close">
				<!-- 	class="close" data-dismiss="alert" -->
				<span aria-hidden="true">Thank you</span>
			</button>
		</div>
		<%-- </c:when>
				<c:when test="${not empty errorMessage}"> --%>
		<div class="form-group" id="forMsgDisplayError">

			<div class="alert alert-danger"
				style="display: block; margin-bottom: 0px;">
				<span style="padding-left: 1%;" id="errorMessage"> </span>
				<button type="button" class="close" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</div>
		<%-- 	</c:when>

			</c:choose> --%>

		<%-- <form:form action="chat" modelAttribute="chatApp"> --%>
		<div class="relative">
			<textarea placeholer="Your Message" id="msg" required="required"
				autocomplete="Off"></textarea>
			<span id="errorMsg"></span>
		</div>
		<div class="relative">
			<input type="text" placeholder="Subject" autocomplete="Off" id="name"
				required="required"> <span id="errorName"></span>
		</div>
		<div class="relative">
			<input autocomplete="Off" type="email" placeholder="Email"
				id="emailid" required="required"> <span id="errorEmail"></span>
		</div>
		<button type="button" class="mail-submit"
			onclick="messagesubmision();">send</button>
		<a href="javascript:void(0)">Already have token? Direct chat</a>
		<%-- </form:form> --%>
	</div>
	<div class="direct-chat">
		<p class="chat-close-direct text-center">
			<i class="zmdi zmdi-close"></i>
		</p>
		<p>
			Do you wont to chat so please submit your <strong>TOKEN</strong>
		</p>
		<form>
			<div class="relative">
				<%-- 			<input type="text" placeholder="Enter your TOKEN"
					required="required"  onselectstart="return false" onpaste="return false;" onCopy="return false" onCut="return false" onDrag="return false" onDrop="return false" autocomplete=off
					onkeypress="return event.charCode >= 48 && event.charCode <= 57 && event.charCode != 8"
					id="token"> <span id="spanId"></span>
					 --%>
					
						<input type="text" placeholder="Enter your TOKEN"
					required="required" autocomplete=off maxlength="10"
					onkeypress="return event.charCode >= 48 && event.charCode <= 57 && event.charCode != 8"
					id="token"> <span id="spanId"></span>
			</div>
			<button type="button" class="" onclick="loginWithToken();">Submit</button>

		</form>
	</div>
</div>


<div class="direct-chat-popup">
	<h4 class="chat-heading">
		Chat <a href="logOut" class="out"><i class="zmdi zmdi-close"></i></a>
	</h4>
	<div class="chat-login-box chat-scroll" id="chat-ajax-loader">
		<ul class="chat-list-details chat-user-list">

		</ul>
	</div>
	<div class="message-box">
		<%-- <form:form action="checkToken" modelAttribute="chatApp"> --%>
		<input type="text" placeholder="Send a message" name="message"
			autocomplete="Off" id="sendMessage">
		<!-- <input type="button" onclick="chatWithAdmin()"> -->
		<%-- </form:form> --%>
	</div>
</div>
<div id="chat-popup">
	<i class="zmdi zmdi-comment "></i><i class="zmdi zmdi-close"></i>

</div>
<footer>
	<div class="container">
		<div class="row">
			<div class="col-md-12 text-center">
				<h1 class="logo">
					<a href="#"> <!-- <img src="" alt="CCT"> -->CCT
					</a>
				</h1>
				<ul class="contactinfo">
					<li class="address"><strong>Address:</strong> Dummy address</li>
					<li class="phone"><strong>Phone:</strong> +49 123 456 789</li>
					<li class="email"><strong>E-mail:</strong> info@cft.com</li>
				</ul>
				<ul class="social">
					<li><a href="javascript:void(0)"><i
							class="zmdi zmdi-facebook"></i></a></li>
					<li><a href="javascript:void(0)"><i
							class="zmdi zmdi-twitter"></i></a></li>
					<li><a href="javascript:void(0)"><i
							class="zmdi zmdi-google-old"></i></a></li>
					<li><a href="javascript:void(0)"><i
							class="zmdi zmdi-instagram"></i></a></li>
				</ul>
			</div>
			<!-- <div class="col-md-2 col-sm-6 col-xs-12">
				<h6>GET HELP</h6>
				<ul class="information">
					<li><a href="javascript:void(0)">Help and FAQ</a></li>
				</ul>
			</div>
			<div class="col-md-3 col-sm-12 col-xs-12">
				<h6> </h6>
				<ul class="information">
					<li><a href="javascript:void(0)">Legal</a></li>
				</ul>
			</div>
			<div class="col-md-3 col-sm-12 col-xs-12">
				<h6> </h6>
				<ul class="information">
				<li><a href="javascript:void(0)">Privacy Policy</a></li>
					<li><a href="javascript:void(0)">Feedback</a></li>
				</ul>
			</div> -->
		</div>
		<div class="row botbar">
			<div class="col-sm-12">
				<p class="copyright text-center">Copyright 2019 &copy; CFT | All
					Rights Reserved</p>
			</div>
		</div>
	</div>

	<script src="resource/assets/libs/jquery/jquery.js"></script>
	<script src="resource/assets/libs/bootstrap/js/bootstrap.min.js"></script>
	<script src="resource/assets/libs/rslides/responsiveslides.min.js"></script>
	<script src="resource/assets/libs/jquery-ui/jquery-ui.min.js"></script>
	<script src="resource/assets/libs/slick/slick.min.js"></script>
	<script src="resource/assets/js/aos.js"></script>
	<script src="resource/assets/js/main.js"></script>
	<script src="resource/assets/js/jquery.custom-scrollbar.js"></script>
	<script src="resource/assets/js/main_agent.js"></script>
	
	
	
	<script type="text/javascript">
		$("#sendMessageToAgent")
				.keypress(
						function(event) {
							if (event.which == 13) {
								//code here //13 represents Enter key
								var tokenid = $("#token01").val();
								var messageData = $("#sendMessageToAgent").val();

								if ($.trim(messageData)) {
									$("#sendMessageToAgent").val('');
									$
											.ajax({
												url : "groupChat",
												async : true,
												crossDomain : true,
												type : "POST",
												data : "message=" + messageData
														+ "&token=" + tokenid,
												success : function(layoutData) {

													$(
															".direct-chat-popup_one .chat-scroll")
															.scrollTop(
																	$(".direct-chat-popup_one .chat-scroll")[0].scrollHeight);
													getMessages(tokenid);
												}
											});
								}
							}
						});

		
	</script>
	
	
	
	
<script>
		function getMessages(tokenid) {
			
			$.ajax({
						url : "getMessagesUsingToken",
						async : true,
						crossDomain : true,
						type : "POST",
						data : "token=" + tokenid,
						success : function(layoutData) {
						
							var obj = JSON.parse(layoutData);
							var noti = obj.notify;
							var myObj = JSON.parse(noti);
							console.log("myObj="+myObj);
							var message = "";
							$(".reciver-user ").remove();
							$(".sender-user ").remove();

							for (x in myObj) {
							
								if (myObj[x].status == 2) {
							
									console.log("myObj status 2="+"li class='reciver-user text-left'><span>");
									$(".chat-user-list01").append(
											'<li class="reciver-user text-left"><span>'
													+ myObj[x].message
													+ '</span></li>');
									$(".direct-chat-popup_one .chat-scroll")
											.scrollTop(
													$(".direct-chat-popup_one .chat-scroll")[0].scrollHeight);

								} else if (myObj[x].status == 1) {
									
									$(".chat-user-list01 ").append(
											'<li class="sender-user text-right"><span>'
													+ myObj[x].message
													+ '</span></li>');
									/* $(".direct-chat-popup01 .chat-scroll")
											.scrollTop(
													$(".direct-chat-popup01 .chat-scroll")[0].scrollHeight); */

								}
							}

						}

					});
		}

		
		/* setInterval(function() {
			getMessages(window.localStorage.getItem('token'));
		}, 1000); */
		
	/* 	function getlastCount(tokenid) {

			$.ajax({
				url : "getLastMessageCountOfAdmin",
				async : true,
				crossDomain : true,
				type : "POST",
				data : "token=" + tokenid,
				success : function(count) {
					window.localStorage.setItem('lastCount', count);
					window.localStorage.setItem('token', tokenid);

				}

			});
		} */

		/* function adminMessage() {
			var tokenid = window.localStorage.getItem('token');
			
			if( tokenid !=null){
				
			$.ajax({
						url : "getAdminNewMessage",
						async : true,
						crossDomain : true,
						type : "POST",
						data : "token=" + tokenid,
						success : function(layoutData) {
							var obj = JSON.parse(layoutData);
							var noti = obj.notify;
							var myObj = JSON.parse(noti);
							var message = "";
							if (myObj.length > window.localStorage
									.getItem('lastCount')) {
								window.localStorage.setItem('lastCount',myObj.length)
								callAjax(myObj[0].token);
							}
						}
					});
		}
		}
		setInterval(function() {
			adminMessage();
		}, 1000);
		
		$(document).on("click", ".out", function() {
			 localStorage.clear();
		
		return true;
		}); */
	</script>

	


<script>
/* 
customerdashboard */
function sendTokenAgent() {

	var messageId = $("#msg01").val().trim();
	var name = $("#name01").val().trim();
	var mail = $("#emailid01").val().trim();
	var shipment = $("#shipmentId01").val().trim();
	
	if (messageId != "" && name != "" && mail != "" && shipment !="" ) {
		var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
		if (re.test(mail)) {
			$("#errorMsg01").text("");
			$("#errorName01").text("");
			$("#errorEmail01").text("");
			$("#shipmentIderror01").text("");
			$.ajax({
				url : "sendMessageToAgent",
				async : true,
				crossDomain : true,
				type : "POST",
				data : "message=" + messageId + "&name=" + name+ "&email=" + mail+"&shipmentId="+shipment,
				success : function(mssg) {
					var myObj = JSON.parse(mssg);
					if (myObj) {
						if (myObj.response == "Please check your mail to continue chat.") {
							$("#forMsgDisplay01").css('display','flex');
							$("#successMessage01").text(myObj.response);
						} else if (myObj.response == "Please Enter a message") {
							$("#forMsgDisplayError01").css('display', 'flex');
							$("#errorMessage01").text(myObj.response);
						} else {
							$("#forMsgDisplayError01").css('display', 'flex');
							$("#errorMessage01").text(myObj.response);
						}
						$("#msg01").val("");
						$("#name01").val("");
						$("#emailid01").val("");
						$("#errorMsg01").text("");
						$("#errorName01").text("");
						$("#errorEmail01").text("");
						$("#shipmentIderror01").text("");
					} else {
						console.log("Frst time chat");
					}
				}
			});
} else {

	$("#errorEmail01").text("Invalid Email Id");
	return false;
}

} else {
if (messageId == "") {
	$("#errorMsg01").text("Please enter required field");
} else {
	$("#errorMsg01").text("");
}

if (name == "") {
	$("#errorName01").text("Please enter required field");
} else {
	$("#errorName01").text("");
}
if (mail == "") {
	$("#errorEmail01").text("Please enter required field");
}
else {
	$("#errorEmail01").text("");
}
if (shipment == "") {
	$("#shipmentIderror01").text("Please enter required field");
}
else {
	$("#shipmentIderror01").text("");
}

}

}
</script>


<script>
/* customer dashboard chat  */

function getRecords() {
var bill = $('#billNo').val().trim();
var shipmentNo = $('#shipmentId').val().trim();
var email_address = $('#email').val().trim();
if(shipmentNo=="" && email_address==""){
	alert("Please fill the madatory details");
	return false;
}
else{
  //$("#data-submit").removeClass("disabled");
  	$.ajax({
       url: "shipment",
       async:true,
      crossDomain:true,
      type: "POST",
      data:  "email="+email_address+ "&billNo="+bill+"&shipmentId="+shipmentNo,
    success: function(result) {
      var myJSON = JSON.stringify(result);
      var obj = JSON.parse(myJSON);
      console.log(obj);
      $(".trtremove").remove();
      if(obj.length==0){
    	  $(".trrepeat").append('<tr class="trtremove"><td colspan="4" class="text-center">'+"No Record Found" +  '</td></tr>');
    	  $('#billNo').val('');
    	  $('#shipmentId').val('');
    	  $('#email').val('');
      }
      else{
    	  console.log(result);
    	  $(".trtremove").remove();
    		  var ms =  obj.createdOn;
    		  var d = new Date(+ms);
              var time=d.toLocaleTimeString();
              var date = d.toLocaleDateString("en-US");
              console.log("date  "+ date+"  time  "+time);
              console.log("obj.length "+obj.length);
            	  $(".trrepeat").append('<tr class="trtremove"><td>'+ obj.shipmentId+'</td><td>'+obj.status+'</td><td>' +date+'</td><td>'+ time+ '</td><td class="chat-open-set"><a href="#" onclick="return false;"><i class="zmdi zmdi-comment "></i></a></td></tr>');
                  $('#billNo').val('');
            	  $('#shipmentId').val('');
            	  $('#email').val('');
    	 }
    }
});

}

}


</script>



	<script>
		$(document).on("click", ".close", function() {
			$("#forMsgDisplay").css('display', 'none');
		});

		$(document).on("click", ".close", function() {
			$("#forMsgDisplayError").css('display', 'none');
		});

		function messagesubmision() {
			var messageId = $("#msg").val().trim();
			var name = $("#name").val().trim();
			var mail = $("#emailid").val().trim();
			if (messageId != "" && name != "" && mail != "") {
				var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

				if (re.test(mail)) {
					$("#errorMsg").text("");
					$("#errorName").text("");
					$("#errorEmail").text("");
					//	alert("validateEmail===true");
					$
							.ajax({
								url : "chat",
								async : true,
								crossDomain : true,
								type : "POST",

								data : "message=" + messageId + "&subject=" + name
										+ "&email=" + mail,
								success : function(mssg) {

									var myObj = JSON.parse(mssg);

									if (myObj) {
										if (myObj.response == "Please check your mail to continue chat.") {
											$("#forMsgDisplay").css('display',
													'flex');
											$("#successMessage").text(
													myObj.response);

										} else if (myObj.response == "Please Enter a message") {
											$("#forMsgDisplayError").css(
													'display', 'flex');
											$("#errorMessage").text(
													myObj.response);

										} else {
											$("#forMsgDisplayError").css(
													'display', 'flex');
											$("#errorMessage").text(
													myObj.response);

										}

										$("#msg").val("");
										$("#name").val("");
										$("#emailid").val("");
										$("#errorMsg").text("");
										$("#errorName").text("");
										$("#errorEmail").text("");

									} else {
										console.log("Frst time chat");
									}
								}
							});
				} else {

					$("#errorEmail").text("Invalid Email Id");
					//alert("validateEmail===false");
					return false;
				}

			} else {
				if (messageId == "") {
					$("#errorMsg").text("Please enter required field");
				} else {
					$("#errorMsg").text("");
				}

				if (name == "") {
					$("#errorName").text("Please enter required field");
				} else {
					$("#errorName").text("");
				}
				if (mail == "") {
					$("#errorEmail").text("Please enter required field");
				}

				else {
					$("#errorEmail").text("");
				}

			}

		}
	</script>

	<script type="text/javascript">
		function loginWithToken() {
			var tokenid = $("#token").val().trim();
			if (tokenid == '') {
				$("#spanId").text("Please Enter  Token");
				return false;
			} else {
				$("#spanId").text("");
				$
						.ajax({
							url : "loginWithToken",
							async : true,
							crossDomain : true,
							type : "POST",
							data : "token=" + tokenid,
							success : function(layoutData) {

								if (layoutData) {

									var obj = JSON.parse(layoutData);
									var noti = obj.notify;
									var myObj = JSON.parse(noti);
									if (myObj[0].response == "Invalid Token") {

										$("#spanId").text(
												"Please Enter correct Token");
									} else {
										$(".direct-chat-popup").addClass(
												"transform-one");
										$("#chat-room").removeClass(
												"transform-one");
										$("#spanId").css({
											'display' : 'none'
										});
										$("#token").val('');
										callAjax(tokenid);
										getlastCount(tokenid);
									}

								}

							}
						});
			}
		}

		var tokenid = $("#token").val();
		$.ajax({
			url : "logOut",
			async : true,
			crossDomain : true,
			type : "GET",
			data : "token=" + tokenid,
			success : function(layoutData) {
				console.log(layoutData);
		
				var obj = JSON.parse(layoutData);
				var noti = obj.notify;
				var myObj = JSON.parse(noti);
			console.log(myObj);
				if (myObj) {
					if (myObj.response == "Session Expired") {
						$("#forMsgDisplay").css('display','flex');
						$("#successMessage").text(myObj.response);

					
					} else {
						$("#forMsgDisplayError").css(
								'display', 'flex');
						$("#errorMessage").text(
								myObj.response);}}
			}
		});
	</script>
	
	<script type="text/javascript">
		$("#sendMessage")
				.keypress(
						function(event) {
							if (event.which == 13) {
								//code here //13 represents Enter key
								var tokenid = $("#token").val();
								var messageData = $("#sendMessage").val();

								if ($.trim(messageData)) {
									$("#sendMessage").val('');
									$
											.ajax({
												url : "chatWithAdmin",
												async : true,
												crossDomain : true,
												type : "POST",
												data : "message=" + messageData
														+ "&token=" + tokenid,
												success : function(layoutData) {

													$(
															".direct-chat-popup .chat-scroll")
															.scrollTop(
																	$(".direct-chat-popup .chat-scroll")[0].scrollHeight);
													callAjax(tokenid);
												}
											});
								}
							}
						});

		
	</script>
	
	
	<script>
		function callAjax(tokenid) {

			$.ajax({
						url : "checkToken",
						async : true,
						crossDomain : true,
						type : "POST",
						data : "token=" + tokenid,

						success : function(layoutData) {
							var obj = JSON.parse(layoutData);
							var noti = obj.notify;
							var myObj = JSON.parse(noti);
							var message = "";
							$(".reciver-user ").remove();
							$(".sender-user ").remove();

							for (x in myObj) {
								if (myObj[x].status == 2) {
									$(".chat-user-list").append(
											'<li class="reciver-user text-left"><span>'
													+ myObj[x].message
													+ '</span></li>');
									$(".direct-chat-popup .chat-scroll")
											.scrollTop(
													$(".direct-chat-popup .chat-scroll")[0].scrollHeight);

								} else if (myObj[x].status == 1) {
									$(".chat-user-list ").append(
											'<li class="sender-user text-right"><span>'
													+ myObj[x].message
													+ '</span></li>');
									$(".direct-chat-popup .chat-scroll")
											.scrollTop(
													$(".direct-chat-popup .chat-scroll")[0].scrollHeight);

								}
							}

						}

					});
		}

		


		
		function getlastCount(tokenid) {

			/* debugger; */
			$.ajax({
				url : "getLastMessageCountOfAdmin",
				async : true,
				crossDomain : true,
				type : "POST",
				data : "token=" + tokenid,
				success : function(count) {
					
					var prevCount = window.localStorage.getItem("lastCount");
					
					if(prevCount == 'null' || prevCount == null){
						prevCount = "0";
					}
					
					var newCount = parseInt(count);
					var oldCount = parseInt(prevCount);
					
					if(newCount > oldCount){
						
						callAjax(tokenid);
						
						window.localStorage.setItem('lastCount', count);
						window.localStorage.setItem('token', tokenid);
						
					}
					window.localStorage.setItem('token', tokenid);
					
					
					

				}

			});
		}


setInterval(function() {
	getlastCount(window.localStorage.getItem('token'));
}, 1000);
 
		/* function adminMessage() {
			var tokenid = window.localStorage.getItem('token');
			
			if( tokenid !=null){
				
			$.ajax({
						url : "getAdminNewMessage",
						async : true,
						crossDomain : true,
						type : "POST",
						data : "token=" + tokenid,
						success : function(layoutData) {
							var obj = JSON.parse(layoutData);
							var noti = obj.notify;
							var myObj = JSON.parse(noti);
							var message = "";
							if (myObj.length > window.localStorage
									.getItem('lastCount')) {
								window.localStorage.setItem('lastCount',myObj.length)
								callAjax(myObj[0].token);
							}
						}
					});
		}
		}
		setInterval(function() {
			adminMessage();
		}, 1000);
		 
		$(document).on("click", ".out", function() {
			 localStorage.clear();
		
		return true;
		});*/
	</script>

<script type="text/javascript">
		function loginUsingToken() {
			
			var tokenid = $("#token01").val().trim();
			if (tokenid == '') {
				$("#spanId01").text("Please Enter Token");
				return false;
			} else {
				$("#spanId01").text("");
				$.ajax({
							url : "loginUsingToken",
							async : true,
							crossDomain : true,
							type : "POST",
							data : "token=" + tokenid,
							success : function(layoutData) {
								if (layoutData) {
									var obj = JSON.parse(layoutData);
									var noti = obj.notify;
									var myObj = JSON.parse(noti);
									if (myObj[0].response == "Invalid Token") {
										$("#spanId01").text("Please Enter correct Token");
									} else {
										$(".direct-chat-popup_one").addClass("transform-one01");
										$("#chat-room01").removeClass("transform-one01");
										$("#spanId01").css({'display' : 'none'});
										$("#token01").val('');
										getMessages(tokenid);
										/* 
										getlastCount(tokenid); */
									}

								}

							}
						});
			}
		}
	</script>
	
	


</footer>

</body>
</html>