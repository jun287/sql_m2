<!-- 2018. 08. 06 공세준 -->
<!-- p122 의 쿼리 실행 결과를 보여주는 view 페이지 입니다. -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- Tag라이브러리(JSTL) 사용하기 위해 정의 해줍니다. c라는 별명을 주고 core태그를 사용합니다 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<title>P122 쿼리 실행 결과</title>
	</head>
	<body>
		<div class="page-header text-center">
			<h1>P122. 쿼리 실행 결과</h1>
		</div>
		<table class="table table-hover table-responsive">
			<thead>
				<tr>
					<th>케익이름</th>
					<th>가격</th>
				</tr>
			</thead>
			<tbody>
				<!-- 컨트롤러에서 받은 list만큼 반복하고 cake 변수를 사용합니다. -->
				<c:forEach var="cake" items="${list}">
					<tr>
						<td>${cake.name}</td><!-- cake 변수를 참조하여 name 값을 가져옵니다.  -->
						<td>${cake.price}</td><!-- cake 변수를 참조하여 price 값을 가져옵니다. -->
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>