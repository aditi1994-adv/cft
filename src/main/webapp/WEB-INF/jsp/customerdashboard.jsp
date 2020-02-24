<%@include file="header.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ page import="com.cft.model.AuditLogs" %>
<style>
.a-hover a:hover{
color: #fff;
text-decoration: none;
}
.direct-customer-chat {
	padding: 30px 10px;
}

.chat-static-window {
	max-width: 600px;
	margin: 0 auto;
	border-radius: 4px;
}

.direct-chat-popup_one {
	border-top-right-radius: 12px;
	border-top-left-radius: 12px;
	border: 1px solid #eaeaea;
}

.chat-heading01 {
	background: #026493;
}

.chat-scroll ul {
	height: 100%;
}

.message-box01 {
	padding: 1%;
	border-top: 1px solid #eaeaea;
}

.message-box01 input {
	margin: 0;
	width: 100%;
	padding: 0 30px 0 10px;
}

.message-box01 {
	position: relative;
}
.chat-heading01 p {
	margin: 0;
}
.send_msg {
	position: absolute;
	right: 6px;
	top: 6px;
	background: #eaeaea;
	color: #026493;
	height: 30px;
	line-height: 30px;
	text-align: center;
	width: 30px;
	border-top-right-radius: 25px;
	border-bottom-right-radius: 25px;
}
.direct-chat-popup_one .chat-login-box01 {
    overflow: inherit;
}
.chat-list-details01 li.sender-user span, .chat-list-details01 li.reciver-user span {
	font-size: 14px;
}
</style>
<main> 

				<%-- 	<%
					
					AuditLogs str2=	(AuditLogs)	session.getAttribute("customerSession");
					if (session.getAttribute("customerSession") == null) {
					%>

				<script>
				
				 window.location.assign("index")
				</script>
					<%
						}
								%>
							 --%>

<h3 class="mt-50 head-bg text-center" style="margin-bottom: 0;"
	data-aos="fade-down">Chat with Agent</h3>
	
	
<div class="direct-customer-chat">
	<div class="chat-static-window">
		<div class="chat-static-list">
			<div class="direct-chat-popup_one">
				<h4 class="chat-heading01">
					<p>
						Shipment - <span>${shipmentId}</span>
					</p>
					<p  class="a-hover"><span><a href="javascript:void(0)" onclick="shipmentChatClose()">Close</a></span></p>
				</h4>
				<div class="chat-login-box01 chat-scroll" id="chat-ajax-loader">
					<ul class="chat-list-details01 chat-user-list01">

					</ul>
				</div>
				<div class="message-box01">
					<input type="hidden" value="${shipmentId}" id="shipmentId">
					
					<input type="text" placeholder="Send a message" name="message"
						autocomplete="Off" id="sendMessageToAgent"  style="display: none;"> 
						
						<a 	href="javascript:void(0)" class="send_msg" id="tag"  onclick="sendMessage();"><i class="zmdi zmdi-arrow-right"></i></a>
					
					
						<input type="text" placeholder="Send a message" name="message"
						autocomplete="Off" id="sendMessageToAgentNotify"  > 
						
						<a 	href="javascript:void(0)" class="send_msg" id="sendMessageToAgentNotifyTag"  onclick="sendMessageNotify();"><i class="zmdi zmdi-arrow-right"></i></a>
					
					
						
					
					
					
					
				</div>
			</div>
		</div>
	</div>
</div>

   

<script type="text/javascript">
  $(document).ready(function() {
	  history.pushState(null, null, location.href);
	    window.onpopstate = function () {
	        history.go(1);
	    };
  });
</script>

<input type="hidden" value="${shipmentId}" id="sessionShipment">
	
</main>
<!-- ========================== -->

<%@include file="footerAfterLogin.jsp"%>