package ir.sbu.ie.Controller;

import ir.sbu.ie.Entity.User;
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
public class userconfrimController {
    @Inject
    private userconfirmdService userconfirmdService;

    @GetMapping("/listunconfrimed")
    @Produces(MediaType.APPLICATION_JSON)
    public Object[] unconfirmedlist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return userconfirmdService.unconfirmdlist();
    }
    @PostMapping("/confrimed")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces (MediaType.TEXT_PLAIN)
    public String confrimed( String email, HttpServletRequest request, HttpServletResponse response){
        return  userconfirmdService.confrimed(email);
    }
    @PostMapping("/unconfrimed")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces (MediaType.TEXT_PLAIN)
    public String unconfrimed(String email,HttpServletRequest request, HttpServletResponse response){
        return userconfirmdService.unconfirmd(email);
    }

}