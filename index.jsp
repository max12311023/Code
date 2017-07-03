<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Basic TextBox - jQuery EasyUI Demo</title>
<link rel="stylesheet" type="text/css"
	href="js/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="js/themes/icon.css">
<link rel="stylesheet" type="text/css" href="../demo.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
</head>
<script type="text/javascript" >
$(function () {
    $('#issue_code').textbox('textbox').attr('maxlength','5');
     $('#issue_code').textbox('textbox').keyup(function(){
    	 var value =$('#issue_code').textbox('textbox').val();
//     	 if (!checkVal(value)){
//     		 $('#issue_code').textbox('textbox').val('');
//     	 }
      	var value =$('#issue_code').textbox('textbox').val().replace(/[^\w\.\/]/ig,'');       
      	$('#issue_code').textbox('textbox').val(value);
     });
    
     function checkVal( str ) {
    	    var regExp = /^[\d|a-zA-Z]+$/;
    	    if (regExp.test(str))
    	        return true;
    	    else
    	        return false;
    	}
});
</script>
<%
	int y = 10;

%>
<body>
	<h2>Basic TextBox</h2>
	<p>The textbox allows a user to enter information.</p>
	
	<form action="test" method="get">
	<div style="margin: 20px 0;"></div>
	<div class="easyui-panel" title="Register"
		style="width: 400px; padding: 30px 60px">
		<div style="margin-bottom: 20px">
			<div>Email:</div>
			<input class="easyui-textbox"
				data-options="prompt:'Enter a email address...',validType:'email'"
				style="width: 100%; height: 32px">
		</div>
		<div style="margin-bottom: 20px">
			<div>First Name:</div>
			<input class="easyui-textbox" name="fisrtName" style="width: 100%; height: 32px">
		</div>
		<div style="margin-bottom: 20px">
			<div>Last Name:</div>
			<input class="easyui-textbox" style="width: 100%; height: 32px">
		</div>
		<div style="margin-bottom: 20px">
			<div>Company:</div>
			<input class="easyui-textbox" style="width: 100%; height: 32px">
		</div>

		<div>
<!-- 			<a href="test" class="easyui-linkbutton" iconCls="icon-ok" -->
<!-- 				style="width: 100%; height: 32px">Register</a> -->
				<input type="submit" value="Submit" class="easyui-linkbutton" iconCls="icon-ok"
				style="width: 100%; height: 32px"/>
		</div>
	</div>
	</form>
<!-- 	<h2>Basic Calendar</h2> -->
<!-- 	<p>Click to select date.</p> -->
<!-- 	<div style="margin: 20px 0"></div> -->
<!-- 	<div class="easyui-calendar" style="width: 250px; height: 250px;"></div> -->

<input class="easyui-textbox" data-options="iconCls:'icon-search'" style="width:300px" id="issue_code">


</body>
</html>