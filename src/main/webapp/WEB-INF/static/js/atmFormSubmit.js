/**
 * Main JavaScript file for the application.
 *
 * @author Simon Njenga
 * @since 0.1
 */
var atmFormSubmit = {

	doAjaxPost : function() {
		// Put jQuery into no-conflict mode. $j is now an alias to the jQuery function; creating the new alias is optional.
		var $j = jQuery.noConflict();
		
		// get the form values
		var city = $j('#city').val();
		
		$j.ajax({
   			
		});
	}
}