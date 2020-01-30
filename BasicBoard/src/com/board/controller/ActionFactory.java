package com.board.controller;

import com.board.controller.action.*;

public class ActionFactory {
	
	private static ActionFactory instance = new ActionFactory();
	
	
	private ActionFactory() {
		super();
	}
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction (String command) {
		
		Action action = null;
		
		if(command.equals("board_List")) { 
			
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
			
			action = new BoardPagingAction(); 
			
		}else if(command.equals("board_paging")) {
			
			action = new BoardPagingAction();
			
		}else if(command.equals("board_download")) {
			
			action = new BoardDownAction();
		}
		
		
		return action;

	}
	

}
