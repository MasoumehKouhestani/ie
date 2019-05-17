package ir.sbu.ie.Controller;

import ir.sbu.ie.Entity.User;
import ir.sbu.ie.Service.LoginService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.Context;
import java.io.IOException;

@RestController
@RequestMapping("/login")
public class LoginController {


    @Inject
    public LoginService loginService;

    @Context
    public HttpServletRequest request;
    @Context
    public HttpServletResponse response;

    @GetMapping("/userlogin")
    @Consumes("application/x-www-form-urlencoded")
    public boolean login(@FormParam("email") String email, @FormParam("password") String password) throws ServletException, IOException {
        User user = new User();
        user.setPassword(password);
        user.setEmail(email);
        boolean result = loginService.userLogin(user);

//        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/orginal.jsp");
//        dispatcher.forward(request, response);

        return result;
    }

}
