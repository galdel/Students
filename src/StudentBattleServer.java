import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class StudentBattleServer {
    private int port;

    public StudentBattleServer(int port) {
        this.port = port;
    }

    // Метод для запуска сервера и приема объекта студента
    public Student receiveStudent() {
        Student receivedStudent = null;
        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket clientSocket = serverSocket.accept();
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            System.out.println("Клиент подключился!");

            // Чтение JSON-строки студента от клиента
            String studentJson = in.readLine();
            System.out.println("Получен студент JSON: " + studentJson);

            // Десериализация студента
            receivedStudent = JsonHelper.fromJson(studentJson, Student.class);

        } catch (IOException e) {
            System.out.println("Ошибка при приеме студента: " + e.getMessage());
        }
        return receivedStudent;
    }
}