package ir.sbu.ie.Repository;

import ir.sbu.ie.Entity.CaseEntity;
import ir.sbu.ie.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CaseRepository extends JpaRepository<CaseEntity,Integer> {

    @Query(value = "SELECT ID,CONDITION,DESCRIPTION,ENDDATE,FILE,ISMANAGER,SECTION,STARTDATE,TOPIC,TYPE  FROM CASES ", nativeQuery = true)
    List<Object> findquery();
}