package application.expensetracker.Service;

import application.expensetracker.Model.ExpenseIncome;
import application.expensetracker.Model.User;
import application.expensetracker.Repository.ExpenseIncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseIncomeService {
    @Autowired
    private ExpenseIncomeRepository expenseIncomeRepository;
    public ExpenseIncome addExpenseIncome(ExpenseIncome expenseIncome){
        return expenseIncomeRepository.save(expenseIncome);
    }
    public List<ExpenseIncome> modifyExpenseIncome(ExpenseIncome expenseIncome){
        long userId=expenseIncome.getUser().getUserId();
        int a = expenseIncomeRepository.modifyExpenseIncome(expenseIncome.expenseIncomeId,expenseIncome.amount,expenseIncome.category,expenseIncome.purpose);
        return expenseIncomeRepository.expenseIncomeList(userId);
    }
    public List<ExpenseIncome> deleteExpenseIncome(ExpenseIncome expenseIncome){
        long userId=expenseIncome.getUser().getUserId();
        expenseIncomeRepository.deleteExpenseIncome(expenseIncome.expenseIncomeId);
        return expenseIncomeRepository.expenseIncomeList(userId);
    }

    public List<ExpenseIncome> requestBalance(long userId){
        return expenseIncomeRepository.expenseIncomeList(userId);
    }

}
