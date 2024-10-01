public class Freshman extends Student {

    public Freshman(String name, int age, int height, int weight, int punchPower) {
        super(name, age, height, weight, punchPower);
    }

    // Переопределение метода атаки для первокурсника (минус 20% к силе удара)
    @Override
    public void attack(Student opponent) {
        int reducedPower = (int) (this.punchPower * 0.8); // 20% меньше
        System.out.println(this.name + " (Первокурсник) атакует " + opponent.name + " с силой " + reducedPower);
        opponent.health -= reducedPower;

        if (opponent.health < 0) {
            opponent.health = 0;
        }

        System.out.println(opponent.name + " теперь имеет " + opponent.health + " здоровья.");
    }
}