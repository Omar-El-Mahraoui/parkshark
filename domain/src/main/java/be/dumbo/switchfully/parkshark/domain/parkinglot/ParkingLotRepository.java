/*
package be.dumbo.switchfully.parkshark.domain.parkinglot;

//copied and adapted code from order solution switchfully

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Named
public class ParkingLotRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public ParkingLot save(ParkingLot parkingLot) {
        */
/*//*
/https://stackoverflow.com/questions/12338463/how-to-handle-bean-validation-exceptions
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<ParkingLot>> constraintViolations = validator.validate(parkingLot);

        if (constraintViolations.size() > 0) {
            Set<String> violationMessages = new HashSet<>();

            for (ConstraintViolation<ParkingLot> constraintViolation : constraintViolations) {
                violationMessages.add(constraintViolation.getPropertyPath() + ": " + constraintViolation.getMessage());
            }
            throw new InvalidDataAccessApiUsageException("Parking lot is not valid:\n" + StringUtils.join(violationMessages, "\n"));
        }*//*

        entityManager.persist(parkingLot);
        return parkingLot;
    }

    public void deleteAll() {
        entityManager.createQuery("delete from ParkingLot p").executeUpdate();
    }

    public List<ParkingLot> getAll() {
        return entityManager.createQuery("from ParkingLot", ParkingLot.class).getResultList();
    }
}
*/
