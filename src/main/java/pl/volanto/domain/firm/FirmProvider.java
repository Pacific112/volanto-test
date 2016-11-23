package pl.volanto.domain.firm;

import org.springframework.stereotype.Component;

@Component
public class FirmProvider {

    private final FirmRepository firmRepository;

    public FirmProvider(FirmRepository firmRepository) {
        this.firmRepository = firmRepository;
    }

    public Firm getCurrentFirm() {
        return firmRepository.findAll().iterator().next();
    }
}
