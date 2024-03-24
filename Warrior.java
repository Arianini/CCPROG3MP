public class Warrior extends JobClass {
    public Warrior() {
        this.stats = new Stats(8, 11, 16, 10, 11, 10, 8);
    }

    @Override
    public void displayStats() {
        System.out.println("Warrior stats: " + stats);
    }
}