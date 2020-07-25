<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="dto.InsertDataDto, model.GetInsertDataLogic, java.util.List"%>
<%
	List<InsertDataDto> insertDataList = (List<InsertDataDto>) session.getAttribute("insertDataList");
	InsertDataDto insertDataDto = insertDataList.get(0);
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
	<a>読込＞ <b>確認＞</b> 完了＞ </a>
	</div>
	<br>
<%-- 	<div>
		<ul>
			<li>ID:<%=insertDataDto.getId() + 1%></li>
			<li>割引券No:<%=insertDataDto.getOld_discount()%></li>
		</ul>
	</div> --%>
	<a>▼以下の内容で登録します▼</a>
	<div>
		<a><b>お客様情報</b></a>
		<table border="1">
			<tr>
				<th>No</th>
				<th>入力項目</th>
				<th>入力データ</th>
			</tr>
			<tr>
				<td>1</td>
				<td>DB登録日</td>
				<td><%=insertDataDto.getInput_date()%></td>
			</tr>
			<tr>
				<td>2</td>
				<td>地区</td>
				<td><%=insertDataDto.getDistrict()%></td>
			</tr>
			<tr>
				<td>3</td>
				<td>機種名</td>
				<td><%=insertDataDto.getModel()%></td>
			</tr>
			<tr>
				<td>4</td>
				<td>出張者組</td>
				<td><%=insertDataDto.getBusiness_team()%></td>
			</tr>
			<tr>
				<td>5</td>
				<td>出張者名</td>
				<td><%=insertDataDto.getBusiness_traveler()%></td>
			</tr>
			<tr>
				<td>6</td>
				<td>会社名</td>
				<td><%=insertDataDto.getCompany()%></td>
			</tr>
			<tr>
				<td>7</td>
				<td>部署名</td>
				<td><%=insertDataDto.getDivision()%></td>
			</tr>
			<tr>
				<td>8</td>
				<td>担当者名</td>
				<td><%=insertDataDto.getResponsible()%></td>
			</tr>
			<tr>
				<td>9</td>
				<td>郵便番号</td>
				<td><%=insertDataDto.getPostal()%></td>
			</tr>
			<tr>
				<td>10</td>
				<td>住所</td>
				<td><%=insertDataDto.getAddress()%></td>
			</tr>
			<tr>
				<td>11</td>
				<td>機番</td>
				<td><%=insertDataDto.getKiban()%></td>
			</tr>
			<tr>
				<td>12</td>
				<td>アンケート提出日</td>
				<td><%=insertDataDto.getQuestionnaire_date()%></td>
			</tr>
		</table>
	</div>
	<br>
	<div>
		<a><b>1. 訪問したサービス員の対応はいかがでしたか。</b></a>
		<table border="1">
			<tr>
				<th>No</th>
				<th>入力項目</th>
				<th>入力データ</th>
			</tr>
			<tr>
				<td>1-1</td>
				<td>身だしなみはいかがでしたか。</td>
				<td><%=insertDataDto.get_1C1()%></td>
			</tr>
			<tr>
				<td>1-2</td>
				<td>対応、態度はいかがでしたか。</td>
				<td><%=insertDataDto.get_1E1()%></td>
			</tr>
			<tr>
				<td>1-3</td>
				<td>修理技術はどうでしたか。</td>
				<td><%=insertDataDto.get_1G1()%></td>
			</tr>
			<tr>
				<td>1-4</td>
				<td>作業方法、後片付けはどうでしたか。</td>
				<td><%=insertDataDto.get_1I1()%></td>
			</tr>
			<tr>
				<td>1-5</td>
				<td>作業報告はどうでしたか、分かりやすかったですか。</td>
				<td><%=insertDataDto.get_1K1()%></td>
			</tr>
			<tr>
				<td>1-6</td>
				<td>サービス員について</td>
				<td><%=insertDataDto.get_1B2()%></td>
			</tr>
		</table>
	</div>
	<br>
	<div>
		<a><b>2. 今回のサービス対応はいかがでしたか。</b></a>
		<table border="1">
			<tr>
				<th>No</th>
				<th>入力項目</th>
				<th>入力データ</th>
			</tr>
			<tr>
				<td>2-1</td>
				<td>お約束の日時にお伺いしましたか。</td>
				<td><%=insertDataDto.get_2C1()%></td>
			</tr>
			<tr>
				<td>2-2</td>
				<td>サービスの即応体制は如何でしょうか。</td>
				<td><%=insertDataDto.get_2E1()%></td>
			</tr>
			<tr>
				<td>2-3</td>
				<td>技術料に見合ったサービス対応（段取り、作業、報告）でしたか。</td>
				<td><%=insertDataDto.get_2G1()%></td>
			</tr>
			<tr>
				<td align="center">※</td>
				<td>2又は1とお応えの場合、理由があればお聞かせ下さい。</td>
				<td><%=insertDataDto.get_2B2()%></td>
			</tr>
		</table>
	</div>
	<br>
	<div>
		<a><b>3. サービスコールされた事はありますか。</b></a>
		<table border="1">
			<tr>
				<th>No</th>
				<th>入力項目</th>
				<th>入力データ</th>
			</tr>
			<tr>
				<td></td>
				<td>ある or ない</td>
				<td><%=insertDataDto.get_3B1()%></td>
			</tr>
			<tr>
				<td>3-1</td>
				<td>その時のフロント対応はどうでしたか。</td>
				<td><%=insertDataDto.get_3E1()%></td>
			</tr>
			<tr>
				<td align="center">※</td>
				<td>2又は1とお応えの場合、理由があればお聞かせ下さい。</td>
				<td><%=insertDataDto.get_3D2()%></td>
			</tr>
		</table>
	</div>
	<br>
	<div>
		<a><b>4. サービスパーツのご依頼をされた事がありますか。</b></a>
		<table border="1">
			<tr>
				<th>No</th>
				<th>入力項目</th>
				<th>入力データ</th>
			</tr>
			<tr>
				<td></td>
				<td>ある or ない</td>
				<td><%=insertDataDto.get_4B1()%></td>
			</tr>
			<tr>
				<td rowspan="2">4-1</td>
				<td>故障の為の緊急パーツ</td>
				<td><%=insertDataDto.get_4E1()%></td>
			</tr>
			<tr>
				
				<td>消耗品、保全用の予備パーツ</td>
				<td><%=insertDataDto.get_4G1()%></td>
			</tr>
			<tr>
				<td>4-2</td>
				<td>パーツの納期はどうでしたか。</td>
				<td><%=insertDataDto.get_4D2()%></td>
			</tr>
			<tr>
				<td align="center">※</td>
				<td>パーツ名</td>
				<td><%=insertDataDto.get_4D3()%></td>
			</tr>
			<tr>
				<td align="center">※</td>
				<td>希望納期</td>
				<td><%=insertDataDto.get_4D4()%></td>
			</tr>
		</table>
	</div>
	<br>
	<div>
		<a><b>5. サービス活動は他社と比べていかがですか。</b></a>
		<table border="1">
			<tr>
				<th>No</th>
				<th>入力項目</th>
				<th>入力データ</th>
			</tr>
			<tr>
				<td></td>
				<td>他社と比べてはいかがでしたか。</td>
				<td><%=insertDataDto.get_5B1()%></td>
			</tr>
			<tr>
				<td>5-1</td>
				<td>比較された他社名</td>
				<td><%=insertDataDto.get_5E1()%></td>
			</tr>
			<tr>
				<td rowspan="5">5-2</td>
				<td>サービス活動全体</td>
				<td><%=insertDataDto.get_5C2()%></td>
			</tr>
			<tr>
				
				<td>サービスコール対応</td>
				<td><%=insertDataDto.get_5E2()%></td>
			</tr>
			<tr>
				
				<td>対応の迅速性</td>
				<td><%=insertDataDto.get_5G2()%></td>
			</tr>
			<tr>
				
				<td>修理技術</td>
				<td><%=insertDataDto.get_5I2()%></td>
			</tr>
			<tr>
				
				<td>パーツ対応</td>
				<td><%=insertDataDto.get_5K2()%></td>
			</tr>
			<tr>
				<td align="center">※</td>
				<td>5項について具体的にコメントがあればお願いします。</td>
				<td><%=insertDataDto.get_5B4()%></td>
			</tr>
			<tr>
				<td  rowspan="5">5-3</td>
				<td>サービス活動全体</td>
				<td><%=insertDataDto.get_5C3()%></td>
			</tr>
			<tr>
				
				<td>サービスコール対応</td>
				<td><%=insertDataDto.get_5E3()%></td>
			</tr>
			<tr>
				
				<td>対応の迅速性</td>
				<td><%=insertDataDto.get_5G3()%></td>
			</tr>
			<tr>
				
				<td>修理技術</td>
				<td><%=insertDataDto.get_5I3()%></td>
			</tr>
			<tr>
				
				<td>パーツ対応</td>
				<td><%=insertDataDto.get_5K3()%></td>
			</tr>
			<tr>
				<td align="center">※</td>
				<td>5項について具体的にコメントがあればお願いします。</td>
				<td><%=insertDataDto.get_5B5()%></td>
			</tr>
		</table>
	</div>
	<br>
	<div>
		<a><b>6. サービス全体に関してご意見、ご要望がありましたらお聞かせください。</b></a>
		<table border="1">
			<tr>
				<th>入力項目</th>
				<th>入力データ</th>
			</tr>
			<tr>
				<td>ご意見、ご要望</td>
				<td><%=insertDataDto.get_6A1()%></td>
			</tr>
		</table>
	</div>
	<br>
	<div>
		<a><b>7. 当社製品に関してご意見、ご要望がありましたらお聞かせください。</b></a>
		<table border="1">
			<tr>
				<th>入力項目</th>
				<th>入力データ</th>
			</tr>
			<tr>
				<td>ご意見、ご要望</td>
				<td><%=insertDataDto.get_7A1()%></td>
			</tr>
		</table>
	</div>
	<br>
	<div>
	<a><b>登録しますか？？</b></a>
	<form action ="./CompleteServlet" method="post">
	<input type= "submit" value ="登録">
	</form>
	</div>
	<br>
	<div>
	<a href="javascript:history.back()">[読込に戻る]</a>
	</div>
</body>
</html>