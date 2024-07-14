package application.expensetracker.Service;

import application.expensetracker.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserHandlerService userRepoService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepoService.getUserByUsername(username);
        if(user!=null){
            UserDetails userDetail= org.springframework.security.core.userdetails.User.builder()
                    .username(user.getUserName())
                    .password(user.getPassWord())
                    .roles(user.getRole())
                    .build();
            return userDetail;
        }else{
            throw(new UsernameNotFoundException("This user not found"));
        }
    }
}
