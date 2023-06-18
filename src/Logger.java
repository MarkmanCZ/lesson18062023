import java.time.LocalDate;

public class Logger {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void Warning(String message) {
        System.out.println(ANSI_YELLOW+"["+ LocalDate.now() +"][Warning]: "+message);
    }

    public static void Error(String message) {
        System.out.println(ANSI_RED+"["+ LocalDate.now() +"][Error]: "+message);
    }

    public static void Info(String message) {
        System.out.println(ANSI_BLUE+"["+ LocalDate.now() +"][Info]: "+message);
    }

}
