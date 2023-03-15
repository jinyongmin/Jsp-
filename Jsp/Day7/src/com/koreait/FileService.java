package com.koreait;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import com.koreait.db.FileBoardDAO;
import com.koreait.db.FileBoardDTO;
public class FileService {
	public static String SAVE_PATH = "D:/Ryuzy/Jsp/Day7/WebContent/board/upload";
	public static int MAX_SIZE = 1024 * 1024 * 100;
	public static String ENC_FORMAT = "UTF-8";
	private FileBoardDAO fileBoardDAO = null;
	
	public FileService() {
		fileBoardDAO = new FileBoardDAO();
	}
	public boolean dataUpload(String userid, String name, String title, String content) {
		FileBoardDTO fileBoardDTO = new FileBoardDTO();
		fileBoardDTO.setUserid(userid);
		fileBoardDTO.setName(name);
		fileBoardDTO.setTitle(title);
		fileBoardDTO.setContent(content);
		
		return fileBoardDAO.insertData(fileBoardDTO);
	}
	
	public boolean dataUpload(String userid, String name, String title, String content, File file) {
		FileBoardDTO fileBoardDTO = new FileBoardDTO();
		fileBoardDTO.setUserid(userid);
		fileBoardDTO.setName(name);
		fileBoardDTO.setTitle(title);
		fileBoardDTO.setContent(content);
		fileBoardDTO.setFilename(file.getName());
		
		boolean isSuccess = fileBoardDAO.insertData(fileBoardDTO);
		if(isSuccess) {
			moveFile(fileBoardDTO, file);
		}
		return isSuccess;
	}
	
	public void moveFile(FileBoardDTO fileBoardDTO, File file) {
		File dir = new File(SAVE_PATH + "/" + getToday());
		if(!dir.isDirectory()) {
			dir.mkdir();
		}
		if(file.isFile()) {
			File newFile = new File(SAVE_PATH + fileBoardDTO.getFilepath());
			file.renameTo(newFile);
			
		}
	}
	
	public static String getToday() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(cal.getTime());
	}
}