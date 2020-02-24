<%@include file="header.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<main>
<h3 class="mt-50 head-bg text-center" data-aos="fade-down">Customer
	Dashboard / Chat with Both Agencies</h3>
<div class="container success">
	<div class="row">
		<div class="col-sm-10 col-sm-offset-1">
			<ul class="service-track-list" data-aos="fade-up">
				<li>You can know the status of the related shipment Number.</li>
				<li>Define the B/L No or Shipment Number.</li>
				<li>Define your email address and see the entire dashboard with
					statuses of your shipments.</li>
				<li>My shipment history is already available in the application</li>
			</ul>
			<h3 class="mt-50  text-center">Customer View</h3>
			<p class="text-wrap" data-aos="fade-up">
				In addition to global advertising services on the website for free.<br>We
				have portfolio of 100,000 companies, so we can help in your
				advertisement as well and seeking to expand for all the sectors in
				the supply chain
			</p>
			<form:form class="cusomer-view-form" data-aos="fade-down" action="#"
				modelattribute="shipment">
				<div class="row">
					<div class="col-md-4">
						<label>Bill Of Lading Number</label> <input type="text"
							autocomplete="Off"
							onkeypress="return event.charCode >= 48 && event.charCode <= 57 && event.charCode != 8"
							name="billNo" placeholder="Number" id="billNo">
					</div>
					<div class="col-md-4">
						<label>Shipping Number*</label> <input type="text"
							autocomplete="Off"
							onkeypress="return event.charCode >= 48 && event.charCode <= 57 && event.charCode != 8"
							name="shipmentId" placeholder="Number" id="shipmentId">
					</div>
					<div class="col-md-4">
						<label>Email Address*</label> <input type="email" name="email"
							autocomplete="Off"
							pattern="/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/"
							placeholder="Email" id="email">
					</div>
					<div class="col-md-12 text-center">


						<!-- <a href="#my-sjipment-history" id="data-submit" onclick="getRecords();"  class="disabled">Submit</a>
					 -->
						<a href="#my-sjipment-history" id="data-submit"
							onclick="getRecords();">Submit</a>
						<!-- <button type="button" id="data-submit" onclick="aditi();">Submit</button> -->
					</div>
				</div>
			</form:form>
			<h3 class="text-center mt-50" id="my-sjipment-history">My
				Shipment History</h3>
			<div class="shipment-history" data-aos="fade-down">
				<form>
					<div class="table-responsive">
						<table class="table table-stripte">
							<thead>
								<tr>
									<th>Shipment Number</th>
									<th>Status</th>
									<th>Date</th>
									<th>Time</th>
									<th>Chat</th>
								</tr>
							</thead>
							<tbody class="trrepeat">
								<!-- <tr class="trtremove">
									<td class="chat-open-set"><a href="javascript:void(0)"><i
											class="zmdi zmdi-comment "></i></a></td>
								</tr> -->
							</tbody>
						</table>
					</div>
				</form>
			</div>
			<h3 class="text-center mt-50">Notification</h3>
			<div class="notification-list-screen">
				<ul>
					<li>Shipment Number <strong>(123456789)</strong> from <strong>"Agenct
							Name"</strong></li>
					<li>Shipment Number <strong>(123456789)</strong> from <strong>"Agenct
							Name"</strong></li>
					<li>Shipment Number <strong>(123456789)</strong> from <strong>"Agenct
							Name"</strong></li>
				</ul>
			</div>
		</div>
	</div>
</div>

<%-- 
<div id="chat-popup_one">
	<i class="zmdi zmdi-comment"></i><i
		class="zmdi zmdi-close zmdi-close01 transform-zero01"></i>
</div>


<div id="chat-room01">
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
	<div class="direct-chat-popup_one">
		<h4 class="chat-heading01">
			Chat <a href="logOut" class="out01"><i class="zmdi zmdi-close zmdi-close01"></i></a>
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
	</div>

 --%>
</main>

	
<%@include file="footer.jsp"%>