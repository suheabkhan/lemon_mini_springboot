<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
	<div class="container">


		<form:form method="post" modelAttribute="toDoModel">
			<form:hidden path="id"/>
			<fieldset class="form-group">
			<form:label path="desc">Description</form:label>
				<form:input path="desc" type="text"
					class="form-control" required="required"/>
			</fieldset>
			<fieldset class="form-group">
            				<form:label path="date">Target Date</form:label>
            				<form:input path="date" type="text" class="form-control"
            					required="required" />
            			</fieldset>

			<button type="submit" class="btn btn-success">Add</button>
		</form:form>
	</div>

<%@ include file="common/footer.jspf" %>