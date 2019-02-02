package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.domain.Role;
import web.domain.User;
import web.repositories.UserRepo;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {

    @Autowired
    private UserRepo userRepo2;

    @GetMapping
    public String userList(Model model){
        model.addAttribute("users", userRepo.findAll());
        return "userlist";
    }

    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model mode){
        mode.addAttribute("user",user);
        mode.addAttribute("roles", Role.values());
        return "userEdit";
    }
    @PostMapping
    public String userSave(
            @RequestParam String username,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user
    ){
        user.setUsername(username);
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        user.getRoles().clear();

        for (String s : form.keySet()) {
            if (roles.contains(s)){
                user.getRoles().add(Role.valueOf(s));
            }
        }


        userRepo.save(user);

        return "redirect:/user";
    }
}
