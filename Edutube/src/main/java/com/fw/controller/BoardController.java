package com.fw.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fw.domain.entity.Board;
import com.fw.domain.entity.BoardJsonResponse;
import com.fw.domain.entity.Subject;
import com.fw.domain.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	private MessageSource messages;
	private boolean flag=false;
	static final Logger logger = Logger.getLogger(BoardController.class);
	
	@RequestMapping(value = "/boardListByUserId", method = RequestMethod.GET)
	public @ResponseBody List<Board> getBoardListByUserId(@RequestParam(value = "user_id") int userId){
		List<Board> boardListByUserId = new ArrayList<Board>();
		try {
			System.out.println("HELLO");
			boardListByUserId = boardService.getBoardListByUserId(userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return boardListByUserId;
	}
	
	@RequestMapping(value = "/addNewBoard", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody BoardJsonResponse addNewBoard(@Valid @RequestBody Board board, BindingResult bindingResult ){
		BoardJsonResponse boardJsonResponse = new BoardJsonResponse();
		if(bindingResult.hasErrors()){
			Map<String, String> errors = new HashMap<String, String>();
			List<FieldError> fieldErrors = bindingResult.getFieldErrors();
			for(FieldError fieldError : fieldErrors){
				String[] resolveMessageCodes = bindingResult.resolveMessageCodes(fieldError.getCode());
				String string = resolveMessageCodes[0];
				logger.debug("resolveMessageCodes: "+string);
				String message = messages.getMessage(string+"."+fieldError.getField(), new Object[]{fieldError.getRejectedValue()}, null);
				logger.debug("Message"+message);
				errors.put(fieldError.getField(), message);
			}
			boardJsonResponse.setErrorsMap(errors);
			boardJsonResponse.setBoard(board);
			boardJsonResponse.setStatus("ERROR");
			return boardJsonResponse;
		}else{
			try{
				boolean flag = boardService.addNewBoard(board);
				if(flag) boardJsonResponse.setStatus("SUCCESS");
				else boardJsonResponse.setStatus("FAILED");
				return boardJsonResponse;
			}catch (Exception e) {
				boardJsonResponse.setStatus(e.toString());
				logger.error("Exception Occurs in : ", e);
			}
		}
		return boardJsonResponse;
	}
	
	@RequestMapping(value = "/validateBoardName", method = RequestMethod.GET)
	public @ResponseBody BoardJsonResponse validateBoardName(@RequestParam(value = "board_name") String board_name){
		BoardJsonResponse boardJsonResponse = new BoardJsonResponse();
		try {
			Board board = boardService.validateBoardName(board_name);
			if(board!=null){
				boardJsonResponse.setStatus("EXISTS");
			}else{
				boardJsonResponse.setStatus("NOT EXISTS");
			}
			return boardJsonResponse;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return boardJsonResponse;
	}
	
	@RequestMapping(value = "/updateBoardDetails", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody BoardJsonResponse updateBoardDetails(@Valid @RequestBody Board board, BindingResult bindingResult){
		BoardJsonResponse boardJsonResponse = new BoardJsonResponse();
		if(bindingResult.hasErrors()){
			Map<String, String> errors = new HashMap<String, String>();
			List<FieldError> fieldErrors = bindingResult.getFieldErrors();
			for(FieldError fieldError : fieldErrors){
				String[] resolveMessageCodes = bindingResult.resolveMessageCodes(fieldError.getCode());
				String string = resolveMessageCodes[0];
				logger.debug("resolveMessageCodes: "+string);
				String message = messages.getMessage(string+"."+fieldError.getField(), new Object[]{fieldError.getRejectedValue()}, null);
				logger.debug("Message"+message);
				errors.put(fieldError.getField(), message);
			}
			boardJsonResponse.setErrorsMap(errors);
			boardJsonResponse.setBoard(board);
			boardJsonResponse.setStatus("ERROR");
			return boardJsonResponse;
		}else{
			try{
				flag = boardService.updateBoardDetails(board);
    			if(flag){
    				boardJsonResponse.setStatus("SUCCESS");
    			}else{
    				boardJsonResponse.setStatus("FAILED");
    			}
    			return boardJsonResponse;
			}catch (Exception e) {
				boardJsonResponse.setStatus(e.toString());
				logger.error("Exception Occurs in : ", e);
			}
		}
		return boardJsonResponse;
	}
	
	@RequestMapping(value = "/deleteBoard", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody BoardJsonResponse deleteBoard(@Valid @RequestBody Board board){
		BoardJsonResponse boardJsonResponse = new BoardJsonResponse();
		System.out.println(board.getBoard_id());
		try{
			flag = boardService.deleteBoard(board);
			if(flag){
				boardJsonResponse.setStatus("SUCCESS");
			}else{
				boardJsonResponse.setStatus("FAILED");
			}
			return boardJsonResponse;
		}catch (Exception e) {
			boardJsonResponse.setStatus(e.toString());
			logger.error("Exception Occurs in : ", e);
		}
		return boardJsonResponse;
	}
	
	@RequestMapping(value = "/boardListByName", method = RequestMethod.GET)
	public @ResponseBody List<Board> getSubjectListByName(@RequestParam(value = "boardName") String boardName){
		List<Board> boardListByName = new ArrayList<Board>();
		try {
			boardListByName = boardService.getBoardListByName(boardName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return boardListByName;
	}
}

