/**
 * Validation of login
 */

var schooldetails=new function(){
	
	
	//validate details
	this.saveData=function(){
		if(validate.validate()){
			validate.showLoader("Saving school details");
			var request=$.ajax({
				  method: "POST",
				  url: "saveSchoolDetails.action",
				  data: $("form[name='schoolDetails']").serialize()
				 		});
			
		}
		request.done(function( msg ) {
			validate.hideLoader();
			$("div[id='content']").html(msg);
		});
		 
	}
	
	
	
	
	
}