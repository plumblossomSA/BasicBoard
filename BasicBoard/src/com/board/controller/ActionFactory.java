package com.board.controller;

import com.board.controller.action.*;

public class ActionFactory {
	
	//싱글톤
	private static ActionFactory instance = new ActionFactory();
	
	//생성자
	private ActionFactory() {
		super();
	}
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction (String command) {
		
		Action action = null;
		
		if(command.equals("board_List")) { //servlet에서 받은 command를  함수를 불러와 처리.
			
			action = new BoardListAction();
			
		}else if(command.equals("board_write_form")) {
			
			action = new BoardWriteFormAction();
			
		}else if(command.equals("board_write")) {
			
			action = new BoardWriteAction();
			
		}else if(command.equals("board_view")) {
			
			action = new BoardViewAction();
			
		}else if(command.equals("board_update_form")) {
			
			action = new BoardUpdateFormAction();
			
		}else if(command.equals("board_update")) {
			
			action = new BoardUpdateAction();
			
		}else if(command.equals("board_delete")) {
			
			action = new BoardDeleteAction();
		
		}else if(command.equals("board_list_pg")) {
			
			action = new BoardPagingAction(); //pg부분
			
		}else if(command.equals("board_paging")) {
			
			action = new BoardPagingAction();
			
		}else if(command.equals("board_download")) {
			
			action = new BoardDownAction();
		}
		
		System.out.println("ActionFactory실행");
		
		return action;

	}
	

}
