package application.expensetracker.RestController;

import application.expensetracker.Model.Transaction;
import application.expensetracker.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200/")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;
    @PostMapping("/addTransaction")
    public List<Transaction> addTransaction(@RequestBody Transaction transaction){
        var savedData = transactionService.addTransaction(transaction);
        return transactionService.getTransactions(savedData.getUserId());
    }
    @GetMapping("/getTransaction/{userId}")
    public List<Transaction> getTransactions(@PathVariable("userId") long userId){
        return transactionService.getTransactions(userId);
    }
    @PutMapping ("/updateTransaction/{transactionId}")
    public List<Transaction> updateTransaction(@RequestBody Transaction transaction){
        return transactionService.updateTransaction(transaction);
    }
    @DeleteMapping  ("/deleteTransaction/{transactionId}")
    public List<Transaction> deleteTransaction(@RequestBody Transaction transaction){
        return transactionService.deleteTransaction(transaction);
    }
}
