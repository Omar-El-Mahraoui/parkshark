package be.dumbo.switchfully.parkshark.domain.division;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Named
public class DivisionRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Division save(Division division) {
        entityManager.persist(division);
        return division;
    }

    public List<Division> getAll() {
        return entityManager.createQuery("from Division", Division.class).getResultList();
    }

    public void deleteAll() {
        entityManager.createQuery("delete from Division d").executeUpdate();
    }
}
