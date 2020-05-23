package com.nbp.afrp.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    
    	
    @GetMapping("/user")
    public List<User> listUser() {
    	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	
        return userService.findAll();
    }

    @PostMapping("/user")
    public User create(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable Long id) {
        userService.delete(id);
        return "success";
    }

}