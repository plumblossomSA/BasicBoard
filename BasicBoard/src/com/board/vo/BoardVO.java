package com.board.vo;

public class BoardVO {
	
	//private String seq; //Number
	private int seq;
	private String lName; 
	private String lIp; 
	private String pmAddr; 
	private String userCnt;
	private String fname;
	private String fpath; 
	

	private String regDate; 
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getlIp() {
		return lIp;
	}
	public void setlIp(String lIp) {
		this.lIp = lIp;
	}
	public String getPmAddr() {
		return pmAddr;
	}
	public void setPmAddr(String pmAddr) {
		this.pmAddr = pmAddr;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getFpath() {
		return fpath;
	}
	public void setFpath(String fpath) {
		this.fpath = fpath;
	}
	
//	public String getUserCnt() {
//		return userCnt;
//	}
//	public void setUserCnt(String userCnt) {
//		this.userCnt = userCnt;
//	}	
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	

}
