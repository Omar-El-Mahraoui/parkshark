/*
package be.dumbo.switchfully.parkshark.domain.parkinglot.contactperson;

import be.dumbo.switchfully.parkshark.domain.parkinglot.contactperson.Email.EmailBuilder;
import be.dumbo.switchfully.parkshark.infrastructure.builder.Builder;

public class EmailTestBuilder extends Builder<Email>{

    private EmailBuilder emailBuilder;

    private EmailTestBuilder() {}

    private EmailTestBuilder(EmailBuilder emailBuilder) {
        this.emailBuilder = emailBuilder;
    }

    public static EmailTestBuilder anEmptyEmail() {
        return new EmailTestBuilder(EmailBuilder.email());
    }

    public static EmailTestBuilder anEmail() {
        return new EmailTestBuilder(EmailBuilder.email()
                    .withLocalPart("emailExampleLocalPart")
                    .withDomain("emailExampleDomain"));
    }

    @Override
    public Email build() {
        return emailBuilder.build();
    }

    public EmailTestBuilder withLocalPart(String localPart) {
        emailBuilder.withLocalPart(localPart);
        return this;
    }

    public EmailTestBuilder withDomain(String domain) {
        emailBuilder.withDomain(domain);
        return this;
    }
}
*/
