<%@include file="TopNavigationbar.jsp" %>




    <!-- report card start -->       
			<h1>Welcome ${sessionScope.userName}</h1>

            <div class="container">
                  <div class="row">
                  
                   <div class="col-xs-18 col-sm-6 col-md-3">
                      <div class="thumbnail">
                        
                  
                          <div class="caption">
                          <h4>Total Grocery Spent</h4>
                          <p>${ totalgorceryspent}</p>
                           </div>
                      </div>
                    </div>

                    <div class="col-xs-18 col-sm-6 col-md-3">
                      <div class="thumbnail">
                       
                      
                          <div class="caption">
                            <h4>Total Meal Count</h4>
                              <p>${ totalmealcount}</p>
                            
                        </div>
                      </div>
                    </div>

                    <div class="col-xs-18 col-sm-6 col-md-3">
                      <div class="thumbnail">
                        
                          <div class="caption">
                            <h4>Average Meal Rate</h4>
                            <p>${avgmeal}</p>
                            
                        </div>
                      </div>
                    </div>
                    
          
                    
                    
                    <div class="col-xs-18 col-sm-6 col-md-3">
                      <div class="thumbnail">
                        
                          <div class="caption">
                            <h4>Have to pay</h4>
                            <p>${probablemeal}</p>
                            
                        </div>
                      </div>
                    </div>

<!--                      <div class="col-xs-18 col-sm-6 col-md-3"> -->
<!--                       <div class="thumbnail"> -->
<!--                         <img src="http://www.rd.com/wp-content/uploads/sites/2/2016/02/06-train-cat-shake-hands.jpg"> -->
<!--                           <div class="caption"> -->
<!--                             <h4>Probable Shopping Amount</h4> -->
<!--                             <p>Lorem </p> -->
<!--                         </div> -->
<!--                       </div> -->
<!--                     </div> -->
        		</div><!--/row-->
			</div><!--/container -->
		<!-- report card start --> 
		
		
		
		
		
		<!-- user monthly table start -->
		
	<div class="container col-md-6">
   <h2>This Month Summary</h2>          
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
		
		
 


<!-- user daily submission form -->	


<div class="container col-md-6 ">
  <h2> Today's Dairy </h2>
  <table border="2">

  <th></th>
   <tr> <td>
  <form class="container col-md-12 " action="UserHome" method="POST">
    <div class="form-group container col-md-12">
      <label >Meal Quantity:</label>
      <input type="text" class="form-control" id="meal" name="meal" >
    </div>
    <div class="form-group">
      <label for="pwd">Grocery Amount:</label>
      <input type="text" class="form-control" id="shopping" name="shopping" >
    </div>
     <div class="form-group">
      <label for="pwd">Grocery Items:</label>
      <input type="text" class="form-control" id="grocery" name="grocery" >
    </div>
    
    <input type="submit" class="btn btn-default" value="submit">
  </form>
</td>
</tr>

</table>
</div>  











		

 </body>
 </html>