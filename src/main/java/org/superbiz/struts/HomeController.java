package org.superbiz.struts;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

//            <a href="addUserForm.action">Add User</a>
//        <a href="findUserForm.action">Find User</a>
//        <a href="listAllUsers.action">List all users</a>
}