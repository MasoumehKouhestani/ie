package ir.sbu.ie.Controller;

import ir.sbu.ie.Entity.CaseEntity;
import ir.sbu.ie.Service.CaseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@Controller
public class CaseController {
    @Inject
    public CaseService caseService;

    @PostMapping("/caseSend")
    @Consumes("application/x-www-form-urlencoded")
    public String caseSend (@FormParam("section") String section, @FormParam("type") String type,
                            @FormParam("referto") String referto, @FormParam("topic") String topic,
                            @FormParam("description") String description, @FormParam("file") File file, HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String senderemail= (String) request.getSession().getAttribute("email");
        CaseEntity newCaseEntity = new CaseEntity();
        newCaseEntity.setCondition("open");
        newCaseEntity.setDescription(description);
        newCaseEntity.setFile(file);
        newCaseEntity.setSection(section);
        newCaseEntity.setTopic(topic);
        newCaseEntity.setType(type);
        Date date = new Date();
        newCaseEntity.setStartdate(date);

        boolean result = caseService.saveCase(referto, newCaseEntity,senderemail);
        if (result){
            return "redirect:/fiveForStudent.html";
        }
        return "redirect:/worngreferTo.html";
    }
}
