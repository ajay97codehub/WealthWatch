package application.expensetracker.Model;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
public class LoginRequest {
    public String userName;
    public String passWord;
}
