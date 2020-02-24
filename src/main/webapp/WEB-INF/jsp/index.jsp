<%@include file="header.jsp"%>
<main>
	<div class="home-page" id="home">
		<div class="container">
			<div class="connecting-platform">
				<div class="outer-connection">
					<h1>Connecting companies on one platform</h1>
					<p class="service-text">Connecting companies and agencies by providing B2B Services, B2C Services , IPAAS(Services to connect different parties' system) & Email Marketing System Combining the richest & effective functionality & the most advanced cloud-native</p>
					<h3>We can help you grow more by our provided services</h3>
					<h5>We lower your costs, increase efficiency, increase transparency, and allow traceability & Free and Online services for your customers</h5>
				</div>
				<%-- <div class="stories-add">
					<a href="javascript:void(0)">Success Stories</a>
					<a href="javascript:void(0)">Watch Videos</a>
					
					<input type="hidden" value="${token}"  id="urlToken">
				</div> --%>
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

<script>
$(document).ready(function() {
	  var tokenId= $("#urlToken").val().trim();

	  if (tokenId != '') {
		  window.localStorage.setItem('token', tokenId);

		  $("#token").val(tokenId);
		  loginUsingToken();
		  console.log("tokenId");
	 } 
	
});

</script>
	
</main>





<%@include file="footer.jsp"%>