package com.example.thyme.controller;

import com.example.thyme.domain.User;
import com.example.thyme.domain.Address;

        //com.coderscampus.ChatApplication.domain.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class UserController {

    @GetMapping("/user-form")
    public String showForm(Model model) {

        System.out.println("********************************************");

        User user = new User();
        user.setAddress(new Address()); // Initialize Address within User
        user.setPassword("firstP");

        System.out.println("Password before html:" + user.getPassword());

        model.addAttribute("user", user);
        return "userForm";
    }

    
    @PostMapping("/submit-user")
    public String submitUser(@ModelAttribute User user) {
        System.out.println("Username: " + user.getUsername());
        System.out.println("Password: " + user.getPassword());
        System.out.println("Email: " + user.getEmail());

        Address address = user.getAddress();
        if (address != null) {
            System.out.println("Street: " + address.getStreet());
            System.out.println("City: " + address.getCity());
            System.out.println("Postal Code: " + address.getPostalCode());
        }

        return "result"; // Redirect to a success page or another view
    }
}
