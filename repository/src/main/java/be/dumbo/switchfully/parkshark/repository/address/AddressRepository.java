package be.dumbo.switchfully.parkshark.repository.address;

import be.dumbo.switchfully.parkshark.domain.address.Address;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class AddressRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Address save(Address address) {
        entityManager.persist(address);
        return address;
    }

}
