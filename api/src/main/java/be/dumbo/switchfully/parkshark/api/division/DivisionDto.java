package be.dumbo.switchfully.parkshark.api.division;

public class DivisionDto {

    private Integer id;
    private String name;
    private String originalName;
    private String director;
    private Integer parentDivision;

    private DivisionDto() {}

    public static DivisionDto divisionDto() {
        return new DivisionDto();
    }

    public DivisionDto withId(Integer id) {
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

    public DivisionDto withParentDivision(Integer parentDivision) {
        this.parentDivision = parentDivision;
        return this;
    }

    public Integer getId() {
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

    public Integer getParentDivision() {
        return parentDivision;
    }
}
