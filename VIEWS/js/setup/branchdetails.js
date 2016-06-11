/**
 * Validation of login
 */

var branchdetails=new function(){
	
	
	//validate details
	this.saveData=function(){
		if(validate.validate()){
			validate.showLoader("Saving branch details...");
			var request=$.ajax({
				  method: "POST",
				  url: "saveBranchDetails.action",
				  data: $("form[name='branchDetails']").serialize()
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