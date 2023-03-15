package com.koreait;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.koreait.db.Dbconn;

public class MemberDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql = "";

	public boolean join(Member member) {
		try {
			sql = "insert into tb_member(mem_userid, mem_userpw, mem_name, mem_hp, mem_email, mem_hobby, mem_ssn1, mem_ssn2, mem_zipcode, mem_address1, mem_address2, mem_address3, mem_gender) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			conn = Dbconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getUserid());
			pstmt.setString(2, member.getUserpw());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getHp());
			pstmt.setString(5, member.getEmail());
			String hobbystr = "";
			for (String hobby : member.getHobby()) {
				hobbystr = hobbystr + hobby + " ";
			}
			pstmt.setString(6, hobbystr);
			pstmt.setString(7, member.getSsn1());
			pstmt.setString(8, member.getSsn2());
			pstmt.setString(9, member.getZipcode());
			pstmt.setString(10, member.getAddress1());
			pstmt.setString(11, member.getAddress1());
			pstmt.setString(12, member.getAddress3());
			pstmt.setString(13, member.getGender());
			if (pstmt.executeUpdate() >= 1) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Member login(Member member) {
		String sql = "select mem_idx, mem_name from tb_member where mem_userid=? and mem_userpw=?";
		try {
			conn = Dbconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getUserid());
			pstmt.setString(2, member.getUserpw());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				member.setIdx(rs.getInt("mem_idx"));
				member.setName(rs.getString("mem_name"));
				return member;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Member info(Member member) {
		String sql = "select * from tb_member where mem_userid=?";
		try {
			conn = Dbconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getUserid());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				member.setIdx(rs.getInt("mem_idx"));
				member.setName(rs.getString("mem_name"));
				member.setEmail(rs.getString("mem_email"));
				member.setHp(rs.getString("mem_hp"));
				String hobby[] = rs.getString("mem_hobby").split(" ");
				member.setHobby(hobby);
				member.setGender(rs.getString("mem_gender"));
				member.setSsn1(rs.getString("mem_ssn1"));
				member.setSsn2(rs.getString("mem_ssn2"));
				member.setZipcode(rs.getString("mem_zipcode"));
				member.setAddress1(rs.getString("mem_address1"));
				member.setAddress2(rs.getString("mem_address2"));
				member.setAddress3(rs.getString("mem_address3"));
				return member;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean pwCheck(Member member) {
		sql = "select mem_idx from tb_member where mem_userid=? and mem_userpw=?";
		try {
			conn = Dbconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getUserid());
			pstmt.setString(2, member.getUserpw());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean edit(Member member) {
		String sql = "update tb_member set mem_name=?, mem_hp=?, mem_email=?, mem_hobby=?, mem_zipcode=?, mem_address1=?, mem_address2=?, mem_address3=?, mem_gender=? where mem_userid=?";
		try {
			conn = Dbconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getHp());
			pstmt.setString(3, member.getEmail());
			String hobbystr = "";
			for (String hobby : member.getHobby()) {
				hobbystr = hobbystr + hobby + " ";
			}
			pstmt.setString(4, hobbystr);
			pstmt.setString(5, member.getZipcode());
			pstmt.setString(6, member.getAddress1());
			pstmt.setString(7, member.getAddress2());
			pstmt.setString(8, member.getAddress3());
			pstmt.setString(9, member.getGender());
			pstmt.setString(10, member.getUserid());

			if (pstmt.executeUpdate() >= 1) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
