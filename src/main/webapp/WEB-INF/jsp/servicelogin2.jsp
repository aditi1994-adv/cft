<%@include file="header.jsp"%>
<main>
<h3 class="mt-50 head-bg text-center" data-aos="fade-down">Service
	Login</h3>
<div class="container success">
	<div class="row">
		<div class="login-section-form">
			<form action="custRegisteration" class="row" method="post">
				<div class="form-group email-field">
				  <div>
					<label for="email">Email</label> 
					<div class="input-submit">
						<p>
						<input type="email"
						 class="form-control" id="email" onkeyup="checkEmail(this.value)"
						autocomplete="off" name="email">
						<button type="button" class="btn btn-primary" onclick="getUserDetail();">Send OTP</button>
						</p>
						<span id="emailError"></span>
					</div>
				  </div>
				  <div> 
						<label for="pwd">Password</label>
					<input type="password" class="form-control disFalse" id="pwd"
						disabled="disabled" autocomplete="off" name="password">
				  </div>
				  <div>
						 <label
						for="use_name">Name</label> <input type="text"
						class="form-control disFalse" id="name" disabled="disabled"
						autocomplete="off" name="name">
				  </div>
				  

				<div class="captcha-chat">
				<label>Enter Captcha</label>
					<div class="captcha-container media">
						<div id="captcha">
							<div class="controls">
								<input class="user-text btn-common" placeholder="Type here"
									type="text" />
								<!-- 	<button class="validate btn-common">
									this image should be converted into inline svg
									<img src="resource/assets/images/enter_icon.png"
										alt="submit icon">
								</button> -->
								<button class="refresh btn-common" type="button">
									<!-- this image should be converted into inline svg -->
									<img src="resource/assets/images/refresh_icon.png"
										alt="refresh icon">
								</button>
							</div>
						</div>
						<p class="wrong info">Wrong!, please try again.</p>
					</div>
				</div>
				<div class="col-sm-12 text-right">
					<button type="submit" class="btn btn-primary" style="width: 100%;">Submit</button>
				</div>
				  
				</div>


			</form>
		</div>



	</div>
</div>


<script>

function checkEmail() {
	var email = $("#email").val();
	if(email==""){
		$("#emailError").css('display', 'none');
		$("#emailError").text("");
		return true;
	}
	
}</script>
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
	</script> </main>
<%@include file="footer.jsp"%>