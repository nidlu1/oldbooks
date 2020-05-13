<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>그리드테스트</title>
<!-- 그리드 js -->
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!--  <script type="text/javascript" src="js/realgrid/jquery-1.11.2.min.js"></script> -->
 <script type="text/javascript" src="js/realgrid/realgridjs-lic.js"></script>
 <script type="text/javascript" src="js/realgrid/realgridjs_eval.1.1.34.min.js"></script>
 <script type="text/javascript" src="js/realgrid/realgridjs-api.1.1.34.js"></script>
<script type="text/javascript">
var gridView;
var dataProvider;
    
$(document).ready( function() {

    RealGridJS.setTrace(false);
    RealGridJS.setRootContext("js/realgrid");
    
    dataProvider = new RealGridJS.LocalDataProvider();
    gridView = new RealGridJS.GridView("realgrid1");
 
    
    
 

    var fields = [
        {
            fieldName: "field1"
        },
        {
            fieldName: "field2"
        },
        {
            fieldName: "field3"
        }
    ];
    
    var columns = [
        {
            name: "col1",
            fieldName: "field1",
            header : {
                text: "이름"
            },
            width: 150
        },
        {
            name: "col2",
            fieldName: "field2",
            header : {
                text: "국어"
            },
            width: 150
        },
        {
            name: "col3",
            fieldName: "field3",
            header : {
                text: "수학"
            },
            width: 150
        }
    ];
    
    var data = [
        ["송윤아", "10", "33"],
        ["전도연", "20", "22"],
        ["하지원", "20", "11"],
        ["전지현", "10", "445"]
    ];
    
    
    dataProvider.setFields(fields);
    dataProvider.setRows(data);
    gridView.setColumns(columns);
    gridView.setDataSource(dataProvider);

});
    
     
</script>
</head>
<body>
	
	<div id="realgrid1" style="width: 100%; height: 200px;"></div>
</body>
</html>