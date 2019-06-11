package ir.sbu.ie.Service;

import ir.sbu.ie.Entity.CaseEntity;
import ir.sbu.ie.Entity.User;
import ir.sbu.ie.Repository.CaseRepository;
import ir.sbu.ie.Repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class TenService {

    @Inject
    private CaseRepository caseRepository;
    @Inject
    private UserRepository userRepository;

    public Object[] reportList(String section, String type, String referTo) throws ParseException {

        User refertouser = userRepository.findByName(referTo);
//        Date start = new SimpleDateFormat("yyyy/mm/dd").parse(startdate);
        Date start = null, end = null;
//        Date end = new SimpleDateFormat("yyyy/mm/dd").parse(enddate);
        List<CaseEntity> find = caseRepository.findReport(section, type, refertouser);
        return find.toArray();
    }


}
