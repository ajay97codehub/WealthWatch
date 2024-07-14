package application.expensetracker.RestController;

import application.expensetracker.Model.ExpenseIncome;
import application.expensetracker.Service.ExpenseIncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenseIncome")
@CrossOrigin(origins = "http://localhost:4200/")
public class ExpenseIncomeController {
    @Autowired
    private ExpenseIncomeService expenseIncomeService;
    @PostMapping("/addAmount")
    public List<ExpenseIncome> addAmount(@RequestBody ExpenseIncome expenseIncome){
        var savedData = expenseIncomeService.addExpenseIncome(expenseIncome);
        return expenseIncomeService.requestBalance(savedData.getUser().getUserId());
    }
    @GetMapping("/requestBalance/{userId}")
    public List<ExpenseIncome> addAmount(@PathVariable("userId") long userId){
        return expenseIncomeService.requestBalance(userId);
    }
    @PutMapping ("/updateBalance")
    public List<ExpenseIncome> modifyBalance(@RequestBody ExpenseIncome expenseIncome){
        return expenseIncomeService.modifyExpenseIncome(expenseIncome);
    }
    @DeleteMapping  ("/deleteBalance")
    public List<ExpenseIncome> deleteBalance(@RequestBody ExpenseIncome expenseIncome){
        return expenseIncomeService.deleteExpenseIncome(expenseIncome);
    }
}
