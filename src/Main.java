import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    // Метод для создания локальных студентов
    public static ArrayList<Student> createLocalStudents() {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Freshman("Иван", 18, 175, 70, 10));
        students.add(new Freshman("Мария", 19, 165, 55, 8));
        students.add(new Senior("Алексей", 22, 180, 80, 15));
        students.add(new Senior("Дмитрий", 23, 185, 90, 18));
        students.add(new Student("Николай", 21, 178, 75, 12));
        students.add(new Student("Ольга", 20, 170, 60, 11));
        students.add(new Freshman("Петр", 18, 172, 68, 9));
        students.add(new Senior("Сергей", 22, 180, 82, 16));
        students.add(new Student("Анна", 21, 160, 54, 10));
        students.add(new Freshman("Елена", 19, 168, 58, 7));
        return students;
    }

    // Метод для проведения битвы
    public static Student conductBattle(ArrayList<Student> students, BattleLogger logger) {
        Random random = new Random();
        boolean battleOver = false;
        int round = 1;

        // Битва продолжается, пока не останется один студент
        while (!battleOver) {
            logger.log("Раунд " + round + " начинается!");

            for (Student attacker : students) {
                if (attacker.isAlive()) {
                    Student opponent;
                    do {
                        opponent = students.get(random.nextInt(students.size()));
                    } while (attacker == opponent || !opponent.isAlive());

                    attacker.attack(opponent);
                    logger.log(attacker.name + " атакует " + opponent.name + ". Здоровье " + opponent.name + ": " + opponent.health);
                }
            }

            // Проверка количества живых студентов
            long aliveCount = students.stream().filter(Student::isAlive).count();
            if (aliveCount <= 1) {
                battleOver = true;
                logger.log("Битва окончена!");
            }

            round++;
        }

        // Возвращаем победителя
        return students.stream().filter(Student::isAlive).findFirst().get();
    }

    public static void main(String[] args) {
        // Логгер для записи процесса битвы
        BattleLogger logger = new BattleLogger("battle_log.txt");
        logger.clearLog();

        // 1. Запускаем сервер для приёма студента
        StudentBattleServer server = new StudentBattleServer(12345);
        Student receivedStudent = server.receiveStudent();

        // 2. Создаем локальных студентов и добавляем принятого студента
        ArrayList<Student> students = createLocalStudents();
        students.add(receivedStudent);

        // 3. Проводим битву и определяем победителя
        Student winner = conductBattle(students, logger);

        // 4. Работа с базой данных PostgreSQL
        String url = "jdbc:postgresql://localhost:5432/mydatabase";
        String user = "myuser";
        String password = "mypassword";

        try (DatabaseHelper dbHelper = new DatabaseHelper(url, user, password)) {
            dbHelper.createTable();
            dbHelper.saveBattleResult(winner.name, winner.health);
        } catch (SQLException e) {
            System.out.println("Ошибка работы с базой данных: " + e.getMessage());
        }

        // 5. Отправляем победителя обратно через клиент
        StudentBattleClient client = new StudentBattleClient("localhost", 12346);
        client.sendStudent(winner);

    }
}