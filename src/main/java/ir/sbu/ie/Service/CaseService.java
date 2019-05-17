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

    public boolean saveCase(String referto, CaseEntity newCaseEntity) {
        User resultUser;
        resultUser = userRepository.findByName(referto);
        if(resultUser != null) {
            newCaseEntity.setReferTo(referto);
            caseRepository.save(newCaseEntity);
            return true;
        }
        return false;
    }
}
