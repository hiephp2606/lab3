package entities;

public class Worker {
    private String name;
    private int id;
    private static int autoId;
    private int age;
    private int salary;
    private String workPlace;

    public Worker(String name, int age, int salary, String workPlace) {
        this.name = name;
        this.id = ++autoId;
        this.age = age;
        this.salary = salary;
        this.workPlace = workPlace;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getAutoId() {
        return autoId;
    }

    public static void setAutoId(int autoId) {
        Worker.autoId = autoId;
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
        return "Worker{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", workPlace='" + workPlace + '\'' +
                ", id=" + id +
                '}';
    }
}
