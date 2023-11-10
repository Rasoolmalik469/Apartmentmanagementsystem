package org.appartment.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.appartment.model.User;
import org.appartment.model.Role;
import org.appartment.service.RoleService;
import org.appartment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Optional;

/**
 * Created by Rasool Malik Vempalli
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/")
    public String showLoginPage(HttpSession session ) {
        User user = (User) session.getAttribute("currentUser");
        if(user!=null) {
            if (user.getRole().getName().equals("ADMIN")) {
                return "redirect:/adminDashboard";
            } else {
                return "redirect:/userDashboard";
            }
        }else {
            return "login";
        }
    }
    @GetMapping("/logout")
    public String logout(HttpSession session ) {
        session.invalidate();

        return "login";

    }


    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, HttpSession session,RedirectAttributes redirectAttributes,Model model) {
        Optional<User> optionalUser = userService.getUserByEmailAndPassword(email,password);
        System.out.println("111112"+optionalUser.toString());

        if ( optionalUser.isPresent()) {
            User user = optionalUser.get();
            System.out.println("Rasool"+user.toString());
            session.setAttribute("currentUser", user);
            model.addAttribute("user",user);
            if (user.getRole().getName().equals("ADMIN")) {
                return "redirect:/adminDashboard";
            } else {
                return "redirect:/userDashboard";
            }
        }

        redirectAttributes.addFlashAttribute("RMSG", "Please enter your login details again");

        return "redirect:/";
    }
    @GetMapping("/adminDashboard")
    public String showAdminDashboardView(Model model) {


        return "adminDashboard";
    }

    @GetMapping("/userDashboard")
    public String showUserDashboard(HttpSession session, Model model) {



        return "userDashboard";
    }

    @PostMapping("/createNewUser")
    public String createNewUser(User user , @RequestParam String roleName , Model model) {
        Optional<Role> r = roleService.getRoleByName(roleName);
        if(r!=null) {
            user.setRole(r.get());
            if( userService.createUser(user)== null) {

                model.addAttribute("MSG", "Failed to craete user");
            }else {
                model.addAttribute("MSG", "USER CREATED SUCCESSFULLY");

            }

        }else {
            model.addAttribute("MSG", "ROLE NOT FOUND");

        }
        return "home";

    }
    @PostMapping("/updateUser")
    public String updateUser(User user , Model model) {
        if( userService.updateUser(user.getId(),user)== null) {

            model.addAttribute("MSG", "FAILED TO UPDATE USER");
        }else {
            model.addAttribute("MSG", "USER  UPDATED SUCCESSFULLY");

        }


        return "home";

    }

    @GetMapping("/newUser")
    public String newUser(HttpSession session, Model model) {
        User user = (User) session.getAttribute("currentUser");

        if (user == null) {
            return "redirect:/";
        }

        model.addAttribute("user", user);

        return "createNewUser";
    }

    @GetMapping("/getUserList")
    public String getUserList(HttpSession session, Model model) {
        User user = (User) session.getAttribute("currentUser");

        if (user == null) {
            return "redirect:/";
        }

        model.addAttribute("user", user);
        model.addAttribute("users", userService.getAllUsers());
        return "userList";
    }



    @GetMapping("/editUserForm")
    public String editUserForm(@RequestParam int id , HttpSession session, Model model) {
        User user = (User) session.getAttribute("currentUser");

        if (user == null) {
            return "redirect:/";
        }

        model.addAttribute("user", user);
        User u = userService.getUserById(id);
        model.addAttribute("editUser", u);
        return "editUser";
    }

    @PostMapping("/removeUser")
    public String removeUser(@RequestParam int id , HttpSession session, Model model) {
        User user = (User) session.getAttribute("currentUser");

        if (user == null) {
            return "redirect:/";
        }

        model.addAttribute("user", user);
        try {
            userService.deleteUser(id);
            model.addAttribute("MSG", "USER REMOVED");
        }catch (Exception e) {

            model.addAttribute("MSG", "Unable To Remove User");
        }
        return "home";
    }

    @GetMapping("/removeUserForm")
    public String removeUserForm(@RequestParam int id , HttpSession session, Model model) {
        User user = (User) session.getAttribute("currentUser");
        System.out.println("hhhhh"+user.getName());
        if (user == null) {
            return "redirect:/";
        }

        model.addAttribute("user", user);
        User u = userService.getUserById(id);
        model.addAttribute("user", u);
        return "confirmRemoveUser";
    }
}