package com.koreait.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.koreait.FileService;
public class FileBoardDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "";
	String[] generatedColumns = {"b_idx"};
	
	public boolean insertData(FileBoardDTO fileBoardDTO) {
		try {
			conn = Dbconn.getConnection();
			sql = "insert into tb_fileboard(b_userid, b_name, b_title, b_content, b_filename) values (?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql, generatedColumns);
			pstmt.setString(1, fileBoardDTO.getUserid());
			pstmt.setString(2, fileBoardDTO.getName());
			pstmt.setString(3, fileBoardDTO.getTitle());
			pstmt.setString(4, fileBoardDTO.getContent());
			pstmt.setString(5, fileBoardDTO.getFilename());
			int result = pstmt.executeUpdate();
			
			try(ResultSet geneResultKey = pstmt.getGeneratedKeys()){
				if(geneResultKey.next()) {
					fileBoardDTO.setIdx(geneResultKey.getInt(1));
				}
			}
			
			if(result >= 1) {
				if(fileBoardDTO.getFilename() != null) {
					fileBoardDTO = this.updateFilePath(fileBoardDTO);
				}
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public FileBoardDTO updateFilePath(FileBoardDTO fileBoardDTO) {
		try {
			conn = Dbconn.getConnection();
			sql = "update tb_fileboard set b_filepath=? where b_idx=?";
			pstmt = conn.prepareStatement(sql);
			String tmp = "/" + FileService.getToday() + "/" + fileBoardDTO.getFilename();
			fileBoardDTO.setFilepath(tmp);
			pstmt.setString(1, tmp);
			pstmt.setInt(2, fileBoardDTO.getIdx());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return fileBoardDTO;
	}
}