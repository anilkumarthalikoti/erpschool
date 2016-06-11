/**
 * Validation of admission
 */

var admission = new function() {
	this.saveApplication = function() {
		if (validate.validate()) {
			validate.showLoader("Saving admission details...");

			$("#admissiondetailsForm").submit(
					function(e) {
						e.preventDefault();
						$("input[name='fileName']").val(
								$("input[name='studentImg']").val());
						var formdata = new FormData(this);

						$.ajax({
							method : "POST",
							url : "saveAdmissionDetails.action",
							data : formdata,
							contentType : false,
							processData : false,
							success : function(msg) {
								validate.hideLoader();
								$("div[id='content']").html(msg);
							}
						});

					});
			$("#admissiondetailsForm").submit();

		}
	}

	this.fetchApplication = function() {
		if ($("input[name='applicationNo']").val().trim().length >= 8) {
			var keyValue = $("input[name='applicationNo']").val().trim();
			var key = "div[id='grid'] table tbody tr[applicationNo='"
					+ keyValue + "']";
			if ($(key).length > 0) {
				$(key).click();
			}

		}
	}

	this.acceptRejectApplication = function() {

		if (validate.validate()) {
			validate.showLoader("Updating admission details...");

			$("#admissiondetailsForm").submit(
					function(e) {
						e.preventDefault();
						$("input[name='fileName']").val(
								$("input[name='studentImg']").val());
						var formdata = new FormData(this);

						$.ajax({
							method : "POST",
							url : "acceptRejectAdmissionDetails.action",
							data : formdata,
							contentType : false,
							processData : false,
							success : function(msg) {
								validate.hideLoader();
								$("div[id='content']").html(msg);
							}
						});

					});
			$("#admissiondetailsForm").submit();

		}

	}

}