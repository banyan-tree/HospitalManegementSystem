function showDates() {
		var date1 = document.getElementById("datepicker").value;
		var doctorId = document.getElementById("doctorId").value;

		var xmlhttp;

		if (date1 == "") {
			document.getElementById("txtHint").innerHTML = "Please select date first";
			return;
		} else {
			document.getElementById("txtHint").innerHTML = "";
		}

		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {

				document.getElementById("div1").innerHTML = xmlhttp.responseText;
				validate();
			}
		};
		xmlhttp.open("GET", "GetAppointmentTime.jsp?date=" + date1
				+ "&doctorId=" + doctorId, true);
		xmlhttp.send();

	}

	function searchPatient() {
		var sName = document.getElementById("searchName").value;
		var sDOB = document.getElementById("datepicker1").value;
		var sCity = document.getElementById("searchCity").value;
		var sMobile = document.getElementById("searchMobile").value;

		var xmlhttp;

		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("divSearch").innerHTML = xmlhttp.responseText;
			}
		};
		xmlhttp.open("GET", "GetPatientData.jsp?name=" + sName + "&dob=" + sDOB
				+ "&city=" + sCity + "&mobile=" + sMobile, true);
		xmlhttp.send();

	}

	function searchPatientFeesDetails() {
		var sName = document.getElementById("searchName").value;
		var sDOB = document.getElementById("datepicker1").value;
		var sCity = document.getElementById("searchCity").value;
		var sMobile = document.getElementById("searchMobile").value;

		var xmlhttp;

		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("divSearch").innerHTML = xmlhttp.responseText;
			}
		};
		xmlhttp.open("GET", "GetPatientData.jsp?name=" + sName + "&dob=" + sDOB
				+ "&city=" + sCity + "&mobile=" + sMobile, true);
		xmlhttp.send();

	}
	
	
