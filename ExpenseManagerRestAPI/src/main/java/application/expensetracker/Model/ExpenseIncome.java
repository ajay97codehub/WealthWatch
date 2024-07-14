package application.expensetracker.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="ExpenseIncome")
public class ExpenseIncome {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long expenseIncomeId;
    @ManyToOne
    @JoinColumn(name = "user_Id")
    public User user;
    public double amount;
    public String category;
    public String purpose;
}
