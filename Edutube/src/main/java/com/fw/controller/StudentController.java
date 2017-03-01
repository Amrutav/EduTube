package com.fw.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.text.rtf.RTFEditorKit;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import sun.misc.BASE64Encoder;

import com.fw.domain.entity.Student;
import com.fw.domain.entity.StudentJsonResponse;
import com.fw.domain.entity.TagStudent;
import com.fw.domain.entity.Tag_Tutor;
import com.fw.domain.entity.Tutor;
import com.fw.domain.entity.TutorTimeSchedule;
import com.fw.domain.entity.User;
import com.fw.domain.entity.UserJsonResponse;
import com.fw.domain.service.StudentService;
import com.fw.domain.service.UserServices;
import com.fw.util.DateTimeUtil;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService studentservice;
	@Autowired
	UserServices dataServices;
	@Autowired
	private MessageSource messages;
	private boolean flag=false;
	static final Logger logger=Logger.getLogger(StudentController.class);
	
	@RequestMapping(value ="/viewProfile" , method =RequestMethod.GET)
	public @ResponseBody Student studenViewProfile(@Valid @RequestParam(value="userId") int userId) {
		logger.debug("Submited User Data : \n"+userId);
		System.out.println("jjjjj");
	        try {
	        	Student student = studentservice.showStudentData(userId);
	        	System.out.println("jjjjj");
				BASE64Encoder encoder = new BASE64Encoder();
				//tutor.setTutorProfilePicturePath("data:image/jpg;base64,"+encoder.encode(tutor.getTutorProfilePicture()));
				return student;
			} catch (Exception e) {
				logger.error("Exception occurs in : ", e);
			}
	        return new Student();
	    			
	}
		

	@RequestMapping(value = "/editPersonal", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	StudentJsonResponse editStudent( @Valid @RequestBody Student student, BindingResult bindingResult) {
		logger.debug("Submited User Data : \n"+student);
		System.out.println("ok");
	        StudentJsonResponse studentJsonResponse=new StudentJsonResponse();
	        System.out.println("ok");
	        if(bindingResult.hasErrors()){
	        	System.out.println("IF");
	            Map<String ,String> errors=new HashMap<String, String>();
	            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
	            for (FieldError fieldError : fieldErrors) {
	                String[] resolveMessageCodes = bindingResult.resolveMessageCodes(fieldError.getCode());
	                String string = resolveMessageCodes[0];
	                logger.debug("resolveMessageCodes : "+string);
	                String message = messages.getMessage(string+"."+fieldError.getField(), new Object[]{fieldError.getRejectedValue()}, null);
	                logger.debug("Meassage : "+message);
	                errors.put(fieldError.getField(), message)    ;
	            }
	            studentJsonResponse.setErrorsMap(errors);
	            studentJsonResponse.setStudent(student);
	            studentJsonResponse.setStatus("ERROR");
	            return studentJsonResponse;
	        }else{
	        	
	        	try {
	        			System.out.println("ELSE");
     				    student.setStudent_dob(DateTimeUtil.toDateConversion(student.getDob()));
	        			studentservice.editStudentPersonalData(student);
     				    System.out.println(student.getStudent_first_name());
     				    System.out.println(student.getStudent_id());
     				  studentJsonResponse.setStatus("SUCCESS");
	    			return studentJsonResponse;
	    			
	    		} catch (Exception e) {
	    			e.printStackTrace();
	    			logger.error("Exception occurs in", e);
	    			studentJsonResponse.setStatus(e.toString());
	    			return studentJsonResponse;
	    		}
	        }
		

	}
	/**
	 * @author Sushanta Barik
	 * @param List<Tag_Tutor> object , BindingResult object
	 * @return UserJsonResponse object in json
	 * @exception Exception
	 */
	@RequestMapping(value = "/studentSubjectMap" , method=RequestMethod.PUT , consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserJsonResponse studentSubjectMap(@Valid @RequestBody  List<TagStudent> studentSubjectList , BindingResult bindingResult) {
		UserJsonResponse userJsonResponse = new UserJsonResponse();
		if(bindingResult.hasErrors()){
        	Map<String ,String> errors=new HashMap<String, String>();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                String[] resolveMessageCodes = bindingResult.resolveMessageCodes(fieldError.getCode());
                String string = resolveMessageCodes[0];
                logger.debug("resolveMessageCodes : "+string);
                String message = messages.getMessage(string+"."+fieldError.getField(), new Object[]{fieldError.getRejectedValue()}, null);
                logger.debug("Meassage : "+message);
                errors.put(fieldError.getField(), message)    ;
            }
            userJsonResponse.setErrorsMap(errors);
            userJsonResponse.setStatus("ERROR");
            return userJsonResponse;
        }else{
			try {
				boolean flag = studentservice.updateStudTutSubMapping(studentSubjectList);
				if(flag) userJsonResponse.setStatus("SUCCESS");
				else userJsonResponse.setStatus("FAILED");
				return userJsonResponse;
			} catch (Exception e) {
				userJsonResponse.setStatus(e.toString());
				logger.error("Exception Occurs in : ", e);
			}
			return userJsonResponse;
        }
	}
	
	@RequestMapping(value = "/studentAboutMeUpdate" , method=RequestMethod.PUT , consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody StudentJsonResponse AboutMeUpdate(@Valid @RequestBody Student student , BindingResult bindingResult) {
		StudentJsonResponse studentJsonResponse = new StudentJsonResponse();
		if(bindingResult.hasErrors()){
        	Map<String ,String> errors=new HashMap<String, String>();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                String[] resolveMessageCodes = bindingResult.resolveMessageCodes(fieldError.getCode());
                String string = resolveMessageCodes[0];
                logger.debug("resolveMessageCodes : "+string);
                String message = messages.getMessage(string+"."+fieldError.getField(), new Object[]{fieldError.getRejectedValue()}, null);
                logger.debug("Meassage : "+message);
                errors.put(fieldError.getField(), message)    ;
            }
            studentJsonResponse.setErrorsMap(errors);
            studentJsonResponse.setStudent(student);
            studentJsonResponse.setStatus("ERROR");
            return studentJsonResponse;
        }else{
			try {
				boolean flag = studentservice.updateStudentAboutMe(student);
				if(flag) studentJsonResponse.setStatus("SUCCESS");
				else studentJsonResponse.setStatus("FAILED");
				return studentJsonResponse;
			} catch (Exception e) {
				studentJsonResponse.setStatus(e.toString());
				logger.error("Exception Occurs in : ", e);
			}
			return studentJsonResponse;
        }
	}
	
	@RequestMapping(value = "/studentSubjectView" , method =RequestMethod.GET)
	public @ResponseBody List<TagStudent> studentSubjectView(@RequestParam(value="student_id") int studentId) {
		List<TagStudent> studnetSubjectTagList = new ArrayList<TagStudent>();
		try {
			studnetSubjectTagList = studentservice.studentSubjectTagList(studentId);
			return studnetSubjectTagList;
		} catch (Exception e) {
			logger.error("Exception occurs in : ", e);
		}
		return studnetSubjectTagList;
	}
	
	/**
	 * @author Sushanta Barik
	 * @param student_id integer value
	 * @return List<TutorTimeSchedule> object in json
	 * @exception Exception
	 */
	@RequestMapping(value = "/scheduledClassesForStudent" , method =RequestMethod.GET)
	public @ResponseBody List<TutorTimeSchedule> scheduledClassesForStudent(@RequestParam(value="student_id") int student_id) {
		List<TutorTimeSchedule> scheduledClasses = new ArrayList<TutorTimeSchedule>();
		try {
			scheduledClasses = studentservice.getscheduledClassesForStudent(student_id);
			return scheduledClasses;
		} catch (Exception e) {
			logger.error("Exception occurs in : ", e);
		}
		return scheduledClasses;
	}
	/**
	 * @author Sushanta Barik
	 * @param student_id integer value
	 * @return List<TutorTimeSchedule> object in json
	 * @exception Exception
	 */
	@RequestMapping(value = "/studentUpcomingClasses" , method =RequestMethod.GET)
	public @ResponseBody List<TutorTimeSchedule> studentUpcomingClasses(@RequestParam(value="student_id") int student_id, @RequestParam(value="scheduleCount") int scheduleCount) {
		List<TutorTimeSchedule> studentUpcomingClasses = new ArrayList<TutorTimeSchedule>();
		try {
			if(!(scheduleCount > 0)){
				scheduleCount = 5;
			}
			studentUpcomingClasses = studentservice.getstudentUpcomingClasses(student_id , scheduleCount);
			return studentUpcomingClasses;
		} catch (Exception e) {
			logger.error("Exception occurs in : ", e);
		}
		return studentUpcomingClasses;
	}
	
	
}	

