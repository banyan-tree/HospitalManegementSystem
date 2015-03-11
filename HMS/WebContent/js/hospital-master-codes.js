/** **************CHARGE CATEGORY MASTER************************** */
function getChargeCategoryList(forSample) {
	var xmlhttp;
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}

	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {

			if (forSample == "forUpdate") {
				document.getElementById("chargeCategoryUpdateListDiv").innerHTML = xmlhttp.responseText;
			} else if (forSample == "forDelete") {
				document.getElementById("chargeCategoryDeleteListDiv").innerHTML = xmlhttp.responseText;
			}
		}
	};

	xmlhttp.open("GET", "ajax/GetChargeCategoryListAJAX.jsp?forSample="
			+ forSample, true);
	xmlhttp.send();
}

function showChargeCategoryDataUpdate() {
	var selected1 = document.getElementById("chargeCategoryIdUpdate");
	var chargeId1 = selected1.options[selected1.selectedIndex].value;

	var xmlhttp;

	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}

	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			document.getElementById("divUpdate").innerHTML = xmlhttp.responseText;
		}
	};

	xmlhttp.open("GET",
			"ajax/GetChargeCategoryDetailsByChargeIdAJAX.jsp?chargeId="
					+ chargeId1 + "&data=update", true);
	xmlhttp.send();
}

function showChargeCategoryDataDelete() {
	var selected1 = document.getElementById("chargeCategoryIdDelete");
	var chargeId1 = selected1.options[selected1.selectedIndex].value;

	var xmlhttp;

	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}

	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			document.getElementById("divDelete").innerHTML = xmlhttp.responseText;
		}
	};

	xmlhttp.open("GET",
			"ajax/GetChargeCategoryDetailsByChargeIdAJAX.jsp?chargeId="
					+ chargeId1 + "&data=delete", true);
	xmlhttp.send();
}

function insertChargeCategory() {
	var name = document.getElementById("name").value;
	var description = document.getElementById("description").value;

	var xmlhttp;

	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}

	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			document.getElementById("notificationBox").innerHTML = xmlhttp.responseText;
		}
	};
	xmlhttp.open("GET", "ajax/InsertChargeCategoryAJAX.jsp?name=" + name
			+ "&description=" + description, true);
	xmlhttp.send();
}

function deleteChargeCategory() {
	var chargeId = document.getElementById("chargeCategoryIdDelete").value;
	var name = document.getElementById("chargeNameDelete").value;

	var xmlhttp;

	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}

	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			document.getElementById("notificationBox").innerHTML = xmlhttp.responseText;
			getChargeCategoryList("forDelete");
		}
	};
	xmlhttp.open("GET", "ajax/DeleteChargeCategoryRecordAJAX.jsp?chargeId="
			+ chargeId + "&name=" + name, true);
	xmlhttp.send();
}

function updateChargeCategory() {
	var chargeId = document.getElementById("chargeCategoryIdUpdate").value;
	var name = document.getElementById("chargeNameUpdate").value;
	var description = document.getElementById("chargeDescriptionUpdate").value;

	var xmlhttp;

	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}

	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			document.getElementById("notificationBox").innerHTML = xmlhttp.responseText;
		}
	};
	xmlhttp.open("GET", "ajax/UpdateChargeCategoryRecordAJAX.jsp?chargeId="
			+ chargeId + "&name=" + name + "&description=" + description, true);
	xmlhttp.send();
}

/** ************CHARGE CATEGORY MASTER ENDS*********************** */

/** **************CHARGE SUB CATEGORY MASTER************************** */

/** Getting charge category list** */
function getChargeCategoryListForSubCategoryAddMaster() {

	var xmlhttp;

	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}

	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			document.getElementById("chargeCategoryDiv").innerHTML = xmlhttp.responseText;
		}
	};
	xmlhttp.open("GET", "ajax/GetChargeCategoryListForAllAJAX.jsp", true);
	xmlhttp.send();
}

function getChargeCategoryListForSubCategoryUpdateMaster() {

	var xmlhttp;

	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}

	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			document.getElementById("chargeCategoryUpdateListDiv").innerHTML = xmlhttp.responseText;
		}
	};
	xmlhttp.open("GET", "ajax/GetChargeCategoryListForUpdateAJAX.jsp", true);
	xmlhttp.send();
}
function getChargeCategoryListForSubCategoryDeleteMaster() {

	var xmlhttp;

	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}

	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			document.getElementById("chargeCategoryDeleteListDiv").innerHTML = xmlhttp.responseText;
		}
	};
	xmlhttp.open("GET", "ajax/GetChargeCategoryListForDeleteAJAX.jsp", true);
	xmlhttp.send();
}

/** inserting sub category record******** */
function insertSubChargeCategory(chargeCategoryId) {
	var name = document.getElementById("subCategoryNameAdd").value;
	var description = document.getElementById("subCategoryDescriptionAdd").value;
	var subChargeCost = document.getElementById("subCategoryCostAdd").value;

	var xmlhttp;

	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}

	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			document.getElementById("notificationBox").innerHTML = xmlhttp.responseText;
		}
	};
	xmlhttp.open("GET",
			"ajax/InsertSubChargeCategoryAJAX.jsp?chargeCategoryId="
					+ chargeCategoryId + "&name=" + name + "&description="
					+ description + "&subChargeCost=" + subChargeCost, true);
	xmlhttp.send();
}

/** *Get sub charge list by passing charge id as parameter *********** */
function getSubChargeCategoryListByChargeIdForUpdate(chargeCategoryId) {

	var xmlhttp;

	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}

	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			document.getElementById("chargeSubCategoryUpdateListDiv").innerHTML = xmlhttp.responseText;
		}
	};
	xmlhttp.open("GET",
			"ajax/GetChargeSubCategoryListByChargeIdForUpdateAJAX.jsp?chargeCategoryId="
					+ chargeCategoryId, true);
	xmlhttp.send();
}

function getSubChargeCategoryDetailsBySubChargeId(subChargeId) {

	var xmlhttp;

	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}

	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			document.getElementById("divUpdate").innerHTML = xmlhttp.responseText;
		}
	};
	xmlhttp.open("GET",
			"ajax/getSubChargeCategoryDetailsBySubChargeIdForUpdateAJAX.jsp?subChargeId="
					+ subChargeId, true);
	xmlhttp.send();

}

function updateSubChargeCategory() {

	var subChargeId = $("#divUpdate").find("#oldSubChargeCategoryId").val();
	var chargeId = $("#divUpdate").find("#newChargeCategoryName").val();
	var name = $("#divUpdate").find("#newSubChargeCategoryName").val();
	var description = $("#divUpdate").find("#newSubChargeCategoryDescription")
			.val();
	var chargeCost = $("#divUpdate").find("#newSubChargeCategoryCost").val();

	var xmlhttp;

	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}

	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			document.getElementById("notificationBox").innerHTML = xmlhttp.responseText;
		}
	};
	xmlhttp.open("GET",
			"ajax/UpdateChargeSubCategoryRecordAJAX.jsp?subChargeId="
					+ subChargeId + "&chargeId=" + chargeId + "&name=" + name
					+ "&description=" + description + "&chargeCost="
					+ chargeCost, true);
	xmlhttp.send();

}

/** ************CHARGE CATEGORY MASTER ENDS*********************** */
