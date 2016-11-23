package pl.volanto.config;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.volanto.domain.firm.Firm;
import pl.volanto.domain.firm.FirmRepository;
import pl.volanto.domain.user.UserDTO;
import pl.volanto.domain.user.UserDtoBuilder;
import pl.volanto.domain.user.UserRepository;

import javax.annotation.PostConstruct;

@Component
@Profile(VolantoProfiles.DEVELOP)
public class InitalDataProvider {

    private final FirmRepository firmRepository;
    private final UserRepository userRepository;

    public InitalDataProvider(FirmRepository firmRepository, UserRepository userRepository) {
        this.firmRepository = firmRepository;
        this.userRepository = userRepository;
    }

    @PostConstruct
    private void provideMockData() {
        Firm firm = firmRepository.save(new Firm("example firm"));
        UserDTO user = new UserDtoBuilder()
                .withEmail("admin@admin.pl")
                .withPassword("password")
                .withAdmin(true)
                .withFirstName("admin")
                .withLastName("admin")
                .withFirm(firm)
                .build();

        userRepository.save(user);
    }
}
