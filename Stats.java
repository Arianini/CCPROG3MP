public class Stats {
    private int level, hp, dex, intel, end, str, fth;

    public Stats(int level, int hp, int dex, int intel, int end, int str, int fth) {
        this.level = level;
        this.hp = hp;
        this.dex = dex;
        this.intel = intel;
        this.end = end;
        this.str = str;
        this.fth = fth;
    }

    public void increaseLevel() {
        this.level++;
    }

    public void increaseHp() {
        this.hp++;
    }

    public void increaseDex() {
        this.dex++;
    }

    public void increaseInt() {
        this.intel++;
    }

    public void increaseEnd() {
        this.end++;
    }

    public void increaseStr() {
        this.str++;
    }

    public void increaseFth() {
        this.fth++;
    }

    public int getLevel() {
        return level;
    }

    public int getHp() {
        return hp;
    }

    public int getDex() {
        return dex;
    }

    public int getintel() {
        return intel;
    }
    public int getEnd() {
        return end;
    }

    public int getStr() {
        return str;
    }
    public int getFth() {
        return fth;
    }

    public String toString() {
        return String.format("Level: %d, HP: %d, DEX: %d, INT: %d, END: %d, STR: %d, FTH: %d",
                level, hp, dex, intel, end, str, fth);
    }
}
