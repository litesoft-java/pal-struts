package org.superbiz.struts;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsersController {
    private final UserRepository mUserRepository;

    public UsersController(UserRepository pUserRepository) {
        mUserRepository = pUserRepository;
    }

    @GetMapping("/addUser")
    public String addUserGet() {
        return "addUserForm";
    }

    @PostMapping("/addUser")
    public String addUserPost(User pUser) {
        System.out.println("UsersController.addUserPost: " + pUser);
        mUserRepository.save(pUser);
        return "addedUser";
    }

    @GetMapping("/findUser")
    public String findUserForm() {
        return "findUserForm";
    }

    @PostMapping("/findUser")
    public String findUser(@RequestParam long id, Model model) {
        User user = mUserRepository.findOne(id);

        if (user == null) {
            model.addAttribute("errorMessage", "User not found");
            return "findUserForm";
        }

        model.addAttribute("user", user);
        return "displayUser";
    }

    @GetMapping("/list")
    public String listUsers(Model model) {
        model.addAttribute("users", mUserRepository.findAll());
        return "displayUsers";
    }
}