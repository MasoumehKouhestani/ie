package ir.sbu.ie.Service;

import ir.sbu.ie.Entity.CaseEntity;
import ir.sbu.ie.Entity.User;
import ir.sbu.ie.Entity.comment;
import ir.sbu.ie.Repository.CaseRepository;
import ir.sbu.ie.Repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class SevenService {

    @Inject
    private CaseRepository caseRepository;

    @Inject
    private UserRepository userRepository;

    public CaseEntity getcase(int id) {

        return caseRepository.findById(id);
    }

    public boolean changerrefer(int id, String email, String name, String des) {
        CaseEntity c=caseRepository.findById(id);
        User refer=userRepository.findByName(name);
        User send=userRepository.findByEmail(email);
        if(refer !=null){
            List<comment> comment = c.getComments();
            comment x = new comment();
            x.setDes(des);
            x.setName(send.getName());
            comment.add(x);
            c.setComments(comment);
            c.setReferTOuser(refer);
            if(!refer.getPosition().equals("manager"))
                c.setIsmanager(false);
            caseRepository.save(c);
            return true;
        }
        return false;

    }

    public void changestate(int id, String email, String des, String state) {
        CaseEntity c=caseRepository.findById(id);
        User send=userRepository.findByEmail(email);
        List<comment> comment = c.getComments();
        comment x = new comment();
        x.setDes(des);
        x.setName(send.getName());
        comment.add(x);
        c.setComments(comment);
        c.setCondition(state);
        caseRepository.save(c);
    }
}
