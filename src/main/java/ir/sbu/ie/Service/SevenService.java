package ir.sbu.ie.Service;

import ir.sbu.ie.Repository.CaseRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class SevenService {

    @Inject
    private CaseRepository caseRepository;

}
