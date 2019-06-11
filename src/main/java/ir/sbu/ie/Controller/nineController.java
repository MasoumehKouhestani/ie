package ir.sbu.ie.Controller;

import ir.sbu.ie.Entity.User;
import ir.sbu.ie.Service.nineService;
import ir.sbu.ie.Service.userconfirmdService;
import ir.sbu.ie.Service.profilesetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.LinkedList;
import java.util.List;

@RestController
public class nineController {
    @Inject
    private nineService nineService;

    @GetMapping("/listofuser")
    @Produces(MediaType.APPLICATION_JSON)
    public Object[] userList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return nineService.userList();
    }

    @PostMapping("/deactive")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String unconfrimed(@RequestBody String username, HttpServletRequest request, HttpServletResponse response) {
        username = username.substring(0, username.length() - 1);
        return nineService.deactive(username);
    }

    @PostMapping("/managerprofileset")
    @Consumes("application/x-www-form-urlencoded")
    public void signup(@FormParam("old") String old, @FormParam("name") String name, @FormParam("username") String username, @FormParam("email") String email, @FormParam("password") String password, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean valid = nineService.profileset(old, name, username, email, password);
        if (valid == true) {

            response.sendRedirect("w2.html");

        } else
            response.sendRedirect("w1.html");
    }
}
