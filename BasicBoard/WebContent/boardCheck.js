

function boardCheck(){
	if(document.frm.name.value.length ==0){
		alert("컴퓨터 이름을 입력하세요");
		return false;
	}
	if(document.frm.ipaddr.value.length==0){
		alert("IP주소를 입력하세요");
		return false;
	}
	if(document.frm.macaddr.value.length==0){
		alert("Mac주소를 입력하세요");
		return false;
	}
//	if(document.frm.regdate.value.length==0){
//		alert("등록일을 입력하세요");
//		return false;
//	}
	return true;
	
}