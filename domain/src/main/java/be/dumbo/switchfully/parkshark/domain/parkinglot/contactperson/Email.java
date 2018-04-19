package be.dumbo.switchfully.parkshark.domain.parkinglot.contactperson;

//copied and adapted code from switchfully order solution

import be.dumbo.switchfully.parkshark.infrastructure.builder.Builder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

@Embeddable
public class Email {
    //https://stackoverflow.com/questions/4662582/make-hibernate-ignore-class-variables-that-are-not-mapped
    @Transient
    private String localPart;
    @Transient
    private String domain;

    @Column(name = "EMAIL")
    private String complete;

    private Email() {}

    private Email(EmailBuilder emailBuilder) {
        this.localPart = emailBuilder.localPart;
        this.domain = emailBuilder.domain;
        this.complete = String.format("%s@%s", getLocalPart(), getDomain());;
    }

    public String getLocalPart() {
        return localPart;
    }

    public String getDomain() {
        return domain;
    }

    public String getComplete() {
        return complete;
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

    public static class EmailBuilder extends Builder<Email> {

        private String localPart;
        private String domain;
        private String complete;

        private EmailBuilder() {}

        public static EmailBuilder email() {
            return new EmailBuilder();
        }

        @Override
        public Email build() {
            return new Email(this);
        }

        public EmailBuilder withLocalPart(String localPart) {
            this.localPart = localPart;
            return this;
        }

        public EmailBuilder withDomain(String domain) {
            this.domain = domain;
            return this;
        }

        public EmailBuilder withComplete(String complete) {
            this.complete = complete;
            return this;
        }
    }

}
