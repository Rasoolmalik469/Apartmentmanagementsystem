package org.appartment.controller;

import org.appartment.model.Apartment;
import org.appartment.model.User;
import org.appartment.service.ApartmentService;
import org.appartment.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
/** Rasool Malik Vempalli **/

@Controller
public class ApartmentController {

    @Autowired
    private ApartmentService apartmentService;

    @Autowired
    private OwnerService ownerService;


    @GetMapping("/getApartmentList")
    public String getApartmentList(HttpSession session, Model model) {
        User user = (User) session.getAttribute("currentUser");

        if (user == null) {
            return "redirect:/";
        }

        model.addAttribute("user", user);
        model.addAttribute("apartments", apartmentService.getAllApartments());
        return "apartmentList";
    }


    @GetMapping("/editApartmentForm")
    public String editApartment(@RequestParam int id , HttpSession session, Model model) {
        User user = (User) session.getAttribute("currentUser");

        if (user == null) {
            return "redirect:/";
        }

        model.addAttribute("user", user);
        Apartment currentApartment = apartmentService.getApartmentById(id);
        model.addAttribute("apartment", currentApartment);
        return "editApartment";
    }

    @PostMapping("/createApartment")
    public String createApartment(Apartment apartment ,@RequestParam Long ownerId, HttpSession  session,   Model model) {
        User user = (User) session.getAttribute("currentUser");

        if (user == null) {
            return "redirect:/";
        }


        apartment.setOwner(ownerService.getOwnerById(ownerId));

        apartment = apartmentService.createApartment(apartment);
        if(apartment==null) {
            return "redirect:/";
        }else {
            model.addAttribute("MSG", "Apartment details uploaded successfully");
            model.addAttribute("action", "apartmentList");

        }


        return "home";

    }


    @GetMapping("/newApartment")
    public String newApartment(@RequestParam Long ownerId, HttpSession session, Model model) {
        User user = (User) session.getAttribute("currentUser");

        if (user == null ) {
            return "redirect:/";
        }
        model.addAttribute("user", user);

        if( ownerId==null) {
            model.addAttribute("owners",ownerService.getAllOwners());
            return "createNewApartmentAndAssignOwner";

        }

        model.addAttribute("ownerId", ownerId);
        model.addAttribute("apartments", apartmentService.getApartmentsByOwnerId(ownerId));
        return "createNewApartment";
    }


    @GetMapping("/newApartmentWithOutOwner")
    public String newApartmentWithOutOwner( HttpSession session, Model model) {
        return newApartment(null, session, model);
    }


    @PostMapping("/removeApartment")
    public String removeApartment(@RequestParam int apartmentId , HttpSession session, Model model) {
        User user = (User) session.getAttribute("currentUser");

        if (user == null) {
            return "redirect:/";
        }

        model.addAttribute("user", user);
        try {
            apartmentService.deletePlayer(apartmentId);
            model.addAttribute("MSG", "Apartment REMOVED");
        }catch (Exception e) {

            model.addAttribute("MSG", "Unable To Remove Apartment");
        }
        model.addAttribute("action", "apartmentList");
        return "home";
    }

    @GetMapping("/removeApartmentForm")
    public String removeApartmentForm(@RequestParam int apartmentId , HttpSession session, Model model) {
        User user = (User) session.getAttribute("currentUser");

        if (user == null) {
            return "redirect:/";
        }

        model.addAttribute("user", user);
        Apartment apartment = apartmentService.getApartmentById(apartmentId);
        model.addAttribute("apartment", apartment);
        return "confirmRemoveApartment";
    }


    @GetMapping("/getUserApartmentList")
    public String getUserApartmentList(HttpSession session, Model model) {
        User user = (User) session.getAttribute("currentUser");

        if (user == null) {
            return "redirect:/";
        }

        model.addAttribute("user", user);
        model.addAttribute("apartments", apartmentService.getAllApartments());
        return "apartmentListUser";
    }
}

