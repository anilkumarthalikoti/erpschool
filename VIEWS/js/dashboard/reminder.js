/**
 * Reminder.js
 */

var reminder = new function() {
	 
this.setReminderView=function(){
	 $("tr[reminderType='onDate']").removeClass('hide');
	  $("tr[reminderType='weekDays']").addClass('hide');
	  $("tr[reminderType='monthDays']").addClass('hide');
	  $("#lableStart").html("Start from");
var selected=$("#reminderType option:selected").val();
 
switch(selected){
	
	 case "2":
	 $("#lableStart").html("Reminder date");
	 $("tr[reminderType='onDate']").addClass('hide');
	 break;
	 
	case "3":
	 $("tr[reminderType='weekDays']").removeClass('hide');
	 break;
	 
	case "4":
 	$("tr[reminderType='monthDays']").removeClass('hide');
	break;
	}
 
	
	
}

this.saveReminder=function(){
	
	if (validate.validate()) {
		validate.showLoader("Saving admission details...");
	var request=$.ajax({
				  method: "POST",
				  url: "savereminder.action",
				  data: $("form[name='reminders']").serialize()
				 		});
	request.done(function( msg ) {
			validate.hideLoader();
			$("div[id='content']").html(msg);
		});

		
	}
}
}