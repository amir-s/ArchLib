<%@page import="test.Book"%>
<%@page import="java.util.Vector"%>
<%@ include file="header.jsp" %>

									<div class="post">
										<h2 class="title"><a href="#">Welcome to ArchLib</a></h2>
										<p class="meta">By <a href="#">Amir Saboury</a> on someday!</p>
										
										
										<% for (Book book : (Vector<Book>)show("Books",request)) { %>
										<div class="entry">
											<p>
											<img src="images/ebook.png" class="alignleft border" />
											<table width="60%">
												<tr>
													<td width="30%">Book title:</td>
													<td><b><%= book.getTitle() %></b></td>
												</tr>
												<tr>
													<td>ISBN:</td>
													<td><b><%= book.getIsbn() %></td>
												</tr>
												<tr>
													<td>Author:</td>
													<td><b><%= book.getAuthor().getName() %></b></td>
												</tr>
												<tr>
													<td>Download:</td>
													<td><b><a href="Download?id=<%= book.getId()%>">Click here</a></b></td>
												</tr>
												
											</table>
											
											
											</p>
											
										</div>
										
										<div style="clear:both;"></div>
										<%} %>
										
										
										
										
										
										
									</div>
									
								
<%@ include file="sidebar.jsp" %>							
<%@ include file="footer.jsp" %>	