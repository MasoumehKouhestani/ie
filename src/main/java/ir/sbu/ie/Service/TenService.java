package ir.sbu.ie.Service;

import ir.sbu.ie.Entity.CaseEntity;
import ir.sbu.ie.Repository.CaseRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class TenService {

    @Inject
    private CaseRepository caseRepository;

    public Object[] reportList(String section, String type, String referTo, String startdate, String enddate) {

        List<CaseEntity> find = caseRepository.findReport(section, type, referTo, startdate, enddate);

        return find.toArray();
    }


}
