<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="/WEB-INF/jsp/template/tags.jsp"%>
<html>
<head>
<title>Nested Selects Example</title>
<%@ include file="/WEB-INF/jsp/template/head.jsp"%>
</head>
<body>
	<c:url value="/" var="url" />
	<a href="${url}"> <img
		src="${pageContext.request.contextPath}/resources/images/back-icon.png"
		alt="Return to examples page" class="back" />
	</a>

	<h1>Nested Selects Example</h1>
	<form:form commandName="result" id="selectedCountriesForm" action="nestedSelect/result">
		<p id="provinceMsg">Province:</p>
		<form:select path="province" id="province">
			<form:option id="defaultValue" value="defaultValue" label="Select a province" />
			<form:option value="Province1" label="Province1" />
			<form:option value="Province2" label="Province2" />
			<form:option value="Province3" label="Province3" />
		</form:select>

		<p id="townMsg" style="display: none;">Town:</p>
		<form:select path="town" id="townSelect" style="display:none;">
		</form:select>

		<br><br>
		<button id="submitButton" type="submit" style="display: none;">Show selected values</button>
	</form:form>

	<spring:url var="townsUrl" value="/nestedSelect/getTowns.json">
		<spring:param name="_MODIFY_HDIV_STATE_" value="${hdivFormStateId}" />
	</spring:url>
	<br><br>
	<div id="selectedValue" style="display: none;">
		The town <label id="selectedTown"></label> from the province <label id="selectedprovince"></label> was selected.
	</div>

	<%@ include file="/WEB-INF/jsp/template/footer.jsp"%>

	<script src="${pageContext.request.contextPath}/resources/js/jquery-1.7.1.min.js"></script>
	<script>
	$("#province").on("change",function(){
		$("#province").find("#defaultValue").remove();
		var selectedProvince = $("#province").val();
		
		var URL ="${townsUrl}" ;
		$.get( URL, { province: selectedProvince}, function(responseData) {
			$("#townMsg").show();
			$("#submitButton").show();
			var $select = $('#townSelect');
			$select.show();
			$select.find('option').remove();
				
		    $.each(responseData, function(key, value) {              
				$('<option>').val(value.key).text(value.name).appendTo($select);
			});
		});
	});
	
	$("#selectedCountriesForm").submit(function() {
	
		$.post( $(this).attr("action"), $(this).serialize(), function(responseData){
			$("#selectedprovince").text(responseData.province);
			$("#selectedTown").text(responseData.town);
			$("#selectedValue").show();
		});
		return false;  
	});
	</script>
</body>
</html>