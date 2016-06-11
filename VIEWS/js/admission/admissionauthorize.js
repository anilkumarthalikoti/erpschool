/**
 * Validation of admission form
 */

var formapp=new function(){
 this.update=function(){
 
	 var key="ac#"+$("select[id='acyear'] option:selected").val();
	 var tableKey="table[id='datatable'] tr[id='" +key+"']";
	 $(tableKey).click();
	 
	 }
	 
	 this.saveData=function(){
		 if(validate.validate()){
			 var date1=new Date($("input[name='acceptDate']").val()).getTime();
			 var date2=new Date($("input[name='acceptTo']").val()).getTime();
			 if(date1>date2){
				 alert("Accept from date can't be greater than Accept to date");
				 return;
				 }
			 validate.showLoader("Saving admission authorization details...");
			var request=$.ajax({
				  method: "POST",
				  url: "saveAdmissionAuthorization.action",
				  data: $("form[name='admissionauthorize']").serialize()
				 		});
			
		}
		request.done(function( msg ) {
			validate.hideLoader();
			$("div[id='content']").html(msg);
		});
			 
			 }
		 
	
}