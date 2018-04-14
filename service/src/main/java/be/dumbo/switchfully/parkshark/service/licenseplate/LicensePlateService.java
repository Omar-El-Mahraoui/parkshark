package be.dumbo.switchfully.parkshark.service.licenseplate;

//copied from order solution switchfully

import be.dumbo.switchfully.parkshark.domain.licenseplate.LicensePlate;
import be.dumbo.switchfully.parkshark.repository.licenseplate.LicensePlateRepository;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class LicensePlateService {

    private LicensePlateRepository licensePlateRepository;
    private LicensePlateValidator licensePlateValidator;

    @Inject
    public LicensePlateService(LicensePlateRepository licensePlateRepository, LicensePlateValidator licensePlateValidator) {
        this.licensePlateRepository = licensePlateRepository;
        this.licensePlateValidator = licensePlateValidator;
    }


    public LicensePlate registerLicenseService(LicensePlate licensePlate) {
        if (!licensePlateValidator.isValidForCreation(licensePlate)) {
            licensePlateValidator.throwInvalidStateException(licensePlate, "registration");
        }
        return licensePlateRepository.save(licensePlate);
    }

}
