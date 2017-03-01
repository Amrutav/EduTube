package com.fw.controller;

import java.util.ArrayList;
import java.util.Date;
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

import com.fw.domain.entity.MailboxJsonResponse;
import com.fw.domain.entity.UserInbox;
import com.fw.domain.entity.UserOutbox;
import com.fw.domain.service.MailboxService;
import com.fw.domain.service.UserServices;
import com.fw.util.MailUtils;

@Controller
@RequestMapping("/mailbox")
public class MailboxController {
	
	@Autowired
	MailboxService mailboxService;
	@Autowired
	UserServices dataServices;
	
	private MessageSource messages;
	private boolean flag=false;
	static final Logger logger = Logger.getLogger(MailboxController.class);
	
	@RequestMapping(value = "/newMailInInbox", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody MailboxJsonResponse inbox(@Valid @RequestBody UserInbox userInbox, BindingResult bindingResult){
		MailboxJsonResponse mailboxJsonResponse = new MailboxJsonResponse();
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
			mailboxJsonResponse.setErrorsMap(errors);
			mailboxJsonResponse.setUserInbox(userInbox);
			mailboxJsonResponse.setStatus("ERROR");
			return mailboxJsonResponse;
		}else{
			try{
				userInbox.setReceive_time(new Date());
				boolean flag = mailboxService.newMailInInbox(userInbox);
				if(flag) mailboxJsonResponse.setStatus("SUCCESS");
				else mailboxJsonResponse.setStatus("FAILED");
				return mailboxJsonResponse;
			}catch (Exception e) {
				mailboxJsonResponse.setStatus(e.toString());
				logger.error("Exception Occurs in : ", e);
			}
		}
		return mailboxJsonResponse;
	}
	@RequestMapping(value = "/inboxMessages", method = RequestMethod.GET)
	public @ResponseBody List<UserInbox> getInboxMessages(@RequestParam(value = "user_id") int user_id){
		List<UserInbox> messageList = new ArrayList<UserInbox>();
		try{
			messageList = mailboxService.getInboxMessages(user_id);
			return messageList;
		}catch(Exception e){
			logger.error("Exception Occours In",e);
		}
		return messageList;
	}
	@RequestMapping(value = "/updateMessageStatus", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody MailboxJsonResponse updateMessageStatus(@RequestParam(value = "inbox_id") int inbox_id){
		MailboxJsonResponse mailboxJsonResponse = new MailboxJsonResponse();
		try{
			boolean flag = mailboxService.updateMessageStatus(inbox_id);
			if(flag) mailboxJsonResponse.setStatus("SUCCESS");
			else mailboxJsonResponse.setStatus("FAILED");
			return mailboxJsonResponse;
		} catch(Exception e){
			logger.error("Exception Occours In",e);
		}
		return mailboxJsonResponse;
		
	}
	@RequestMapping(value = "/newMailInOutbox", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody MailboxJsonResponse outbox(@Valid @RequestBody UserOutbox userOutbox, BindingResult bindingResult){
		MailboxJsonResponse mailboxJsonResponse = new MailboxJsonResponse();
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
			mailboxJsonResponse.setErrorsMap(errors);
			mailboxJsonResponse.setUserOutbox(userOutbox);
			mailboxJsonResponse.setStatus("ERROR");
			return mailboxJsonResponse;
		}else{
			try{
				MailUtils.sendMail(userOutbox.getTo_email(), userOutbox.getSent_message_subject(), userOutbox.getSent_message_description());
				userOutbox.setSend_time(new Date());
				boolean flag = mailboxService.newMailInOutbox(userOutbox);
				if(flag) mailboxJsonResponse.setStatus("SUCCESS");
				else mailboxJsonResponse.setStatus("FAILED");
				return mailboxJsonResponse;
			}catch (Exception e) {
				mailboxJsonResponse.setStatus(e.toString());
				logger.error("Exception Occurs in : ", e);
			}
		}
		return mailboxJsonResponse;
	}
	@RequestMapping(value = "/outboxMessages", method = RequestMethod.GET)
	public @ResponseBody List<UserOutbox> getOutboxMessages(@RequestParam(value = "user_id") int user_id){
		List<UserOutbox> messageList = new ArrayList<UserOutbox>();
		try{
			messageList = mailboxService.getOutboxMessages(user_id);
			return messageList;
		}catch(Exception e){
			logger.error("Exception Occours In",e);
		}
		return messageList;
	}
}