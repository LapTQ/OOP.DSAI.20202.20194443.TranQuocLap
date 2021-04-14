public class Test {
    public static void main(String[] args) {
        Person p = new Person();
        Person e = new Employee();
        Manager m = new Manager();
        Person[] group = {p, e, m};
        group[0].getDetails();
        group[1].getDetails();
        System.out.println(group[1].getClass());
    }
}
