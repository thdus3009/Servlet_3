package com.sy.point;

import java.util.ArrayList;

public class PointService {

	private PointDAO pointDAO;
	
	public PointService() {
		this.pointDAO = new PointDAO();//this. 생략가능
	}
	//5. update
	public int pointMod(PointDTO pointDTO) throws Exception{
		pointDTO.setTotal(pointDTO.getKor()+pointDTO.getEng()+pointDTO.getMath());
		pointDTO.setAvg(pointDTO.getTotal()/3.0);
		return pointDAO.pointUpdate(pointDTO);
	}
	
	//4. add
	public int pointAdd(PointDTO pointDTO) throws Exception{
		pointDTO.setTotal(pointDTO.getKor()+pointDTO.getEng()+pointDTO.getMath());
		pointDTO.setAvg(pointDTO.getTotal()/3.0);
		
		return pointDAO.pointAdd(pointDTO);
	}
	
	//3. delete
	public int pointDelete(int num) throws Exception{
		return pointDAO.pointDelete(num);
	}
	
	//2. select
	public PointDTO pointSelect(int num) throws Exception{
		return pointDAO.pointSelect(num);
	}
	
	//1.list
	public ArrayList<PointDTO> pointList() throws Exception{
		return pointDAO.pointList();
	}
	
	
}
