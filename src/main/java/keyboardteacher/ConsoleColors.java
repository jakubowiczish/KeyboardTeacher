package keyboardteacher;

/**
 * Contains some colors for console messages
 */
public enum ConsoleColors {
    GREEN_BOLD("\033[1;32m"),

    RED_BOLD("\033[1;31m"),

    BLUE_BOLD_BRIGHT("\033[1;94m"),

    PURPLE_BOLD("\033[1;35m"),

    YELLOW_BOLD("\033[1;33m"),

    RESET("\033[0m");

    private final String colorCode;

    ConsoleColors(String colorCode) {
        this.colorCode = colorCode;
    }

    @Override
    public String toString() {
        return colorCode;
    }
}
