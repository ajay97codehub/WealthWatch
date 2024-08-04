package application.expensetracker.Repository;

import application.expensetracker.Model.Transaction;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query(nativeQuery = true, value="select * from transaction where user_id=:user_id")
    public List<Transaction> transactionList(@Param("user_id") long user_id);
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value="update transaction t set t.amount=:amount, t.type=:type, t.description=:description where transaction_id =:transaction_id")
    public int updateTransaction(@Param("transaction_id") long transaction_id,@Param("amount") double amount,@Param("type") String type,@Param("description") String description);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value="delete from transaction t where t.transaction_id =:transaction_id")
    public void deleteTransaction(@Param("transaction_id") long transaction_id);
}
