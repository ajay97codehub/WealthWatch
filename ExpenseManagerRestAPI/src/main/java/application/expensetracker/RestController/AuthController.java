package application.expensetracker.RestController;

import application.expensetracker.Model.LoginRequest;
import application.expensetracker.Model.LoginResponse;
import application.expensetracker.Model.Role;
import application.expensetracker.Model.User;
import application.expensetracker.Service.AuthService;
import application.expensetracker.Service.UserHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200/")
public class AuthController {
    @Autowired
    private UserHandlerService authService;
    @Autowired
    private PasswordEncoder passWordEncoder;
    @PostMapping("/registerUser")
    public User registerNewUser(@RequestBody User user){
        if(user.getRole()==null){
            user.setRole(Role.normalUser.toString());
        }
        var userFound=authService.getUserByUsername(user.getUserName());
        if(userFound==null){
            user.setPassWord(passWordEncoder.encode(user.getPassWord()));
            return authService.registerNewUser(user);
        }
        else return userFound;
    }
}
