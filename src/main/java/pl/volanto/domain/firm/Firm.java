package pl.volanto.domain.firm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Firm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firmName;

    public Firm() {
    }

    public Firm(String firmName) {
        this.firmName = firmName;
    }

    public String getFirmName() {
        return firmName;
    }
}