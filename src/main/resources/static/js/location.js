

$('document').ready(function(){
	$('.table #editButton').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function(location,status){
			$('#idEdit').val(location.id);
			$('#ddlCountryEdit').val(location.countryid);
			$('#ddlStateEdit').val(location.stateid);
			$('#descriptionEdit').val(location.description);
			$('#cityEdit').val(location.city);
			$('#addressEdit').val(location.address);
			$('#detailsEdit').val(location.details);
		});
		$('#editModal').modal();
	});
	
	$('.table #detailsButton').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function(location,status){
			$('#idDetails').val(location.id);
			$('#cityDetails').val(location.city);
			$('#addressDetails').val(location.address);
			$('#ddlCountryDetails').val(location.countryid);
			$('#ddlStateDetails').val(location.stateid);
			$('#descriptionDetails').val(location.description);
			$('#detailsDetails').val(location.details);
			$('#lastModifiedByDetails').val(location.lastModifiedBy);
			$('#lastModifiedDateDetails').val(location.lastModifiedDate.substr(0,19).replace("T"," "));
		});
		$('#detailsModal').modal();
	});
	
	$('.table #deleteButton').on('click',function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		$('#deleteModal #delRef').attr('href',href);
		$('#deleteModal').modal();
	});
});