package be.dumbo.switchfully.parkshark.domain.parkinglot.contactperson;

//copied and adapted code from order solution switchfully

import be.dumbo.switchfully.parkshark.infrastructure.builder.Builder;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TelephoneNumber {

    //https://stackoverflow.com/questions/4892925/how-can-i-map-insert-false-update-false-on-a-composite-id-key-property-whi
    @Column(name = "TELEPHONE_NUMBER", insertable = false, updatable = false)
    private String number;

    @Column(name = "COUNTRY_CALLING_CODE", insertable = false, updatable = false)
    private String countryCallingCode;

    private TelephoneNumber() {}

    private TelephoneNumber(TelephoneNumberBuilder mobilePhoneNumberBuilder) {
        this.number = mobilePhoneNumberBuilder.getNumber();
        this.countryCallingCode = mobilePhoneNumberBuilder.getCountryCallingCode();
    }

    public static class TelephoneNumberBuilder extends Builder<TelephoneNumber> {

        private String number;
        private String countryCallingCode;

        private TelephoneNumberBuilder() {}

        public static TelephoneNumberBuilder mobilePhoneNumber() {
            return new TelephoneNumberBuilder();
        }

        public TelephoneNumberBuilder withNumber(String number) {
            this.number = number;
            return this;
        }

        public TelephoneNumberBuilder withCountryCallingCode(String countryCallingCode) {
            this.countryCallingCode = countryCallingCode;
            return this;
        }

        private String getNumber() {
            return number;
        }

        private String getCountryCallingCode() {
            return countryCallingCode;
        }

        @Override
        public TelephoneNumber build() {
            return new TelephoneNumber(this);
        }
    }

}
