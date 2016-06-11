/**
 * admin creation
 */

var admin=new function(){
	
	
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
		
		var params={};
		params["loginId"]=$(userName).val();
		params["loginPassword"]=$(password).val();
		$.ajax({
			  method: "POST",
			  url: "createadmin.action",
			  data: params,
			  dataType:'json'
			})
			  .done(function( msg ) {
			   
			 if(msg['valid']){
			 window.location="login.action";
				
			 }else{
				 $("#errorMsg").show(); 
				 
			 }
			  });
	}
	
	
	
	
	
}