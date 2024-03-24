public class Astrologer extends JobClass {
    public Astrologer() {
        this.stats = new Stats(6, 9, 12, 16, 9, 8, 7);
    }

    @Override
    public void displayStats() {
        System.out.println("Astrologer stats: " + stats);
    }
}