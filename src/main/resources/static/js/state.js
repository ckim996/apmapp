

$('document').ready(function() {
	$('.table .btn-primary').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function(location, status) {
			$('#idEdit').val(location.id);
			$('#cityEdit').val(location.city);
			$('#addressEdit').val(location.address);
			$('#ddlStateEdit').val(location.stateid);
			$('#ddlCountryEdit').val(location.countryid);
			$('#descriptionEdit').val(location.description);
			$('#detailsEdit').val(location.details);
		});
		$('#editModal').modal();
	});

	$('.table #detailsButton').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function(state, status) {
			$('#idDetails').val(state.id);
			$('#ddlCountryDetails').val(state.countryid);
			$('#nameDetails').val(state.name);
			$('#detailsDetails').val(state.details);
			$('#lastModifiedByDetails').val(state.lastModifiedBy);
			$('#lastModifiedDateDetails').val(state.lastModifiedDate.substr(0, 19).replace("T", " "));
		});
		$('#detailsModal').modal();
	});

	$('.table #deleteButton').on('click', function(event) {
		event.preventDefault();

		var href = $(this).attr('href');
		$('#deleteModal #delRef').attr('href', href);
		$('#deleteModal').modal();
	});
});