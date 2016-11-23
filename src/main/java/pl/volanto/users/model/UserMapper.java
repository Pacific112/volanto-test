package pl.volanto.users.model;

import org.springframework.stereotype.Component;
import pl.volanto.domain.user.UserDTO;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public List<UserRest> mapToRest(List<UserDTO> userDTOs) {
        return userDTOs.stream()
                .map(this::mapToRest)
                .collect(Collectors.toList());
    }

    public UserRest mapToRest(UserDTO userDTO) {
        return new UserRest(userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getEmail(),
                userDTO.getPhoneNumber(),
                userDTO.getPicturePath());
    }


}
