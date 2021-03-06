package pl.volanto.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserDTO, Long> {

    Optional<UserDTO> findByEmail(String email);

}
