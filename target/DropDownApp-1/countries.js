

<script type="text/javascript">
$(document).ready(function() {
    
    // 1. When Country changes
    $('#country').change(function() {
        var selectedCountryId = $(this).val();
        
        // Clear dependent dropdowns
        $('#state').html('<option value="-1">-- Select State --</option>');
        $('#village').html('<option value="-1">-- Select Village --</option>');

        if (selectedCountryId != "-1") {
            $.ajax({
                url: 'getStates', // Action name in struts.xml
                data: { countryId: selectedCountryId },
                type: 'get',
                success: function(data) {
                    // 'data' is the stateList sent as JSON
                    $.each(data, function(index, item) {
                        $('#state').append($('<option>', {
                            value: item.id,
                            text: item.name
                        }));
                    });
                }
            });
        }
    });

    // 2. When State changes
    $('#state').change(function() {
        var selectedStateId = $(this).val();
        
        $('#village').html('<option value="-1">-- Select Village --</option>');

        if (selectedStateId != "-1") {
            $.ajax({
                url: 'getVillages',
                data: { stateId: selectedStateId },
                type: 'get',
                success: function(data) {
                    $.each(data, function(index, item) {
                        $('#village').append($('<option>', {
                            value: item.id,
                            text: item.name
                        }));
                    });
                }
            });
        }
    });
});
</script>