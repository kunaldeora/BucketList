package com.neu.BucketList.Controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
//import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.neu.BucketList.DAO.AdventureDAO;
import com.neu.BucketList.DAO.BucketListDao;
import com.neu.BucketList.DAO.LocationDAO;
import com.neu.BucketList.DAO.OrganizerDao;
import com.neu.BucketList.DAO.UserDao;
import com.neu.BucketList.Pojo.Adventurer;
import com.neu.BucketList.Pojo.Advertisement;
import com.neu.BucketList.Pojo.BucketList;
import com.neu.BucketList.Pojo.Location;
import com.neu.BucketList.Pojo.Organizer;
import com.neu.BucketList.Pojo.Adventure;
import com.neu.BucketList.Pojo.Person;
import com.neu.BucketList.Pojo.UserAccount;




@Controller
public class SignUpController {
	
	
	@RequestMapping(value = "/signup.htm", method = RequestMethod.POST)
   protected String doSubmitAction(@ModelAttribute("person") Person person, @RequestParam("myLocation") String myLocation) throws Exception {
	
		try {
			
			if (person.getUserAccount().getTypeOfUser().equals("adventurer")){
				Location searchedLoc = (new LocationDAO()).checkIfLocationExists(myLocation);
				UserDao userDao = new UserDao();
				userDao.create(person.getUserAccount().getPassword(), person.getUserAccount().getEmail(), person.getFirstName(), person.getLastName(), searchedLoc );
				
			}
			else{
				Location searchedLoc = (new LocationDAO()).checkIfLocationExists(myLocation);
				OrganizerDao orgDao = new OrganizerDao();
				UserAccount orgAcc = orgDao.create(person.getUserAccount().getPassword(), person.getUserAccount().getEmail(), person.getFirstName(), person.getLastName(), searchedLoc);
				//org.setLocation((new LocationDAO()).checkIfLocationExists(person.getMyLocation()));
				//orgDao.setLocationForOrganizerPerson(orgAcc, searchedLoc.getLocationName());
			}
			
			
			
			// DAO.close();
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		
		
		
		return "successUser";
	}
	
	
	@RequestMapping(value ="/login.htm", method = RequestMethod.POST)
	public ModelAndView loginForm(@ModelAttribute("person") Person person, HttpSession session) throws Exception{
//		, @ModelAttribute("adventurer") Adventurer adventurer
		String userEmail = person.getUserAccount().getEmail();
		String password = person.getUserAccount().getPassword();
		ModelAndView mv = new ModelAndView();
		AdventureDAO advertDao = new AdventureDAO();
		UserDao userDao = new UserDao();
		BucketListDao bucketDao = new BucketListDao(); 
		UserAccount account = userDao.checkIfUserExists(userEmail, password);
		
		//return "adventurerMainPage";
		
		//Adventurer adventurer = adventureDao.getAdventurer(Integer.parseInt(id));
		
		
		if (account.getTypeOfUser().equalsIgnoreCase("Adventurer")){
			session.setAttribute("adventurer", (Adventurer) account.getPerson());
			mv.addObject("adventurer", (Adventurer) account.getPerson());
			mv.addObject("adventures", new Adventure());
			List adventureListfromDatabase = advertDao.getAdventureList();
			mv.addObject("adventureList", adventureListfromDatabase);
			mv.setViewName("adventurerMainPage"); 
			
			Set<BucketList> bucketList = bucketDao.getBucketList(account.getPerson().getPersonId());
			List<BucketList> listBucketList = bucketDao.getAllCompletedAdventures( account.getPerson().getPersonId() , "Y");
			Set<Adventure> adventureListBucket =  bucketDao.getAllAdventures(bucketList);
			mv.addObject("adventureListBucket", adventureListBucket);
			mv.addObject("listBucketList", listBucketList);
			
			return mv;
		  // person.setFirstName(account.getPerson().getFirstName());	
		  //	return "adventurerMainPage";
		}
		else
			mv.addObject("organizer", (Organizer) account.getPerson());
			mv.addObject("advertisement", new Advertisement());
			mv.addObject("adventures", new Adventure());		
			List adventureListfromDatabase = advertDao.getAdventureList();
			mv.addObject("adventureList", adventureListfromDatabase);
			mv.setViewName("organizerMainPage");
			return mv;
	}

	@RequestMapping(value="/abc" , method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("person") Person person) {
		return "signUp";
	}
	
	
	
	
	

}
