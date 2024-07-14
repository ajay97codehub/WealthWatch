package application.expensetracker.Service;

import application.expensetracker.Model.User;
import application.expensetracker.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserHandlerService {
    @Autowired
    private UserRepository userRepo;
    public User getUserById(long userId){
        return userRepo.getUserById(userId);
    }
    public List<User> getAllUsers(){
        return userRepo.findAllUser();
    }
    public User getUserByUsername(String userName){
        return userRepo.getUserByUserName(userName);
    }
    public User registerNewUser(User user){
        return userRepo.save(user);
    }
}
