package application.expensetracker.Service;

import application.expensetracker.Model.Transaction;
import application.expensetracker.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    public Transaction addTransaction(Transaction transaction){
        return transactionRepository.save(transaction);
    }
    public List<Transaction> updateTransaction(Transaction transaction){
        long userId=transaction.getUserId();
        int a = transactionRepository.updateTransaction(transaction.transactionId,transaction.amount,transaction.type,transaction.description);
        return transactionRepository.transactionList(userId);
    }
    public List<Transaction> deleteTransaction(Transaction transaction){
        long userId=transaction.getUserId();
        transactionRepository.deleteTransaction(transaction.transactionId);
        return transactionRepository.transactionList(userId);
    }

    public List<Transaction> getTransactions(long userId){
        return transactionRepository.transactionList(userId);
    }

}
