
<html>
<style>
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


<body onload="onpagelLOad()">
	<div class="chat-box">
		<h3>Chat Popup</h3>
		<ul class="chat-user-list">
			<li class="sender-user"><span>chandan</span></li>
			<li class="reciver-user"><span>jack</span></li>
		</ul>
	</div>
	
	
	<script src="resource/js/jquery-3.4.1.min.js"></script>
	
	<script type="text/javascript">
		function onpagelLOad() {
		$.ajax({
						url : "listChat",
						type : "GET",
						success : function(layoutData) {
							var obj = JSON.parse(layoutData);
							var noti = obj.notify;
							var myObj = JSON.parse(noti);
							//document.getElementById("headerId").innerHTML = myObj.length;
							var message = "";
							for (x in myObj) {
								//alert("myObj[x] +"+myObj[x].message);
								var type = myObj[x].senderId;
								if (type == 1) {
									/* 	<li class="sender-user"><span>chandan</span></li> */
									$(".chat-user-list").append(
											'<li class="sender-user"><span>'
													+ myObj[x].message
													+ '</span></li>');
								} else if (myObj[x].receiverId == 1) {
									$(".chat-user-list ul").append(
											'<li class="reciver-user"><span>'
													+ myObj[x].message
													+ '</span></li>');

								}

							}

						}

					});
		}
	</script>

</body>





</html>
