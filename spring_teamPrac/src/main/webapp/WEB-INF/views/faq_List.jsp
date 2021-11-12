<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<html>
<head>
<title>FAQList</title>
<style type="text/css">
li {
	display: inline;
}
</style>

</head>

<body>

	<a href="/faq_enroll">게시판 등록</a>

	<br>
	<form method="get" class="moveForm">
		<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum }">
		<b>페이지</b><input type="number" name="amount" value="${pageMaker.cri.amount }" min="1" max="20">
		<input type="submit" value="줄 보기">
	</form>
	

	<table border="1">

		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>내용</td>
			<td>등록일</td>
		</tr>

		<c:forEach var="faq_List" items="${faq_List}">
			<tr>
				<td>${faq_List.faq_no}</td>
    			<td><a href="/faq_contents?faq_no=${faq_List.faq_no}">${faq_List.faq_title}</a></td>				
				<td>${faq_List.faq_content}</td>
				<td><fmt:formatDate pattern="yyyy/MM/dd" value="${faq_List.faq_regdate}"/></td>
				<%-- <td><a href="/delete?bno=${faq_List.faq_no}">삭제하기</a></td> --%>
			</tr>
		</c:forEach>

	</table>
	<form id="jumpForm" method="get">    
    </form>



	<div class="pageInfo">
		<c:if test="${pageMaker.prev}">
			<li><a href="${pageMaker.startPage -1}">이전</a></li>
		</c:if>

		<c:forEach var="num" begin="${pageMaker.startPage}"
			end="${pageMaker.endPage}">
			<li><a href="${num}">${num}</a></li>
		</c:forEach>

		<c:if test="${pageMaker.next}">
			<li><a href="${pageMaker.endPage + 1}">다음</a></li>
		</c:if>
	</div>




	<script src="https://code.jquery.com/jquery-3.6.0.js"
		integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
		crossorigin="anonymous"></script>

	<script>
		
		/* 페이징 */
		$(function() {
			var moveForm = $(".moveForm");
			$(".pageInfo a").on("click", function(e) {
				e.preventDefault();
				moveForm.find("input[name ='pageNum']").val($(this).attr("href"));
				moveForm.attr("action", "/faq_List");
				moveForm.submit();

			})

		});
		
		$(document).ready(function(){
			let result = '<c:out value="${result}"/>';
			checkAlert(result);
			
			function checkAlert(result) {
				if(result == ''){
					return;
				}
				if(result == "faq 게시글 등록 성공"){
					alert("등록이 완료 되었습니다.")
				}
				
				if(result === "faq 게시글 수정 성공"){
		            alert("수정이 완료되었습니다.");
		        }
				
				if(result === "faq 게시글 삭제 성공"){
		            alert("삭제가 완료되었습니다.");
		        }
			}
			
		});	
		

	    let jumpForm = $("#jumpForm");
	 
	    $(".move").on("click", function(e){
	        e.preventDefault();
	        
	        moveForm.append("<input type='hidden' name='faq_no' value='"+ $(this).attr("href")+ "'>");
	        moveForm.attr("action", "/faq_contents");
	        moveForm.submit();
	    });
		
	
	</script>
</body>
</html>
