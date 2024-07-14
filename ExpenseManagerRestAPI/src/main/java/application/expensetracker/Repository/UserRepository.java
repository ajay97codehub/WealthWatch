package application.expensetracker.Repository;

import application.expensetracker.Model.ExpenseIncome;
import application.expensetracker.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(nativeQuery = true, value="select * from users where user_id=:user_id")
    public User getUserById(@Param("user_id") long user_id);
    @Query(nativeQuery = true, value="select * from users where email=:email_id")
    public User getUserByEmailId(@Param("email_id") String email_id);
    @Query(nativeQuery = true, value="select * from users where user_name=:user_name")
    public User getUserByUserName(@Param("user_name") String user_name);
    @Query(nativeQuery = true, value="select * from users")
    public List<User> findAllUser();
}
