package ir.sbu.ie.Controller;

import ir.sbu.ie.Entity.User;
import ir.sbu.ie.Service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Inject
    public LoginService loginService;

    @PostMapping("/userlogin")
    @Consumes("application/x-www-form-urlencoded")
    @Produces("text/html")
    public String login(@FormParam("email") String email, @FormParam("password") String password){
        User user = new User();
        user.setPassword(password);
        user.setEmail(email);

//        HttpSession session = request.getSession();

        boolean result = loginService.userLogin(user);
        if (result)
            return "redirect:/orginal.html";
        return "redirect:/worgPassOrEmail.html";
    }

}
