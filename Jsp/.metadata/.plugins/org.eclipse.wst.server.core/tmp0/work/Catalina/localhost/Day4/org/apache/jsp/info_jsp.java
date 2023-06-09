/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.69
 * Generated at: 2022-11-22 04:36:27 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import com.koreait.db.Dbconn;

public final class info_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

public static boolean compareHobby(String[] arr, String item) {
		for (String i : arr) {
			if (i.equals(item)) {
				return true;
			}
		}
		return false;
	}
  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/./include/sessioncheck.jsp", Long.valueOf(1669091764656L));
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
      out.write('\r');
      out.write('\n');

	// String idx = (String)session.getAttribute("idx"); // idx를 사용하여 검색하면 속도가 유리(인덱싱)
	String userid = (String) session.getAttribute("userid");

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String mem_name = "";

	String mem_hp = "";
	String mem_email = "";
	String[] hobbyArr = null;
	String mem_ssn1 = "";
	String mem_ssn2 = "";
	String mem_zipcode = "";
	String mem_address1 = "";
	String mem_address2 = "";
	String mem_address3 = "";
	String mem_gender = "";

	try {
		conn = Dbconn.getConnection();
		if (conn != null) {
			// *(별표) 절대 사용하지 말것!
			String sql = "select * from tb_member where mem_userid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				mem_hp = rs.getString("mem_hp");
				mem_name = rs.getString("mem_name");
				mem_email = rs.getString("mem_email");
				hobbyArr = rs.getString("mem_hobby").split(" ");
				mem_ssn1 = rs.getString("mem_ssn1");
				mem_ssn2 = rs.getString("mem_ssn2");
				mem_zipcode = rs.getString("mem_zipcode");
				mem_address1 = rs.getString("mem_address1");
				mem_address2 = rs.getString("mem_address2");
				mem_address3 = rs.getString("mem_address3");
				mem_gender = rs.getString("mem_gender");
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("<title>정보수정</title>\r\n");
      out.write("<script defer src=\"./js/info.js\"></script>\r\n");
      out.write("<script src=\"//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("    function sample6_execDaumPostcode() {\r\n");
      out.write("        new daum.Postcode({\r\n");
      out.write("            oncomplete: function(data) {\r\n");
      out.write("                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.\r\n");
      out.write("\r\n");
      out.write("                // 각 주소의 노출 규칙에 따라 주소를 조합한다.\r\n");
      out.write("                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.\r\n");
      out.write("                var addr = ''; // 주소 변수\r\n");
      out.write("                var extraAddr = ''; // 참고항목 변수\r\n");
      out.write("\r\n");
      out.write("                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.\r\n");
      out.write("                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우\r\n");
      out.write("                    addr = data.roadAddress;\r\n");
      out.write("                } else { // 사용자가 지번 주소를 선택했을 경우(J)\r\n");
      out.write("                    addr = data.jibunAddress;\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.\r\n");
      out.write("                if(data.userSelectedType === 'R'){\r\n");
      out.write("                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)\r\n");
      out.write("                    // 법정동의 경우 마지막 문자가 \"동/로/가\"로 끝난다.\r\n");
      out.write("                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){\r\n");
      out.write("                        extraAddr += data.bname;\r\n");
      out.write("                    }\r\n");
      out.write("                    // 건물명이 있고, 공동주택일 경우 추가한다.\r\n");
      out.write("                    if(data.buildingName !== '' && data.apartment === 'Y'){\r\n");
      out.write("                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);\r\n");
      out.write("                    }\r\n");
      out.write("                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.\r\n");
      out.write("                    if(extraAddr !== ''){\r\n");
      out.write("                        extraAddr = ' (' + extraAddr + ')';\r\n");
      out.write("                    }\r\n");
      out.write("                    // 조합된 참고항목을 해당 필드에 넣는다.\r\n");
      out.write("                    document.getElementById(\"sample6_extraAddress\").value = extraAddr;\r\n");
      out.write("                \r\n");
      out.write("                } else {\r\n");
      out.write("                    document.getElementById(\"sample6_extraAddress\").value = '';\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("                // 우편번호와 주소 정보를 해당 필드에 넣는다.\r\n");
      out.write("                document.getElementById('sample6_postcode').value = data.zonecode;\r\n");
      out.write("                document.getElementById(\"sample6_address\").value = addr;\r\n");
      out.write("                // 커서를 상세주소 필드로 이동한다.\r\n");
      out.write("                document.getElementById(\"sample6_detailAddress\").focus();\r\n");
      out.write("            }\r\n");
      out.write("        }).open();\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<h2>정보수정</h2>\r\n");
      out.write("	<form action=\"./info_ok.jsp\" name=\"regform\" id=\"regform\" method=\"post\"\r\n");
      out.write("		onsubmit=\"return sendit()\">\r\n");
      out.write("		<p>\r\n");
      out.write("			아이디:\r\n");
      out.write("			");
      out.print(userid);
      out.write("</p>\r\n");
      out.write("		<p>\r\n");
      out.write("			비밀번호: <input type=\"password\" name=\"userpw\" id=\"userpw\" maxlength=\"20\"\r\n");
      out.write("				onsubmit=\"return sendit()\">\r\n");
      out.write("		</p>\r\n");
      out.write("		<p>\r\n");
      out.write("			비밀번호 확인: <input type=\"password\" name=\"userpw_re\" id=\"userpw_re\"\r\n");
      out.write("				maxlength=\"20\">\r\n");
      out.write("		</p>\r\n");
      out.write("		<p>\r\n");
      out.write("			이름: <input type=\"text\" name=\"name\" id=\"name\" value=\"");
      out.print(mem_name);
      out.write("\">\r\n");
      out.write("		</p>\r\n");
      out.write("		<p>\r\n");
      out.write("			휴대폰번호: <input type=\"text\" name=\"hp\" id=\"hp\" value=\"");
      out.print(mem_hp);
      out.write("\">\r\n");
      out.write("		</p>\r\n");
      out.write("		<p>\r\n");
      out.write("			이메일: <input type=\"text\" name=\"email\" id=\"email\"\r\n");
      out.write("				value=\"");
      out.print(mem_email);
      out.write("\">\r\n");
      out.write("		</p>\r\n");
      out.write("		<p>\r\n");
      out.write("			성별: <label>남자<input type=\"radio\" name=\"gender\" value=\"남자\"\r\n");
      out.write("				");
if (mem_gender.equals("남자"))
				out.print("checked");
      out.write("></label> <label>여자<input\r\n");
      out.write("				type=\"radio\" name=\"gender\" value=\"여자\"\r\n");
      out.write("				");
if (mem_gender.equals("여자"))
				out.print("checked");
      out.write("></label>\r\n");
      out.write("		</p>\r\n");
      out.write("		<p>\r\n");
      out.write("			취미: <label>등산<input type=\"checkbox\" name=\"hobby\" value=\"등산\"\r\n");
      out.write("				");
if (compareHobby(hobbyArr, "등산"))
				out.print("checked");
      out.write("></label>\r\n");
      out.write("			<label>게임<input type=\"checkbox\" name=\"hobby\" value=\"게임\"\r\n");
      out.write("				");
if (compareHobby(hobbyArr, "게임"))
				out.print("checked");
      out.write("></label>\r\n");
      out.write("			<label>영화감상<input type=\"checkbox\" name=\"hobby\" value=\"영화감상\"\r\n");
      out.write("				");
if (compareHobby(hobbyArr, "영화감상"))
				out.print("checked");
      out.write("></label>\r\n");
      out.write("			<label>드라이브<input type=\"checkbox\" name=\"hobby\" value=\"드라이브\"\r\n");
      out.write("				");
if (compareHobby(hobbyArr, "드라이브"))
				out.print("checked");
      out.write("></label>\r\n");
      out.write("			<label>운동<input type=\"checkbox\" name=\"hobby\" value=\"운동\"\r\n");
      out.write("				");
if (compareHobby(hobbyArr, "운동"))
				out.print("checked");
      out.write("></label>\r\n");
      out.write("		</p>\r\n");
      out.write("		<p>\r\n");
      out.write("			주민번호: <input type=\"text\" name=\"ssn1\" value=\"");
      out.print(mem_ssn1);
      out.write("\"> -\r\n");
      out.write("			<input type=\"text\" name=\"ssn2\" value=\"");
      out.print(mem_ssn2);
      out.write("\">\r\n");
      out.write("		</p>\r\n");
      out.write("		<p>\r\n");
      out.write("			우편번호: <input type=\"text\" name=\"zipcode\" maxlength=\"5\"\r\n");
      out.write("				id=\"sample6_postcode\" value=\"");
      out.print(mem_zipcode);
      out.write("\">\r\n");
      out.write("			<button onclick=\"sample6_execDaumPostcode()\" type=\"button\">검색</button>\r\n");
      out.write("		</p>\r\n");
      out.write("		<p>\r\n");
      out.write("			주소: <input type=\"text\" name=\"address1\" id=\"sample6_address\"\r\n");
      out.write("				value=\"");
      out.print(mem_address1);
      out.write("\">\r\n");
      out.write("		</p>\r\n");
      out.write("		<p>\r\n");
      out.write("			상세주소: <input type=\"text\" name=\"address2\" id=\"sample6_detailAddress\"\r\n");
      out.write("				value=\"");
      out.print(mem_address2);
      out.write("\">\r\n");
      out.write("		</p>\r\n");
      out.write("		<p>\r\n");
      out.write("			참고항목: <input type=\"text\" name=\"address3\" id=\"sample6_extraAddress\"\r\n");
      out.write("				value=\"");
      out.print(mem_address3);
      out.write("\">\r\n");
      out.write("		</p>\r\n");
      out.write("		<p>\r\n");
      out.write("			<button>수정완료</button>\r\n");
      out.write("			<button type=\"reset\">다시작성</button>\r\n");
      out.write("			<button type=\"button\" onclick=\"location.href='login.jsp'\">돌아가기</button>\r\n");
      out.write("		</p>\r\n");
      out.write("	</form>\r\n");
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
