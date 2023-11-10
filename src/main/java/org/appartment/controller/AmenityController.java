package org.appartment.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.appartment.model.Amenity;
import org.appartment.model.User;
import org.appartment.service.AmenityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Rasool Malik Vempalli
 */

@Controller
public class AmenityController {

	@Autowired
	private AmenityService amenityService;

	@GetMapping("/getUserAmenityList")
	public String getUserAmenityList(HttpSession session, Model model) {
		User user = (User) session.getAttribute("currentUser");

		if (user == null) {
			return "redirect:/";
		}

		model.addAttribute("user", user);
		List<Amenity> amenity = amenityService.getAllAmenity();
		model.addAttribute("amenity", amenity);
		return "amenityListUser";
	}
}
