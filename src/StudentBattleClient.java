import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class StudentBattleClient {
    private String host;
    private int port;

    public StudentBattleClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    // Метод для отправки объекта студента
    public void sendStudent(Student student) {
        try (Socket socket = new Socket(host, port);
             PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true)) {

            // Сериализация объекта студента в JSON
            String studentJson = JsonHelper.toJson(student);
            System.out.println("Отправка студента: " + studentJson);

            // Отправляем JSON на сервер
            out.println(studentJson);

        } catch (IOException e) {
            System.out.println("Ошибка при отправке студента: " + e.getMessage());
        }
    }
}