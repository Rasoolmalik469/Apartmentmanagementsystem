package org.appartment.controller;

import org.appartment.model.ParkingSpace;
import org.appartment.model.User;
import org.appartment.model.Vehicle;
import org.appartment.service.ParkingSpaceService;
import org.appartment.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Rasool Malik Vempalli
 */
@Controller
public class ParkingSpaceController {

    @Autowired
    private ParkingSpaceService parkingSpaceService;


    @GetMapping("/getUserParkingSpaceList")
    public String getUserParkingSpaceList(HttpSession session, Model model) {
        User user = (User) session.getAttribute("currentUser");

        if (user == null) {
            return "redirect:/";
        }

        model.addAttribute("user", user);
        List<ParkingSpace> parkingSpaces =  parkingSpaceService.getAllParkingSpace();
        model.addAttribute("parkingSpaces",parkingSpaces);
        return "parkingSpaceListUser";
    }
}
