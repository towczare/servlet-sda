<%--
  Created by IntelliJ IDEA.
  User: tomic
  Date: 2019-05-19
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>App</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.11.1/jquery.js" type="text/javascript"></script>
</head>
<body>
<script>
    jQuery(function($) {
        var locations = {
           ${countryList}
        }

        var $locations = $('#location');
        $('#country').change(function () {
            var country = $(this).val(), lcns = locations[country] || [];

            var html = $.map(lcns, function(lcn){
                return '<option value="' + lcn + '">' + lcn + '</option>'
            }).join('');
            $locations.html(html)
        });
    });

</script>

<label class="page1">Country</label>
<div class="tooltips" title="Please select the country that the customer will primarily be served from">
    <select id="country" name="country" placeholder="Phantasyland">
        <option></option>
        <option>Germany</option>
        <option>Spain</option>
        <option>Hungary</option>
    </select>
</div>
<br />
<br />
<label class="page1">Location</label>
<div class="tooltips" title="Please select the city that the customer is primarily to be served from.">
    <select id="location" name="location" placeholder="Anycity"></select>
</div>

</body>
</html>
