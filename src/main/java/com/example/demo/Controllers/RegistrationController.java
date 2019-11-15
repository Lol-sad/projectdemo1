package com.example.demo.Controllers;

import com.example.demo.Dtos.UserDto;
import com.example.demo.Entities.User;
import com.example.demo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {
    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserDto userDto() {
        return new UserDto();
    }

    @GetMapping
    public String getRegistrationPage(){
        return "cow";
    }
    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid UserDto accountDto, BindingResult result){
        User user = userService.findByEmail(accountDto.getEmail());
        if(user != null){
            result.rejectValue("Email", null, "Email is taken");
        }
        user = userService.findByUsername(accountDto.getUsername());
        if(user != null){
            result.rejectValue("username", null, "Username is taken");
        }
        System.out.println(1111111);
        userService.registerUser(accountDto);
        return "home";
    }
}
