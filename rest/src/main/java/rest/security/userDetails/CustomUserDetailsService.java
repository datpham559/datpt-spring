package rest.security.userDetails;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import rest.entity.PTUser;
import rest.repository.PTUserRepository;

import java.util.Optional;
@Component
public class CustomUserDetailsService implements UserDetailsService {
    private final PTUserRepository ptUserRepository;

    public CustomUserDetailsService(PTUserRepository ptUserRepository) {
        this.ptUserRepository = ptUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<PTUser> user = ptUserRepository.findByUsername(username);
        if (user.isPresent()){
            return new CustomUserDetails(user.get());
        }
        throw new UsernameNotFoundException(username);
    }
}
