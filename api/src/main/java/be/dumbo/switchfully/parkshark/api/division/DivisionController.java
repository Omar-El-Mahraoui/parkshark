package be.dumbo.switchfully.parkshark.api.division;
// copied and adapted code from order solution switchfully

import be.dumbo.switchfully.parkshark.api.member.MemberController;
import be.dumbo.switchfully.parkshark.service.division.DivisionService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequestMapping(path = "/" + MemberController.RESOURCE_NAME)
public class DivisionController {

    public static final String RESOURCE_NAME = "division";

    private DivisionService divisionService;
    private DivisionMapper divisionMapper;

    @Inject
    public DivisionController(DivisionService divisionService, DivisionMapper divisionMapper) {
        this.divisionService = divisionService;
        this.divisionMapper = divisionMapper;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public DivisionDto createDivision(@RequestBody DivisionDto divisionDto) {
        return divisionMapper.toDto(
                divisionService.createDivision(
                        divisionMapper.toDomain(divisionDto)));
    }
}
