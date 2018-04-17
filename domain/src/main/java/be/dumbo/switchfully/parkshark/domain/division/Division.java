package be.dumbo.switchfully.parkshark.domain.division;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

@Entity
@Table(name="DIVISIONS")
public class Division {

    @Id
    @Column(name="ID")
    @SequenceGenerator(name="division_seq", sequenceName = "DIVISIONS_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "division_seq")
    private Integer id;

    @Column(name="NAME")
    @NotNull(message = "Name cannot be null.")
    private String name;

    @Column(name="ORIGINALNAME")
    @NotNull(message = "Original name cannot be null.")
    private String originalName;

    @Column(name="DIRECTOR")
    @NotNull(message = "Director cannot be null.")
    private String director;

    //http://www.baeldung.com/spring-mvc-custom-validator
    @Column(name="PARENTDIVISION")
    @ParentDivisionConstraint(message = "Invalid parent division id.")
    private Integer parentDivision;

    private Division() {
    }

    private Division(DivisionBuilder divisionBuilder) {
        this.id = divisionBuilder.getId();
        this.name = divisionBuilder.getName();
        this.originalName = divisionBuilder.getOriginalName();
        this.director = divisionBuilder.getDirector();
        this.parentDivision = divisionBuilder.getParentDivision();
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

    public Integer getParentDivision() {
        return parentDivision;
    }

    public Integer getId() {
        return id;
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

    public static class DivisionBuilder {

        private Integer id;
        private String name;
        private String originalName;
        private String director;
        private Integer parentDivision;

        private DivisionBuilder() {}

        public static DivisionBuilder division() {
            return new DivisionBuilder();
        }

        public Division build() {
            return new Division(this);
        }

        public DivisionBuilder withId(Integer id) {
            this.id = id;
            return this;
        }

        public DivisionBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public DivisionBuilder withOriginalName(String originalName) {
            this.originalName = originalName;
            return this;
        }

        public DivisionBuilder withDirector(String director) {
            this.director = director;
            return this;
        }

        public DivisionBuilder withParentDivision(Integer parentDivision) {
            this.parentDivision = parentDivision;
            return this;
        }

        private Integer getId() {
            return id;
        }

        private String getName() {
            return name;
        }

        private String getOriginalName() {
            return originalName;
        }

        private String getDirector() {
            return director;
        }

        private Integer getParentDivision() {
            return parentDivision;
        }
    }
}
