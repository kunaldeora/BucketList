package com.neu.BucketList.Controller;

import java.net.Authenticator.RequestorType;
import java.nio.file.AccessDeniedException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.RequestToViewNameTranslator;

import com.neu.BucketList.DAO.AdventureDAO;
import com.neu.BucketList.DAO.BucketListDao;
import com.neu.BucketList.DAO.LocationDAO;
import com.neu.BucketList.DAO.UserDao;
import com.neu.BucketList.Pojo.Adventure;
import com.neu.BucketList.Pojo.Adventurer;
import com.neu.BucketList.Pojo.BucketList;
import com.neu.BucketList.Pojo.Location;
import com.neu.BucketList.Pojo.Person;
import com.neu.BucketList.Pojo.UserAccount;



@Controller
public class AdventureController {
	
    @Autowired
    AdventureDAO adventureDao;
    @Autowired
    BucketListDao bucketListDao;
    
	
	@RequestMapping(value="/advMainPage.htm",method=RequestMethod.POST)
	public ModelAndView createAdventure(@ModelAttribute("adventures") Adventure adventure ) {
	   
	   String userEmail = adventure.getPostedBy();
	   
	   
	   UserDao userDao = new UserDao();
	   UserAccount userAccount =  userDao.get(userEmail);  
	   Person person=  userAccount.getPerson();
	   
	   Adventurer adventurer =  (Adventurer) adventureDao.getAdventurer(person.getPersonId());

	   Adventure newAdv = adventureDao.createAdventure(adventure.getAdventureName(), adventurer.getAd_location() ,adventurer, adventure.getTypeOfAdventure());
	   
	   
	   
	   bucketListDao.insertIntoBucketList(adventurer, newAdv);
	   
	    Set<BucketList> bucketList = bucketListDao.getBucketList(adventurer.getPersonId());
		Set<Adventure> adventureListBucket =  bucketListDao.getAllAdventures(bucketList);
		
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("adventureListBucket", adventureListBucket);
		mv.addObject("adventurer", adventurer);
		mv.addObject("adventures", new Adventure());
		mv.setViewName("adventurerMainPage");
		
	    return mv;
		
	}
	
	
	
	@RequestMapping(value = "/searchAdventure", method = RequestMethod.POST)
	public @ResponseBody String checkIfAdventureNameExists(@RequestParam("adventureName") String adventureName){
		
		System.err.println("Comming value : " + adventureName);
		
		AdventureDAO adventureDao = new AdventureDAO();
		Adventure adventure = adventureDao.getAdventurerforAdvertisement(adventureName);
		//System.err.println("Name : " + adventure.getAdventureName());
		
		if(adventure == null){
			return "N";	
		}
		else{
			return "Y";
		}
	}
	
	@RequestMapping(value = "/bucketListDisplay.htm", params={"id"}, method = RequestMethod.GET)
	public ModelAndView getDataForBucketList(@RequestParam("id") String id){
		ModelAndView mv = new ModelAndView();
		Adventurer adventurer = adventureDao.getAdventurer(Integer.parseInt(id));
		Set<BucketList> bucketList = bucketListDao.getBucketList(Integer.parseInt(id));
		Set<Adventure> adventureList =  bucketListDao.getAllAdventures(bucketList);
		mv.addObject("adventureList", adventureList);
		mv.addObject("adventurer", adventurer);
		mv.addObject("adventures", new Adventure());
		mv.setViewName("adventurerMainPage");
		return mv;
		
	}
	
	@RequestMapping(value = "/completedAdventure", method = RequestMethod.POST)
	public @ResponseBody String checkCompletedAdventure(@RequestParam("adventureID") String adventureID,
			@RequestParam("besttime") String besttime,
			@RequestParam("datecompleted") String datecompleted,
			@RequestParam("expectedexpense") String expectedexpense,
			@RequestParam("feedback") String feedback,
			@RequestParam("rating") String rating,
			@RequestParam("status") String status){
			
		    AdventureDAO adventureDao = new AdventureDAO();
		    
		    String[] ids= adventureID.split("_");
		    String adventurerId =  ids[0];
		    String adventureId =   ids[1];
		    
		    Adventurer adventurer = adventureDao.getAdventurer(Integer.parseInt(adventurerId));
		    Adventure adventure = adventureDao.getAdventure(Integer.parseInt(adventureId));
		    
		    boolean result = adventureDao.saveFeedBackOnCompletionOfAdventure(adventurer, adventure, besttime, feedback, datecompleted, expectedexpense, rating, status);
		
		    if(result){
		    	return "done";
		    }
		    else{
		    	return "notDone";
		    }

	}
	
	
	@RequestMapping(value = "/deleteAdventure", method = RequestMethod.POST)
	public @ResponseBody String deleteFromBucketList(@RequestParam("adventureId") String adventureId){
		

		
		 String[] ids= adventureId.split("_");
		 String adventurerIdDelete =  ids[0];
		 String adventureIdDelete =   ids[1];
		 
		 //Adventurer adventurer = adventureDao.getAdventurer(Integer.parseInt(adventurerIdDelete));
		 //Adventure adventure = adventureDao.getAdventure(Integer.parseInt(adventureIdDelete));
		 
		 AdventureDAO adventureDao = new AdventureDAO();
		 Boolean result =  adventureDao.deleteAdventureFromBucketList(Integer.parseInt(adventurerIdDelete),Integer.parseInt(adventureIdDelete));
		 
		 if(result){
			 
			 return "Y";
		 }else{
			 
			 return "N";
		 }
		 
		
	}
	
	
	
	
	
	
	

}
