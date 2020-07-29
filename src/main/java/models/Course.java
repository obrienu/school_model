package models;

public class Course {
    private String code;
    private int creditLoad;
    private String title;
    private String description;

    public Course(){}
    public Course(String code, int creditLoad, String title, String description) {
        this.code = code;
        this.creditLoad = creditLoad;
        this.title = title;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getCreditLoad() {
        return creditLoad;
    }

    public void setCreditLoad(int creditLoad) {
        this.creditLoad = creditLoad;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCourseSummary() {
        return "Course code: " + getCode() + ", Title: " + getTitle() + ", Credit load: " + getCreditLoad();
    }

    @Override
    public String toString() {
        return "Course{" +
                "code='" + code + '\'' +
                ", creditLoad=" + creditLoad +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
