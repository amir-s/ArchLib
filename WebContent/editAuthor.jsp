<%@page import="java.util.Vector"%>
<%@page import="test.*" %>
<%@ include file="header.jsp" %>

									<div class="post">
										<h2 class="title">Edit Author</h2>
										
										<div class="entry">
											<form action="Authors-update.do" method="post">
											<%
												Author auth = (Author)show("Author", request);
											%>
												<table>
													<tr>
														<td>Author name:</td><td><input type="text" name="author_name" size="36" value="<%= auth.getName()%>" /></td>
													</tr>
													<tr>
														<td>Email:</td><td><input type="text" name="author_email" size="36" value="<%= auth.getEmail() %>" /></td>
													</tr>
													<tr>
														<td>Web-site:</td><td><input type="text" name="author_website" size="36" value="<%= auth.getWebsite() %>" /></td>
													</tr>
													
													<tr>
														<td><input type="hidden" name="author_id" value="<%= auth.getID() %>" /></td><td><input type="submit" value=" + Update this Author" /></td>
													</tr>
												</table>
											</form>
										</div>
									</div>
								
<%@ include file="sidebar.jsp" %>							
<%@ include file="footer.jsp" %>	
