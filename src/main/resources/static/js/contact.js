

$('document').ready(function() {
	$('table #editButton').on('click', function(event) {

		event.preventDefault();

		var href = $(this).attr('href');

		$.get(href, function(contact, status) {
			$('#txtIdEdit').val(contact.id);
			$('#txtFirstNameEdit').val(contact.firstname);
			$('#txtLastNameEdit').val(contact.lastname);
			$('#txtPhoneEdit').val(contact.phone);
			$('#txtMobileEdit').val(contact.mobile);
			$('#txtEmailEdit').val(contact.email);
			$('#txtRemarksEdit').val(contact.remarks);
		});
		$('#editModal').modal();
	});

	$('table #deleteButton').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #delRef').attr('href', href);
		$('#deleteModal').modal();
	});
});