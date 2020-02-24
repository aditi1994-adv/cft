"use strict";

$(window).scroll(function() {    
  var scroll = $(window).scrollTop();
  if (scroll >= 50) {
      $(".header-top").addClass("darkHeader");
  }
  else {
  	$(".header-top").removeClass("darkHeader");
  }
});

$(document).ready(function(){

AOS.init();

 $(".dropdown").hover(function() {
      $('.dropdown-menu', this).stop( true, true ).fadeIn("fast");
      $(this).toggleClass('open');
      $('b', this).toggleClass("caret caret-up");                
   },
  function() {
      $('.dropdown-menu', this).stop( true, true ).fadeOut("fast");
      $(this).toggleClass('open');
      $('b', this).toggleClass("caret caret-up");                
      
  });	 

$("#chat-popup .zmdi-comment").click(function(){
	$(this).addClass("transform-zero");
	$("#chat-popup .zmdi-close").addClass("transform-one");
	$("#chat-room").addClass("transform-one");
	$("#spanId").text("");
	$("#errorMsg").text("");
	$("#errorName").text("");
	$("#errorEmail").text("");		
});
$("#chat-popup .zmdi-close").click(function(){
	$(this).removeClass("transform-one");
	$("#chat-popup .zmdi-comment").removeClass("transform-zero");
	$("#chat-room").removeClass("transform-one");
	$(".direct-chat").removeClass("transform-one");
	$(".direct-chat-popup").removeClass("transform-one");
	$("#forMsgDisplay").css({ 'display' : 'none' });
});
$("#chat-room .chat-heading .zmdi-close").click(function(){
	$("#chat-room").removeClass("transform-one");
	$("#chat-popup .zmdi-close").removeClass("transform-one");
	$("#chat-popup .zmdi-comment").addClass("transform-one");
	//aditi
	 $("#errorMsg").text("");
	$("#errorName").text("");
	$("#errorEmail").text("");
	
});
$(".chat-login-box a").click(function(){
	$(".direct-chat").addClass("transform-one");
});
/*$(".chat-login-box form .mail-submit").click(function(){
	$(".direct-chat").addClass("transform-one");
});*/
$(".direct-chat .chat-close-direct .zmdi-close").click(function(){
	$(".direct-chat").removeClass("transform-one");
//aditi
	$("#spanId").text("");
	$("#errorMsg").text("");
	$("#errorName").text("");
	$("#errorEmail").text("");
});
$(".chat-window-popup").click(function(){
	$(".direct-chat-popup").addClass("transform-one");
	$("#chat-room").removeClass("transform-one");
});
$(".direct-chat-popup .chat-heading .zmdi-close").click(function(){
	$(".direct-chat-popup").removeClass("transform-one");
	$("#chat-popup .zmdi-close").removeClass("transform-one");
	$("#chat-popup .zmdi-comment").addClass("transform-one");
	$(".direct-chat").removeClass("transform-one");
});

var height = 0;
$('.chat-scroll ul').each(function(i, value){
    height += parseInt($(this).height());
});

height += '';

$('.chat-scroll').animate({scrollTop: height});

});

$(function() {

$(".rslides-header").responsiveSlides({
	prevText: '<i class="zmdi zmdi-chevron-left zmdi-hc-2x text-center"></i>',
	nextText: '<i class="zmdi zmdi-chevron-right zmdi-hc-2x text-center"></i>',
	nav: true
});

$(".scrolldown").on("click", function(){
	$("html,body").animate({
		scrollTop: $("header").height()
	});
});

$(".slick-features").slick({
	slidesToShow: 5,
	prevArrow: '<i class="zmdi zmdi-chevron-left zmdi-hc-2x text-center"></i>',
	nextArrow: '<i class="zmdi zmdi-chevron-right zmdi-hc-2x text-center"></i>',
	responsive: [
	{
		breakpoint: 1200,
		settings: {
			slidesToShow: 3
		}
	},
 		{
		breakpoint: 992,
		settings: {
			slidesToShow: 2
		}
	},
	{
		breakpoint: 768,
		settings: {
			slidesToShow: 1
		}
	}]
});

$(".slick-testimonials").slick({
	slidesToShow: 1,
	prevArrow: '<i class="zmdi zmdi-chevron-left text-center"></i>',
	nextArrow: '<i class="zmdi zmdi-chevron-right text-center"></i>',
});

$(".popular-scrolldown").on("click", function(){
	$('html,body').animate({
        scrollTop: $(".tutorials").offset().top - 50
      }, 1000);
});

var $teacher = 	$(".teacher > a");

$teacher.hover(function(){
	$(this).siblings(".imgcontainer").find(".overlay").fadeIn();
});

$teacher.mouseout(function(){
	$(this).siblings(".imgcontainer").find(".overlay").fadeOut();
});

$(".jquery-select").selectmenu();

$("#teacher-single .tutorials").slick({
	slidesToShow: 3,
	prevArrow: '<i class="zmdi zmdi-chevron-left text-center"></i>',
	nextArrow: '<i class="zmdi zmdi-chevron-right text-center"></i>',
	responsive: [
 		{
		breakpoint: 992,
		settings: {
			slidesToShow: 2
		}
	},
	{
		breakpoint: 768,
		settings: {
			slidesToShow: 1
		}
	}]
});

$(".option-title").on("click", function(){
	var $parent = $(this).parent();
	$parent.addClass("opened");
	$parent.siblings().removeClass("opened");
});

$(".courses-side-slick").slick({
	slidesToShow: 1,
	prevArrow: '<i class="zmdi zmdi-chevron-left text-center"></i>',
	nextArrow: '<i class="zmdi zmdi-chevron-right text-center"></i>'
});

$(".loadmore").on("click", function(e){
	$(this).fadeOut(500);
	$(".more-categories").slideDown(700);
	$(".service-categories").animate({"margin-bottom": 0}, 700);
	e.preventDefault();
});


if(window.innerWidth < 768){
	var $items = $("#myNavbar > ul > li > a");
	$items.each(function(i, el){
		if($(el).attr("href") == "#"){
			$(this).on("click",function(e){
				e.preventDefault();
				$(".submenu").hide();
				$(this).siblings(".submenu").show();

			});
		}
	});
}

});



$(document).ready(function(){
$('#myNavbar ul li a').click(function(){
  $('li a').removeClass("active-hover");
  $(this).addClass("active-hover");
});
});