// JavaScript Document
$(function(){
	$("#iframe",window.parent.document).height($("body").height()+20);

	setInterval(change,2000);
	nav_do = $(".head_nav ul li a");
	nav_do.click(function(e) {
        nav_do.removeClass("nav_selected");
		$(this).addClass("nav_selected");
    });

	
});
function change(){
	
	var turn = $("#pc");
	
	$("#pc").animate({marginTop:"-170px"},1000,function(){
	$("#pc li:eq(0)").appendTo($("#pc"));
	$("#pc").css("marginTop","0px");
	});	
}
