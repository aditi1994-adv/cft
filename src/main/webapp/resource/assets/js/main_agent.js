$(document).ready(function(){
	
	// ==============================================
	$(document).on('click', '.chat-open-set a', function(){
		$("#chat-popup_one").show();
		$(this).addClass("transform-zero01");
		$("#chat-popup_one .zmdi-comment").addClass("transform-zero01");
		$("#chat-popup_one .zmdi-close").addClass("transform-one01");
		$("#chat-room01").addClass("transform-one01");
	});
	
	
	$("#chat-popup_one .zmdi-comment").click(function(){
		$(this).addClass("transform-zero01");
		$("#chat-popup_one .zmdi-close01").addClass("transform-one01");
		$("#chat-room01").addClass("transform-one01");
		$("#spanId01").text("");
		$("#errorMsg01").text("");
		$("#errorName01").text("");
		$("#errorEmail01").text("");		
	});
	$("#chat-popup_one .zmdi-close01").click(function(){
		$(this).removeClass("transform-one01");
		$("#chat-popup_one .zmdi-comment").removeClass("transform-zero01");
		$("#chat-room01").removeClass("transform-one01");
		$(".direct-chat01").removeClass("transform-one01");
		$(".direct-chat-popup_one").removeClass("transform-one01");
		$("#forMsgDisplay01").css({ 'display' : 'none' });
	});
	$("#chat-room01 .chat-heading01 .zmdi-close01").click(function(){
		$("#chat-room01").removeClass("transform-one01");
		$("#chat-popup_one .zmdi-close01").removeClass("transform-one01");
		$("#chat-popup_one .zmdi-comment").addClass("transform-one01");
		//aditi
		$("#errorMsg01").text("");
		$("#errorName01").text("");
		$("#errorEmail01").text("");
		
	});
	$(".chat-login-box01 a").click(function(){
		$(".direct-chat01").addClass("transform-one01");
	});
	/*$(".chat-login-box form .mail-submit").click(function(){
		$(".direct-chat").addClass("transform-one");
	});*/
	$(".direct-chat01 .chat-close-direct01 .zmdi-close01").click(function(){
		$(".direct-chat01").removeClass("transform-one01");
	//aditi
		$("#spanId01").text("");
		$("#errorMsg01").text("");
		$("#errorName01").text("");
		$("#errorEmail01").text("");
	});
	$(".chat-window-popup01").click(function(){
		$(".direct-chat-popup_one").addClass("transform-one01");
		$("#chat-room01").removeClass("transform-one01");
	});
	$(".direct-chat-popup_one .chat-heading01 .zmdi-close01").click(function(){
		$(".direct-chat-popup_one").removeClass("transform-one01");
		$("#chat-popup_one .zmdi-close01").removeClass("transform-one01");
		$("#chat-popup_one .zmdi-comment").addClass("transform-one01");
		$(".direct-chat01").removeClass("transform-one01");
	});

	// ==============================================
});