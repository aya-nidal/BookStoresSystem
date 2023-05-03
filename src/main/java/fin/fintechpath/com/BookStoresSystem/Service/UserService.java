package fin.fintechpath.com.BookStoresSystem.Service;

import fin.fintechpath.com.BookStoresSystem.model.User;
import fin.fintechpath.com.BookStoresSystem.model.UserPrincipal;
import fin.fintechpath.com.BookStoresSystem.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        UserPrincipal userPrinciple = new UserPrincipal(user);
        return userPrinciple;
    }


}
