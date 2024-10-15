import java.io.FileWriter;
import java.io.IOException;

public class BattleLogger {

    private String filePath;

    public BattleLogger(String filePath) {
        this.filePath = filePath;
    }

    // Метод для записи строки в лог-файл
    public void log(String message) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(message + "\n");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в лог: " + e.getMessage());
        }
    }

    // Метод для очистки файла перед новой записью
    public void clearLog() {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(""); // Пустая строка для очистки файла
        } catch (IOException e) {
            System.out.println("Ошибка при очистке файла: " + e.getMessage());
        }
    }
}