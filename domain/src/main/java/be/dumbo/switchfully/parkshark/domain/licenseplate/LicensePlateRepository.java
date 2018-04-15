package be.dumbo.switchfully.parkshark.domain.licenseplate;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class LicensePlateRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public LicensePlate save(LicensePlate licensePlate) {
        entityManager.persist(licensePlate);
        return licensePlate;
    }

}
