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

import sun.misc.BASE64Encoder;

import com.fw.domain.entity.Tag_Tutor;
import com.fw.domain.entity.Tutor;
import com.fw.domain.entity.TutorTimeSchedule;
import com.fw.domain.entity.TutorTransaction;
import com.fw.domain.entity.UserJsonResponse;
import com.fw.domain.service.TutorService;
import com.fw.domain.service.UserServices;
import com.fw.util.DateTimeUtil;
import com.fw.util.MailUtils;

@Controller
@RequestMapping("/tutor")
public class TutorController {
	
	@Autowired
	TutorService tutorService;
	@Autowired
	UserServices dataServices;
	@Autowired
    private MessageSource messages;
	final Logger logger = Logger.getLogger(TutorController.class);
	/**
	 * @author Sushanta Barik
	 * @param userId
	 * @return Tutor object in json
	 * @exception Exception
	 */
	@SuppressWarnings("restriction")
	@RequestMapping(value = "/tutorProfile" , method =RequestMethod.GET)
	public @ResponseBody Tutor tutorProfileView(@RequestParam(value="userId") int userId) {
		try {
			Tutor tutor = tutorService.getTutorDetailsByUserid(userId);
			
			BASE64Encoder encoder = new BASE64Encoder();
			//tutor.setTutorProfilePicturePath("data:image/jpg;base64,"+encoder.encode(tutor.getTutorProfilePicture()));
			return tutor;
		} catch (Exception e) {
			logger.error("Exception occurs in : ", e);
		}
		return new Tutor();
	}
	/**
	 * @author Sushanta Barik
	 * @param Tutor object
	 * @return UserJsonResponse object in json
	 * @exception Exception
	 */
	@RequestMapping(value = "/tutorBasicProfileUpdate" , method=RequestMethod.PUT , consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserJsonResponse tutorBasicProfileUpdate(@Valid @RequestBody Tutor tutor , BindingResult bindingResult) {
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
            userJsonResponse.setTutor(tutor);
            userJsonResponse.setStatus("ERROR");
            return userJsonResponse;
        }else{
			try {
				tutor.setTutorDateOfBirth(DateTimeUtil.toDateConversion(tutor.getDobInput()));
				boolean flag = tutorService.updateTutorBasicProfile(tutor);
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
	/**
	 * @author Sushanta Barik
	 * @param Tutor object , BindingResult object
	 * @return UserJsonResponse object in json
	 * @exception Exception
	 */
	@RequestMapping(value = "/tutorAboutMeUpdate" , method=RequestMethod.PUT , consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserJsonResponse tutorAboutMeUpdate(@Valid @RequestBody Tutor tutor , BindingResult bindingResult) {
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
            userJsonResponse.setTutor(tutor);
            userJsonResponse.setStatus("ERROR");
            return userJsonResponse;
        }else{
			try {
				boolean flag = tutorService.updateTutorAboutMe(tutor);
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
	/**
	 * @author Sushanta Barik
	 * @param userId
	 * @return Tutor object in json
	 * @exception Exception
	 */
	@RequestMapping(value = "/tutorSubjectView" , method =RequestMethod.GET)
	public @ResponseBody List<Tag_Tutor> tutorSubjectView(@RequestParam(value="tutorId") int tutorId) {
		List<Tag_Tutor> tutorSubjectTagList = new ArrayList<Tag_Tutor>();
		try {
			tutorSubjectTagList = tutorService.getTutorSubjectTagList(tutorId);
			return tutorSubjectTagList;
		} catch (Exception e) {
			logger.error("Exception occurs in : ", e);
		}
		return tutorSubjectTagList;
	}
	/**
	 * @author Sushanta Barik
	 * @param List<Tag_Tutor> object , BindingResult object
	 * @return UserJsonResponse object in json
	 * @exception Exception
	 */
	@RequestMapping(value = "/tutorSubjectMap" , method=RequestMethod.PUT , consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserJsonResponse tutorSubjectMap(@Valid @RequestBody  List<Tag_Tutor> tutorSubjectList , BindingResult bindingResult) {
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
				boolean flag = tutorService.updateTutorSubMapping(tutorSubjectList);
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
	/**
	 * @author Sushanta Barik
	 * @param TutorTimeSchedule object , BindingResult object
	 * @return UserJsonResponse object in json
	 * @exception Exception
	 */
	@RequestMapping(value = "/tutorTimeSchedule", method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserJsonResponse tutorTimeSchedule(@Valid @RequestBody  TutorTimeSchedule timeSchedule , BindingResult bindingResult) {
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
            userJsonResponse.setTutorTimeSchedule(timeSchedule);
            return userJsonResponse;
        }else{
			try {
				timeSchedule.setScheduleStartTime(DateTimeUtil.toDateConvertor(timeSchedule.getScheduleStartTimeInput()));
				timeSchedule.setScheduleEndTime(DateTimeUtil.toDateConvertor(timeSchedule.getScheduleEndTimeInput()));
				timeSchedule.setScheduleDate(new Date());
				List<TutorTimeSchedule> tutorTimeSchedules = new ArrayList<TutorTimeSchedule>();
				if(timeSchedule.getScheduleEndDateInput() == null || timeSchedule.getScheduleEndDateInput().equals("")){
					tutorTimeSchedules.add(timeSchedule);
				}else{
					String[] time = timeSchedule.getScheduleStartTimeInput().split(" ");
					timeSchedule.setScheduleEndDate(DateTimeUtil.toDateConvertor(timeSchedule.getScheduleEndDateInput().concat(" "+time[1])));
					List<Date> dateList = new ArrayList<Date>();
					if(timeSchedule.getDailyRecurrence() != null && timeSchedule.getDailyRecurrence().equalsIgnoreCase("Everyday")){
						dateList = DateTimeUtil.getDaysBetweenDates(timeSchedule.getScheduleStartTime(), timeSchedule.getScheduleEndDate());
						for(Date startDate : dateList){
							TutorTimeSchedule schedule = new TutorTimeSchedule();
							schedule.setTagTutor(timeSchedule.getTagTutor());
							schedule.setScheduleStartTime(startDate);
							schedule.setScheduleEndTime(DateTimeUtil.getSettingTimeInToDate(startDate, timeSchedule.getScheduleEndTime()));
							schedule.setScheduleEndDate(timeSchedule.getScheduleEndDate());
							tutorTimeSchedules.add(schedule);
						}
					}else if(timeSchedule.getDailyRecurrence() != null && timeSchedule.getDailyRecurrence().equalsIgnoreCase("Every Weekday")){
						dateList = DateTimeUtil.getWeekDaysBetweenDates(timeSchedule.getScheduleStartTime(), timeSchedule.getScheduleEndDate());
						for(Date startDate : dateList){
							TutorTimeSchedule schedule = new TutorTimeSchedule();
							schedule.setTagTutor(timeSchedule.getTagTutor());
							schedule.setScheduleStartTime(startDate);
							schedule.setScheduleEndTime(DateTimeUtil.getSettingTimeInToDate(startDate, timeSchedule.getScheduleEndTime()));
							schedule.setScheduleEndDate(timeSchedule.getScheduleEndDate());
							tutorTimeSchedules.add(schedule);
						}
					}else if(timeSchedule.getWeekDaysRecurrence() != null && timeSchedule.getWeekDaysRecurrence().length > 0){
						for(String scheduleWeekDay : timeSchedule.getWeekDaysRecurrence()){
							dateList = DateTimeUtil.getParticularWeekdaysWithSomeDateRange(timeSchedule.getScheduleStartTime() , timeSchedule.getScheduleEndDate() , scheduleWeekDay);
							for(Date startDate : dateList){
								TutorTimeSchedule schedule = new TutorTimeSchedule();
								schedule.setTagTutor(timeSchedule.getTagTutor());
								schedule.setScheduleStartTime(startDate);
								schedule.setScheduleEndTime(DateTimeUtil.getSettingTimeInToDate(startDate, timeSchedule.getScheduleEndTime()));
								schedule.setScheduleEndDate(timeSchedule.getScheduleEndDate());
								tutorTimeSchedules.add(schedule);
							}
						}
					}else{
						
					}
				}
				boolean flag = tutorService.saveTutorSchedule(tutorTimeSchedules);
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
	/**
	 * @author Sushanta Barik
	 * @param tutorId integer value
	 * @return List<TutorTimeSchedule> object in json
	 * @exception Exception
	 */
	@RequestMapping(value = "/tutorScheduleList" , method =RequestMethod.GET)
	public @ResponseBody List<TutorTimeSchedule> tutorScheduleList(@RequestParam(value="tutorId") int tutorId) {
		List<TutorTimeSchedule> tutorScheduleList = new ArrayList<TutorTimeSchedule>();
		try {
			tutorScheduleList = tutorService.getTutorScheduleList(tutorId);
			return tutorScheduleList;
		} catch (Exception e) {
			logger.error("Exception occurs in : ", e);
		}
		return tutorScheduleList;
	}
	/**
	 * @author Sushanta Barik
	 * @param tutorId integer value
	 * @return List<TutorTimeSchedule> object in json
	 * @exception Exception
	 */
	@RequestMapping(value = "/tutorUpcomingScheduleList" , method =RequestMethod.GET)
	public @ResponseBody List<TutorTimeSchedule> tutorUpcomingScheduleList(@RequestParam(value="tutorId") int tutorId, @RequestParam(value="scheduleCount") int scheduleCount) {
		List<TutorTimeSchedule> tutorScheduleList = new ArrayList<TutorTimeSchedule>();
		try {
			if(!(scheduleCount > 0)){
				scheduleCount = 5;
			}
			tutorScheduleList = tutorService.getTutorUpcomingScheduleList(tutorId , scheduleCount);
			return tutorScheduleList;
		} catch (Exception e) {
			logger.error("Exception occurs in : ", e);
		}
		return tutorScheduleList;
	}
	/**
	 * @author Sushanta Barik
	 * @param tutorTimeScheduleId integer value
	 * @return TutorTimeSchedule object in json
	 * @exception Exception
	 */
	@RequestMapping(value = "/tutorSingleSchedule" , method =RequestMethod.GET)
	public @ResponseBody TutorTimeSchedule singleScheduleOfTutor(@RequestParam(value="tutorTimeScheduleId") int tutorTimeScheduleId) {
		TutorTimeSchedule tutorSchedule = new TutorTimeSchedule();
		try {
			tutorSchedule = tutorService.singleScheduleOfTutor(tutorTimeScheduleId);
		} catch (Exception e) {
			logger.error("Exception occurs in : ", e);
		}
		return tutorSchedule;
	}
	/**
	 * @author Sushanta Barik
	 * @param tutorTimeScheduleId integer value
	 * @return UserJsonResponse object in json
	 * @exception Exception
	 */
	@RequestMapping(value = "/tutorCancelSingleSchedule" , method =RequestMethod.PUT , consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserJsonResponse cancelSingleScheduleOfTutor(@Valid @RequestBody TutorTimeSchedule timeSchedule , BindingResult bindingResult) {
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
            userJsonResponse.setTutorTimeSchedule(timeSchedule);
            return userJsonResponse;
        }else{
			try {
				boolean flag = tutorService.cancelSingleScheduleOfTutor(timeSchedule);
				if(flag) userJsonResponse.setStatus("SUCCESS");
				else userJsonResponse.setStatus("FAILED");
			} catch (Exception e) {
				userJsonResponse.setStatus(e.toString());
				logger.error("Exception occurs in : ", e);
			}
		return userJsonResponse;
        }
	}
	@RequestMapping(value = "/tutorTransactionList" , method =RequestMethod.GET)
		public @ResponseBody List<TutorTransaction> tutorTransactionList(@RequestParam(value="start_date") String startDate, @RequestParam(value="end_date") String endDate) {
			List<TutorTransaction> transactionList = new ArrayList<TutorTransaction>();
			try {
				transactionList = tutorService.getTransactionList(DateTimeUtil.toDateConversion(startDate),DateTimeUtil.toDateConversion(endDate));
				return transactionList;
			} catch (Exception e) {
				logger.error("Exception occurs in : ", e);
			}
			return transactionList;
		}
	@RequestMapping(value = "/sendMail" , method =RequestMethod.GET)
	public @ResponseBody UserJsonResponse sendMail() {
		UserJsonResponse jsonResponse = new UserJsonResponse();
		try {
			String email = "sushanta.barik@quadraphic.com";
			String subject = "Welcome";
			String content="<HTML><BODY><center><div>Welcome to Edutube.<div></center></BODY></HTML>";
			boolean flag = MailUtils.sendMail(email, subject, content);
			if(flag) jsonResponse.setStatus("SUCCESS");
			else jsonResponse.setStatus("FAILED");
		} catch (Exception e) {
			jsonResponse.setStatus(e.toString());
			logger.error("Exception occurs in : ", e);
		}
		return jsonResponse;
	}
	
	
}
