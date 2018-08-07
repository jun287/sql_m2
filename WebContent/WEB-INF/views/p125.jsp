<!-- 2018. 08. 07 공세준 -->
<!-- p125 의 쿼리 실행 결과를 보여주는 view 페이지 입니다. -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<title>P125. 쿼리 실행 결과</title>
	</head>
	<body>
		<div class="page-header text-center">
			<h1>P125. 쿼리 실행 결과</h1>
		</div>
		<table class="table table-hover table-responsive">
			<thead>
				<tr>
					<th>가격</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${requestScope.cake.price}</td><!-- cake 객체를 참조하여 price 값을 가져옵니다. -->
				</tr>
			</tbody>
		</table>
	</body>
</html>