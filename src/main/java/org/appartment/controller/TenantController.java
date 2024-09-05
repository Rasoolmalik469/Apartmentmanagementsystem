package org.appartment.controller;

import org.appartment.model.Tenant;
import org.appartment.model.User;
import org.appartment.model.Visitor;
import org.appartment.service.TenantsService;
import org.appartment.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/** Rasool Malik Vempalli **/
@Controller
public class TenantController {

    @Autowired
    private TenantsService tenantService;

    @GetMapping("/getUserTenantList")
    public String getUserTenantList(HttpSession session, Model model) {
        User user = (User) session.getAttribute("currentUser");

        if (user == null) {
            return "redirect:/";
        }

        model.addAttribute("user", user);
        List<Tenant> tenant =  tenantService.getAllTenants();
        model.addAttribute("tenant",tenant);
        return "tenentListUser";
    }
}
