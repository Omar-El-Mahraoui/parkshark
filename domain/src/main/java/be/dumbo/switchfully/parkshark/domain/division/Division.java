package be.dumbo.switchfully.parkshark.domain.division;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

@Entity
@Table(name="DIVISIONS")
public class Division {

    /*@Id
    @Column(name="DIVISION_ID")
    @SequenceGenerator(name="division_seq", sequenceName = "DIVISIONS_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "division_seq")
    private Integer id;*/

    @Id
    @Column(name="DIVISIONS_ID")
    private String id;

    // https://stackoverflow.com/questions/3126769/uniqueconstraint-annotation-in-java
    @Column(name="DIVISIONS_NAME", unique = true)
    @NotNull(message = "Name cannot be null.")
    @NotBlank(message = "Name must be filled in.")
    private String name;

    @Column(name="DIVISIONS_ORIGINAL_NAME")
    @NotNull(message = "Original name cannot be null.")
    @NotBlank(message = "Original name must be filled in.")
    private String originalName;

    @Column(name="DIVISIONS_DIRECTOR")
    @NotNull(message = "Director cannot be null.")
    @NotBlank(message = "Director must be filled in.")
    private String director;

    //http://www.baeldung.com/spring-mvc-custom-validator
    @Column(name="DIVISIONS_PARENT_DIVISION_ID")
    private String parentDivisionId;

    private Division() {
    }

    private Division(DivisionBuilder divisionBuilder) {
        this.id = divisionBuilder.id;
        this.name = divisionBuilder.name;
        this.originalName = divisionBuilder.originalName;
        this.director = divisionBuilder.director;
        this.parentDivisionId = divisionBuilder.parentDivisionId;
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

    public String getParentDivisionId() {
        return parentDivisionId;
    }

    public String getId() {
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

        private String id;
        private String name;
        private String originalName;
        private String director;
        private String parentDivisionId;

        private DivisionBuilder() {}

        public static DivisionBuilder division() {
            return new DivisionBuilder()
                        .withId(UUID.randomUUID().toString());
        }

        public Division build() {
            return new Division(this);
        }

        private DivisionBuilder withId(String id) {
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

        public DivisionBuilder withParentDivisionId(String parentDivisionId) {
            this.parentDivisionId = parentDivisionId;
            return this;
        }
    }
}
