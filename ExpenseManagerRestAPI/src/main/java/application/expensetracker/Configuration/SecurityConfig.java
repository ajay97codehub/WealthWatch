package application.expensetracker.Configuration;

import application.expensetracker.Model.User;
import application.expensetracker.Repository.UserRepository;
import application.expensetracker.Service.CustomUserDetailsService;
import application.expensetracker.Service.UserHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

@Configuration
//@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private UserHandlerService userService;
/*
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf((csrf) -> csrf.disable()).authorizeHttpRequests(authorizeHttpRequests->authorizeHttpRequests.anyRequest().authenticated()).httpBasic(Customizer.withDefaults());
    return http.build();
    }*/
    @Bean
    PasswordEncoder passwordEncoder (){
        return new BCryptPasswordEncoder();
    }
    // In below dynamic user authentication was not happening
    /*@Bean
    UserDetailsService userDetailsService(){
        List<User> users = userService.getAllUsers();
        ArrayList<UserDetails> userDeatilsList = new ArrayList<UserDetails>();
        for(User user :users){
            UserDetails userDetail= org.springframework.security.core.userdetails.User.builder()
                    .username(user.getUserName())
                    .password(passwordEncoder().encode(user.getPassWord()))
                    .roles(user.getRole())
                    .build();
            userDeatilsList.add(userDetail);
        }
        return new InMemoryUserDetailsManager(userDeatilsList);
    }*/
    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authConfiguration) throws Exception {
        return authConfiguration.getAuthenticationManager();
    }
}
