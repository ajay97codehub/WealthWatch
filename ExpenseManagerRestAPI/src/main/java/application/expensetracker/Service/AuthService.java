package application.expensetracker.Service;

import application.expensetracker.Model.User;
import application.expensetracker.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepo;
    public User registerNewUser(User user){
        return userRepo.save(user);
    }
    public User loginUser(User user){
        return user;
    }
    public User logoutUser(User user){
        return user;
    }
    public User getUserByEmail(User user){
        return userRepo.getUserByEmailId(user.getEmail());
    }
}
