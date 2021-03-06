package ir.sbu.ie.Service;

import ir.sbu.ie.Entity.CaseEntity;
import ir.sbu.ie.Entity.User;
import ir.sbu.ie.Repository.CaseRepository;
import ir.sbu.ie.Repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class CaseService {
    @Inject
    private CaseRepository caseRepository;
    @Inject
    private UserRepository userRepository;

    public boolean saveCase(String referto, CaseEntity newCaseEntity, String senderEmail) {
        User refertouser= userRepository.findByName(referto);
        User sender = userRepository.findByEmail(senderEmail);
        if (refertouser != null && sender != null && !refertouser.getPosition().equals("student")) {
            newCaseEntity.setSenderuser(sender);
            newCaseEntity.setReferTOuser(refertouser);



          caseRepository.save(newCaseEntity);

            return true;
        }
        return false;
    }
}
