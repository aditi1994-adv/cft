<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page isELIgnored="false"%>
<style>
.closenw {
	display: none;
}
#closechat_modal {
	position: fixed;
	left: 0;
	top: 0;
	width: 100%;
	height: 100%;
	align-items: center;
	justify-content: center;
	text-align: center;
  background: rgba(0,0,0,0.7);
  z-index: 9999999;
  transition: all 0.5s;
  display: none;
}
.modal-chat {
	padding: 15px 25px;
  border-radius: 8px;
  width: 300px;
  background: #fff;
  display: flex; 
  justify-content: center;
  align-items: center;
  flex-direction: column;
}
.modal-chat-content {
	margin: 0 0 15px;
  font-weight: bold;
  letter-spacing: 1px;
  font-size: 16px;
  border-bottom: 1px solid #eaeaea;
  padding: 0 0 10px;
}
</style>

<div id="chat-room">
<h4 class="chat-heading">Chat With Admin <i class="zmdi zmdi-close"></i></h4>
<div class="chat-login-box text-center">
	<p class="text-center">We will reply here  by mail
	
	




	</p>
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
		<input type="text" placeholder="Name" autocomplete="Off" id="name"
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
			<%-- <input type="text" placeholder="Enter your TOKEN" required="required"
			onselectstart="return false" onpaste="return false;" onCopy="return false" onCut="return false" onDrag="return false" onDrop="return false" autocomplete=off
			onkeypress="return event.charCode >= 48 && event.charCode <= 57 && event.charCode != 8" id="token"> --%>

			<input type="text" placeholder="Enter your TOKEN"
				required="required"   autocomplete=off
				onkeypress="return event.charCode >= 48 && event.charCode <= 57 && event.charCode != 8"
				id="token"> <span id="spanId"></span>
		</div>
		<button type="button" class="" onclick="loginUsingToken();">Submit</button>

	</form>
</div>
</div>

<div id="closechat_modal">
	<div class="modal-chat">
		<div class="modal-chat-content">
			Do yo want to close your current chat?
		</div>
		<div class="modal-chat-footer text-right">
			<button type="button" class="btn btn-sm btn-primary confirm-chat-fix" data-dismiss="modal">Confirm</button>
			<button type="button" class="btn btn-sm btn-danger cancel-chat-fix" data-dismiss="modal">Cancel</button>
		</div>
	</div>
</div>
<!-- ========================== -->

<%
String sessionOut="";
if (session.getAttribute("userSession") == null || session.getAttribute("userSession").equals("")) 
{
	sessionOut="";
}
else{
	sessionOut="transform-one";
	%>
	
  <script>
        callAjax(window.localStorage.getItem('token'));
        </script>
<%}
%>
	
<div class="direct-chat-popup  <%=sessionOut %>">
	<h4 class="chat-heading">
		Chat <a href="javascript:void(0)" class="out">
		<i class="zmdi zmdi-close"></i></a>
</h4>
<div class="chat-login-box chat-scroll" id="chat-ajax-loader">
	<ul class="chat-list-details chat-user-list">

	</ul>
</div>
<div class="message-box">
	<%-- <form:form action="checkToken" modelAttribute="chatApp"> --%>
	<input type="text" placeholder="Send a message" name="message"
		autocomplete="Off" id="sendMessageAditi">
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
<!-- ========================== -->
<script src="resource/assets/libs/jquery/jquery.js"></script>
<script src="resource/assets/libs/bootstrap/js/bootstrap.min.js"></script>
<script src="resource/assets/libs/rslides/responsiveslides.min.js"></script>
<script src="resource/assets/libs/jquery-ui/jquery-ui.min.js"></script>
<script src="resource/assets/libs/slick/slick.min.js"></script>
<script src="resource/assets/js/aos.js"></script>
<script src="resource/assets/js/main.js"></script>
<script src="resource/assets/js/main_agent.js"></script>
<script src="resource/assets/js/jquery.custom-scrollbar.js"></script>
<script>	

	$(document).on("click", ".direct-chat-popup .chat-heading .out", function() {
		$("#closechat_modal").addClass('d-flex');
	});

	$(document).on("click", ".cancel-chat-fix", function() {
		$("#closechat_modal").removeClass('d-flex');
	});

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

							data : "message=" + messageId + "&name=" + name
									+ "&email=" + mail,
							success : function(mssg) {
debugger;
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
	function loginUsingToken() {
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
		}
	});
</script>
<script type="text/javascript">
	$("#sendMessageAditi")
			.keypress(
					function(event) {
						if (event.which == 13) {
							//code here //13 represents Enter key
							var tokenid = $("#token").val();
							var messageData = $("#sendMessageAditi").val();

							if ($.trim(messageData)) {
								$("#sendMessageAditi").val('');
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

		$
				.ajax({
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

	function adminMessage() {
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
							window.localStorage.setItem('lastCount',
									myObj.length)

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
	});
</script>


</footer>

</body>
</html>