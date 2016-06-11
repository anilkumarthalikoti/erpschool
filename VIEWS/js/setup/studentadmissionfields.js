/**
 * Validation of course
 */

var studentfields=new function(){
	
 
	//validate details
	this.saveData=function(){
	 $("input[type='checkbox']:checked").val("Y");
	 $("input[type='checkbox'] :not(:checked )").val("N");
		if(validate.validate()){
			var request=$.ajax({
				  method: "POST",
				  url: "saveStudentAdmissionFields.action",
				  data: $("form[name='studentadmissionfields']").serialize()
				 		});
			
		}
		request.done(function( msg ) {
			
			$("div[id='content']").html(msg);
		});
		 
	}
	
	
	
	
	
}