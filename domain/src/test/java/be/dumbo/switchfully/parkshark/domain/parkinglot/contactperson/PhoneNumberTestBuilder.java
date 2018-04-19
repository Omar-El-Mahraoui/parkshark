/*
package be.dumbo.switchfully.parkshark.domain.parkinglot.contactperson;

//copied code from order solution switchfully

import be.dumbo.switchfully.parkshark.domain.parkinglot.contactperson.PhoneNumber.PhoneNumberBuilder;
import be.dumbo.switchfully.parkshark.infrastructure.builder.Builder;

import static be.dumbo.switchfully.parkshark.domain.parkinglot.contactperson.PhoneNumber.PhoneNumberBuilder.phoneNumber;

public class PhoneNumberTestBuilder extends Builder<PhoneNumber> {

    private PhoneNumberBuilder phoneNumberBuilder;

    private PhoneNumberTestBuilder() {}

    private PhoneNumberTestBuilder(PhoneNumberBuilder phoneNumberBuilder) {
        this.phoneNumberBuilder = phoneNumberBuilder;
    }

    public static PhoneNumberTestBuilder anEmptyPhoneNumber() {
        return new PhoneNumberTestBuilder(phoneNumber());
    }

    public static PhoneNumberTestBuilder aPhoneNumber() {
        return new PhoneNumberTestBuilder(phoneNumber()
                        .withTelephoneNumber("0123456789")
                        .withMobilePhoneNumber("00000"));
    }

    @Override
    public PhoneNumber build() {
        return phoneNumberBuilder.build();
    }

    public PhoneNumberTestBuilder withTelephoneNumber(String telephoneNumber) {
        phoneNumberBuilder.withTelephoneNumber(telephoneNumber);
        return this;
    }

    public PhoneNumberTestBuilder withMobilePhoneNumber(String mobilePhoneNumber) {
        phoneNumberBuilder.withMobilePhoneNumber(mobilePhoneNumber);
        return this;
    }
}
*/
