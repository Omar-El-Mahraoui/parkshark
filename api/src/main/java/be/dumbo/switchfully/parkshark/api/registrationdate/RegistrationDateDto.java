package be.dumbo.switchfully.parkshark.api.registrationdate;

public class RegistrationDateDto {

    private String registrationDate;

    private RegistrationDateDto() {}

    public static RegistrationDateDto registrationDateDto() {
        return new RegistrationDateDto();
    }


}
