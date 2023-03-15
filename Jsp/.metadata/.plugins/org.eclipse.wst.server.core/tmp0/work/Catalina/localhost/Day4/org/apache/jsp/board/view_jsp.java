/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.69
 * Generated at: 2022-11-24 05:45:51 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import com.koreait.db.Dbconn;

public final class view_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/board/../include/sessioncheck.jsp", Long.valueOf(1669091764656L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("java.sql");
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.koreait.db.Dbconn");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');

		if(session.getAttribute("userid") == null){
		response.sendRedirect("/Day4/login.jsp");	
		return;
		}

      out.write('\r');
      out.write('\n');

	String b_idx = request.getParameter("b_idx");
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String userid = (String)session.getAttribute("userid");
	String name = (String)session.getAttribute("name");
	String b_userid = "";
	String b_name = "";
	String b_title = "";
	String b_content = "";
	String b_regdate = "";
	Boolean isLike = false;
	int b_hit = 0;
	int b_like = 0;
	
	try {
		conn = Dbconn.getConnection();
		if(conn != null){
			String sql = "update tb_board set b_hit = b_hit + 1 where b_idx=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b_idx);
			pstmt.executeUpdate();
			
			sql = "select * from tb_board where b_idx=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b_idx);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				sql = "select li_idx from tb_like where li_boardidx=? and li_userid=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, b_idx);
				pstmt.setString(2, userid);
				ResultSet rs_like = pstmt.executeQuery();
				if(rs_like.next()){
					isLike = true;
				}
				
				b_userid = rs.getString("b_userid");
				b_name = rs.getString("b_name");
				b_title = rs.getString("b_title");
				b_content = rs.getString("b_content");
				b_regdate = rs.getString("b_regdate");
				b_hit = rs.getInt("b_hit");
				b_like = rs.getInt("b_like");
			}
		}
	}catch(Exception e){
		e.printStackTrace();
	}

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>글보기</title>\r\n");
      out.write("<style>\r\n");
      out.write("	table {\r\n");
      out.write("		width: 800px;\r\n");
      out.write("		border: 1px solid black;\r\n");
      out.write("		border-collapse: collapse;\r\n");
      out.write("	}\r\n");
      out.write("	th, td {\r\n");
      out.write("		border: 1px solid black;\r\n");
      out.write("		padding: 10px;\r\n");
      out.write("	}\r\n");
      out.write("	img {\r\n");
      out.write("		width: 16px;\r\n");
      out.write("	}\r\n");
      out.write("</style>\r\n");
      out.write("<script>\r\n");
      out.write("	function del(idx){\r\n");
      out.write("		// alert(idx);\r\n");
      out.write("		const yn = confirm('글을 삭제하시겠습니까?');\r\n");
      out.write("		if(yn) location.href='delete_ok.jsp?b_idx='+ idx;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	function replyDel(re_idx, b_idx){\r\n");
      out.write("		// alert(idx);\r\n");
      out.write("		const yn = confirm('해당 댓글을 삭제하시겠습니까?');\r\n");
      out.write("		if(yn) location.href='reply_del_ok.jsp?re_idx='+ re_idx + \"&b_idx=\" + b_idx;\r\n");
      out.write("	}\r\n");
      out.write("	function like(){\r\n");
      out.write("		const isHeart = document.querySelector(\"img[title=on]\");\r\n");
      out.write("		if(isHeart){\r\n");
      out.write("			document.getElementById('heart').setAttribute('src', './like_off.png');\r\n");
      out.write("			document.getElementById('heart').setAttribute('title', 'off');\r\n");
      out.write("		}else{\r\n");
      out.write("			document.getElementById('heart').setAttribute('src', './like_on.png');\r\n");
      out.write("			document.getElementById('heart').setAttribute('title', 'on');\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("		const xhr = new XMLHttpRequest();\r\n");
      out.write("		xhr.onreadystatechange = function(){\r\n");
      out.write("			if(xhr.readyState == XMLHttpRequest.DONE && xhr.status == 200){\r\n");
      out.write("				document.getElementById('like').innerHTML = xhr.responseText;\r\n");
      out.write("			}\r\n");
      out.write("		}\r\n");
      out.write("		xhr.open('GET', 'like_ok.jsp?b_idx=");
      out.print(b_idx);
      out.write("', true);\r\n");
      out.write("		xhr.send();\r\n");
      out.write("	}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<h2>글보기</h2>\r\n");
      out.write("	<table>\r\n");
      out.write("		<tr>\r\n");
      out.write("			<th>제목</th><td>");
      out.print(b_title );
      out.write("</td>\r\n");
      out.write("		</tr>\r\n");
      out.write("		<tr>\r\n");
      out.write("			<th>날짜</th><td>");
      out.print(b_regdate );
      out.write("</td>\r\n");
      out.write("		</tr>\r\n");
      out.write("		<tr>\r\n");
      out.write("			<th>작성자</th><td>");
      out.print(b_name );
      out.write('(');
      out.print(b_userid );
      out.write(")</td>\r\n");
      out.write("		</tr>\r\n");
      out.write("		<tr>\r\n");
      out.write("			<th>조회수</th><td>");
      out.print(b_hit );
      out.write("</td>\r\n");
      out.write("		</tr>\r\n");
      out.write("		<tr>\r\n");
      out.write("			<th>좋아요</th><td> ");
if(isLike){
      out.write("<img id=\"heart\" src=\"./like_on.png\" alt=\"좋아요\" onclick=\"like()\">\r\n");
      out.write("			");
}else{
      out.write("<img id=\"heart\" src=\"./like_off.png\" alt=\"좋아요\" onclick=\"like()\">");
}
      out.write(" <span id=\"like\">");
      out.print(b_like );
      out.write("</span></td>\r\n");
      out.write("		</tr>\r\n");
      out.write("		<tr>\r\n");
      out.write("			<th>내용</th><td>");
      out.print(b_content );
      out.write("</td>\r\n");
      out.write("		</tr>\r\n");
      out.write("		<tr>\r\n");
      out.write("			<td colspan=\"2\">\r\n");
      out.write("			\r\n");

	if(b_userid.equals(userid)){

      out.write("\r\n");
      out.write("			<input type=\"button\" value=\"수정\" onclick=\"location.href='edit.jsp?b_idx=");
      out.print(b_idx);
      out.write("'\">\r\n");
      out.write("<!--  		<input type=\"button\" value=\"삭제\" onclick=\"location.href='delete_ok.jsp?b_idx=");
      out.print(b_idx);
      out.write("'\"> -->\r\n");
      out.write("			<input type=\"button\" value=\"삭제\" onclick=\"del('");
      out.print(b_idx);
      out.write("')\">\r\n");

	}

      out.write("\r\n");
      out.write("			\r\n");
      out.write("			<input type=\"button\" value=\"리스트\" onclick=\"location.href='list.jsp'\"> </td>\r\n");
      out.write("		</tr>\r\n");
      out.write("	</table>\r\n");
      out.write("	<hr>\r\n");
      out.write("	<form method=\"post\" action=\"re_write_ok.jsp\">\r\n");
      out.write("		<input type=\"hidden\" name=\"b_idx\" value=\"");
      out.print(b_idx);
      out.write("\">\r\n");
      out.write("		<p>");
      out.print(userid);
      out.write('(');
      out.print(name);
      out.write("): <input type=\"text\" name=\"re_content\"> <button>확인</button></p>\r\n");
      out.write("	</form>\r\n");
      out.write("	<hr>\r\n");

	String sql = "select * from tb_reply where re_boardidx=? order by re_idx asc";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, b_idx);
	rs = pstmt.executeQuery();
	
	while(rs.next()){
		String re_idx = rs.getString("re_idx");
		String re_userid = rs.getString("re_userid");
		String re_name = rs.getString("re_name");
		String re_content = rs.getString("re_content");
		String re_regdate = rs.getString("re_regdate");

      out.write("\r\n");
      out.write("	<p>:오른쪽을_가리키는_손_모양: ");
      out.print(re_userid );
      out.write('(');
      out.print(re_name );
      out.write(") : ");
      out.print(re_content );
      out.write(' ');
      out.write('(');
      out.print(re_regdate );
      out.write(")\r\n");
      out.write("		");

			if(re_userid.equals(userid)){	
		
      out.write("\r\n");
      out.write("		<input type=\"button\" value=\"삭제\" onclick=\"replyDel('");
      out.print(re_idx);
      out.write("', '");
      out.print(b_idx);
      out.write("')\">\r\n");
      out.write("		");

			}
		
      out.write("\r\n");
      out.write("	</p>\r\n");

	}

      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}