package be.dumbo.switchfully.parkshark.api.licenseplate;

//copied and adpated code from order solution switchfully

import be.dumbo.switchfully.parkshark.domain.licenseplate.LicensePlate;
import be.dumbo.switchfully.parkshark.infrastructure.dto.Mapper;

import javax.inject.Named;

@Named
public class LicensePlateMapper extends Mapper<LicensePlateDto, LicensePlate>{
    @Override
    public LicensePlateDto toDto(LicensePlate licensePlate) {
        return LicensePlateDto.licensePlateDto()
                .withPlateNumber(licensePlate.getPlateNumber())
                .withIssuingCountry(licensePlate.getIssuingCountry());
    }

    @Override
    public LicensePlate toDomain(LicensePlateDto licensePlateDto) {
        return LicensePlate.LicensePlateBuilder.licensePlate()
                .withPlateNumber(licensePlateDto.getPlateNumber())
                .withIssuingCountry(licensePlateDto.getIssuingCountry())
                .build();
    }
}
