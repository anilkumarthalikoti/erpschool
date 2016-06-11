/**
 * Validation of admission form
 */

var admissionsettings=new function(){
 this.update=function(){
 
	 var key="ac#"+$("select[id='acyear'] option:selected").val();
	 var tableKey="table[id='datatable'] tr[id='" +key+"']";
	 $(tableKey).click();
	 
	 }
	 
	 this.saveData=function(){
		 if(validate.validate()){
			 
			 validate.showLoader("Saving admission settings...");
			var request=$.ajax({
				  method: "POST",
				  url: "saveAdmissionSettings.action",
				  data: $("form[name='admissionauthorize']").serialize()
				 		});
			
		}
		request.done(function( msg ) {
			validate.hideLoader();
			$("div[id='content']").html(msg);
		});
			 
			 }
		 
	
}