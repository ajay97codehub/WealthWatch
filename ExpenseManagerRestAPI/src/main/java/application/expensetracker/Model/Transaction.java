package application.expensetracker.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="Transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long transactionId;
    public long userId;
    public double amount;
    public String type;
    public String description;
}
