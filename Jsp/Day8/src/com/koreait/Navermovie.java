package com.koreait;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.koreait.db.Dbconn;
public class Navermovie {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql="";
	
	public  boolean movie(Movie_ok member) {
		try {
			sql="insert into tb_movie(tb_title,tb_score,tb_review)values(?, ?, ?)";
			conn = Dbconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  member.getTb_title());
			pstmt.setString(2,  member.getTb_score());
			pstmt.setString(3,  member.getTb_review());
	
		
		
		
				return true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}