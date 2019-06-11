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
public class eightService {

    @Inject
    private CaseRepository caseRepository;

    @Inject
    private UserRepository userRepository;

    public void setrezayat(int id, boolean b) {
        CaseEntity c = caseRepository.findById(id);
        c.setRezayat(b);
        caseRepository.save(c);
    }

    public Object[] caseList(String email) {
        User user=userRepository.findByEmail(email);
        List<CaseEntity> find=caseRepository.findByReferTo(user.getName());
        return find.toArray();
    }
}