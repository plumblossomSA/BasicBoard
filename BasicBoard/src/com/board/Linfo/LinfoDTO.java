package com.board.Linfo;

public class LinfoDTO {
	
	private String seq; //Number
	private String lName; //Linux 컴퓨터 이름
	private String lIp; //IP주소
	private String pmAddr; //MAC 주소
	private String userCnt; //사용자수
	private String regDate; //등록일
	
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
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
	
	public String getUserCnt() {
		return userCnt;
	}
	public void setUserCnt(String userCnt) {
		this.userCnt = userCnt;
	}
	
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	

}
