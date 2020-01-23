package com.board.Linfo;

import java.util.*;


public class test {
	
	
	public static void main(String[] args) {
	
	LinfoDAO dao = new LinfoDAO();
	ArrayList<LinfoDTO> list = dao.LinfoList();
	//ArrayList<LinfoDTO> list = new ArrayList<LinfoDTO>();
	//ArrayList<LinfoDTO> list = dao.LinfoList(l_list);
	//ArrayList<LinfoDTO> list = dao.LinfoList;
	
//	for(LinfoDTO s : list) {
//		System.out.println(s);
//	}
	

for(LinfoDTO dto : list){
	
	System.out.println(dto.getSeq());
	System.out.println(dto.getlName());
 
}
	
	
	}
}
