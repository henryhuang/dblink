<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>GENONE</title>

<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="css/bootstrap-responsive.min.css">

</head>

<body data-spy="scroll" data-target=".bs-docs-sidebar">

	<div class="span8">
		<fieldset>
			<legend>相对路径</legend>
			${relpath}
		</fieldset>

		<div class="form-inline">
			<fieldset>
				<legend>Dropbox连接</legend>
				<div class="input-append">
					<input type="text" value="${oneUrl}" id="onrurlcontent"
						style="height:30px;" />
					<button onclick="stickUrl('onrurlcontent');" class="btn">粘贴</button>
				</div>
			</fieldset>
			<a href="index.html" class=" btn btn-link">返回</a>
		</div>

	</div>
</body>

<script type="text/javascript">
	function stickUrl(contentid) {
		var content = document.getElementById(contentid);
		content.select();
	}
</script>
</html>
