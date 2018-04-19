package be.dumbo.switchfully.parkshark.api.parkinglot;

// copied and adapted code from switchfully order solution jpa

import be.dumbo.switchfully.parkshark.service.parkinglot.ParkingLotService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/" + ParkingLotController.RESOURCE_NAME)
public class ParkingLotController {

    public static final String RESOURCE_NAME = "parkinglot";

    private ParkingLotService parkingLotService;
    private ParkingLotMapper parkingLotMapper;

    @Inject
    public ParkingLotController(ParkingLotService parkingLotService, ParkingLotMapper parkingLotMapper) {
        this.parkingLotService = parkingLotService;
        this.parkingLotMapper = parkingLotMapper;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<ParkingLotDto> getAllParkingLots() {
        return parkingLotService.getAllParkingLots().stream()
                .map(parkingLot -> parkingLotMapper.toDto(parkingLot))
                .collect(Collectors.toList());
    }
}
