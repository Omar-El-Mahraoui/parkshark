package be.dumbo.switchfully.parkshark.service.member;

import be.dumbo.switchfully.parkshark.domain.member.Member;

import javax.inject.Named;

//copied from order solution switchfully

@Named
public class MemberValidator {

    private boolean isARequiredFieldEmptyOrNull(Member member) {
        return isNull(member) || isEmptyOrNull(member.getName());
    }

    private boolean isNull(Member member) {
        return member == null;
    }

    private boolean isEmptyOrNull(String attribute) {
        return attribute == null || attribute.isEmpty();
    }

    public boolean isValidForCreation(Member member) {
        return !isARequiredFieldEmptyOrNull(member) && member.getId() == 0;
    }

    public void throwInvalidStateException(Member member, String type) {
        throw new IllegalStateException("Invalid " + (member == null ? "NULL_ENTITY" : member.getClass().getSimpleName())
                + " provided for " + type + ". Provided object: " + (member == null ? null : member.toString()));
    }

}
