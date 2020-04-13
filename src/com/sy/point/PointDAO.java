package com.sy.point;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;
import com.sy.util.DBConnect;

public class PointDAO {
	//DAO (Data Access Object)
	
	//sql문은 문법에 맞게썼는가(?표갯수나 오타등..)
	//DB의 컬럼명과 일치하는지 확인
	
	//5.Update(Mod)
	public int pointUpdate(PointDTO pointDTO) throws Exception{
		int result=0;
		
		Connection con = DBConnect.getConnection();
		String sql = "update point set name=?, kor=?, eng=?, math=?, total=?, avg=? where num=?";
		 
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, pointDTO.getName());
		st.setInt(2, pointDTO.getKor());
		st.setInt(3, pointDTO.getEng());
		st.setInt(4, pointDTO.getMath());
		st.setInt(5, pointDTO.getTotal());
		st.setDouble(6, pointDTO.getAvg());
		st.setInt(7, pointDTO.getNum());
		
		
		result = st.executeUpdate();
		System.out.println(result);
		st.close();
		con.close();
		
		return result;

	}
	
	//4.Add(Insert)
	public int pointAdd(PointDTO pointDTO) throws Exception{
		int result=0;
		
		Connection con = DBConnect.getConnection();
		String sql = "INSERT INTO POINT VALUES (?,?,?,?,?,?,?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, pointDTO.getName());
		st.setInt(2, pointDTO.getNum());
		st.setInt(3, pointDTO.getKor());
		st.setInt(4, pointDTO.getEng());
		st.setInt(5, pointDTO.getMath());
		st.setInt(6, pointDTO.getTotal());
		st.setDouble(7, pointDTO.getAvg());
		
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
		
	}
	
	//3.Delete
	public int pointDelete(int num) throws Exception{
		int result = 0;
		
		Connection con = DBConnect.getConnection();
		String sql = "delete point where num=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1,num);
		
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;

	}
	
	//2.SelectOne
	public PointDTO pointSelect(int num) throws Exception{
		PointDTO pointDTO = null;
		
		Connection con = DBConnect.getConnection();
		
		String sql = "select * from point where num=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, num);
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			pointDTO = new PointDTO();
			pointDTO.setName(rs.getString("name"));
			pointDTO.setNum(rs.getInt("num"));
			pointDTO.setKor(rs.getInt("kor"));
			pointDTO.setEng(rs.getInt("eng"));
			pointDTO.setMath(rs.getInt("math"));
			pointDTO.setTotal(rs.getInt("total"));
			pointDTO.setAvg(rs.getDouble("avg"));
	
		}
		
		rs.close();
		st.close();
		con.close();
		
		System.out.println("pointDAO Select");
		
		return pointDTO;
		
		
	}
	
	//1.List
	public ArrayList<PointDTO> pointList() throws Exception{
		
		ArrayList<PointDTO> ar = new ArrayList<PointDTO>();//미리만들어놓고 시작
		
		//1.DB연결
		Connection con = DBConnect.getConnection();
		//2.SQL문 작성
		String sql = "Select * from point order by num asc";
		//3.SQL문 미리전송
		PreparedStatement st = con.prepareStatement(sql);
		//4.?표값 세팅
			/*sql문에 ?가 없기 때문에 넘어간다.*/
		//5.최종 전송 후 결과 처리
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			
			PointDTO pointDTO = new PointDTO();//이걸 안에다 만들어야 여러사람을 만들수 있다.
			pointDTO.setName(rs.getString("name"));
			pointDTO.setNum(rs.getInt("num"));//clumn명과 같게 작성
			pointDTO.setKor(rs.getInt("kor"));
			pointDTO.setEng(rs.getInt("eng"));
			pointDTO.setMath(rs.getInt("math"));
			pointDTO.setTotal(rs.getInt("total"));
			pointDTO.setAvg(rs.getDouble("avg"));
			ar.add(pointDTO);
			
		}
		
		//6.자원 해제
		rs.close();
		st.close();
		con.close();
		
		return ar;
		
	}
	
	//2.Select
	
	//3.Insert
	
	//4.Update
	
	//5.Delete
}
