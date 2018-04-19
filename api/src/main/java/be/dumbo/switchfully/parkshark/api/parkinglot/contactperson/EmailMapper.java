package be.dumbo.switchfully.parkshark.api.parkinglot.contactperson;

//copied from order solution jpa switchfully

import be.dumbo.switchfully.parkshark.domain.parkinglot.contactperson.Email;
import be.dumbo.switchfully.parkshark.infrastructure.dto.Mapper;

import javax.inject.Named;

@Named
public class EmailMapper extends Mapper<EmailDto,Email>{
    @Override
    public EmailDto toDto(Email email) {
        return EmailDto.emailDto()
                .withLocalPart(email.getLocalPart())
                .withDomain(email.getDomain())
                .withComplete(email.getComplete());
    }

    @Override
    public Email toDomain(EmailDto emailDto) {
        return Email.EmailBuilder.email()
                .withLocalPart(emailDto.getLocalPart())
                .withDomain(emailDto.getDomain())
                .withComplete(emailDto.getComplete())
                .build();
    }
}
