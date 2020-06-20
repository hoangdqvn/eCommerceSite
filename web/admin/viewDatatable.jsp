<%--
  Created by IntelliJ IDEA.
  User: hoangdq
  Date: 16/06/2020
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript">
        var path = '${pageContext.request.contextPath}';
    </script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <link href="http://cdn.datatables.net/1.10.3/css/jquery.dataTables.css" rel="stylesheet" type="text/css">
    <link href="http://datatables.net/release-datatables/extensions/ColVis/css/dataTables.colVis.css" rel="stylesheet" type="text/css">
    <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="http://cdn.datatables.net/1.10.3/js/jquery.dataTables.min.js"></script>
    <script src="http://datatables.net/release-datatables/extensions/ColVis/js/dataTables.colVis.js"></script>
    <script src="http://jquery-datatables-column-filter.googlecode.com/svn/trunk/media/js/jquery.dataTables.columnFilter.js"></script>
    <script type="text/javascript" src="../js/custom-datatable.js"></script>
    <script type="text/javascript" src="../js/fnStandingRedraw.js"></script>
    <script type="text/javascript" src="../js/fnSetFilteringDelay.js"></script>
    <title>Person Form</title>
</head>
<body>
<form>
    <div class="form">
        <table width="100%" border="0" margin="0" padding="0"
               class="row-border tableHeader" id="personTable">
            <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Place</th>
                <th>City</th>
                <th>State</th>
                <th>Phone</th>
            </tr>
            </thead>
            <tfoot>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Place</th>
                <th>City</th>
                <th>State</th>
                <th>Phone</th>
            </tr>
            </tfoot>
            <tbody>
            </tbody>
        </table>
    </div>
</form>
<style>
    tfoot input {
        width: 100%;
        padding: 3px;
        box-sizing: border-box;
    }
    .tableHeader{
        text-align:left;
    }
    tfoot {
        display: table-header-group;
    }
    .dataTables_length
    {
        position: absolute;
        top: 10px;
        left: 220px;
    }
    .dataTables_info {
        position: absolute;
        top: 0px;
        left: 5px;
    }
    .ColVis{
        padding-right:10px;
        padding-top:5px;

    }
    .dataTables_filter {
        position: absolute;
        top: 10px;
        left: 200px;
        font-size:15px;
    }
    .dataTables_filter input{
        height:22px;
        width:150px
    }
    input
    {
        -moz-border-radius: 15px;
        border-radius: 3px;
        border:solid 1px #c7c7c7;
        padding:5px;
    }
    table.dataTable tbody td {
        padding: 5px;
        padding-left: 20px;
    }
</style>
</body>
</html>
