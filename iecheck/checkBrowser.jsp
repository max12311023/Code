<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">

<!-- 強制執行ie  -->
<!-- <meta http-equiv="X-UA-Compatible" content="IE=7" /> -->
<head>
    <title>Testing IE Compatibility Mode</title>
    <script src="iecheck.js" type="text/javascript"></script>
</head>
<body>
<div id="results">Results: </div>
</br>
<script type="text/javascript">

var ie = IeVersion();

document.write("IsIE: " + ie.IsIE + "</br>");
document.write("TrueVersion: " + ie.TrueVersion + "</br>");
document.write("ActingVersion: " + ie.ActingVersion + "</br>");
document.write("CompatibilityMode: " + ie.CompatibilityMode + "</br>");

if (getInternetExplorerVersion() ==11){
	alert(getInternetExplorerVersion() +"  version "+checkIsIE());
}

</script>
</body>
</html>