<!-- 2018. 08. 08 공세준  -->
<!-- p143 의 쿼리 실행 결과를 보여주는 view 페이지 입니다. -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- Tag라이브러리(JSTL) 사용하기 위해 정의 해줍니다. c라는 별명을 주고 core태그를 사용합니다 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<!-- 부트스트랩 소스코드를 가져옵니다. -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<title>p143. 쿼리 실행 결과</title>
	</head>
	<body>
		<div class="page-header text-center">
			<h1>P143. 쿼리 실행 결과</h1>
		</div>
		<table class="table table-hover table-responsive">
			<thead>
				<tr>
					<th>번호(학생)</th>
					<th>이름</th>
					<th>번호(점수)</th>
					<th>역사</th>
					<th>과학</th>
				</tr>
			</thead>
			<tbody>
				<!-- 컨트롤러에서 받은 list만큼 반복하고 student 변수를 사용합니다. -->
				<c:forEach var="student" items="${list}">
					<tr>
						<td>${student.nameList.no}</td> <!-- student 변수를 참조하여 nameList에 no 값을 가져옵니다. -->
						<td>${student.nameList.name}</td> <!-- student 변수를 참조하여 nameList에 name을 가져옵니다. -->
						<td>${student.grades.no}</td> <!-- student 변수를 참조하여  grades에 no 값을 가져옵니다.  -->
						<td>${student.grades.history}</td> <!-- student 변수를 참조하여 grades에 history 값을 가져옵니다. -->
						<td>${student.grades.science}</td> <!-- student 변수를 참조하여 grades에 science 값을 가져옵니다. -->
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>