class Student {
    String name;
    int age;
    int height;
    int weight;
    int punchPower;
    int health;

    // Конструктор
    public Student(String name, int age, int height, int weight, int punchPower) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.punchPower = punchPower;
        this.health = 100; // Начальное здоровье
    }

    // Метод для атаки
    public void attack(Student opponent) {
        if (opponent.health > 0) {
            System.out.println(this.name + " атакует " + opponent.name + " с силой " + this.punchPower);
            opponent.health -= this.punchPower;

            if (opponent.health < 0) {
                opponent.health = 0;
            }

            System.out.println(opponent.name + " теперь имеет " + opponent.health + " здоровья.");
        } else {
            System.out.println(opponent.name + " уже выбыл из битвы.");
        }
    }

    // Проверка, жив ли студент
    public boolean isAlive() {
        return this.health > 0;
    }
}