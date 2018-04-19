package be.dumbo.switchfully.parkshark.api.parkinglot.contactperson;

public class EmailDto {

    private String email;

    private EmailDto() {}

    public static EmailDto emailDto() {
        return new EmailDto();
    }

    public EmailDto withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getEmail() {
        return email;
    }
}
