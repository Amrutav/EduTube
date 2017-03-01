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
import com.fw.domain.entity.CourseJsonResponse;
import com.fw.domain.entity.Course_Master;
import com.fw.domain.entity.Subject;
import com.fw.domain.entity.SubjectJsonResponse;
import com.fw.domain.service.SubjectService;

@Controller
@RequestMapping("/subject")
public class SubjectController {
	
	@Autowired
	SubjectService subjectService;
	
	private MessageSource messages;
	private boolean flag=false;
	static final Logger logger = Logger.getLogger(BoardController.class);
	
	@RequestMapping(value = "/subjectListByUserId", method = RequestMethod.GET)
	public @ResponseBody List<Subject> getSubjectListByUserId(@RequestParam(value = "user_id") int userId){
		List<Subject> subjectListByUserId = new ArrayList<Subject>();
		try {
			subjectListByUserId = subjectService.getSubjectListByUserId(userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return subjectListByUserId;
	}
	
	@RequestMapping(value = "/addNewSubject", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody SubjectJsonResponse addNewSubject(@Valid @RequestBody Subject subject, BindingResult bindingResult ){
		SubjectJsonResponse subjectJsonResponse = new SubjectJsonResponse();
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
			subjectJsonResponse.setErrorsMap(errors);
			subjectJsonResponse.setSubject(subject);
			subjectJsonResponse.setStatus("ERROR");
			return subjectJsonResponse;
		}else{
			try{
				boolean flag = subjectService.addNewSubject(subject);
				if(flag) subjectJsonResponse.setStatus("SUCCESS");
				else subjectJsonResponse.setStatus("FAILED");
				return subjectJsonResponse;
			}catch (Exception e) {
				subjectJsonResponse.setStatus(e.toString());
				logger.error("Exception Occurs in : ", e);
			}
		}
		return subjectJsonResponse;
	}
	
	@RequestMapping(value = "/validateSubjectName", method = RequestMethod.GET)
	public @ResponseBody SubjectJsonResponse validateSubjectName(@RequestParam(value = "subject_name") String subject_name){
		SubjectJsonResponse subjectJsonResponse = new SubjectJsonResponse();
		try {
			Subject subject = subjectService.validateSubjectName(subject_name);
			if(subject!=null){
				subjectJsonResponse.setStatus("EXISTS");
			}else{
				subjectJsonResponse.setStatus("NOT EXISTS");
			}
			return subjectJsonResponse;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return subjectJsonResponse;
	}
	
	@RequestMapping(value = "/updateSubjectDetails", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody SubjectJsonResponse updateSubjectDetails(@Valid @RequestBody Subject subject, BindingResult bindingResult){
		SubjectJsonResponse subjectJsonResponse = new SubjectJsonResponse();
		System.out.println(subject.getSubjectId());
		System.out.println(subject.getSubjectdescription());
		System.out.println(subject.getSubjectname());
		System.out.println(subject.getUser().getUserId());
		if(bindingResult.hasErrors()){
			System.out.println("error");
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
			subjectJsonResponse.setErrorsMap(errors);
			subjectJsonResponse.setSubject(subject);
			subjectJsonResponse.setStatus("ERROR");
			return subjectJsonResponse;
		}else{
			try{
				System.out.println("ok");
				flag = subjectService.updateSubjectDetails(subject);
    			if(flag){
    				subjectJsonResponse.setStatus("SUCCESS");
    			}else{
    				subjectJsonResponse.setStatus("FAILED");
    			}
    			return subjectJsonResponse;
			}catch (Exception e) {
				subjectJsonResponse.setStatus(e.toString());
				logger.error("Exception Occurs in : ", e);
			}
		}
		return subjectJsonResponse;
	}
	
	@RequestMapping(value = "/deleteSubject", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody SubjectJsonResponse deleteSubject(@Valid @RequestBody Subject subject){
		SubjectJsonResponse subjectJsonResponse = new SubjectJsonResponse();
		try{
			flag = subjectService.deleteSubject(subject);
			if(flag){
				subjectJsonResponse.setStatus("SUCCESS");
			}else{
				subjectJsonResponse.setStatus("FAILED");
			}
			return subjectJsonResponse;
		}catch (Exception e) {
			subjectJsonResponse.setStatus(e.toString());
			logger.error("Exception Occurs in : ", e);
		}
		return subjectJsonResponse;
	}
	
	@RequestMapping(value = "/subjectListByName", method = RequestMethod.GET)
	public @ResponseBody List<Subject> getSubjectListByName(@RequestParam(value = "subjectName") String subjectName){
		List<Subject> subjectListByUserId = new ArrayList<Subject>();
		try {
			subjectListByUserId = subjectService.getSubjectListByName(subjectName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return subjectListByUserId;
	}
}