package be.dumbo.switchfully.parkshark.api.division;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

public class DivisionDto {

    private String id;
    private String name;
    private String originalName;
    private String director;
    private String parentDivision;

    private DivisionDto() {}

    public static DivisionDto divisionDto() {
        return new DivisionDto();
    }

    public DivisionDto withId(String id) {
        this.id = id;
        return this;
    }

    public DivisionDto withName(String name) {
        this.name = name;
        return this;
    }

    public DivisionDto withOriginalName(String originalName) {
        this.originalName = originalName;
        return this;
    }

    public DivisionDto withDirector(String director) {
        this.director = director;
        return this;
    }

    public DivisionDto withParentDivision(String parentDivision) {
        this.parentDivision = parentDivision;
        return this;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOriginalName() {
        return originalName;
    }

    public String getDirector() {
        return director;
    }

    public String getParentDivision() {
        return parentDivision;
    }

    //copied from provided example codelab02 switchfully orm codelabs
    @Override
    public boolean equals(Object other){
        return EqualsBuilder.reflectionEquals(this, other);
    }

    @Override
    public int hashCode(){
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, SHORT_PREFIX_STYLE);
    }
}
