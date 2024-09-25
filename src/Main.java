public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Alexey", 20, 180, 75, 15);
        Student student2 = new Student("Dmitry", 21, 175, 85, 20);
        Student student3 = new Student("Ivan", 19, 165, 70, 10);

        System.out.println("Battle begins!");

        student1.attack(student2);
        student2.attack(student1);
        student3.attack(student2);
        student1.attack(student2);
        student2.attack(student1);
        student3.attack(student2);
        student1.attack(student2);
        student2.attack(student1);
        student3.attack(student2);

        student1.getStats();
        student2.getStats();
        student3.getStats();

    }
}
