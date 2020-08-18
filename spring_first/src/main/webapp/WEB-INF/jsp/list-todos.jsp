<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
<table class="table table-stripped">
<caption>congrats with your todos</caption>
<thead>
<tr>
<th>id</th>
<th>Description</th>
<th>Date</th>
<th>is Done</th>
<th>Update</th>
<th>Delete</th>
</tr>
</thead>
<tbody>
<c:forEach items="${todos}" var="todo">
					<tr>
					    <td>${todo.id}</td>
						<td>${todo.desc}</td>
						<td><fmt:formatDate value="${todo.date}" pattern="dd/MM/yyyy"/></td>
						<td>${todo.done}</td>
						<td><a type="button" class="button btn btn-success" href="/update-todos?id=${todo.id}">Update</a></td>
						<td><a type="button" class="button btn btn-warning" href="/delete-todos?id=${todo.id}">Delete</a></td>
					</tr>
	</c:forEach>
</tbody>
</table>

<div>
<a type="button" class="button btn btn-primary" href="/add-todos">ADD A NEW TODO</a>
</div>
<%@ include file="common/footer.jspf" %>