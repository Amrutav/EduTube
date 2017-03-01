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
import com.fw.domain.service.CourseMasterService;

@Controller
@RequestMapping("/course")
public class CourseController {
	@Autowired
	CourseMasterService courseMasterService;
	
	boolean flag = false;
	private MessageSource messages;
	static final Logger logger = Logger.getLogger(CourseController.class);
	
	@RequestMapping(value = "/courseListByUserId", method = RequestMethod.GET)
	public @ResponseBody List<Course_Master> getCourseListByUserId(@RequestParam(value = "user_id") int userId){
		List<Course_Master> courseListByUserId = new ArrayList<Course_Master>();
		try {
			courseListByUserId = courseMasterService.getCourseListByUserId(userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return courseListByUserId;
	}
	
	@RequestMapping(value = "/addNewCourse", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody CourseJsonResponse addNewCourse(@Valid @RequestBody Course_Master course, BindingResult bindingResult ){
		CourseJsonResponse courseJsonResponse = new CourseJsonResponse();
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
			courseJsonResponse.setErrorsMap(errors);
			courseJsonResponse.setCourse(course);
			courseJsonResponse.setStatus("ERROR");
			return courseJsonResponse;
		}else{
			try{
				boolean flag = courseMasterService.addNewCourse(course);
				if(flag) courseJsonResponse.setStatus("SUCCESS");
				else courseJsonResponse.setStatus("FAILED");
				return courseJsonResponse;
			}catch (Exception e) {
				courseJsonResponse.setStatus(e.toString());
				logger.error("Exception Occurs in : ", e);
			}
		}
		return courseJsonResponse;
	}
	
	@RequestMapping(value = "/validateCourseName", method = RequestMethod.GET)
	public @ResponseBody CourseJsonResponse validateCourseName(@RequestParam(value = "course_name") String course_name){
		CourseJsonResponse courseJsonResponse = new CourseJsonResponse();
		try {
			Course_Master course = courseMasterService.validateCourseName(course_name);
			
			if(course!=null){
				courseJsonResponse.setStatus("EXISTS");
			}else{
				courseJsonResponse.setStatus("NOT EXISTS");
			}
			return courseJsonResponse;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return courseJsonResponse;
	}
	
	@RequestMapping(value = "/updateCourseDetails", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody CourseJsonResponse updateCourseDetails(@Valid @RequestBody Course_Master course, BindingResult bindingResult){
		CourseJsonResponse courseJsonResponse = new CourseJsonResponse();
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
			courseJsonResponse.setErrorsMap(errors);
			courseJsonResponse.setCourse(course);
			courseJsonResponse.setStatus("ERROR");
			return courseJsonResponse;
		}else{
			try{
				flag = courseMasterService.updateCourseDetails(course);
    			if(flag){
    				courseJsonResponse.setStatus("SUCCESS");
    			}else{
    				courseJsonResponse.setStatus("FAILED");
    			}
    			return courseJsonResponse;
			}catch (Exception e) {
				courseJsonResponse.setStatus(e.toString());
				logger.error("Exception Occurs in : ", e);
			}
		}
		return courseJsonResponse;
	}
	
	@RequestMapping(value = "/deleteCourse", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody CourseJsonResponse deleteCourse(@Valid @RequestBody Course_Master course){
		CourseJsonResponse courseJsonResponse = new CourseJsonResponse();
		try{
			flag = courseMasterService.deleteCourse(course);
			if(flag){
				courseJsonResponse.setStatus("SUCCESS");
			}else{
				courseJsonResponse.setStatus("FAILED");
			}
			return courseJsonResponse;
		}catch (Exception e) {
			courseJsonResponse.setStatus(e.toString());
			logger.error("Exception Occurs in : ", e);
		}
		return courseJsonResponse;
	}
	
	@RequestMapping(value = "/courseListByName", method = RequestMethod.GET)
	public @ResponseBody List<Course_Master> getCourseListByName(@RequestParam(value = "courseName") String courseName){
		List<Course_Master> courseListByName = new ArrayList<Course_Master>();
		try {
			courseListByName = courseMasterService.getCourseListByName(courseName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return courseListByName;
	}
}