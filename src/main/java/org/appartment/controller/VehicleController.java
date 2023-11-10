package org.appartment.controller;

import org.appartment.model.User;
import org.appartment.model.Vehicle;
import org.appartment.model.Visitor;
import org.appartment.service.VehicleService;
import org.appartment.service.VisitorService;
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
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;


    @GetMapping("/getUserVehicleList")
    public String getUserVehicleList(HttpSession session, Model model) {
        User user = (User) session.getAttribute("currentUser");

        if (user == null) {
            return "redirect:/";
        }

        model.addAttribute("user", user);
        List<Vehicle> vehicles =  vehicleService.getAllVehicles();
        model.addAttribute("vehicles",vehicles);
        return "vehicleListUser";
    }
}
