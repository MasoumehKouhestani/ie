package ir.sbu.ie.Service;

import ir.sbu.ie.Entity.CaseEntity;
import ir.sbu.ie.Entity.User;
import ir.sbu.ie.Repository.CaseRepository;
import ir.sbu.ie.Repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class CaseService {
    @Inject
    private CaseRepository caseRepository;
    @Inject
    private UserRepository userRepository;

    public boolean saveCase(String referto, CaseEntity newCaseEntity, String senderEmail) {
        User resultUser;
        resultUser = userRepository.findByName(referto);
        User sender = userRepository.findByEmail(senderEmail);
        if (resultUser != null && sender != null && !sender.getPosition().equals("student")) {
            newCaseEntity.setSender(sender);
            newCaseEntity.setReferTo(resultUser);
            caseRepository.save(newCaseEntity);
            return true;
        }
        return false;
    }
}
