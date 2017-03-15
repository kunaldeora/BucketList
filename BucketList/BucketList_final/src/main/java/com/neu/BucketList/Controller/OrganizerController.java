package com.neu.BucketList.Controller;

import java.sql.Blob;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.neu.BucketList.DAO.AdventureDAO;
import com.neu.BucketList.DAO.OrganizerDao;
import com.neu.BucketList.DAO.UserDao;
import com.neu.BucketList.Pojo.Adventure;
import com.neu.BucketList.Pojo.Adventurer;
import com.neu.BucketList.Pojo.Advertisement;
import com.neu.BucketList.Pojo.Organizer;
import com.neu.BucketList.Pojo.Person;
import com.neu.BucketList.Pojo.UserAccount;

@Controller
public class OrganizerController {

	@RequestMapping(value="/orgMainPage.htm", method=RequestMethod.POST)
	public ModelAndView createAdvertisement(@ModelAttribute("advertisement") Advertisement advertisement){
		
		
		
		UserDao userDao = new UserDao();
		AdventureDAO advertDao = new AdventureDAO();
		OrganizerDao orgDao = new OrganizerDao();
		ModelAndView mv = new ModelAndView();
		
		
		String orgEmail = advertisement.getPostedBy();
		UserAccount userAccount =  userDao.get(orgEmail);
		Person person=  userAccount.getPerson();
		Organizer organizer =  (Organizer) orgDao.getOrganizer(person.getPersonId());
		Adventure adventure = advertDao.getAdventurerforAdvertisement(advertisement.getAdventures().getAdventureName());
		orgDao.createAdvertisement(advertisement.getDescription(), advertisement.getMessage(), advertisement.getDateofEvent(), organizer, adventure);
		mv.addObject("organizer", organizer);
		mv.setViewName("organizerMainPage");
		return mv;
		
		
	}
	
	
	
	
}
