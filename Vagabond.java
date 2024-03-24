public class Vagabond extends JobClass {
    public Vagabond() {
        this.stats = new Stats(9, 15, 13, 9, 11, 14, 9);
    }

    @Override
    public void displayStats() {
        System.out.println("Vagabond stats: " + stats);
    }
}