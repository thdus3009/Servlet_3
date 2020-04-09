package com.sy.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sy.util.DBConnect;

public class MemberDAO {

	//join
	public int memberJoin(MemberDTO memberDTO) throws Exception{
		int result=0;
		
		Connection con = DBConnect.getConnection();
		String sql = "insert into member values (?,?,?,?,?,?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPw());
		st.setString(3, memberDTO.getName());
		st.setString(4, memberDTO.getEmail());
		st.setString(5, memberDTO.getPhone());
		st.setInt(6, memberDTO.getAge());
		
		result = st.executeUpdate();

		st.close();
		con.close();
		
		return result;
	}
	
	//login
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception{
		
		Connection con = DBConnect.getConnection();
		String sql = "select * from member where id=? and pw=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPw());
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			memberDTO.setName(rs.getString("name"));
			memberDTO.setEmail(rs.getString("email"));
			memberDTO.setPhone(rs.getString("phone"));
			memberDTO.setAge(rs.getInt("age"));
		}else {
			memberDTO=null;
		}
			
		st.close();
		con.close();
		
		return memberDTO;
	}
}
