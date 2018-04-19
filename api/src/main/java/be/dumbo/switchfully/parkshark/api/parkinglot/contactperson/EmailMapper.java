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
                .withEmail(email.getComplete());
    }

    @Override
    public Email toDomain(EmailDto dtoObject) {
        return null;
    }
}
