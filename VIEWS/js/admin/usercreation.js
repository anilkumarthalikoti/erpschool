/**
 * admin creation
 */

var user=new function(){
	
	
	//validate details
	this.saveData=function(){
		 

		if(validate.validate()){
			validate.showLoader("Saving user details...");
			var request=$.ajax({
				  method: "POST",
				  url: "saveUserDetails.action",
				  data: $("form[name='userDetails']").serialize()
				 		});
			
		}
		request.done(function( msg ) {
			validate.hideLoader();
			$("div[id='content']").html(msg);
		});
	}
	
	
	
	
	
}