package pl.volanto.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import pl.volanto.domain.user.UserDTO;
import pl.volanto.domain.user.UserRepository;

import java.util.Collections;
import java.util.Optional;

@Component
public class CrmUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CrmUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<UserDTO> foundUser = userRepository.findByEmail(email);

        return foundUser.map(this::mapUser)
                .orElseThrow(() -> new UsernameNotFoundException(""));
    }

    private User mapUser(UserDTO user) {
        boolean admin = user.isAdmin();

        if(admin) {
            return new User(user.getEmail(), user.getPassword(), Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN")));
        }
        return new User(user.getEmail(), user.getPassword(), Collections.emptyList());
    }
}