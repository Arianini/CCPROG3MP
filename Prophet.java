public class Prophet extends JobClass {
    public Prophet() {
        this.stats = new Stats(7, 10, 10, 7, 8, 11, 16);
    }

    @Override
    public void displayStats() {
        System.out.println("Prophet stats: " + stats);
    }
}
