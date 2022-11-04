$(".add-to-cart-btn").click(function(e) { // .apply-course
e.preventDefault();
var id = $(this).parent().find('.idPro').text();
console.log(id);

$.ajax({
	
	type:"GET",
	data: {"productID":id},
	url:"/add",
	success: function(data){
		console.log(data)
	
	var amount = 0;
		 
$(".cart-dropdown .cart-list").find(".product-widget").remove();
		 
		 //them san pham vao trong cart
		 
		 $.each(data, function(i, item) {
        $(".cart-dropdown .cart-list").append(
			'<div class="product-widget">'+
'												<div class="product-img">'+
'													<img src="./img/product02.png" alt="">'+
'												</div>'+
'												<div class="product-body">'+
'													<h3 class="product-name"><a href="#">'+item.name+'</a></h3>'+
'													<h4 class="product-price"><span class="qty">x'+item.quantity+'</span>'+item.price+'</h4>'+
'												</div>'+
'												<button class="delete"><i class="fa fa-close"></i></button>'+
'											</div>'
			)
			amount += (item.price * item.quantity)
			})
			
			
			$(".cart-summary small").text( data.length +" Item(s) selected ");
			$(".cart-summary h5").text("SUBTOTAL: " + amount);
			
			
			}})})


		
