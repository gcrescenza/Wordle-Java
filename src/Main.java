public class Main {
    public static void main(String args[]) {
        ScreenManager.greetings(args);
        GameManager parsifal = new GameManager();
        do {
            try {
                parsifal.computeInput(Keyboard.getString());
            } catch (NotRecognized e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }
}
