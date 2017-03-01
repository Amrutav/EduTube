package com.fw.controller;

import java.text.SimpleDateFormat;
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

import com.fw.dao.WorkExperienceDao;
import com.fw.domain.entity.Board;
import com.fw.domain.entity.Course_Master;
import com.fw.domain.entity.Education;
import com.fw.domain.entity.Subject;
import com.fw.domain.entity.Tutor;
import com.fw.domain.entity.UserJsonResponse;
import com.fw.domain.entity.WorkExperience;
import com.fw.domain.service.BoardService;
import com.fw.domain.service.CourseMasterService;
import com.fw.domain.service.EducationService;
import com.fw.domain.service.SubjectService;
import com.fw.domain.service.TutorService;
import com.fw.domain.service.WorkExperienceService;

@Controller
@RequestMapping("/utils")
public class UtilsController {

	
	@Autowired
	SubjectService subjectService;
	@Autowired
	WorkExperienceService workExperienceService;
	@Autowired
	EducationService educationService;
	@Autowired
	TutorService tutorService;
	@Autowired
	BoardService boardService;
	@Autowired
	CourseMasterService courseMasterService;
    @Autowired
    private MessageSource messages;
	final Logger logger = Logger.getLogger(UtilsController.class);
	
	@RequestMapping(value = "/subjectList")
	public @ResponseBody List<Subject> getSubjectList() {
		List<Subject> subjects = new ArrayList<Subject>();
		try {
			subjects = subjectService.getSubjectList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return subjects;
	}
	@RequestMapping(value = "/workExperienceList")
	public @ResponseBody List<WorkExperience> getworkExperienceList() {
		List<WorkExperience> workExperienceList = new ArrayList<WorkExperience>();
		try {
			workExperienceList = workExperienceService.getworkExperienceList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return workExperienceList;
	}
	@RequestMapping(value = "/educationList")
	public @ResponseBody List<Education> getEducationList() {
		List<Education> educationList = new ArrayList<Education>();
		try {
			educationList = educationService.geteducationList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return educationList;
	}
	
	@RequestMapping(value = "/boardList")
	public @ResponseBody List<Board> getBoardList() {
		List<Board> board = new ArrayList<Board>();
		try {
			board = boardService.getBoardList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return board;
	}
	
	@RequestMapping(value = "/courseList")
	public @ResponseBody List<Course_Master> getCourseList() {
		List<Course_Master> courses = new ArrayList<Course_Master>();
		try {
			courses = courseMasterService.getCourseList();
			System.out.println(courses);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return courses;
	}
	
	
	@RequestMapping(value="/searchBySubject", method = RequestMethod.GET)
	public @ResponseBody List<Tutor> getTutorList(@RequestParam(value="subjectname") String subjectName ){
		List<Tutor> list= new ArrayList<Tutor>();
		try{
			list=tutorService.searchBySubject(subjectName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping(value="/advance", method = RequestMethod.GET)
	public @ResponseBody List<Tutor> getAdvanceTutorList(@RequestParam(value="board_name")String board, @RequestParam(value="course_name")String course, @RequestParam(value="subjectname") String subject){
		List<Tutor> list = new ArrayList<Tutor>();
		try{
			list=tutorService.advanceSearch(board, course, subject);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
}

