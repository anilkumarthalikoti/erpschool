/**
 * Validation of fee structure
 */

var feestru = new function() {
	 this.saveFee=function(){
		 
		 
		if (validate.validate()) {
			validate.showLoader("Saving fee structure details...");

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
	}