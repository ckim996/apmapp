

$('document').ready(function() {
	$('table #editButton').on('click', function(event) {

		event.preventDefault();

		var href = $(this).attr('href');

		$.get(href, function(user, status) {
			$('#txtIdEdit').val(user.id);
			$('#txtFirstNameEdit').val(user.firstname);
			$('#txtLastNameEdit').val(user.lastname);
			$('#txtUsernameEdit').val(user.username);
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