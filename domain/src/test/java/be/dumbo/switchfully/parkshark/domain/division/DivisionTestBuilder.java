package be.dumbo.switchfully.parkshark.domain.division;

//copied code from order solution switchfully

import be.dumbo.switchfully.parkshark.domain.division.Division.DivisionBuilder;
import be.dumbo.switchfully.parkshark.infrastructure.builder.Builder;

import static be.dumbo.switchfully.parkshark.domain.division.Division.DivisionBuilder.division;

public class DivisionTestBuilder extends Builder<Division> {

    private DivisionBuilder divisionBuilder;

    private DivisionTestBuilder() {}

    private DivisionTestBuilder(DivisionBuilder divisionBuilder) {
        this.divisionBuilder = divisionBuilder;
    }

    public static DivisionTestBuilder anEmptyDivision() {
        return new DivisionTestBuilder(division());
    }

    public static DivisionTestBuilder aDivision() {
        return new DivisionTestBuilder(division()
                .withName("division1")
                .withOriginalName("original-name-1")
                .withDirector("director1"));
    }

    @Override
    public Division build() {
        return divisionBuilder.build();
    }

    public DivisionTestBuilder withName(String name) {
        divisionBuilder.withName(name);
        return this;
    }

    public DivisionTestBuilder withOriginalName(String originalName) {
        divisionBuilder.withOriginalName(originalName);
        return this;
    }

    public DivisionTestBuilder withDirector(String director) {
        divisionBuilder.withDirector(director);
        return this;
    }

    public DivisionTestBuilder withParentDivision(String parentDivision) {
        divisionBuilder.withParentDivision(parentDivision);
        return this;
    }
}
