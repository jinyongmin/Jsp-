/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.69
 * Generated at: 2022-12-02 05:31:45 UTC
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
import java.text.SimpleDateFormat;
import java.util.Date;

public final class list_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/board/../include/sessioncheck.jsp", Long.valueOf(1669781319526L));
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
    _jspx_imports_classes.add("java.util.Date");
    _jspx_imports_classes.add("java.text.SimpleDateFormat");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');

	if(session.getAttribute("userid")==null){
	response.sendRedirect("/Day7/login.jsp");
	return;
	} 


      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	int totalCount = 0;
	int pagePerCount = 10;	// 페이지당 글 갯수
	int start = 0;	// mysql 시작 글번호
	
	String pageNum = request.getParameter("pageNum");
	if(pageNum != null && !pageNum.equals("")){
		start = (Integer.parseInt(pageNum) - 1) * pagePerCount;
	}else{
		pageNum = "1";
		start = 0;
	}
	
	try{
		conn = Dbconn.getConnection();
		if(conn != null){
			String sql = "select count(b_idx) as total from tb_fileboard";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				totalCount = rs.getInt("total");
			}
			
			sql = "select * from tb_fileboard order by b_idx desc limit ?, ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, pagePerCount);
			rs = pstmt.executeQuery();
		}
	}catch(Exception e){
		e.printStackTrace();
	}

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>리스트</title>\r\n");
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
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<h2>리스트</h2>\r\n");
      out.write("	<p>총 게시글 : ");
      out.print(totalCount);
      out.write(" 개</p>\r\n");
      out.write("	<table>\r\n");
      out.write("		<tr>\r\n");
      out.write("			<th>번호</th>\r\n");
      out.write("			<th>제목</th>\r\n");
      out.write("			<th>글쓴이</th>\r\n");
      out.write("			<th>조회수</th>\r\n");
      out.write("			<th>날짜</th>\r\n");
      out.write("			<th>좋아요</th>\r\n");
      out.write("		</tr>\r\n");

	while(rs.next()){
		String b_idx = rs.getString("b_idx");
		String b_title = rs.getString("b_title");
		String b_userid = rs.getString("b_userid");
		String b_name = rs.getString("b_name");
		String b_regdate = rs.getString("b_regdate");
		String b_hit = rs.getString("b_hit");
		String b_like = rs.getString("b_like");
		String b_filename = rs.getString("b_filename");
		
		// Date date = new Date(b_regdate.substring(0, 10));
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = transFormat.parse(b_regdate);
		long now = System.currentTimeMillis();
		long inputDate = date.getTime();
		
		String sql = "select count(re_idx) as cnt from tb_filereply where re_boardidx=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, b_idx);
		ResultSet rs_reply = pstmt.executeQuery();
		
		String replyCnt = "";
		
		if(rs_reply.next()){
			int cnt = rs_reply.getInt("cnt");
			if(cnt > 0){
				replyCnt = "[" + cnt + "]";
			}
		}

      out.write("\r\n");
      out.write("		<tr>\r\n");
      out.write("			<td>");
      out.print(b_idx );
      out.write("</td>\r\n");
      out.write("			<td><a href=\"view.jsp?b_idx=");
      out.print(b_idx );
      out.write('"');
      out.write('>');
      out.print(b_title );
      out.write("</a> ");
      out.print(replyCnt );
      out.write("\r\n");
      out.write("			");

				if(now - inputDate < (1000*60*60*24*1)){
			
      out.write("\r\n");
      out.write("				<img src=\"./new.png\" alt=\"새글\">\r\n");
      out.write("			");

				}
			
      out.write("\r\n");
      out.write("			");

				if(b_filename != null && !b_filename.equals("")){
			
      out.write("\r\n");
      out.write("				<img src=\"./pic.png\" alt=\"파일\">\r\n");
      out.write("			");

				}
			
      out.write("\r\n");
      out.write("			\r\n");
      out.write("			</td>\r\n");
      out.write("			<td>");
      out.print(b_userid );
      out.write('(');
      out.print(b_name );
      out.write(")</td>\r\n");
      out.write("			<td>");
      out.print(b_hit );
      out.write("</td>\r\n");
      out.write("			<td>");
      out.print(b_regdate );
      out.write("</td>\r\n");
      out.write("			<td>");
      out.print(b_like );
      out.write("</td>\r\n");
      out.write("		</tr>\r\n");

	}
	int pageNums = 0; // 총 페이지 수
	if(totalCount % pagePerCount == 0){
		pageNums = (totalCount / pagePerCount);
	}else{
		pageNums = (totalCount / pagePerCount) + 1;
	}

      out.write("\r\n");
      out.write("		<tr>\r\n");
      out.write("			<td colspan=\"6\">\r\n");
      out.write("			");

				for(int i=1; i<=pageNums; i++){
					out.print("<a href='list.jsp?pageNum=" + i + "'>[" + i + "]</a>&nbsp;&nbsp;&nbsp;");
				}
			
      out.write("\r\n");
      out.write("			</td>\r\n");
      out.write("		</tr>\r\n");
      out.write("	</table>\r\n");
      out.write("	<p><a href=\"write.jsp\">글쓰기</a> <a href=\"../login.jsp\">돌아가기</a></p>\r\n");
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
