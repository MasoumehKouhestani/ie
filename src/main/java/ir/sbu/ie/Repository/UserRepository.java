package ir.sbu.ie.Repository;

import ir.sbu.ie.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository  extends JpaRepository<User,Integer>{
    @Query
    public User findByEmail(String email);
    @Query
    public User findByName(String name);
}
