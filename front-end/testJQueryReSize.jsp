<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
 <!-- jQuery -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<!-- Optional localStorage dependancy, for persistent column width storage -->
<script src="http://cdnjs.cloudflare.com/ajax/libs/store.js/1.3.14/store.min.js"></script>

<!-- Plugin -->
<script src="js/jquery.resizableColumns.min.js"></script>
<link rel="stylesheet" href="//cdn.jsdelivr.net/bootstrap/3.2.0/css/bootstrap.min.css"/>
<link rel="stylesheet" href="css/jquery.resizableColumns.css">
<link rel="stylesheet" href="css/demo1.css">

 <script>
    $(function(){
      $("table").resizableColumns({
        store: window.store
      });
    });
  </script>

<title>Insert title here</title>
</head>

<body>
    <table class="table table-bordered" data-resizable-columns-id="demo-table-v2">
      <thead>
        <tr>
          <th data-resizable-column-id="#">#</th>
          <th data-resizable-column-id="first_name">First Name</th>
          <th data-resizable-column-id="last_name">Last Name</th>
          <th data-resizable-column-id="username" id="username-column" data-noresize>Username</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>1</td>
          <td>Mark</td>
          <td>Otto</td>
          <td>@mdo</td>
        </tr>
        <tr>
          <td>2</td>
          <td>Jacob</td>
          <td>Thornton</td>
          <td>@fat</td>
        </tr>
        <tr>
          <td>3</td>
          <td colspan="2">Larry the Bird</td>
          <td>@twitter</td>
        </tr>
      </tbody>
    </table>
</body>

</html>
