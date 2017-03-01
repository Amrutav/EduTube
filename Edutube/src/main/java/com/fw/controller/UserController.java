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

import com.fw.domain.entity.Contact;
import com.fw.domain.entity.EducationWorkProfile;
import com.fw.domain.entity.User;
import com.fw.domain.entity.UserJsonResponse;
import com.fw.util.DateTimeUtil;
import com.fw.util.MailUtils;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	com.fw.domain.service.UserServices dataServices;
    @Autowired
    private MessageSource messages;
    private boolean flag = false;
	static final Logger logger = Logger.getLogger(UserController.class);
	/**
	 * @author Sushanta Barik
	 * @param string value username
	 * @exception Exception
	 * @return userJsonResponse
	 */
	@RequestMapping(value = "/validateUsername", method = RequestMethod.GET)
	public @ResponseBody UserJsonResponse validateUsername( @RequestParam(value = "username")String username) {
		UserJsonResponse userJsonResponse=new UserJsonResponse();
	    try {
	        User user = dataServices.getUserDetailsByUsername(username);
	        if(user.getUserId() > 0){
	        	userJsonResponse.setStatus("EXIST");
	        }else{
	        	userJsonResponse.setStatus("NOT EXIST");
	        }
	    	return userJsonResponse;
	       } catch (Exception e) {
	    	logger.error("Exception occurs in", e);
	    	userJsonResponse.setStatus(e.toString());
	    }
	   	return userJsonResponse;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserJsonResponse addUser( @Valid @RequestBody User user, BindingResult bindingResult) {
		logger.debug("Submited User Data : \n"+user);
		UserJsonResponse userJsonResponse=new UserJsonResponse();
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
	        userJsonResponse.setUser(user);
	        userJsonResponse.setStatus("ERROR");
	        return userJsonResponse;
	   }else{
	        try {
	        	user.setUserAccountCreatedDate(new Date()); 
	        	dataServices.addUser(user);
	        	String token=dataServices.createToken(user);
	        	//String link="http://localhost:8080/Edutube?token="+token;
	        	String email = user.getEmail();
				String subject = "Welcome";
				String content="Welcome to Edutube."
						+ "A secret token is generated for you. Type this in the specified box and submit to activate your account."
						+ "Thank You."+" "
						+token;
				boolean flag = MailUtils.sendMail(email, subject, content);
	        	userJsonResponse.setStatus("SUCCESS");
	    		return userJsonResponse;
	        } catch (Exception e) {
	    		logger.error("Exception occurs in", e);
	    		userJsonResponse.setStatus(e.toString());
	    	}
	   	}
	    return userJsonResponse;
	}
	
	@RequestMapping(value = "/activateAccount", method = RequestMethod.GET)
	public @ResponseBody UserJsonResponse activateAccount( @RequestParam(value = "token")String token) {
		UserJsonResponse userJsonResponse=new UserJsonResponse();
		User user=new User();
	    try {
	    	System.out.println(user.getUserAccountFlag());
	        user = dataServices.activateAccount(token);
	        if(user.getUserId() > 0){
	        	userJsonResponse.setStatus("ACTIVATED");
	        }else{
	        	userJsonResponse.setStatus("NOT ACTIVATED");
	        }
	    	return userJsonResponse;
	       } catch (Exception e) {
	    	logger.error("Exception occurs in", e);
	    	userJsonResponse.setStatus(e.toString());
	    }
	   	return userJsonResponse;
	}	
	
	/**
	 * @author Sushanta Barik
	 * @param user
	 * @param bindingResult
	 * @exception Exception
	 * @return userJsonResponse
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserJsonResponse loginUser( @Valid @RequestBody User user, BindingResult bindingResult) {
		logger.debug("Submited User Data : \n"+user);
	    UserJsonResponse userJsonResponse=new UserJsonResponse();
	    if(bindingResult.hasErrors()){
        	Map<String ,String> errors=new HashMap<String, String>();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                String[] resolveMessageCodes = bindingResult.resolveMessageCodes(fieldError.getCode());
                String string = resolveMessageCodes[0];
                logger.debug("resolveMessageCodes : "+string);
                System.out.println("resolveMessageCodes : "+string);
                String message = messages.getMessage(string+"."+fieldError.getField(), new Object[]{fieldError.getRejectedValue()}, null);
                logger.debug("Meassage : "+message);
                System.out.println("resolveMessageCodes : "+string);
                errors.put(fieldError.getField(), message)    ;
            }
            userJsonResponse.setErrorsMap(errors);
            userJsonResponse.setUser(user);
            userJsonResponse.setStatus("ERROR");
            return userJsonResponse;
        }else{
        	try {
    			User validUser = dataServices.getAuthenticateUser(user);
    			if(validUser.getUserId() > 0){
    				userJsonResponse.setStatus("SUCCESS");
    				userJsonResponse.setUser(validUser);
    			}else{
    				userJsonResponse.setStatus("FAILED");
    			}
    			return userJsonResponse;
    			
    		} catch (Exception e) {
    			logger.error("Exception occurs in", e);
    			userJsonResponse.setStatus(e.toString());
    			return userJsonResponse;
    		}
        }    
	}
	/**
	 * @author Sushanta Barik
	 * @param user
	 * @param bindingResult
	 * @exception Exception
	 * @return userJsonResponse
	 */
	@RequestMapping(value = "/updateLoginDetails", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserJsonResponse updateLoginDetails( @Valid @RequestBody User user, BindingResult bindingResult) {
		logger.debug("Submited Login Data : \n"+user);
	    UserJsonResponse userJsonResponse=new UserJsonResponse();
	    if(bindingResult.hasErrors()){
        	Map<String ,String> errors=new HashMap<String, String>();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                String[] resolveMessageCodes = bindingResult.resolveMessageCodes(fieldError.getCode());
                String string = resolveMessageCodes[0];
                logger.debug("resolveMessageCodes : "+string);
                System.out.println("resolveMessageCodes : "+string);
                String message = messages.getMessage(string+"."+fieldError.getField(), new Object[]{fieldError.getRejectedValue()}, null);
                logger.debug("Meassage : "+message);
                System.out.println("resolveMessageCodes : "+string);
                errors.put(fieldError.getField(), message)    ;
            }
            userJsonResponse.setErrorsMap(errors);
            userJsonResponse.setUser(user);
            userJsonResponse.setStatus("ERROR");
            return userJsonResponse;
        }else{
        	try {
        		user.setLastLoginTime(new Date());
    			flag = dataServices.updateLoginDetails(user);
    			if(flag){
    				userJsonResponse.setStatus("SUCCESS");
    			}else{
    				userJsonResponse.setStatus("FAILED");
    			}
    			return userJsonResponse;
    			
    		} catch (Exception e) {
    			// e.printStackTrace();
    			logger.error("Exception occurs in", e);
    			userJsonResponse.setStatus(e.toString());
    			return userJsonResponse;
    		}
        }    
	}
	/**
	 * @author Sushanta Barik
	 * @param user
	 * @param bindingResult
	 * @exception Exception
	 * @return userJsonResponse
	 */
	@RequestMapping(value = "/updateUserType", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserJsonResponse updateUserType( @Valid @RequestBody User user, BindingResult bindingResult) {
		logger.debug("Submited User Data : \n"+user);
	    UserJsonResponse userJsonResponse=new UserJsonResponse();
	    if(bindingResult.hasErrors()){
        	Map<String ,String> errors=new HashMap<String, String>();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                String[] resolveMessageCodes = bindingResult.resolveMessageCodes(fieldError.getCode());
                String string = resolveMessageCodes[0];
                logger.debug("resolveMessageCodes : "+string);
                System.out.println("resolveMessageCodes : "+string);
                String message = messages.getMessage(string+"."+fieldError.getField(), new Object[]{fieldError.getRejectedValue()}, null);
                logger.debug("Meassage : "+message);
                System.out.println("resolveMessageCodes : "+string);
                errors.put(fieldError.getField(), message)    ;
            }
            userJsonResponse.setErrorsMap(errors);
            userJsonResponse.setUser(user);
            userJsonResponse.setStatus("ERROR");
            return userJsonResponse;
        }else{
        	try {
        		flag = dataServices.updateUserType(user);
    			if(flag){
    				userJsonResponse.setStatus("SUCCESS");
    			}else{
    				userJsonResponse.setStatus("FAILED");
    			}
    			return userJsonResponse;
    			
    		} catch (Exception e) {
    			// e.printStackTrace();
    			logger.error("Exception occurs in", e);
    			userJsonResponse.setStatus(e.toString());
    			return userJsonResponse;
    		}
        }    
	}
	/**
	 * @author Sushanta Barik
	 * @param user
	 * @param bindingResult
	 * @exception Exception
	 * @return userJsonResponse
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserJsonResponse userLogout( @Valid @RequestBody User user, BindingResult bindingResult) {
		logger.debug("Inside Logout : \n"+user);
	    UserJsonResponse userJsonResponse=new UserJsonResponse();
	    if(bindingResult.hasErrors()){
        	Map<String ,String> errors=new HashMap<String, String>();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                String[] resolveMessageCodes = bindingResult.resolveMessageCodes(fieldError.getCode());
                String string = resolveMessageCodes[0];
                logger.debug("resolveMessageCodes : "+string);
                System.out.println("resolveMessageCodes : "+string);
                String message = messages.getMessage(string+"."+fieldError.getField(), new Object[]{fieldError.getRejectedValue()}, null);
                logger.debug("Meassage : "+message);
                System.out.println("resolveMessageCodes : "+string);
                errors.put(fieldError.getField(), message)    ;
            }
            userJsonResponse.setErrorsMap(errors);
            userJsonResponse.setUser(user);
            userJsonResponse.setStatus("ERROR");
            return userJsonResponse;
        }else{
        	try {
        		user.setLastLogoutTime(new Date());
        		flag = dataServices.updateUserLogoutDetails(user);
    			if(flag){
    				userJsonResponse.setStatus("SUCCESS");
    			}else{
    				userJsonResponse.setStatus("FAILED");
    			}
    			return userJsonResponse;
    			
    		} catch (Exception e) {
    			logger.error("Exception occurs in", e);
    			userJsonResponse.setStatus(e.toString());
    			return userJsonResponse;
    		}
        }    
	}
	/**
	 * @author Sushanta Barik
	 * @param integer value userId
	 * @exception Exception
	 * @return Contact object
	 */
	@RequestMapping(value = "/viewUserContact", method = RequestMethod.GET)
	public @ResponseBody Contact getUserContact( @RequestParam(value = "userId") int userId) {
		Contact contact = new Contact();
		try {
	        contact = dataServices.getUserContact(userId);
	    	return contact;
	       } catch (Exception e) {
	    	logger.error("Exception occurs in", e);
	    }
	   	return contact;
	}
	/**
	 * @author Sushanta Barik
	 * @param Contact object , BindingResult object
	 * @exception Exception
	 * @return userJsonResponse
	 */
	@RequestMapping(value = "/userContactUpdate" , method=RequestMethod.PUT , consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserJsonResponse tutorContactUpdate(@Valid @RequestBody Contact contact , BindingResult bindingResult) {
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
            userJsonResponse.setContact(contact);
            userJsonResponse.setStatus("ERROR");
            return userJsonResponse;
        }else{
			try {
				boolean flag = dataServices.updateUserContact(contact);
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
	 * @param integer value userId
	 * @exception Exception
	 * @return List<EducationWorkProfile> object in json
	 */
	@RequestMapping(value = "/viewUserEducationWorkProfile", method = RequestMethod.GET)
	public @ResponseBody List<EducationWorkProfile> getUserEducationWorkProfile( @RequestParam(value = "userId") int userId) {
		List<EducationWorkProfile> educationWorkProfileList = new ArrayList<EducationWorkProfile>();
		try {
	        educationWorkProfileList = dataServices.getUserEducationWorkProfile(userId);
	    	return educationWorkProfileList;
	       } catch (Exception e) {
	    	logger.error("Exception occurs in", e);
	    }
	   	return educationWorkProfileList;
	}
	/**
	 * @author Sushanta Barik
	 * @param List<EducationWorkProfile> object , BindingResult object
	 * @exception Exception
	 * @return userJsonResponse
	 */
	@RequestMapping(value = "/userEducationUpdate" , method=RequestMethod.PUT , consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserJsonResponse userEducationUpdate(@Valid @RequestBody List<EducationWorkProfile> educationList , BindingResult bindingResult) {
		UserJsonResponse userJsonResponse = new UserJsonResponse();
		logger.error("Education List Size : "+educationList.size());
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
            //userJsonResponse.setContact(contact);
            userJsonResponse.setStatus("ERROR");
            return userJsonResponse;
        }else{
			try {
				for(EducationWorkProfile educationProfile : educationList){
					educationProfile.setEduStartDate(DateTimeUtil.toDateConversion(educationProfile.getStartDateInput()));
					educationProfile.setEduEndDate(DateTimeUtil.toDateConversion(educationProfile.getEndDateInput()));
					educationProfile.setEduCreateDate(new Date());
				}
				boolean flag = dataServices.updateUserEducation(educationList);
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
	 * @param List<EducationWorkProfile> object , BindingResult object
	 * @exception Exception
	 * @return userJsonResponse
	 */
	@RequestMapping(value = "/userWorkExpUpdate" , method=RequestMethod.PUT , consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserJsonResponse userWorkExpUpdate(@Valid @RequestBody List<EducationWorkProfile> workExpList , BindingResult bindingResult) {
		UserJsonResponse userJsonResponse = new UserJsonResponse();
		logger.error("Education List Size : "+workExpList.size());
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
            //userJsonResponse.setContact(contact);
            userJsonResponse.setStatus("ERROR");
            return userJsonResponse;
        }else{
			try {
				for(EducationWorkProfile workExpProfile : workExpList){
					workExpProfile.setWorkStartDate(DateTimeUtil.toDateConversion(workExpProfile.getStartDateInput()));
					workExpProfile.setWorkEndDate(DateTimeUtil.toDateConversion(workExpProfile.getEndDateInput()));
					workExpProfile.setWorkCreateDate(new Date());
				}
				boolean flag = dataServices.updateUserWorkExpProfile(workExpList);
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
	
	@RequestMapping(value = "/facebookLogin", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserJsonResponse facebookLogin( @Valid @RequestBody User user, BindingResult bindingResult) {
		User facebookUser= new User();
		logger.debug("Submited User Data : \n"+user);
		UserJsonResponse userJsonResponse=new UserJsonResponse();
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
	        userJsonResponse.setUser(user);
	        userJsonResponse.setStatus("ERROR");
	        return userJsonResponse;
	   }else{
		   		
		   try {
	        	facebookUser=dataServices.getUserByEmailId(user.getEmail());
	        	if(facebookUser==null){
	        	user.setUserAccountCreatedDate(new Date()); 
	        	dataServices.addUser(user);
	        	facebookUser=dataServices.getUserByEmailId(user.getEmail());
	        	}
	        	else {
					if(facebookUser!=null){
						System.out.println("entered");
						facebookUser.setFacebookId(user.getFacebookId());
						dataServices.updateUserSocialPlugin(facebookUser);
					}
				}
	        	if(facebookUser.getUserId()>0){
	        		userJsonResponse.setStatus("SUCCESS");
	        	}
	        	else{
	        		userJsonResponse.setStatus("FAILED");
	        	}
	        	userJsonResponse.setUser(facebookUser);
	    		return userJsonResponse;
	        } catch (Exception e) {
	    		logger.error("Exception occurs in", e);
	    		userJsonResponse.setStatus(e.toString());
	    	}
	   	}
	    return userJsonResponse;
	}
	
	
	@RequestMapping(value = "/googleLogin", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserJsonResponse googleLogin( @Valid @RequestBody User user, BindingResult bindingResult) {
		User googleUser= new User();
		logger.debug("Submited User Data : \n"+user);
		UserJsonResponse userJsonResponse=new UserJsonResponse();
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
	        userJsonResponse.setUser(user);
	        userJsonResponse.setStatus("ERROR");
	        return userJsonResponse;
	   }else{
		   		
		   try {
	        	googleUser=dataServices.getUserByEmailId(user.getEmail());
	        	if(googleUser==null){
	        	user.setUserAccountCreatedDate(new Date()); 
	        	dataServices.addUser(user);
	        	googleUser=dataServices.getUserByEmailId(user.getEmail());
	        	}
	        	else {
					if(googleUser!=null){
						googleUser.setGoogleId(user.getGoogleId());
						dataServices.updateUserSocialPlugin(googleUser);
					}
				}
	        	if(googleUser.getUserId()>0){
	        		userJsonResponse.setStatus("SUCCESS");
	        	}
	        	else{
	        		userJsonResponse.setStatus("FAILED");
	        	}
	        	userJsonResponse.setUser(googleUser);
	    		return userJsonResponse;
	        } catch (Exception e) {
	    		logger.error("Exception occurs in", e);
	    		userJsonResponse.setStatus(e.toString());
	    	}
	   	}
	    return userJsonResponse;
	}
	
	
	@RequestMapping(value = "/twitterLogin", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserJsonResponse twitterLogin( @Valid @RequestBody User user, BindingResult bindingResult) {
		User twitterUser= new User();
		logger.debug("Submited User Data : \n"+user);
		UserJsonResponse userJsonResponse=new UserJsonResponse();
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
	        userJsonResponse.setUser(user);
	        userJsonResponse.setStatus("ERROR");
	        return userJsonResponse;
	   }else{
		   		
		   try {
	        	twitterUser=dataServices.getUserByEmailId(user.getEmail());
	        	if(twitterUser==null){
	        	user.setUserAccountCreatedDate(new Date()); 
	        	dataServices.addUser(user);
	        	twitterUser=dataServices.getUserByEmailId(user.getEmail());
	        	}
	        	else {
					if(twitterUser!=null){
						twitterUser.setTwitterId(user.getTwitterId());
						dataServices.updateUserSocialPlugin(twitterUser);
					}
				}
	        	if(twitterUser.getUserId()>0){
	        		userJsonResponse.setStatus("SUCCESS");
	        	}
	        	else{
	        		userJsonResponse.setStatus("FAILED");
	        	}
	        	userJsonResponse.setUser(twitterUser);
	    		return userJsonResponse;
	        } catch (Exception e) {
	    		logger.error("Exception occurs in", e);
	    		userJsonResponse.setStatus(e.toString());
	    	}
	   	}
	    return userJsonResponse;
	}
	
	
	@RequestMapping(value = "/validateEmail", method = RequestMethod.GET)
	public @ResponseBody UserJsonResponse validateEmail( @RequestParam(value = "email") String email) {
		UserJsonResponse userJsonResponse=new UserJsonResponse();
	    try {
	        User user = dataServices.getUserDetailsByEmail(email);
	        if(user!=null){
	        	userJsonResponse.setStatus("EXIST");
	        }else{
	        	userJsonResponse.setStatus("NOT EXIST");
	        }
	    	return userJsonResponse;
	       } catch (Exception e) {
	    	logger.error("Exception occurs in", e);
	    	userJsonResponse.setStatus(e.toString());
	    }
	   	return userJsonResponse;
	}
	
//	@RequestMapping(value = "/facebookLogin")
//	public @ResponseBody
//	com.fw.domain.entity.UserJsonResponse facebookLogin(@RequestParam(value ="code") String code) {
//		logger.debug("Inside facebookLogin=======");
//	        com.fw.domain.entity.UserJsonResponse userJsonResponse=new com.fw.domain.entity.UserJsonResponse();
//	        String farmId = "NA";
//			String lendValue = "NA";
//			String contributeValue ="NA";
//			String interest = "NA"; 
//			String type = "NA";
//			String loginid="NA";
//			String forwardAction = "login";   
//			     
//			String response = "failed";
//			String facebookId = null;
//			String firstName = null;
//			String middleNames;
//			String lastName = null;
//			String email = null;
//			String username = null;
//			String birthday = null;
//			String location = null;
//			String city = null;
//			String state = null;
//			String country = null;
//			String gender = null;
//			String investor_birth_date = null;
//			String investor_birth_month = null;
//			String investor_birth_year = null;
//
//			
//			String token = null;
//			try {
//				String g = "https://graph.facebook.com/oauth/access_token?client_id=490694001088434&redirect_uri="
//						+ "http://localhost:8080/FwdSample/user/facebookLogin?value="+3552                 
//						+ "&client_secret=2c65d5fa622b7111d271b06f2ad8891b&code="
//						+ code;
//				/*String g = "https://graph.facebook.com/oauth/access_token?client_id=624417064261703&redirect_uri="
//						+ "http://localhost:8080/OAV/facebookInvestment?value="+info                 
//						+ "&client_secret=2a962a6145a0d0e8892cda6eb0a41691&code="
//						+ code;*/
//				
//				URL u = new URL(g);
//				System.out.println("first url created=>"+u);
//				
//				URLConnection c = u.openConnection();
//				//c.setRequestMethod("GET");
//				System.out.println("connection opened=>"+c);
//				System.out.println("InputStream Reader : "+c.getInputStream());
//				BufferedReader in = new BufferedReader(new InputStreamReader(
//						c.getInputStream()));
//				System.out.println("++++++++++"+in);
//				String inputLine;
//				StringBuffer b = new StringBuffer();
//				while ((inputLine = in.readLine()) != null)
//					b.append(inputLine + "\n");
//				in.close();
//				token = b.toString();
//				System.out.println(token);
//				if (token.startsWith("{"))
//					throw new Exception("error on requesting token: " + token
//							+ " with code: " + code);
//			} catch (Exception e) {
//				e.printStackTrace();
//				logger.error(
//						"Error present in the LoginAction class at facebookLogin method",
//						e);
//			}
//
//			String graph = null;
//			try {
//				String g = "https://graph.facebook.com/me?" + token;
//				URL u = new URL(g);
//				URLConnection c = u.openConnection();
//				BufferedReader in = new BufferedReader(new InputStreamReader(
//						c.getInputStream()));
//				String inputLine;
//				StringBuffer b = new StringBuffer();
//				while ((inputLine = in.readLine()) != null)
//					b.append(inputLine + "\n");
//				in.close();
//				graph = b.toString();
//			} catch (Exception e) {
//				logger.error(
//						"Error present in the LoginAction class at facebookLogin method",
//						e);
//			}
//
//			try {
//				JSONObject json = new JSONObject(graph);
//				logger.debug(json);
//				System.out.println("------>"+json.toString());
//				if (json.has("location")) {
//					JSONObject locationJson = json.getJSONObject("location");
//					location = locationJson.getString("name");
//					int loop = 1;
//					for (String value : location.split(",", 3)) {
//						if (loop == 1)
//							city = value;
//						if (loop == 2)
//							country = value;
//						if (loop == 3)
//							state = country;
//						country = value;
//						loop++;
//					}
//				}
//				facebookId = json.getString("id");
//				firstName = json.getString("first_name");
//				if (json.has("middle_name"))
//					middleNames = json.getString("middle_name");
//				else
//					middleNames = null;
//				if (middleNames != null && middleNames.equals(""))
//					middleNames = null;
//				lastName = json.getString("last_name");
//				email = json.getString("email");
//				username = json.getString("username");
//				//username = json.getString("email");
//
//				if (json.has("gender")) {
//					gender = json.getString("gender");
//
//				}
//
//				if (json.has("birthday")) {
//					birthday = json.getString("birthday");
//				}
//
//			} catch (Exception e) {
//				logger.error(
//						"Error present in the LoginAction class at facebookLogin method ",
//						e);
//			}    
//			
//				
//				System.out.println("firstName : "+firstName);
//				System.out.println("lastName : "+lastName);
//				System.out.println("email : "+email);
//				System.out.println("username : "+username);
//				System.out.println("facebookId : "+facebookId);
//				System.out.println("birthday : "+birthday);
//				System.out.println("country : "+country);
//				System.out.println("city : "+city);
//				System.out.println("state : "+state);
//
//	        return userJsonResponse;
//	}
//
//	
//	        public MessageSource getMessages() {
//	            return messages;
//	        }
//	        public void setMessages(MessageSource messages) {
//	            this.messages = messages;
//	        }
	
	@RequestMapping(value = "/updateTermsConditions", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserJsonResponse updateTermsConditions( @Valid @RequestBody User user, BindingResult bindingResult) {
		logger.debug("Submited Login Data : \n"+user);
	    UserJsonResponse userJsonResponse=new UserJsonResponse();
	    if(bindingResult.hasErrors()){
        	Map<String ,String> errors=new HashMap<String, String>();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                String[] resolveMessageCodes = bindingResult.resolveMessageCodes(fieldError.getCode());
                String string = resolveMessageCodes[0];
                logger.debug("resolveMessageCodes : "+string);
                System.out.println("resolveMessageCodes : "+string);
                String message = messages.getMessage(string+"."+fieldError.getField(), new Object[]{fieldError.getRejectedValue()}, null);
                logger.debug("Meassage : "+message);
                System.out.println("resolveMessageCodes : "+string);
                errors.put(fieldError.getField(), message)    ;
            }
            userJsonResponse.setErrorsMap(errors);
            userJsonResponse.setUser(user);
            userJsonResponse.setStatus("ERROR");
            return userJsonResponse;
        }else{
        	try {
    			flag = dataServices.updateTermsConditions(user);
    			if(flag){
    				userJsonResponse.setStatus("SUCCESS");
    			}else{
    				userJsonResponse.setStatus("FAILED");
    			}
    			return userJsonResponse;
    			
    		} catch (Exception e) {
    			// e.printStackTrace();
    			logger.error("Exception occurs in", e);
    			userJsonResponse.setStatus(e.toString());
    			return userJsonResponse;
    		}
        }    
	}
	
	@RequestMapping(value = "/regenerateToken", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserJsonResponse regenerateToken( @Valid @RequestBody User user) {
		logger.debug("Submited User Data : \n"+user);
		UserJsonResponse userJsonResponse=new UserJsonResponse();
	    try {
	        	String token=dataServices.createToken(user);
	        	String email = user.getEmail();
				String subject = "Welcome";
				String content="Welcome to Edutube."
						+ "A secret token is generated for you. Type this in the specified box and submit to activate your account."
						+ "Thank You."+" "
						+token;
				boolean flag = MailUtils.sendMail(email, subject, content);
	        	userJsonResponse.setStatus("SUCCESS");
	    		return userJsonResponse;
	        } catch (Exception e) {
	    		logger.error("Exception occurs in", e);
	    		userJsonResponse.setStatus(e.toString());
	    	}
	    return userJsonResponse;
	}
}
