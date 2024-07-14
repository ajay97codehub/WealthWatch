package application.expensetracker.RestController;
import application.expensetracker.Model.User;
import application.expensetracker.Service.AuthService;
import application.expensetracker.Service.UserHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200/")
public class UserController{
    @Autowired
    private UserHandlerService userService;


    @GetMapping("/users/{username}")
    public User getUserDeatils(@PathVariable("username") String username){
        return userService.getUserByUsername(username);
    }
    @GetMapping("/users/")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
}