package enums;

public enum Species {
    CAT(false, 4, true),
    DOG(false, 4, true),
    ROBOT_CAT(false, 4, false),
    RABBIT(false, 4, true),
    PARROT(true, 2, false);

    public final boolean canFly;
    public final int numberOfLegs;
    public final boolean hasFur;

    Species(boolean canFly, int numberOfLegs, boolean hasFur) {
        this.canFly = canFly;
        this.numberOfLegs = numberOfLegs;
        this.hasFur = hasFur;
    }

    public boolean isCanFly() {
        return canFly;
    }

    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    public boolean isHasFur() {
        return hasFur;
    }
}