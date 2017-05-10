<%@include file="AdminTopNav.jsp" %>




    
  <form class="container col-md-12 " action="MealEdit" method="POST">
    <div class="form-group container col-md-12">
      <label >Meal Count:</label>
      <input type="text" class="form-control" id="mealCount" name="mealCount"  value=${meal.mealCount }>
    </div>
    <input type="hidden" class="form-control" id="mealId" name="mealId"  value=${meal.mealId }>
    
    <div class="form-group">
      <label for="pwd">Grocery Amount:</label>
      <input type="text" class="form-control" id="groceryPrice" name="groceryPrice" value="${meal.groceryPrice}" >
    </div>
     <div class="form-group">
      <label for="pwd">Grocery Items:</label>
      <input type="text" class="form-control" id="groceryItem" name="groceryItem" value="${meal.groceryItem }">
    </div>
    
    
    <input type="submit" class="btn btn-default" value="submit">
  </form>













		

 </body>
 </html>