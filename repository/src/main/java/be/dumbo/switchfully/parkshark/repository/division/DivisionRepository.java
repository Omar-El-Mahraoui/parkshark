package be.dumbo.switchfully.parkshark.repository.division;

import be.dumbo.switchfully.parkshark.domain.division.Division;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
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
