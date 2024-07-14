package application.expensetracker.Model;

import lombok.Data;

@Data
public class LoginResponse {
    public String token;
    public String refreshedToken;
}
