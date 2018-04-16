package be.dumbo.switchfully.parkshark.domain.parkinglot.contactperson;

//copied code from order solution switchfully

import be.dumbo.switchfully.parkshark.domain.parkinglot.contactperson.TelephoneNumber.TelephoneNumberBuilder;
import be.dumbo.switchfully.parkshark.infrastructure.builder.Builder;

import static be.dumbo.switchfully.parkshark.domain.parkinglot.contactperson.TelephoneNumber.TelephoneNumberBuilder.telephoneNumber;

public class TelephoneNumberTestBuilder extends Builder<TelephoneNumber> {

    private TelephoneNumberBuilder telephoneNumberBuilder;

    private TelephoneNumberTestBuilder() {}

    private TelephoneNumberTestBuilder(TelephoneNumberBuilder telephoneNumberBuilder) {
        this.telephoneNumberBuilder = telephoneNumberBuilder;
    }

    public static TelephoneNumberTestBuilder anEmptyTelephoneNumber() {
        return new TelephoneNumberTestBuilder(telephoneNumber());
    }

    public static TelephoneNumberTestBuilder aTelephoneNumber() {
        return new TelephoneNumberTestBuilder(telephoneNumber()
                        .withNumber("0123456789")
                        .withCountryCallingCode("00000"));
    }

    @Override
    public TelephoneNumber build() {
        return telephoneNumberBuilder.build();
    }

    public TelephoneNumberTestBuilder withNumber(String number) {
        telephoneNumberBuilder.withNumber(number);
        return this;
    }

    public TelephoneNumberTestBuilder withCountryCallingCode(String countryCallingCode) {
        telephoneNumberBuilder.withCountryCallingCode(countryCallingCode);
        return this;
    }
}