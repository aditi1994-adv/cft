<%-- <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> --%>
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

<script src="resource/assets/libs/bootstrap/js/bootstrap.min.js"></script>
<script src="resource/assets/libs/rslides/responsiveslides.min.js"></script>
<script src="resource/assets/libs/jquery-ui/jquery-ui.min.js"></script>
<script src="resource/assets/libs/slick/slick.min.js"></script>
<script src="resource/assets/js/aos.js"></script>
<script src="resource/assets/js/main.js"></script>
<script src="resource/assets/js/main_agent.js"></script>
<script src="resource/assets/js/jquery.custom-scrollbar.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>




<script type="text/javascript">

$("#sendMessageToAgentNotify")
.keypress(
		function(event) {
			if (event.which == 13 ) {
				//code here //13 represents Enter key
			sendMessageNotify();
			
			}
		});

function  sendMessageNotify() {
	var msg = $("#sendMessageToAgentNotify").val();
	
	var messageData1=encodeURIComponent(msg)
	var shipmentId=$("#shipmentId").val();

debugger;
	if (messageData1.trim()) {
		$.ajax({
					url : "groupChatNotify",
					async : true,
					crossDomain : true,
					type : "POST",
					data : "message=" + messageData1+"&shipmentId="+shipmentId,
					success : function(layoutData) {
				   
						if(layoutData){
							debugger;
						
							$("#sendMessageToAgentNotify").val('');
							//getMessages(shipmentId,data.token);
							$("#sendMessageToAgentNotifyTag").css('display', 'none');
							$("#sendMessageToAgentNotify").css('display', 'none');
							$("#sendMessageToAgent").css('display', 'block');
							$("#tag").css('display', 'block');
							
							
						debugger;
						 var obj = JSON.parse(layoutData);
						var noti = obj.notify;
						var myObj = JSON.parse(noti);
						
						var message = "";
						$(".reciver-user").remove();
						$(".sender-user").remove();
						for (x in myObj) {
							
							if (myObj[x].status == 2) {
								console.log("myObj status 2="+"li class='reciver-user text-left'><span>");
								$(".chat-user-list01").append('<li class="reciver-user text-left"><span>'+ myObj[x].message+ '</span></li>');
							//	$(".direct-chat-popup_one .chat-scroll").scrollTop($(".direct-chat-popup_one .chat-scroll")[0].scrollHeight);

							} else if (myObj[x].status == 1) {
								$(".chat-user-list01 ").append('<li class="sender-user text-right"><span>'+ myObj[x].message+ '</span></li>');
								}
						}
						}
						
						/* getMessagesFromAgent(shipmentId); */
						/* getlastCount(shipmentId); */
						
					}
				});
	}	

	
}		
	</script>
	
	



<script type="text/javascript">

$("#sendMessageToAgent")
.keypress(
		function(event) {
			if (event.which == 13 ) {
				//code here //13 represents Enter key
			sendMessage();
			
			}
		});

function  sendMessage() {
	var msg = $("#sendMessageToAgent").val();
	
	var messageData=encodeURIComponent(msg)
	
	var shipmentId=$("#shipmentId").val();

	if (messageData.trim()) {
		$.ajax({
					url : "groupChat",
					async : true,
					crossDomain : true,
					type : "POST",
					data : "message=" + messageData+"&shipmentId="+shipmentId,
					success : function(layoutData) {
				   
						if(layoutData){
							$("#sendMessageToAgent").val('');
							//getMessages(shipmentId,data.token);
							
						debugger;
						 var obj = JSON.parse(layoutData);
						var noti = obj.notify;
						var myObj = JSON.parse(noti);
						
						var message = "";
						$(".reciver-user").remove();
						$(".sender-user").remove();
						for (x in myObj) {
							
							if (myObj[x].status == 2) {
								console.log("myObj status 2="+"li class='reciver-user text-left'><span>");
								$(".chat-user-list01").append('<li class="reciver-user text-left"><span>'+ myObj[x].message+ '</span></li>');
							//	$(".direct-chat-popup_one .chat-scroll").scrollTop($(".direct-chat-popup_one .chat-scroll")[0].scrollHeight);

							} else if (myObj[x].status == 1) {
								$(".chat-user-list01 ").append('<li class="sender-user text-right"><span>'+ myObj[x].message+ '</span></li>');
								}
						}
						}
						getMessagesFromAgent(shipmentId);
						/* getlastCount(shipmentId); */
						
					}
				});
	}	

	
}		
	</script>
	
	
<script>
		function getMessagesFromAgent(shipmentId) {
			
			/* console.log("getMessagesFromAgent"+shipmentId); */
			var shipmentDat=shipmentId;
			/* console.log("getMessagesFromAgent"+shipmentDat); */
			
			$.ajax({
						url : "getMessagesFromAgent",
						async : true,
						crossDomain : true,
						type : "POST",
						data : "shipmentId="+shipmentDat,
						success : function(layoutData) {
							
						
							/* console.log("myObj="+layoutData); */
							
							var obj = JSON.parse(layoutData);
							var noti = obj.notify;
							var myObj = JSON.parse(noti);
							
							var message = "";
							$(".reciver-user ").remove();
							$(".sender-user ").remove();

							for (x in myObj) {
						
								if (myObj[x].status == 2) {
							
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
									
								}
							}

						}

					});
			
		}
		
	</script>
	
	
	<script>
	setInterval(function() {
		  var shipmentId=$("#shipmentId").val();
		 /*  console.log("shipmentId interrval == "+shipmentId); */
		  getMessagesFromAgent(shipmentId);
	}, 1000); 
	</script>
	

<script>
	var id=document.getElementById("sessionShipment").value;
	 /*  console.log("shipmentId == "+id); */
	window.localStorage.setItem('shipmentId', id);
	
	
	getMessagesFromAgent(id);
	</script> 

<script>


function shipmentChatClose() {
	
	var shipment =localStorage.getItem("shipmentId");
	localStorage.removeItem("shipmentId");
	window.location.assign("http://103.241.146.152:8080/CFT-Website/redirectedLink")
	
	//window.location.assign("http://localhost:8083/aditi/redirectedLink")
	
	$.ajax({
		url : "clearAgentChat",
		async : true,
		crossDomain : true,
		type : "GET",
		data : "shipmentId="+ shipment,
		success : function(chatLogout) {
			
			
			if(chatLogout=="token_timeout_set"){
				console.log("success");
			}
			else{
				console.log("failure");
			}
			}
		
	});
}

</script>

</footer>

</body>
</html>