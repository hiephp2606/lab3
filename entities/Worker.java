package entities;

public class Worker {
    private int id;
    private String name;
    private int age;
    private int salary;
    private String workPlace;

    public Worker(int id, String name, int age, int salary, String workPlace) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.workPlace = workPlace;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    @Override
    public String toString() {
        return "W " +
                 id +
                "       " + name +
                "       " + age +
                "       " + salary +
                "       " + workPlace +
                "\n"
                ;
    }
}
