package be.dumbo.switchfully.parkshark.api.parkinglot;

// copied and adapted code from switchfully order solution jpa

import be.dumbo.switchfully.parkshark.domain.parkinglot.ParkingLotRepository;
import be.dumbo.switchfully.parkshark.service.parkinglot.ParkingLotService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/" + ParkingLot.RESOURCE_NAME)
public class ParkingLot {

    public static final String RESOURCE_NAME = "parkinglot";

    private ParkingLotService parkingLotService;
    private ParkingLotRepository parkingLotRepository;

    @Inject
    public ParkingLot(ParkingLotService parkingLotService, ParkingLotRepository parkingLotRepository) {
        this.parkingLotService = parkingLotService;
        this.parkingLotRepository = parkingLotRepository;
    }

    public List<ParkingLotDto> getAllParkingLots() {
        return parkingLotService.getAllParkingLots().stream()
                .map(parkingLot -> parkingLotMapper.toDto(parkingLot))
                .collect(Collectors.toList());
    }
}
