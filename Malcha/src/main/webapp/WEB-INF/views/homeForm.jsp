<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>


<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.0/jquery.min.js"></script>


<script src="https://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
function ajaxData() {
    $.ajax({
        url: './people',
        type: 'post',
        async: false,
        success: function(lists) { 
        	google.charts.load('current', {'packages':['corechart']});
			google.charts.setOnLoadCallback(drawChart);
			function drawChart() { 
				
                var dataChart = [['ID', 'age', 'age2', 'region', 'number']];
                if(lists.length != 0) {
                    $.each(lists, function(i, item){
                        dataChart.push(['CAN', item.age, item.age, 'DONGUK', item.number]);
                    });
                }else {
                    dataChart.push(['입력해주세요', 1]);
                }
                
                var data = google.visualization.arrayToDataTable(dataChart);
                var view = new google.visualization.DataView(data);

				var options = {
			  		title: 'Vehicle detection number by time zone',
			  		hAxis: {title: 'Life Expectancy'},
			        vAxis: {title: 'Fertility Rate'},
			        bubble: {textStyle: {fontSize: 11}}
				};

				var chart = new google.visualization.BubbleChart(document.getElementById('syoungee_graph'));
				chart.draw(view, options);
			}
        }
    });
}
$(document).ready(function(){ 
	ajaxData();
    setInterval(ajaxData, 3000);
});
</script>




</head>
<body>
	<div id="syoungee_graph" style="width: 900px; height: 500px;"></div>
	
	<form action="/logout" method="post">
	    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	    <button id="btn_logout" type="submit">로그아웃</button>
	</form>
</body>
</html>