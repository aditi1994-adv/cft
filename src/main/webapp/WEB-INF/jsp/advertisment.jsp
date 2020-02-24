<%@include file="header.jsp"%>
<style>
* {
	border-radius: 0 !important;
}

body {
	font-family: "Open Sans", sans-serif;
	font-size: 16px;
	font-weight: 300;
	line-height: 1.6;
	color: #494949;
	margin: 5% 0;
}

h1, h2, h3, h4, h5, h6, .h1, .h2, .h3, .h4, .h5, .h6 {
	color: inherit;
	font-family: "Raleway", sans-serif;
	font-weight: 300;
	line-height: 1.1;
}

.title h1, .title h2, .title h3, .title h4 {
	margin: 5px;
}

.title {
	position: relative;
	display: block;
	padding-bottom: 0;
	border-bottom: 3px double #dcdcdc;
	margin-bottom: 30px;
}

.title::before {
	width: 15%;
	height: 3px;
	background: #53bdff;
	position: absolute;
	bottom: -3px;
	content: '';
}

a {
	color: #53bdff;
	text-decoration: none;
	outline: 0;
}

a:hover {
	color: #06a0ff;
	text-decoration: none;
}

p {
	margin: 10px 0;
}

/* ==========================================================================
   WYSIWYG
   ========================================================================== */
#editor {
	resize: vertical;
	overflow: auto;
	line-height: 1.5;
	background-color: #fafafa;
	background-image: none;
	border: 0;
	border-top: 4px solid #3b8dbd !important;
	border-bottom: 1px solid #3b8dbd;
	min-height: 170px;
	box-shadow: none;
	padding: 8px 16px;
	margin: 0 auto;
	margin-top: 6px;
	font-size: 14px;
	transition: border-color 0.15s ease-in-out 0s, box-shadow 0.15s
		ease-in-out 0s;
}

#editor:focus {
	background-color: #f0f0f0;
	border-color: #38af5b;
	box-shadow: none;
	outline: 0 none;
}

/* ==========================================================================
   Buttons
   ========================================================================== */
.btn {
	font-family: "Raleway", sans-serif;
	font-weight: 300;
	font-size: 1em;
	-webkit-font-smoothing: antialiased;
	-moz-osx-font-smoothing: grayscale;
	border: none;
	padding: 0.65em 1.3em;
}

.btn-xs {
	font-size: .80em;
	padding: 10px 15px;
}

#editControls {
	background-image: linear-gradient(#ffffff, #f2f2f2);
	border-bottom: 2px solid #d9d9d9;
}

.btn-default {
	background-image: linear-gradient(#ffffff, #f2f2f2);
}

.btn-default:hover {
	background: linear-gradient(#f2f2f2, #e6e6e6);
}

#parent_id {
	padding: 20px 20px 0px;
	border-radius: 3px;
}

h5.self-heading {
	color: #0085c3;
	text-transform: uppercase;
	font-size: 17px;
	margin-bottom: 15px;
}
/* reset */
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

/* general */
body {
	margin: 0;
}

/* page */
.page-wrapper {
	width: 100%;
}

/* box */
.box-content {
	padding: 20px;
	background-color: #EFEFEF;
}

textarea {
	background-color: #FAFAFA;
	border: #EFEFEF solid 1px;
	color: #333;
	height: 150px;
	width: 100%;
}

/* richtext custom style */
.richText {
	margin-top: 40px;
	-webkit-box-shadow: 0 0 20px 0 #999;
	-moz-box-shadow: 0 0 20px 0 #999;
	box-shadow: 0 0 20px 0 #999;
}

div#top-clas {
	margin-top: 30px;
}

ui li {
	list-style-type: unset !important;
}

.subject-input {
	margin: 10px 0 0 0;
}

.subject-input input {
	font-family: 'Oswald', sans-serif;
	font-size: 15px;
	margin: 0 0 10px;
	border: 1px solid #eaeaea;
	border-top: none !important;
	height: 34px;
	line-height: 32px;
	padding: 0 10px;
	display: block;
	width: 100%;
	letter-spacing: 1px;
}

.form-submittion {
	text-align: center;
	margin: 10px 0 20px;
}

.form-submittion input {
	color: #fff;
	border-radius: 3px;
	background: #0062cc;
	margin: 0;
	height: 34px;
	line-height: 30px;
	font-size: 14px;
	padding: 0 10px;
	border: none;
}

.advertising-box{

padding: 20px 20px 0px;
    border-radius: 6px !important;
    border: 1px solid #000;
    margin-bottom: 10px !important;
}
</style>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page isELIgnored="false"%>
<main>
<h3 class="mt-50 head-bg text-center aos-init aos-animate"
	data-aos="fade-down">Advertisement</h3>
<div class="container  advertising-box">
	
	<c:choose>

		<c:when test="${shipmentRecord == 0}">
  
No Shipment Record found ,so, you are not able to advertise 

  
  		</c:when>
		<c:otherwise>

			<form action="saveAdvertisement" method="post"
				enctype="multipart/form-data">
				<div id="parent_id">
					<div class="row">
						<div class="col-md-12">
							<%-- <c:choose>
							<c:when test="${not empty successMessage}">
								<div class="form-group alertClose" >
									<div class="alert alert-success">
										<span>${successMessage} data sent</span>
										<button type="button" class="close" data-dismiss="alert"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
								</div>
							</c:when>
						</c:choose>  --%>

							<h5 class="self-heading">Attachment</h5>
							<input type="file" name="attachment">
						</div>
					</div>
					<div class="row" id="top-clas">
						<div class="col-md-12">
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-6 col-12">
									<h5 class="self-heading">Attach Emails(Excel Sheet)(.xslx)</h5>
										
									<input type="file" name="excelpath">
								</div>

								<div class="col-lg-6 col-md-6 col-sm-6 col-12">
									<!--  <h5 class="self-heading" style="text-align: right;"><i class="fa fa-download" aria-hidden="true"></i>Click to download demo file</h5> -->
	 <a class="self-heading" style="text-align: right;" href="resource/ExcelSheet/UploadEmailsFormat.xlsx"
										download=""><i
										class="fa fa-download" aria-hidden="true"></i>Emails Template Format</a>
										

								<!-- 	<a class="self-heading" style="text-align: right;" href="http://103.241.146.152:8080/CFT/docs/UploadEmailsFormat.xlsx"
										download=""><i
										class="fa fa-download" aria-hidden="true"></i>Click to
										download demo file</a> -->

								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-md-12">
							<div class="subject-input">
								<label for="pwd">Subject</label> <input type="text"
									class="form-control" name="subject">
							</div>
						</div>
					</div>
				</div>

				<!-- </div> -->

				<div class="container" id="parent_id"
					style="margin-top: 0px; padding-top: 0px !important;">

					<div id="editparent">
						<div id="editControls">
							<div class="btn-group">
								<a class="btn btn-xs btn-default" data-role="undo" href="#"
									title="Undo"><i class="fa fa-undo"></i></a> <a
									class="btn btn-xs btn-default" data-role="redo" href="#"
									title="Redo"><i class="fa fa-repeat"></i></a>
							</div>
							<div class="btn-group">
								<a class="btn btn-xs btn-default" data-role="bold" href="#"
									title="Bold"><i class="fa fa-bold"></i></a> <a
									class="btn btn-xs btn-default" data-role="italic" href="#"
									title="Italic"><i class="fa fa-italic"></i></a> <a
									class="btn btn-xs btn-default" data-role="underline" href="#"
									title="Underline"><i class="fa fa-underline"></i></a> <a
									class="btn btn-xs btn-default" data-role="strikeThrough"
									href="#" title="Strikethrough"><i
									class="fa fa-strikethrough"></i></a>
							</div>
							<div class="btn-group">
								<a class="btn btn-xs btn-default" data-role="indent" href="#"
									title="Blockquote"><i class="fa fa-indent"></i></a> <a
									class="btn btn-xs btn-default" data-role="insertUnorderedList"
									href="#" title="Unordered List"><i class="fa fa-list-ul"></i></a>
								<a class="btn btn-xs btn-default" data-role="insertOrderedList"
									href="#" title="Ordered List"><i class="fa fa-list-ol"></i></a>
							</div>
							<div class="btn-group">
								<a class="btn btn-xs btn-default" data-role="h1" href="#"
									title="Heading 1"><i class="fa fa-header"></i><sup>1</sup></a>
								<a class="btn btn-xs btn-default" data-role="h2" href="#"
									title="Heading 2"><i class="fa fa-header"></i><sup>2</sup></a>
								<a class="btn btn-xs btn-default" data-role="h3" href="#"
									title="Heading 3"><i class="fa fa-header"></i><sup>3</sup></a>
								<a class="btn btn-xs btn-default" data-role="p" href="#"
									title="Paragraph"><i class="fa fa-paragraph"></i></a>
							</div>
						</div>
						<div id="editor" contenteditable></div>
						<textarea name="message" id="editorCopy" required="required"
							style="display: none;"></textarea>
					</div>
					<div class="form-submittion">
						<input type="submit" value="Submit">

					</div>


				</div>
			</form>


		</c:otherwise>
	</c:choose>




</div>
</main>
<%@include file="footerAfterLogin.jsp"%>
<script>
	jQuery(document).ready(
			function($) {
				/** ******************************
				 * Simple WYSIWYG
				 ****************************** **/
				$('#editControls a').click(
						function(e) {
							e.preventDefault();
							switch ($(this).data('role')) {
							case 'h1':
							case 'h2':
							case 'h3':
							case 'p':
								document.execCommand('formatBlock', false, $(
										this).data('role'));
								break;
							default:
								document.execCommand($(this).data('role'),
										false, null);
								break;
							}

							var textval = $("#editor").html();
							$("#editorCopy").val(textval);
						});

				$("#editor").keyup(function() {
					var value = $(this).html();
					$("#editorCopy").val(value);
				}).keyup();

				$('#checkIt').click(function(e) {
					e.preventDefault();
					alert($("#editorCopy").val());
				});
			});
</script>
<script>

setInterval(function() {
	 
	$(".alertClose").css('display', 'none');
	
}, 2000);  
</script>
