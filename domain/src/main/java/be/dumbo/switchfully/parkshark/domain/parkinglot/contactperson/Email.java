package be.dumbo.switchfully.parkshark.domain.parkinglot.contactperson;

//copied and adapted code from switchfully order solution

import be.dumbo.switchfully.parkshark.infrastructure.builder.Builder;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Email {

    private String localPart;
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

    public static class EmailBuilder extends Builder<Email> {

        private String localPart;
        private String domain;

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
    }

}
