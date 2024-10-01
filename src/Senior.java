public class Senior extends Student {

    public Senior(String name, int age, int height, int weight, int punchPower) {
        super(name, age, height, weight, punchPower);
    }

    // Переопределение метода атаки для старшекурсника (плюс 20% к силе удара)
    @Override
    public void attack(Student opponent) {
        int increasedPower = (int) (this.punchPower * 1.2); // 20% больше
        System.out.println(this.name + " (Старшекурсник) атакует " + opponent.name + " с силой " + increasedPower);
        opponent.health -= increasedPower;

        if (opponent.health < 0) {
            opponent.health = 0;
        }

        System.out.println(opponent.name + " теперь имеет " + opponent.health + " здоровья.");
    }
}