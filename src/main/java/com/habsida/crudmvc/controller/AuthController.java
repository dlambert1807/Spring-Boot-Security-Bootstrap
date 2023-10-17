package com.habsida.crudmvc.controller;

import com.habsida.crudmvc.entity.Role;
import com.habsida.crudmvc.entity.User;
import com.habsida.crudmvc.service.RoleService;
import com.habsida.crudmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        return "redirect:/login";
    }

    @GetMapping("/user")
    public String user(Principal principal, ModelMap model) {
        model.addAttribute("currentUser", userService.findByEmail(principal.getName()));
        return "user_index";
    }

    @GetMapping("/admin")
    public String admin(Principal principal, ModelMap model) {
        User currentUser = userService.findByEmail(principal.getName());
        Collection<Role> roles = currentUser.getRoles();
        StringBuilder currentRoles = new StringBuilder();
        for (Role role : roles) {
            currentRoles.append("[").append(role.getAuthority()).append("]");
        }
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("currentRoles", currentRoles.toString());
        List<User> users = userService.listUsers();
        model.addAttribute("users", users);
        model.addAttribute("user", new User());
        model.addAttribute("allRoles", roleService.listRoles());
        model.addAttribute("roles", new ArrayList<Role>());
        return "admin_index";
    }

    @PostMapping("/admin/newuser")
    public String createUser(@ModelAttribute("user") User user, @ModelAttribute("roles") ArrayList<Role> roles) {
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @PutMapping("/admin/edit/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable(name = "id") Long id) {
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/admin/delete/{id}")
    public String deleteUser(@ModelAttribute("user") User deleteUser, ModelMap model) {
        userService.deleteById(deleteUser.getId());
        return "redirect:/admin";
    }
}
