/**
 * 
 */

var validate=new function(){
	
	this.validate=function(){
		var valid=true;
	$("[validate]").each(function(){
		 
		   var rules=$(this).attr("validate").split("#");
		   if(rules.indexOf("notNull")>-1){
		   alert($(this).prop('nodeName'));
		   if($(this).prop('nodeName')== "select"){
		   if($(this).selectedIndex==null){
		      $(this).addClass("error");
			   $(this).focus();
			   valid=false;
			   return false;
		   }
		   }else{
		   if($(this).val().trim().length==0){
			    $(this).keypress(function(){
										  $(this).removeClass("error");
										  });
			   $(this).addClass("error");
			   $(this).focus();
			   valid=false;
			   return false;
			   }
			   }
		   }
		    
		   
		   
		   
		   
		   
		   }); 


return valid;
		 
		}
		
		
		
	this.isNull=function(element){
		if($(element).val().trim().length==0){
			return true;
		}
		return false;
		
	}
	this.alert=function(msg){
		
		$.msgBox({
			title: "Error",
			content: msg,
			type: "error",
			buttons: [{ value: "Ok" }],
			
			});
	}
	 this.showLoader=function(msg){
		 if(typeof msg === 'undefined'){
			 msg="Loading...";
			 }
			 $("[id='popUpErpMsg'] [id='message']").html(msg);
		 $("[id='popUpErp']").removeClass("popup-hide");
		 $("[id='popUpErp']").addClass("popup-show");
		  $("[id='popUpErpMsg']").removeClass("popup-mg-hide");
		 $("[id='popUpErpMsg']").addClass("popup-msg-show").fadeIn();
		 
		 
	 }
this.hideLoader=function(){
		 
		 $("[id='popUpErp']").addClass("popup-hide");
		 $("[id='popUpErp']").removeClass("popup-show");
		  $("[id='popUpErpMsg']").addClass("popup-msg-hide");
		 $("[id='popUpErpMsg']").removeClass("popup-msg-show").fadeOut();
	 }
}