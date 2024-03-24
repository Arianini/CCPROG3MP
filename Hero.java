public class Hero extends JobClass {
    public Hero() {
        this.stats = new Stats(7, 14, 9, 7, 12, 16, 8);
    }

    @Override
    public void displayStats() {
        System.out.println("Hero stats: " + stats);
    }
}