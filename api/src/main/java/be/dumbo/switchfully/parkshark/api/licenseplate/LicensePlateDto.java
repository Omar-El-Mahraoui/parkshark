package be.dumbo.switchfully.parkshark.api.licenseplate;

//copied and adpated code from order solution switchfully

public class LicensePlateDto {

    private String plateNumber;
    private String issuingCountry;

    private LicensePlateDto() {}

    public static LicensePlateDto licensePlateDto() {
        return new LicensePlateDto();
    }

    public LicensePlateDto withPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
        return this;
    }

    public LicensePlateDto withIssuingCountry(String issuingCountry) {
        this.issuingCountry = issuingCountry;
        return this;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public String getIssuingCountry() {
        return issuingCountry;
    }
}
