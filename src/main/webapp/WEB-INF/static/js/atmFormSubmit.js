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
            url : '/ListCityATM/listATMsByCity',
            data: "city=" + city,
            success : function(responseData) {
                // alert(responseData);
                // var jsonData = JSON.stringify(responseData, null, 4);
                // var objData = JSON.parse(jsonData);

                // $j('#info').html(jsonData); #E6E6FC

                var objContent = "";
                objContent += "<table border='border' cellspacing='0' cellpadding='5' width='100%' align='center'><thead><tr>";
                objContent += "<th>Street</th><th>Housenumber</th><th>Postalcode</th><th>City</th><th>Latitude</th><th>Longitude</th><th>Distance</th><th>Type</th>";
                objContent += "</tr></thead>";
                for(var i = 0; i < responseData.length; i++) {
                    objContent += "<tr>";
                    objContent += "<td width='100%' align='center'>"+responseData[i].address.street+"</td>";
                    objContent += "<td width='100%' align='center'>"+responseData[i].address.housenumber+"</td>";
                    objContent += "<td width='100%' align='center'>"+responseData[i].address.postalcode+"</td>";
                    objContent += "<td width='100%' align='center'>"+responseData[i].address.city+"</td>";
                    objContent += "<td width='100%' align='center'>"+responseData[i].address.geoLocation.lat+"</td>";
                    objContent += "<td width='100%' align='center'>"+responseData[i].address.geoLocation.lng+"</td>";
                    objContent += "<td width='100%' align='center'>"+responseData[i].distance+"</td>";
                    objContent += "<td width='100%' align='center'>"+responseData[i].type+"</td>";
                    objContent += "</tr>";
                }
                objContent += "</table>";
                $j('#info').html(objContent);
            }
       });
    }
}