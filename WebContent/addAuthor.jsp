<%@page import="java.util.Vector"%>
<%@page import="test.*" %>
<%@ include file="header.jsp" %>

									<div class="post">
										<h2 class="title">Add an Author</h2>
										
										<div class="entry">
										<%
											if (show("added", request) != null) {
										
										%>
											<center> Added successfully</center>
										<%
											}
											if (show("notFound", request) != null) {
										%>
											<center>The author can not be found!</center>
										<%
											}
											if (show("edited", request) != null) {
										%>
											<center>The Author updated!</center>
										<%
											}
											if (show("deleted", request) != null) {
										%>
											<center>The Author Deleted!</center>
										<%
											}
										%>
										
											<form action="Authors-insert.do" method="post">
												<table>
													<tr>
														<td>Author name:</td><td><input type="text" name="author_name" size="36" /></td>
													</tr>
													<tr>
														<td>Email:</td><td><input type="text" name="author_email" size="36" /></td>
													</tr>
													<tr>
														<td>Web-site:</td><td><input type="text" name="author_website" size="36" /></td>
													</tr>
													
													<tr>
														<td></td><td><input type="submit" value=" + Add this Author" /></td>
													</tr>
												</table>
											</form>
										</div>
									</div>
									
									<div class="post">
										<h2 class="title">Manage Authors</h2>
										<div class="entry">
											<table width="100%">
												<% for (Author author : (Vector<Author>)show("Authors",request)) { %>
													<tr> <td><strong><%= author.getName() %></strong></td><td><a href="Authors-edit.do?id=<%= author.getID() %>">[Edit]</a> - <a href="Authors-delete.do?id=<%= author.getID() %>">[Delete]</a></td></tr>
												<% } %>
												</table>
										</div>
									</div>
									
								
<%@ include file="sidebar.jsp" %>							
<%@ include file="footer.jsp" %>	
