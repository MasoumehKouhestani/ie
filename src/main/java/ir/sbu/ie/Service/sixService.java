package ir.sbu.ie.Service;

import ir.sbu.ie.Entity.CaseEntity;
import ir.sbu.ie.Entity.User;
import ir.sbu.ie.Repository.CaseRepository;
import ir.sbu.ie.Repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;


@Service
public class sixService {

    @Inject
    private CaseRepository caseRepository;
    @Inject
    private UserRepository userRepository;

    public Object[] caseList() {

        List<CaseEntity> find = caseRepository.findAll();

        return find.toArray();
    }


    public boolean ismanager(Object email) {
        User user=userRepository.findByEmail(email.toString());
        if (user.getPosition().equals("manager"))
            return true;
        return false;
    }

    public Object[] emcaseList(String email) {
        User user=userRepository.findByEmail(email);
        return caseRepository.findByReferTo(user.getName()).toArray();
    }
}
