/**
 * Validation of login
 */

var batchdetails=new function(){
	
	
	//validate details
	this.saveBatchdetails=function(){
		
		if(validate.validate()){
			validate.showLoader("Saving batch details...");
			var request=$.ajax({
				  method: "POST",
				  url: "saveBatchDetails.action",
				  data: $("form[name='batchDetails']").serialize()
				 		});
			
		}
		request.done(function( msg ) {
			validate.hideLoader();
			$("div[id='content']").html(msg);
		});
		/*
		 
			
			
			
			request.done(function( msg ) {
			 
			 if(msg['valid']){
			 window.location="home.action";
				
			 } 
			  });
			  
			  request.fail(function(msg){
			 $("#errorMsg").html(msg); 
			  });
			*/
	}
	
	
	
	
	
}