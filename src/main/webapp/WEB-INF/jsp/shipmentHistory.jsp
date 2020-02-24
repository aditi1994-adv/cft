<%@include file="header.jsp"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<style>
#example {
	border: 1px solid #ddd;
    border: 1px solid #000;
}
.advertisement-link {
	text-align: right;
    font-size: 16px;
    font-weight: bold;
    margin: 0 0 10px;
}
.advertisement-link a {
	width: 231px;
    text-align: center;
	display: inline-block;
    border: 1px solid #007bff;
    padding: 3px 10px;
    background: #fff;
    color: #007bff;
	text-transform: uppercase;
}
.advertisement-link a:hover {
	/* background: #fff;
	color: #007bff; */
	text-decoration: none;
}
.chat-open-set form button {
	    color: #fff;
    background: #12c8fc;
    padding: 3px 10px 2px 10px;
    border-radius: 15px;
    border: none;
}
.chat-open-set a {
	position: relative;
}
.chat-open-set a span {
	    position: absolute;
    background: red;
    color: #fff;
    display: inline-block;
    border-radius: 5px;
    left: 24px;
    top: -7px;
    font-size: 10px;
    padding: 2px;
    line-height: 11px;
}
.shipment-status-table {
	font-size: 14px;
}
.shipment-status-table #example_length {
	float: left;
	width: 50%;
}
.shipment-status-table #example_filter {
	float: right;
	width: 50%;
}
.shipment-status-table #example_filter input {
	height: 24px;
	padding: 0 10px;
}
.shipment-status-table #example_paginate a {
	display: inline-block;
    border: 1px solid #eaeaea;
    padding: 2px 5px 3px;
    margin: 0 4px 0 0;
    cursor: pointer;
    transition: all 0.3s;
    background: #fff;
    font-weight: bold;
    color: #242020;
}
.shipment-status-table #example_paginate a:hover {
    background: #242020;
    color: #fff;
}
tfoot {
	display: none;
}
</style>
<main>
  <h3 class="mt-50 head-bg text-center" data-aos="fade-down">"Check your all shipment status & Chat with your Agent". "You can do as well Email Marketing to market to your Items/Goods"</h3>
  <div class="container success">
    <div class="row">
      <div class="login-section-form" style="width: 100%;">
        <div class="table-responsive">
      
        <c:choose>
       <c:when test="${not empty shipmentRecord }">
       
       <div class="shipment-status-table">
          <div class="advertisement-link"><a href="advertisement">Email marketing</a></div>
    
       	  <table id="example" class="table" style="width:100%">
		        <thead>
		            <tr>
		                <th>S.No.</th>
		                <th>Shipment Id</th>
		                <th>Customer Shipments</th>
		                <th>Creation Date</th>
		                <th>Chat</th>
		               
		            </tr>
		        </thead>
		        <tbody>
		            <c:forEach  items="${shipmentRecord}" var="lang" varStatus="loop">
                <tr class="trtremove">
                  <td> ${loop.index+1}
                 
                  </td>
                  <td> ${lang.shipmentId}</td>
                  <td> ${lang.shipmentStatusValue}</td>
                  <td>
                    ${lang.createdOn}
                  </td>
                  <td class="chat-open-set">
                 
                  <a href="customerdashboard?shipmentId=${lang.shipmentId}"><i class="zmdi zmdi-comment "></i>
                  <c:if test="${lang.msgCount!=0}"><span>${lang.msgCount}</span></c:if>
                  </a>
                
                  </td>
                </tr>
              </c:forEach>  
                </tbody>
		        <tfoot>
		            <tr>
		                <th>S.No.</th>
		                <th>Shipment Id</th>
		                <th>Shipment Status</th>
		                <th>Creation Date</th>
		                <th>Chat</th>
		                <!-- <th>Salary</th> -->
		            </tr>
		        </tfoot>
		    </table>
       </div>
        
      
       </c:when>
        <c:otherwise>
        <p style="text-align: center; font-size: 20px; font-weight: bold;">No Record Found</p>
        </c:otherwise>
        </c:choose>
        </div>
      </div>
    </div>
  </div>
  
</main>
<%@include file="footerAfterLogin.jsp"%>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
<!-- https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js -->
<script>
$(document).ready(function() {
    $('#example').DataTable();
} );
</script>