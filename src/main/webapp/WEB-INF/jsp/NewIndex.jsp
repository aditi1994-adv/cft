<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>


<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page isELIgnored="false"%>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
.reciver-user {
	color: green;
	text-align: right;
}

.sender-user {
	color: red;
}

* {
	margin: 0;
	padding: 0;
}

.chat-box {
	width: 100%;
	height: 100vh;
	display: flex;
	justify-content: center;
	align-items: center;
	flex-direction: column;
}

.chat-box h3 {
	margin: 0 0 20px;
	font-size: 25px;
	line-height: 30px;
}

.chat-box ul {
	background: #80808024;
	height: 300px;
	width: 250px;
	border-top-left-radius: 10px;
	border-top-right-radius: 10px;
	display: flex;
	box-sizing: border-box;
	padding: 10px;
	overflow-y: auto;
	flex-direction: column;
	justify-content: flex-end;
	height: 300px;
}

.chat-box ul li {
	list-style-type: none;
	margin: 0 0 8px;
}

.chat-box ul li span {
	display: inline-block;
	min-width: 0px;
	max-width: 200px;
	background: #fff;
	padding: 6px 8px;
}
</style>
<script src="resource/js/jquery-3.4.1.min.js"></script>
<!-- 
  <script type="text/javascript" src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
 -->
</head>
<body>


	<div class="chat-box">
		<h3>Chat Popup </h3>
		<ul class="chat-user-list">
			<!--  <li class="sender-user"><span>chandan</span></li>
			<li class="reciver-user"><span>jack</span></li> -->
		</ul>
		<div>
			<!-- onclick="resetInput()" -->


			<form:form action="chatApp" method="post" modelAttribute="chat">
				<form:input type="text" placeholder="Type a message" path="message" />
				<form:input type="hidden" class="write_msg" placeholder="SenderId"
					value="1" path="senderId" />
				<form:input type="hidden" class="write_msg" placeholder="status"
					value="1" path="status" />
				<button class="msg_send_btn" type="submit">
					<i class="fa fa-paper-plane-o" aria-hidden="true"></i>receiver
				</button>

			</form:form>

		</div>
	</div>

	<script type="text/javascript">
		function resetInput() {
			$("[id='text']").each(function() {

				$(this).val("");

			});
		}
		function onpagelLoad() {
			$.ajax({
				url : "listChat",
				type : "GET",
				success : function(layoutData) {
					var obj = JSON.parse(layoutData);
					var noti = obj.notify;
					var myObj = JSON.parse(noti);
					var message = "";
					$(".reciver-user ").remove();
					$(".sender-user ").remove();
					for (x in myObj) {
					
						if (myObj[x].status == 1) {

							$(".chat-user-list ")
									.append(
											'<li class="reciver-user"><span>'
													+ myObj[x].message
													+ '</span></li>');
						} else if (myObj[x].status == 2) {
							$(".chat-user-list ")
									.append(
											'<li class="sender-user"><span>'
													+ myObj[x].message
													+ '</span></li>');
						}
					}
				}
			});

		}
		setInterval(function() {
			onpagelLoad();
		}, 100);
	</script>

</body>
</html>