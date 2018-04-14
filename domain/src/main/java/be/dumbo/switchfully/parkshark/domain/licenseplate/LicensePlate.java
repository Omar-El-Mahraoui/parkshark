package be.dumbo.switchfully.parkshark.domain.licenseplate;

import javax.persistence.*;

@Entity
@Table(name="LICENSEPLATES")
public class LicensePlate {

    @Id
    @Column(name="ID")
    @SequenceGenerator(name="licenseplates_seq", sequenceName = "LICENSEPLATES_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "licenseplates_seq")
    private int id;
    @Column(name="PLATE_NUMBER")
    private String plateNumber;
    @Column(name="ISSUING_COUNTRY")
    private String issuingCountry;

    private LicensePlate() {}

    private LicensePlate(LicensePlateBuilder licensePlateBuilder) {
        this.plateNumber = licensePlateBuilder.getPlateNumber();
        this.issuingCountry = licensePlateBuilder.getIssuingCountry();
    }

    public int getId() {
        return id;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public String getIssuingCountry() {
        return issuingCountry;
    }

    public static class LicensePlateBuilder {

        private String plateNumber;
        private String issuingCountry;

        private LicensePlateBuilder() {}

        public static LicensePlateBuilder licensePlate() {
            return new LicensePlateBuilder();
        }

        public LicensePlate build() {
            return new LicensePlate(this);
        }

        public LicensePlateBuilder withPlateNumber(String plateNumber) {
            this.plateNumber = plateNumber;
            return this;
        }

        public LicensePlateBuilder withIssuingCountry(String issuingCountry) {
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
}
