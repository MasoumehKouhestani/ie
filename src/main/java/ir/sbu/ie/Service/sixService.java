package ir.sbu.ie.Service;

import ir.sbu.ie.Entity.CaseEntity;
import ir.sbu.ie.Entity.User;
import ir.sbu.ie.Repository.CaseRepository;
import ir.sbu.ie.Repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;


@Service
public class sixService{

    @Inject
    private CaseRepository caseRepository;


    public Object[] caseList() {

        List<Object> find= caseRepository.findquery();

        return find.toArray();
    }


}
