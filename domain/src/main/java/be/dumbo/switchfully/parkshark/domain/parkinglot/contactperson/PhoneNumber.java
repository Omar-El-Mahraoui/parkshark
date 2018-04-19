/*
package be.dumbo.switchfully.parkshark.domain.parkinglot.contactperson;

//copied and adapted code from order solution switchfully

import be.dumbo.switchfully.parkshark.infrastructure.builder.Builder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

@Entity
@Table(name = "PHONE_NUMBERS")
public class PhoneNumber {

    @Id
    @Column(name = "PHONE_NUMBERS_ID")
    private String id;

    @Column(name = "PHONE_NUMBERS_TELEPHONE_NUMBER")
    private String telephoneNumber;

    @Column(name = "PHONE_NUMBERS_MOBILE_PHONE_NUMBER")
    private String mobilePhoneNumber;

    private PhoneNumber() {}

    private PhoneNumber(PhoneNumberBuilder phoneNumberBuilder) {
        this.telephoneNumber = phoneNumberBuilder.telephoneNumber;
        this.mobilePhoneNumber = phoneNumberBuilder.mobilePhoneNumber;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    //copied from provided example codelab02 switchfully orm codelabs
    @Override
    public boolean equals(Object other){
        return EqualsBuilder.reflectionEquals(this, other);
    }

    @Override
    public int hashCode(){
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, SHORT_PREFIX_STYLE);
    }

    public static class PhoneNumberBuilder extends Builder<PhoneNumber> {

        private String telephoneNumber;
        private String mobilePhoneNumber;

        private PhoneNumberBuilder() {}

        public static PhoneNumberBuilder phoneNumber() {
            return new PhoneNumberBuilder();
        }

        public PhoneNumberBuilder withTelephoneNumber(String telephoneNumber) {
            this.telephoneNumber = telephoneNumber;
            return this;
        }

        public PhoneNumberBuilder withMobilePhoneNumber(String mobilePhoneNumber) {
            this.mobilePhoneNumber = mobilePhoneNumber;
            return this;
        }

        @Override
        public PhoneNumber build() {
            return new PhoneNumber(this);
        }
    }

}
*/
