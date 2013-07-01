<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'gewnew_result.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/bootstrap-responsive.min.css">
	<link rel="stylesheet" type="text/css" href="css/docs.css">

  </head>
  
<body data-spy="scroll" data-target=".bs-docs-sidebar">

  <div class="span8">	
  	<table class="table">
  		<thead>
  			<tr>
  				<td>Â·¾¶</td>
  			</tr>
  		</thead>
	 	<s:iterator id="list" value="allUrls" status="file">
			<tr>
				<td><input type="text" value="<s:property />" id="urlcontent${file.index}" class="span5" style="height:30px;" /></td>
				<td><button onclick="stickUrl('urlcontent${file.index}');" class="btn" type="button">Õ³Ìù</button></td>
			</tr>
		</s:iterator>
	</table>
	<a href="index.html" class="btn btn-link">·µ»Ø</a>
	</div>
</body>

<script type="text/javascript">
  	
	function stickUrl(contentid) {

		var content = document.getElementById(contentid);

		content.select();

	}
  
  </script>
</html>
