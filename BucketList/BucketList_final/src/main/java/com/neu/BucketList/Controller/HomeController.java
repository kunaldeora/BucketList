package com.neu.BucketList.Controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neu.BucketList.Pojo.Adventurer;
import com.neu.BucketList.DAO.AdventureDAO;
import com.neu.BucketList.Pojo.Adventure;
import com.neu.BucketList.Pojo.Organizer;
import com.neu.BucketList.Pojo.Person;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		model.addAttribute("person", new Person());
        model.addAttribute("adventurer", new Adventurer());
      
//		model.addAttribute("organizer", new Organizer());
//		
		return "logintest";
	}
	
	@RequestMapping(value = "/logout.htm", method = RequestMethod.GET)
	public String logoutUser(Model model) {
		
		model.addAttribute("person", new Person());
        model.addAttribute("adventurer", new Adventurer());
      
//		model.addAttribute("organizer", new Organizer());
//		
		return "logintest";
	}

}
