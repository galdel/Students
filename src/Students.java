class Student {
    String name;
    int age;
    int height; // in cm
    int weight; // in kg
    int punchPower;
    int health;

    public Student(String name, int age, int height, int weight, int punchPower) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.punchPower = punchPower;
        this.health = 100; // Initial health
    }

    public void attack(Student opponent) {
        System.out.println(this.name + " attacks " + opponent.name + " with punch power " + this.punchPower);
        opponent.health -= this.punchPower;
        if (opponent.health < 0) {
            opponent.health = 0;
        }
        System.out.println(opponent.name + " health: " + opponent.health);
    }

    public void getStats() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Height: " + height);
        System.out.println("Weight: " + weight);
        System.out.println("Punch Power: " + punchPower);
        System.out.println("Health: " + health);
    }
}