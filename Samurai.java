public class Samurai extends JobClass {
    public Samurai() {
        this.stats = new Stats(9, 12, 15, 9, 13, 12, 8);
    }

    @Override
    public void displayStats() {
        System.out.println("Samurai stats: " + stats);
    }
}
