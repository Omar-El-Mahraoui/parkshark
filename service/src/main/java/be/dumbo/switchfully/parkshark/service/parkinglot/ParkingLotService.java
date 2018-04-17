package be.dumbo.switchfully.parkshark.service.parkinglot;

import be.dumbo.switchfully.parkshark.domain.parkinglot.ParkingLot;
import be.dumbo.switchfully.parkshark.domain.parkinglot.ParkingLotRepository;
import org.springframework.validation.annotation.Validated;

import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.List;

// validate javax validation beans: https://docs.jboss.org/hibernate/validator/4.1/reference/en-US/html/validator-customconstraints.html#validator-customconstraints-using

@Named
@Validated
@Transactional
public class ParkingLotService {

    private ParkingLotRepository parkingLotRepository;

    @Named
    public ParkingLotService(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    public List<ParkingLot> getAllParkingLots() {
        return parkingLotRepository.getAll();
    }

    public ParkingLot createParkingLot(ParkingLot parkingLot) {
        return parkingLotRepository.save(parkingLot);
    }
}
