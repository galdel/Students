
 public class Main {
    public static void main(String[] args) {
        // Создание массива студентов
        Student[] students = {
                new Student("Алексей", 20, 180, 75, 15),
                new Student("Дмитрий", 21, 175, 85, 20),
                new Student("Иван", 19, 165, 70, 10),
                new Student("Мария", 22, 160, 55, 12)
        };

        Student id1 = new Freshman("Мария", 22, 160, 55, 12);

        String studentJson = JsonHelper.toJson(id1);
        System.out.println("Студент в формате JSON: " + studentJson);

        Student deserializedStudent = JsonHelper.fromJson(studentJson, Student.class);
        System.out.println("Десериализованный студент: " + deserializedStudent.name);

        // Инициализация переменной для хранения индикатора конца игры
        boolean battleOver = false;

        // Цикл битвы
        int round = 1;
       /* while (!battleOver) {
            System.out.println("Раунд " + round);

            // Каждый студент атакует случайного противника
            for (int i = 0; i < students.length; i++) {
                if (students[i].isAlive()) {
                    // Находим случайного противника, который еще жив
                    int opponentIndex;
                    do {
                        opponentIndex = (int) (Math.random() * students.length);
                    } while (opponentIndex == i || !students[opponentIndex].isAlive());

                    // Атака противника
                    students[i].attack(students[opponentIndex]);
                }
            }

            // Проверка, остался ли только один живой студент
            int aliveCount = 0;
            for (Student student : students) {
                if (student.isAlive()) {
                    aliveCount++;
                }
            }

            // Если живым остался только один студент, битва окончена
            if (aliveCount <= 1) {
                battleOver = true;
                System.out.println("Битва окончена!");
            }

            // Переход к следующему раунду
            round++;
        }

        // Вывод результатов битвы
        System.out.println("Результаты битвы:");
        for (Student student : students) {
            System.out.println(student.name + " имеет " + student.health + " здоровья.");
        }
        */
    }
}