/**
 * Validation of login
 */

var login=new function(){
	
	
	//validate details
	this.validateDetails=function(){
		var userName=$("input[id='userId']");
		var password=$("input[id='password']");
		if(validate.isNull(userName)){
			validate.alert('Enter login id');
			$(userName).focus();
			 return false;
		}
		
		if(validate.isNull(password)){
			validate.alert('Enter password');
			$(password).focus();
			 return false;
		}
		validate.showLoader("Validating credentials");
		var params={};
		params["loginId"]=$(userName).val();
		params["loginPassword"]=$(password).val();
		var request=$.ajax({
			  method: "POST",
			  url: "validatelogin.action",
			  data: params,
			  dataType:'json'
			});
			
			
			
			
			request.done(function( msg ) {
				validate.hideLoader();
			 if(msg['valid']){
			 window.location="home.action";
				
			 }else{
				 $("#errorMsg").html(msg['errorMessage']); 
				 
			 } 
			  });
			 
			
	}
	
	
	
	
	
}