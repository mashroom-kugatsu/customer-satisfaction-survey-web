<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="dto.InsertDataDto, model.GetInsertDataLogic, java.util.List"%>
<%
	List<InsertDataDto> insertDataList = (List<InsertDataDto>) session.getAttribute("insertDataList");
	InsertDataDto insertDataDto = insertDataList.get(0);
	String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お客様満足度調査Web入力データ 登録ツール</title>
</head>
<body>
	<h3>お客様満足度調査Web入力データ 登録ツール</h3>
	<div>
		<a>読込＞ 確認＞ <b>完了＞</b>
		</a>
	</div>
	<p><%= msg %></p>

	<div>
		<a>▼以下の割引券Noで登録しました▼</a><br>
		<%-- ID:<%=insertDataDto.getId() + 1%> --%>
		割引券No:<%=insertDataDto.getOld_discount()%>
	</div>
	<br>
	<div>
		<a href="./index.jsp">[読込に戻る]</a>
	</div>

</body>
</html>