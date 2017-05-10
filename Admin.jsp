<%@include file="AdminTopNav.jsp" %>



<!--  ==============================================================-- report card start ======================================================-->       


            <div class="container">
                  <div class="row">
                  
                   <div class="col-xs-18 col-sm-6 col-md-3">
                   
                    </div>

                        <div class="col-xs-18 col-sm-6 col-md-3">
                      <div class="thumbnail">
                        
                  
                          <div class="caption">
                          <h4>Total Grocery Spent</h4>
                          <p>${ alltotalgorceryspent}</p>
                           </div>
                      </div>
                    </div>

                    <div class="col-xs-18 col-sm-6 col-md-3">
                      <div class="thumbnail">
                       
                      
                          <div class="caption">
                            <h4>Total Meal Count</h4>
                              <p>${ alltotalmealcount}</p>
                            
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
        		</div><!--/row-->
			</div><!--/container -->
		<!-- ====================================================================================report card start============================================= --> 
 

	<!-- ==============================================user monthly table start ==============================================-->
		
	<div class="container col-md-12">
   <h2>your meal</h2>          
  <table class="table table-striped" border="2">
    <thead>
      <tr>
        <th class="col-md-2">Name</th>
        <th class="col-md-2">User Name</th>
        <th class="col-md-2">Total Meal Count</th>
        <th class="col-md-2">Total Grocery Price</th>
        
        <th class="col-md-2">Total Cost</th>
        <th class="col-md-2">Have to pay</th>
<!--         <th class="col-md-2">Current Balance</th> -->
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${userinfo}" var="ui">
      <tr>
        <td>${ui.userName }</td>
        <td>${ui.name }</td>
        <td>${ui.tMealCount}</td>
        <td>${ui.tGroceryPrice}</td>
         <td>${avgmeal*ui.tMealCount}</td>
         <td>${ui.tGroceryPrice-avgmeal*ui.tMealCount}</td>
      </tr>
      </c:forEach> 
     
    </tbody>
  </table>
</div>
		<!-- =======================================user monthly table end======================================================= -->		 
		




        </body>
 </html>
