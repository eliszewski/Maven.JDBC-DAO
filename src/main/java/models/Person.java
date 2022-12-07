package models;

public class Person implements PersonInterface {
    private Integer id;
    private String lastName;
    private String firstName;
    private Integer age;
    private String job;

    public Person(String lastName, String firstName, Integer age, String job) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.job = job;
    }

    public Person(Integer id, String lastName, String firstName, Integer age, String job) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.job = job;
    }

    public Person() {
    }

    @Override
    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Integer getAge() {
        return age;
    }

    public String getJob() {
        return job;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
