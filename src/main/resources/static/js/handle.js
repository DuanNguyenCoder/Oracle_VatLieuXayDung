
//// change list new product
$(".section-tab-nav li a").click(function(){
var value =	$("#tab1 .products-slick .slick-track").empty();

var idCate = $(this).data("value");

console.log($(this).data("value"))
console.log($(this));
$.ajax({
	
	type:"GET",
	url:"/getNewPro",
	data: {"idCate":idCate},
	success: function(data){
		console.log(data)
		
		for( var i = 4; i >= 1 ; i-- ){
			
		$("#tab1 .products-slick .slick-track").append(
								   
'<div class="slick-slide product slick-cloned" data-slick-index="-'+i+'" aria-hidden="true" tabindex="-1" style="width: 293px;">'+
'    <div class="product-img">'+
'        <a href="/detail" tabindex="-1">'+
'            <img src="./img/empty.png" style="max-width: 100%; max-height: 100%; height: 306px;" alt="" />'+
'        </a>'+
'        <div class="product-label">'+
'            <span class="sale">-30%</span>'+
'            <span class="new">NEW</span>'+
'        </div>'+
'    </div>'+
'    <div class="product-body">'+
'        <p class="product-category"test</p>'+
'        <h3 class="product-name"><a href="#" tabindex="-1">test</a></h3>'+
'        <h4 class="product-price">990000.0</h4>'+
'        <div class="product-btns">'+
'            <button class="add-to-wishlist" tabindex="-1"><i class="fa fa-heart-o"></i><span class="tooltipp">add to wishlist</span></button>'+
'            <button class="add-to-compare" tabindex="-1"><i class="fa fa-exchange"></i><span class="tooltipp">add to compare</span></button>'+
'            <button class="quick-view" tabindex="-1"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span></button>'+
'        </div>'+
'    </div>'+
'    <div class="add-to-cart">'+
'        <button class="add-to-cart-btn" tabindex="-1"><i class="fa fa-shopping-cart"></i> add to cart</button>'+
'        <a id="" hide="true" tabindex="-1">51</a>'+
'    </div>'+
'</div>' )

/////////////////////////////////////
		}

			 var slickcurrent = 'slick-current'
		 $.each(data, function(i, item){
			 var scrImage;
			 if(item.image.length != 0){
				 scrImage = 'data:image/jpg;base64, \ ' +  item.image[0].convertBlobToBase64 ;
			 }else{
				 scrImage = '../img/empty.png';
			 }
			 var slickActive = '';
			 if(i <= 4 ){ slickActive = 'slick-active'}else{
				 slickActive = ''
			 }
   				$("#tab1 .products-slick .slick-track").append(
'<div class=" slick-slide product '+slickActive +' '+slickcurrent+' "  style = "width: 293px;" aria-hidden = "true" data-slick-index = "'+i+'" tabindex = "-1">'+
'											<div class="product-img">'+
'											'+
'											<a href = "@{/detail}">'+
'											<img src = " '+ scrImage  +' " style = "max-width: 100%; max-height: 100%; height: 306px;" alt=""> 				'+
'											</a>'+
'												<div class="product-label">'+
'													<span class="sale">-30%</span>'+
'													<span class="new">NEW</span>'+
'												</div>'+
'											</div>'+
'											<div  class="product-body">'+
'												<p class="product-category"  >'+item.detailsCate +'</p>'+
'												<h3 class="product-name"><a href="#" >'+item.name +'</a></h3>'+
'												<h4 class="product-price" ><del class="product-old-price">$990.00</del>'+item.price +'</h4>'+
'												<div class="product-btns">'+
'													<button class="add-to-wishlist"><i class="fa fa-heart-o"></i><span class="tooltipp">add to wishlist</span></button>'+
'													<button class="add-to-compare"><i class="fa fa-exchange"></i><span class="tooltipp">add to compare</span></button>'+
'													<button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span></button>'+
'												</div>'+
'											</div>'+
'											<div class="add-to-cart">'+
'												<button  class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button>'+
'												<a id = "idPro" hide = "true"> '+item.id +'</a>'+
'											</div>'+
'										</div>'
	   )
		slickcurrent = "";
		 })
/////////////////////////
for( var i =  data.length; i <= data.length + 7; i++ ){
			
		$("#tab1 .products-slick .slick-track").append(
								   
'<div class="slick-slide product slick-cloned" data-slick-index="'+i+'" aria-hidden="true" tabindex="-1" style="width: 293px;">'+
'    <div class="product-img">'+
'        <a href="/detail" tabindex="-1">'+
'            <img src="./img/empty.png" style="max-width: 100%; max-height: 100%; height: 306px;" alt="" />'+
'        </a>'+
'        <div class="product-label">'+
'            <span class="sale">-30%</span>'+
'            <span class="new">NEW</span>'+
'        </div>'+
'    </div>'+
'    <div class="product-body">'+
'        <p class="product-category"test</p>'+
'        <h3 class="product-name"><a href="#" tabindex="-1">test</a></h3>'+
'        <h4 class="product-price">990000.0</h4>'+
'        <div class="product-btns">'+
'            <button class="add-to-wishlist" tabindex="-1"><i class="fa fa-heart-o"></i><span class="tooltipp">add to wishlist</span></button>'+
'            <button class="add-to-compare" tabindex="-1"><i class="fa fa-exchange"></i><span class="tooltipp">add to compare</span></button>'+
'            <button class="quick-view" tabindex="-1"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span></button>'+
'        </div>'+
'    </div>'+
'    <div class="add-to-cart">'+
'        <button class="add-to-cart-btn" tabindex="-1"><i class="fa fa-shopping-cart"></i> add to cart</button>'+
'        <a id="" hide="true" tabindex="-1">51</a>'+
'    </div>'+
'</div>' )}

	}
})

})

/////////////////////addd pro to cart view
$(".add-to-cart-btn").click(function(e) { // .apply-course
e.preventDefault();
var id = $(this).parent().find('#idPro').text();
console.log(id);
console.log(window.location.origin);

$.ajax({
	
	type:"GET",
	data: {"productID":id},
	url: window.location.origin + "/viewcart/add",
	success: function(data){
		console.log(data)
	
	var amount = 0;
		 
$(".cart-dropdown .cart-list").find(".product-widget").remove();
		 
		 
		 $.each(data, function(i, item) {
        $(".cart-dropdown .cart-list").append(
			'<div class="product-widget" id="idWidget-'+item.id+'">'+
'												<div class="product-img">'+
'													<img src="./img/product02.png" alt="">'+
'												</div>'+
'												<div class="product-body">'+
'													<h3 class="product-name"><a href="#">'+item.name+'</a></h3>'+
'													<h4 class="product-price"><span class="qty">x'+item.quantity+'</span>'+item.price+'</h4>'+
'												</div>'+
'												<button class="delete"><i onclick = "deleteItem('+item.id+')" class="fa fa-close"></i></button>'+
'											</div>'
			)
			amount += (item.price * item.quantity)
			})
			
			
			$(".cart-summary small").text( data.length +" Item(s) selected ");
			$(".cart-summary h5").text("SUBTOTAL: " + amount);

			
			}})})
////////////DELTE ITEM VIEW CART///////////////

function deleteItem(id){
	
	var idWidget = "#idWidget-" + id;
	$(idWidget).remove();
   $.ajax({
	   type:"post",
	   url:window.location.origin + "/viewcart/remove",
	   data:{"itemId" : id},
	   success:function(data){
		   console.log(data)
		   $(".cart-summary small").text( data[1] +" Item(s) selected ");
		   $(".cart-summary h5").text("SUBTOTAL: " + data[0]);
	   }
   })
}
//////////////////////// OTHER////////////////////////

//$(".navbar-nav li a").on("click",function(){
// $(".breadcrumb-tree").children()[2].innerText = "hellodaun";
//
//})
///////////////////////////////HANDLE MANAGER PAGE/////////////////////////////////

function preview() {
  frame.src = URL.createObjectURL(event.target.files[0]);
  
}
function clearImage() {
  document.getElementById('formFile').value = null;
  frame.src = "";
}

/// get content row when click down
$(".rows").click(function (){ 
  var tr = $(this).closest('tr')
  var id = $(tr).find('td').eq(0).text();
  var name = $(tr).find('td').eq(1).text();
  var price = $(tr).find('td').eq(2).text();
  var quantity = $(tr).find('td').eq(3).text();
  var brand = $(tr).find('td').eq(4).text();
  var cate = $(tr).find('td').eq(5).text();
  
  ////get image
  try {
  var image = $(tr).find('td').eq(6).children()[0].src;
}
catch(err) {
  $("#frame").attr('src',"../img/empty.png");
}
   ////set input value is null 
   
   $("#formFile").val(null);


    /// input text change when click row
    $("#idPro").val(id);
    $("#name").val(name);
    $("#price").val(price);
    $("#quantity").val(quantity);
     
     $.each( $("#category option"),function(index,val){
		 if(val.text == cate){
			 val.selected = true;
		 }
	 })
	 
      $.each( $("#brand option"),function(index,val){
		 if(val.text == brand){
			 val.selected = true;
		 }
	 })
     if($(tr).find('td').eq(6).children() != null){
     $("#frame").attr('src',image);
	 }
    
   
});
//////// add product


/////// update product
 $(".btnControl .btnUpdate").on("click",function(e){    
	
	var encodeBase64 = $("#frame").attr("src");
	var split;
	var encode;
	if(encodeBase64.includes("data:image/jpg;base64,")){
	 split = encodeBase64.split(",");
	 encode = split[1];
	}else{
		encode = null;
	}
	
	var id = $("#idPro").val();
	var name =	$("#name").val();
   var price =  $("#price").val();
    var quantity = $("#quantity").val();
    var cate =  $("#category").find(":selected").val();
    var brand  =  $("#brand").find(":selected").val();
   var des  =  $("#description").val();
    
    console.log($("#formFile").val());
    console.log("test");

    //// update product have image
  if($("#formFile").val() == "")  {
	  console.log("update")
    $.ajax( {
      url: '/manager/updatePro',
      type: 'POST',
      data: {"encode":encode,"idPro":id,"name":name,"price":price,"quantity":quantity,"cate":cate,"brand":brand,"desc":des},
      success: function(data){
		  console.log(data);
	  }
    } );

   /// update product not have image
  }else{
	 
	
  }
 })

		
