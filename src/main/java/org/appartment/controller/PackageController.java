package org.appartment.controller;

import org.appartment.model.Delivery;
import org.appartment.model.ParkingSpace;
import org.appartment.model.User;

import org.appartment.service.PackageService;
import org.appartment.service.ParkingSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/** Rasool Malik Vempalli **/

@Controller
public class PackageController {

	@Autowired
	private PackageService packageService;

	@GetMapping("/getUserPackageList")
	public String getUserPackageList(HttpSession session, Model model) {
		User user = (User) session.getAttribute("currentUser");

		if (user == null) {
			return "redirect:/";
		}

		model.addAttribute("user", user);
		List<Delivery> delivery = packageService.getAllPackage();
		model.addAttribute("delivery", delivery);
		return "packageListUser";
	}
}
