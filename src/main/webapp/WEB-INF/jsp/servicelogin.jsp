<%@include file="header.jsp"%>
<style>
.input-submit p button, .ReloadBtn, #btnSubmit {
    width: 18%;
    margin: 0;
    height: 34px;
    line-height: 30px;
    font-size: 14px;
    padding: 0;
    color: #fff;
    background-color: #007bff;
    border-color: #007bff;
}
.email-field {
	padding: 20px;
    border: 1px solid #000;
    border-radius: 6px;
    box-shadow: 0 0 10px -8px #000;
}
</style>
<main>
<h3 class="mt-50 head-bg text-center" data-aos="fade-down">Service
	Login</h3>
<div class="container success">
	<div class="row">
		<div class="login-section-form" style="width: 100%;">
			<form action="customerLogin" class="row" method="post"
				onsubmit="return checkCaptcha();">
				<div class="form-group email-field">
				<span id="successMessage01"></span>
					<div>
						<label for="email">Email</label>
						<div class="input-submit">
							<p>
								<input type="email" class="form-control" id="email" name="email"
									onkeyup="checkEmail(this.value)" autocomplete="off"
									name="email">
								<button type="button" class="btn btn-primary"
									onclick="getUserDetail();">Send OTP</button>
							</p>
							<span id="emailError"></span>
						</div>
					</div>
					<div>
						<label for="pwd">OTP</label> <input type="password"  autocomplete="off"
							class="form-control disFalse" id="pwd" disabled="disabled"
							autocomplete="off" name="password"> <span
							id="passwordError"></span>
					</div>
					<div>
						<label for="use_name">Name</label> <input type="text"  autocomplete="off"
							class="form-control disFalse" id="name" disabled="disabled"
							autocomplete="off" name="name"> <span id="nameError"></span>
							
							
							<input type="hidden" class="form-control" id="timezone" name="timeZone">
					</div>

					<div>
						<label for="use_name">Please Enter Captach</label>
						<section>
							<fieldset>

							<div class='CaptchaWrap' style="display: flex; align-items: center;">
								<div id="CaptchaImageCode" class="CaptchaTxtField">
									<canvas id="CapCode" class="capcode" width="300" height="80"></canvas>
								</div>
								<input type="button" class="ReloadBtn" value="reset"
									onclick='CreateCaptcha();' style="margin: 0 0 0 10px;">
							</div>

							<input type="text" id="UserCaptchaCode" class="CaptchaTxtField" autocomplete="off"
								placeholder='Enter Captcha - Case Sensitive' style="width: 100%; display: block;"> 
								<span
								id="WrongCaptchaError" class="error"></span> 
								
								<!-- <input
								type="button" class="btnSubmit" onclick="CheckCaptcha();"
								value="Submit"> -->
						</fieldset>
					</section>
				</div>

					<div class="col-sm-12 text-right" style="padding: 0;">
						<button type="submit" disabled="disabled"  id="btnSubmit"  class="btn btn-primary" onclick="checkCaptcha();" style="width: 100%;">Submit</button>
					</div>

				</div>


			</form>
		</div>



	</div>
</div>


<script>

function getTimeZone() {
	//alert("hello...");
	 var offset = new Date().getTimezoneOffset(), o = Math.abs(offset);
	 var timezone = (offset < 0 ? "+" : "-") + ("00" + Math.floor(o / 60)).slice(-2) + ":" + ("00" + (o % 60)).slice(-2);
	// alert("---"+timezone);
	 var update_time = "GMT"+timezone
	// alert("update_time---"+update_time);
	 document.getElementById("timezone").value = update_time;
	}
	getTimeZone();

</script>


</main>
<%@include file="footer.jsp"%>