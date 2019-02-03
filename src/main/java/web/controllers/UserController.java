package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.domain.Role;
import web.domain.User;
import web.service.UserService;

import java.util.Map;
//В КОНТРОЛЛЕРАХ НЕ ДОЛЖНО БЫТЬ ЛОГИКИ только получение - отсылка данных
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public String userList(Model model){
        model.addAttribute("users", userService.findAll());
        return "userlist";
    }

    @GetMapping("{user}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String userEditForm(@PathVariable User user, Model mode){
        mode.addAttribute("user",user);
        mode.addAttribute("roles", Role.values());
        return "userEdit";
    }
    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public String userSave(
            @RequestParam String username,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user
    ){
        userService.saveUser(user,username,form);
        return "redirect:/user";
    }

    @GetMapping("profile")
    public String getProfile(Model model, @AuthenticationPrincipal User user){
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email",user.getEmail());
        return "profile";
    }
    @PostMapping("profile")
    public String updateProfile(
            @AuthenticationPrincipal User user,
            @RequestParam String password,
            @RequestParam String email
    ){

        userService.updateProfile(user,password,email);
        return "redirect:/user/profile";
    }
    @GetMapping("subscribe/{user}")
    public String subscribe(
            @AuthenticationPrincipal User currentUser,
            @PathVariable User user)
    {
        userService.subscribe(currentUser,user);
        return "redirect:/user-messages/"+ user.getId();
    }
    @GetMapping("unsubscribe/{user}")
    public String unsubscribe(
            @AuthenticationPrincipal User currentUser,
            @PathVariable User user)
    {
        userService.unsubscribe(currentUser,user);
        return "redirect:/user-messages/"+ user.getId();
    }

    @GetMapping("{type}/{user}/list")
    public String userList(
            Model model,
            @PathVariable User user,
            @PathVariable String type
    ){
        model.addAttribute("userChannel",user);
        model.addAttribute("type",type);

        if ("subscriptions".equals(type)){
            model.addAttribute("users",user.getSubscriptions());
        }
        else {
            model.addAttribute("users",user.getSubscribers());
        }

        return "subscriptions";
    }
}
