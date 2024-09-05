package org.appartment.controller;

import org.appartment.model.Owner;
import org.appartment.model.User;
import org.appartment.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/** Rasool Malik Vempalli **/
@Controller
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @PostMapping("/createOwner")
    public String createOwner(Owner owner , HttpSession session, Model model) {
        User user = (User) session.getAttribute("currentUser");

        if (user == null) {
            return "redirect:/";
        }




        owner = ownerService.createOwner(owner);
        if(owner==null) {
            return "redirect:/";
        }else {
            model.addAttribute("MSG", "Owner details SUCCESSFULLY");
            model.addAttribute("action", "ownerList");

        }


        return "home";

    }
    @PostMapping("/updateOwner")
    public String updateOwner(Owner owner , Model model) {
        if( ownerService.updateOwner(owner.getOwnerId(),owner)== null) {

            model.addAttribute("MSG", "FAILED TO UPDATE USER DETAILES");
        }else {
            model.addAttribute("MSG", "Owner DETAILES UPDATED SUCCESSFULLY");
            model.addAttribute("action", "ownerList");

        }


        return "home";

    }

    @GetMapping("/newOwner")
    public String newOwner(HttpSession session, Model model) {
        User user = (User) session.getAttribute("currentUser");

        if (user == null) {
            return "redirect:/";
        }

        model.addAttribute("user", user);

        return "createNewOwner";
    }

    @GetMapping("/getOwnerList")
    public String getOwnerList(HttpSession session, Model model) {
        User user = (User) session.getAttribute("currentUser");

        if (user == null) {
            return "redirect:/";
        }

        model.addAttribute("user", user);
        List<Owner> owners =  ownerService.getAllOwners();
        model.addAttribute("owners",owners);
        return "ownerList";
    }




    @GetMapping("/editOwnerForm")
    public String editOwnerForm(@RequestParam Long ownerId , HttpSession session, Model model) {
        User user = (User) session.getAttribute("currentUser");

        if (user == null) {
            return "redirect:/";
        }

        model.addAttribute("user", user);
        Owner owner = ownerService.getOwnerById(ownerId);
        model.addAttribute("team", owner);
        return "editOwner";
    }

    @PostMapping("/removeOwner")
    public String removeOwner(@RequestParam Long ownerId , HttpSession session, Model model) {
        User user = (User) session.getAttribute("currentUser");

        if (user == null) {
            return "redirect:/";
        }

        model.addAttribute("user", user);
        ownerService.deleteOwner(ownerId);
        try {
            model.addAttribute("MSG", "Owner REMOVED Successfully");
        }catch (Exception e) {

            model.addAttribute("MSG", "Unable To Remove Owner");
        }
        model.addAttribute("action", "ownerList");
        return "home";
    }

    @GetMapping("/removeOwnerForm")
    public String removeOwnerForm(@RequestParam Long ownerId , HttpSession session, Model model) {
        User user = (User) session.getAttribute("currentUser");

        if (user == null) {
            return "redirect:/";
        }

        model.addAttribute("user", user);
        Owner owner = ownerService.getOwnerById(ownerId);
        model.addAttribute("team", owner);
        return "confirmRemoveOwner";
    }

    @GetMapping("/getUserOwnerList")
    public String getUserOwnerList(HttpSession session, Model model) {
        User user = (User) session.getAttribute("currentUser");

        if (user == null) {
            return "redirect:/";
        }

        model.addAttribute("user", user);
        List<Owner> owners =  ownerService.getAllOwners();
        model.addAttribute("owners",owners);
        return "ownerListUser";
    }


}
