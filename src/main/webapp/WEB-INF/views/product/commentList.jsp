<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
	<div>
	<table class="table">
	<c:forEach items="${list}" var="v">
		<tr>
			<td>${v.username}</td>
			<td>${v.boardContents}</td>
			<td>${v.boardDate}</td>
		</tr>
		
		
	</c:forEach>
	</table>  
	</div>
    <div class="row justify-content-between col-sm-8 offset-sm-2">
     <nav aria-label="Page navigation example">
	  <ul class="pagination ">
	    <li class="page-item">
	      <a class="page-link" href="./list?page=${pager.begin-1}&kind=${param.kind}&search=${param.search}" aria-label="Previous">
	        <span aria-hidden="true">&laquo;</span>
	      </a>
	    </li>
	    <c:forEach begin="${pager.begin}" end="${pager.end}" var="i">
	    <li class="page-item"><a class="page-link" href="./list?page=${i}&kind=${param.kind}&search=${param.search}">${i}</a></li>
	    </c:forEach>
	    <li class="page-item">
	      <a class="page-link" href="./list?page=${pager.end+1}&kind=${param.kind}&search=${param.search}" aria-label="Next">
	        <span aria-hidden="true">&raquo;</span>
	      </a>
	    </li>
	  </ul>
	</nav>
   </div>  
    