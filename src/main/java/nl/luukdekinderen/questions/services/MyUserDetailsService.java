package nl.luukdekinderen.questions.services;

import nl.luukdekinderen.questions.models.MyUserDetails;
import nl.luukdekinderen.questions.models.User;
import nl.luukdekinderen.questions.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Optional<User> user = userRepository.findByUserName(s);

        user.orElseThrow(() -> new UsernameNotFoundException("Username not found: " + s));

        return user.map(MyUserDetails::new).get();
    }
}
