package com.sy.notice;

import java.util.ArrayList;

public class NoticeService {

	private NoticeDAO noticeDAO;
	
	public NoticeService() {
		this.noticeDAO= new NoticeDAO();
	}
	
	//1. list
	public ArrayList<NoticeDTO> noticeList() throws Exception{
		return noticeDAO.noticeList();
	}
	
	//2. Select
	public NoticeDTO noticeSelect(int num) throws Exception{
		return noticeDAO.noticeSelect(num);
	}
	
	//3. Add
	public int noticeAdd(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.noticeAdd(noticeDTO);
	}
	
	//4. delete
	public int noticeDelete(String num) throws Exception{
		return noticeDAO.noticeDelete(num);
	}
	
	//5. Mod
	public int noticeMod(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.noticeMod(noticeDTO);
	}
	
	
}
