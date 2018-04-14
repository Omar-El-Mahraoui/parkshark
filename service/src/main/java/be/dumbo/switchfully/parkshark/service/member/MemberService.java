package be.dumbo.switchfully.parkshark.service.member;

import be.dumbo.switchfully.parkshark.domain.member.Member;
import be.dumbo.switchfully.parkshark.repository.member.MemberRepository;

import javax.inject.Inject;
import javax.inject.Named;
//copied from order solution switchfully

@Named
public class MemberService {

    private MemberRepository memberRepository;
    private MemberValidator memberValidator;

    @Inject
    public MemberService(MemberRepository memberRepository, MemberValidator memberValidator) {

        this.memberRepository = memberRepository;
        this.memberValidator = memberValidator;
    }

    public Member registerMember(Member member) {
        if (!memberValidator.isValidForCreation(member)) {
            memberValidator.throwInvalidStateException(member, "registration");
        }
        return memberRepository.save(member);
    }

}
