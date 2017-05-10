<%@include file="AdminTopNav.jsp" %>

<!-- ==============================================user monthly table start ==============================================-->
		
	<div class="container col-md-12">
   <h2>your meal</h2>          
  <table class="table table-striped" border="2">
    <thead>
      <tr>
        <th class="col-md-2">User Name</th>
        <th class="col-md-2">Name</th>
        <th class="col-md-2">Email</th>
         <th class="col-md-2">Action</th>
        
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
      <tr>
        <td>${user.userName}</td>
        <td>${user.name}</td>
        <td>${user.email}</td>
        <td><a href="UserDelete?userId=${user.userId }">Delete</a></td>
      </tr>
     </c:forEach> 
    </tbody>
  </table>
</div>
		<!-- =======================================user monthly table end======================================================= -->		 
		
