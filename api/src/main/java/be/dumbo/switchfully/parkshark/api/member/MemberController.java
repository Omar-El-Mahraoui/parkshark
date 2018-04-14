package be.dumbo.switchfully.parkshark.api.member;
// copied and adapted code from order solution switchfully
import be.dumbo.switchfully.parkshark.service.member.MemberService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequestMapping(path = "/" + MemberController.RESOURCE_NAME)
public class MemberController {

    public static final String RESOURCE_NAME = "member";

    private MemberMapper memberMapper;
    private MemberService memberService;

    @Inject
    public MemberController() {
        this.memberService = memberService;
        this.memberMapper = memberMapper;
    }

}
