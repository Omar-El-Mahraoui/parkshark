/*
package be.dumbo.switchfully.parkshark.api.parkinglot;

import be.dumbo.switchfully.parkshark.api.address.AddressMapper;
import be.dumbo.switchfully.parkshark.api.division.DivisionMapper;
import be.dumbo.switchfully.parkshark.api.parkinglot.contactperson.ContactPersonMapper;
import be.dumbo.switchfully.parkshark.domain.parkinglot.BuildingType;
import be.dumbo.switchfully.parkshark.domain.parkinglot.ParkingLot;
import be.dumbo.switchfully.parkshark.infrastructure.dto.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;
import java.math.BigDecimal;

@Named
public class ParkingLotMapper extends Mapper<ParkingLotDto, ParkingLot> {

    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private ContactPersonMapper contactPersonMapper;
    @Autowired
    private DivisionMapper divisionMapper;

    @Override
    public ParkingLotDto toDto(ParkingLot parkingLot) {
        return ParkingLotDto.parkingLotDto()
                .withId(parkingLot.getId())
                .withName(parkingLot.getName())
                .withAddress(addressMapper.toDto(parkingLot.getAddress()))
                .withBuildingType(parkingLot.getBuildingType().toString())
                .withCapacity(parkingLot.getCapacity())
                .withContactPerson(contactPersonMapper.toDto(parkingLot.getContactPerson()))
                .withDivision(divisionMapper.toDto(parkingLot.getDivision()));
    }

    @Override
    public ParkingLot toDomain(ParkingLotDto parkingLotDto) {
        return ParkingLot.ParkingLotBuilder.parkingLot()
                .withId(parkingLotDto.getId())
                .withName(parkingLotDto.getName())
                .withPricePerHourInEuro(BigDecimal.valueOf(
                        Double.parseDouble(parkingLotDto.getPricePerHourInEuro())))
                .withBuildingType(BuildingType.valueOf(parkingLotDto.getBuildingType()))
                .withAddress(addressMapper.toDomain(parkingLotDto.getAddress()))
                .withContactPerson(contactPersonMapper.toDomain(parkingLotDto.getContactPerson()))
                .withCapacity(parkingLotDto.getCapacity())
                .withDivision(divisionMapper.toDomain(parkingLotDto.getDivision()))
                .build();
    }
}
*/
