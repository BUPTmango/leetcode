package entity;

/**
 * 学生类
 *
 * @author Wang Guolong
 * @create 2019-03-28 2:06 PM
 */
public class Student {
    public Student(String id, String name, String school, Integer weight) {
        this.id = id;
        this.name = name;
        this.school = school;
        this.weight = weight;
    }
    private String id;
    private String name;
    private String school;
    private Integer weight;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", school='" + school + '\'' +
                ", weight=" + weight +
                '}';
    }

    public String introduction () {
        return "My name is " + name + ", I come from " + school + ". Thank you!!";
    }
}