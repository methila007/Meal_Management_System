<%@include file="TopNavigationbar.jsp" %>


<!-- user monthly table start -->
		
	<div class="container col-md-6">
   <h2>Full History</h2>          
  <table class="table table-striped" border="2">
    <thead>
      <tr>
        <th class="col-md-2">Date</th>
        
        <th class="col-md-2">Meal Count</th>
        <th class="col-md-2">Grocery Amount</th>
        <th class="col-md-2">Grocery Name</th>
      </tr>
    </thead>
    <tbody>
     <c:forEach items="${meals}" var="meal">
      <tr>
        <td>${meal.entryDate}</td>
      
        <td>${meal.mealCount}</td>
        <td>${meal.groceryPrice}</td>
        <td>${meal.groceryItem}</td>
      </tr>
       </c:forEach> 
    </tbody>
  </table>
</div>
		<!-- user monthly table end -->		 
		
 </body>
 </html>		