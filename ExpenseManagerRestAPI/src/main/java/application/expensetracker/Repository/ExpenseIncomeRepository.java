package application.expensetracker.Repository;

import application.expensetracker.Model.ExpenseIncome;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseIncomeRepository extends JpaRepository<ExpenseIncome, Long> {
    @Query(nativeQuery = true, value="select * from expense_income where user_id=:user_id")
    public List<ExpenseIncome> expenseIncomeList(@Param("user_id") long user_id);
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value="update expense_income ei set ei.amount=:amount, ei.category=:category, ei.purpose=:purpose where expense_income_id =:expense_income_id")
    public int modifyExpenseIncome(@Param("expense_income_id") long expense_income_id,@Param("amount") double amount,@Param("category") String category,@Param("purpose") String purpose);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value="delete from expense_income ei where ei.expense_income_id =:expense_income_id")
    public void deleteExpenseIncome(@Param("expense_income_id") long expense_income_id);
}
