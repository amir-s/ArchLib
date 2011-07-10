<%@page import="java.util.Vector"%>
<%@page import="test.*" %>
<%@ include file="header.jsp" %>

									<div class="post">
									<%
										if (show("added", request) != null) {
									%>
										<center>Added successfully</center>
										<%} %>
										<h2 class="title">Add a book</h2>
										<div class="entry">
											<form action="Books-insert.do" method="post" enctype="multipart/form-data">
												<table>
													<tr>
														<td>Book title:</td><td><input type="text" name="book_title" size="36" /></td>
													</tr>
													<tr>
														<td>Author:</td>
														<td>
															<select name="author_id">
																<%
																	for (Author author : (Vector<Author>)show("Authors",request)) {
																%>
																<option value="<%=author.getID()%>"><%=author.getName()%></option>
																<%
																	}
																%>
															</select>
														</td>
													</tr>
													<tr>
														<td>ISBN:</td><td><input type="text" name="book_isbn" size="36" /></td>
													</tr>
													<tr>
														<td>Year:</td><td><input type="text" name="book_year" size="36" /></td>
													</tr>
													<tr>
														<td>Publisher:</td><td><input type="text" name="book_publisher" size="36" /></td>
													</tr>
													<tr>
														<td>PDF file:</td>
														<td><input type="file" name="pdf_file" /></td>
													</tr>
													<tr>
														<td></td><td><input type="submit" value=" + Add this book" /></td>
												</table>
											</form>
										</div>
									</div>
									
								
<%@ include file="sidebar.jsp" %>							
<%@ include file="footer.jsp" %>	
