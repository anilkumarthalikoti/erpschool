/**
 * Validation of fee structure
 */

var feepay = new function() {
	 this.saveFee=function(){
		 
		 
		if (validate.validate()) {
			validate.showLoader("Saving fee payments...");

			var request=$.ajax({
				  method: "POST",
				  url: "savefeestructure.action",
				  data: $("form[name='feestructure']").serialize()
				 		});
						
						request.done(function( msg ) {
			validate.hideLoader();
			$("div[id='content']").html(msg);
		});
			
		}
		
		
		 }
	 this.fetchfeepayments=function(e){
		  if (e.keyCode == 13) {
			  var studentId=$("input[id='studentId']").val();
			  if(studentId.length==0){
				  validate.alert("Enter student/appliction no");
				  return;
				  }
				  validate.showLoader("Fetching fee payments...");
				  var request=$.ajax({
				  method: "POST",
				  url: "fetchfeepayment.action",
				  data: $("form[name='feestudent']").serialize()
				 		});
						
						request.done(function( msg ) {
			validate.hideLoader();
			$("div[id='feeview']").html(msg);
		});
			  }
		 
			 
			
			 }
	}