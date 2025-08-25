package Story1;

public enum BoyParkCarStrategyEnum {
    NOTCLEVER(0, new NotCleverBoyStrategy()),
    CLEVER(1, new CleverBoyStrategy()),
    SUPER(2, new SuperBoyStrategy());

    private final Integer boyState;
    private final BoyParkCarStrategy boyParkCarStrategy;

    BoyParkCarStrategyEnum(int boyState, BoyParkCarStrategy boyParkCarStrategy) {
        this.boyState = boyState;
        this.boyParkCarStrategy = boyParkCarStrategy;
    }

    public static BoyParkCarStrategy getStrategy(int boyState) {
        for (BoyParkCarStrategyEnum type : values()) {
            if (type.boyState == boyState) {
                return type.boyParkCarStrategy;
            }
        }
        return null;
    }
}
