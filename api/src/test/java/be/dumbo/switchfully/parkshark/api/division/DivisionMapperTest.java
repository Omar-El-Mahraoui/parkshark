package be.dumbo.switchfully.parkshark.api.division;

import be.dumbo.switchfully.parkshark.domain.division.Division;
import be.dumbo.switchfully.parkshark.infrastructure.IntegrationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static be.dumbo.switchfully.parkshark.domain.division.DivisionTestBuilder.aDivision;
import static org.assertj.core.api.Assertions.assertThat;

//copied and adapted code from funiversity exercise solution switchfully

public class DivisionMapperTest extends IntegrationTest {

    @Autowired
    private DivisionMapper divisionMapper;

    @Test
    public void toDto() {
        //GIVEN
        Division division = aDivision().build();

        //WHEN
        DivisionDto divisionDto = divisionMapper.toDto(division);

        //THEN
        assertThat(divisionDto)
                .isEqualToComparingFieldByField(division);
    }

    @Test
    public void toDomain() {
        //GIVEN
        DivisionDto divisionDto = DivisionDto.divisionDto()
                                    .withName("division1")
                                    .withOriginalName("originalName1")
                                    .withDirector("director1");

        //WHEN
        Division division = divisionMapper.toDomain(divisionDto);

        //THEN
        assertThat(division).isEqualToComparingFieldByField(divisionDto);
    }

}