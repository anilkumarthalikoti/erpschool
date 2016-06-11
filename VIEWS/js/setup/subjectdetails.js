/**
 * Validation of login
 */

var subjectdetails=new function(){
	
	
	//validate details
	this.saveData=function(){
		if(validate.validate()){
			var request=$.ajax({
				  method: "POST",
				  url: "saveSubjectDetails.action",
				  data: $("form[name='subjectDetails']").serialize()
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