package pl.volanto.domain.contact;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.volanto.domain.user.UserDTO;

import java.util.List;

public interface ContactsRepository extends JpaRepository<Contact, Long> {

    List<Contact> findByUser(UserDTO userDTO);

}
