/**
 * Validation of course
 */

var coursedetails=new function(){
	
	
	//validate details
	this.saveData=function(){
		if(validate.validate()){
			var request=$.ajax({
				  method: "POST",
				  url: "saveCourseDetails.action",
				  data: $("form[name='courseDetails']").serialize()
				 		});
			
		}
		request.done(function( msg ) {
			
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