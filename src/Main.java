import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {


        Student maria = new Freshman("Мария", 22, 160, 55, 12);

        String studentJson = JsonHelper.toJson(maria);
        System.out.println("Студент в формате JSON: " + studentJson);

        Student deserializedStudent = JsonHelper.fromJson(studentJson, Student.class);
        System.out.println("Десериализованный студент: " + deserializedStudent.name);

        //Сервер
        int port = 12345; // Порт, на котором сервер будет слушать соединения

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен и ждет соединений...");

            while (true) {
                // Принимаем клиентское соединение
                Socket clientSocket = serverSocket.accept();
                System.out.println("Клиент подключился!");

                // Получаем данные от клиента
                try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    // Чтение JSON-строки
                    String json = in.readLine();
                    System.out.println("Получен JSON: " + json);

                    // Десериализация JSON в объект Student
                    Student student = JsonHelper.fromJson(json, Student.class);
                    System.out.println("Получен студент: " + student.name + ", возраст: " + student.age);

                    // Ответ клиенту
                    out.println("Студент " + student.name + " успешно получен!");

                    // Дополнительные действия: например, добавить студента в битву
                } catch (IOException e) {
                    System.out.println("Ошибка чтения данных от клиента: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка запуска сервера: " + e.getMessage());
        }

        //Клиент
        /*
        String host = "localhost"; // Адрес сервера
        int port = 12345; // Порт сервера

        // Создаем объект студента
        Student student = new Freshman("Иван", 18, 175, 70, 10);

        try (Socket socket = new Socket(host, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            // Сериализация объекта студента в JSON
            String studentJson = JsonHelper.toJson(student);
            System.out.println("Отправка JSON: " + studentJson);

            // Отправляем JSON на сервер
            out.println(studentJson);

            // Чтение ответа от сервера
            String response = in.readLine();
            System.out.println("Ответ от сервера: " + response);

        } catch (IOException e) {
            System.out.println("Ошибка при соединении с сервером: " + e.getMessage());
        }
    } */



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