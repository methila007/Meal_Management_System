<%@include file="AdminTopNav.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- ==============================================user monthly table start ==============================================-->
		
	<div class="container col-md-12">
   <h2>your meal</h2>          
  <table class="table table-striped" border="2">
    <thead>
      <tr>
        <th class="col-md-2">Entry Date</th>
        <th class="col-md-2">Name</th>
        <th class="col-md-2">Meal Count</th>
        <th class="col-md-2">Shopping Amount</th>
        <th class="col-md-2">Grocery Name</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${categories}" var="category">
      <tr>
        <td>John</td>
        <td>Doe</td>
        <td>john@example.com</td>
        <td>mary@example.com</td>
      </tr>
     </c:forEach> 
    </tbody>
  </table>
</div>
		<!-- =======================================user monthly table end======================================================= -->		 
		
