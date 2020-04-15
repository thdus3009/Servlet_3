package com.sy.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sy.util.DBConnect;

public class NoticeDAO {

	
	//1.List
	public ArrayList<NoticeDTO> noticeList() throws Exception{
		
		ArrayList<NoticeDTO> ar = new ArrayList<NoticeDTO>();//미리만들어놓고 시작
		
		//1.DB연결
		Connection con = DBConnect.getConnection();
		//2.SQL문 작성
		String sql = "select * from notice order by num DESC";
		//3.SQL문 미리전송
		PreparedStatement st = con.prepareStatement(sql);
		//4.?표값 세팅
			/*sql문에 ?가 없기 때문에 넘어간다.*/
		//5.최종 전송 후 결과 처리
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			
			NoticeDTO noticeDTO = new NoticeDTO();//이걸 안에다 만들어야 여러사람을 만들수 있다.
			noticeDTO.setNum(rs.getInt("num"));//clumn명과 같게 작성
			noticeDTO.setSubject(rs.getString("subject"));
			noticeDTO.setId(rs.getString("id"));
			noticeDTO.setDay(rs.getDate("day"));
			noticeDTO.setHit(rs.getInt("hit"));

			ar.add(noticeDTO);
			
		}		
		//6.자원 해제
		rs.close();
		st.close();
		con.close();
		
		return ar;
		
	}
		
	//2.Select
	public NoticeDTO noticeSelect(int num) throws Exception{
		
		NoticeDTO noticeDTO = null;
		
		Connection con = DBConnect.getConnection();
		
		String sql = "select * from notice where num=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);
		
		ResultSet rs = st.executeQuery();
		
		
		System.out.println(rs);
		
		
		if(rs.next()) {
			noticeDTO = new NoticeDTO();
			
			noticeDTO.setNum(rs.getInt("num"));
			noticeDTO.setSubject(rs.getString("subject"));
			noticeDTO.setId(rs.getString("id"));
			noticeDTO.setDay(rs.getDate("day"));
			noticeDTO.setHit(rs.getInt("hit"));
			noticeDTO.setText(rs.getString("text"));
		}
		rs.close();
		st.close();
		con.close();
		
		return noticeDTO;
		
	}
	
	
		//3.Add(Insert) - 
		public int noticeAdd(NoticeDTO noticeDTO) throws Exception{
			int result=0;
			
			Connection con = DBConnect.getConnection();
			String sql = "INSERT INTO NOTICE VALUES (notice_seq.nextVal,?,?,sysdate,1,?)";
			
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, noticeDTO.getSubject());
			st.setString(2, noticeDTO.getId());
			st.setString(3, noticeDTO.getText());
			
			result = st.executeUpdate();
			
			st.close();
			con.close();
			
			System.out.println(result);
			
			return result;
			
		}
	
		//4. boardDelete
		public int noticeDelete(String num) throws Exception{
			Connection con = DBConnect.getConnection();
			
			String sql = "delete notice where num = ?";
			
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, num);
			
			int result = st.executeUpdate();
			
			return result;
		}
		
		//5. boardMod
		public int noticeMod(NoticeDTO noticeDTO) throws Exception{
			Connection con = DBConnect.getConnection();
			
			String sql = "update notice SET num=?, subject=?, id=?, day=sysdate, hit=?, text=?  where num = ?";
			
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1, noticeDTO.getNum());
			st.setString(2, noticeDTO.getSubject());
			st.setString(3, noticeDTO.getId());
			st.setInt(4, 1);
			st.setString(5, noticeDTO.getText());
			st.setInt(6, noticeDTO.getNum());
			
			int result = st.executeUpdate();
			
			return result;
		}
}
