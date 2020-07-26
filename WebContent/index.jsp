<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お客様満足度調査Web入力データ 登録ツール</title>
</head>
<body>
	<h3>お客様満足度調査Web入力データ 登録ツール</h3>
	<div>
		<a><b>読込＞ </b>確認＞ 完了＞ </a>
	</div>
	<br>
	<div>
		<form action="./ConfirmServlet" method="post"
			enctype="multipart/form-data">
			読込するファイルを選択してください
			<p>
				<input type="file" name="file" accept=".xlsx" size="100" style="width:750px;">
			</p>
			<p>
				<input type="submit" value="読込">
			</p>
		</form>
	</div>
	<div>
	=============================<br> 
	Working with server:<%=application.getServerInfo()%><br> 
	Servlet Specification:
	<%=application.getMajorVersion()%>.<%=application.getMinorVersion()%><br>
	JSP version:
	<%=JspFactory.getDefaultFactory().getEngineInfo().getSpecificationVersion()%><br>
	=============================
	</div>
</body>
</html>