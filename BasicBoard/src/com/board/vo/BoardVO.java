package com.board.vo;

public class BoardVO {
	
	//private String seq; //Number
	private int seq;
	private String lName; //Linux 컴퓨터 이름
	private String lIp; //IP주소
	private String pmAddr; //MAC 주소
	private String userCnt; //사용자수
	private String fname; //파일업로드
	private String fpath; //파일경로
	

	private String regDate; //등록일
	
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
