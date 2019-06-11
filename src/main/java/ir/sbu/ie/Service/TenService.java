package ir.sbu.ie.Service;

import ir.sbu.ie.Entity.CaseEntity;
import ir.sbu.ie.Entity.User;
import ir.sbu.ie.Repository.CaseRepository;
import ir.sbu.ie.Repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class TenService {

    @Inject
    private CaseRepository caseRepository;
    @Inject
    private UserRepository userRepository;

    public Object[] reportList(String section, String type, String referTo, String startdate, String enddate) {

        User refertouser = userRepository.findByName(referTo);
        List<CaseEntity> find = caseRepository.findReport(section, type, refertouser, startdate, enddate);
        return find.toArray();
    }


}
