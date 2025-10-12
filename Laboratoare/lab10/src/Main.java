public class Main {
    public static void main(String[] args) {
        File file1 = new File("a");
        Invoker invoker = new Invoker();

        invoker.execute(new AppendCommand(file1, "b"));
        System.out.println(file1.getText());

        invoker.undo();
        System.out.println(file1.getText());

        invoker.redo();
        System.out.println(file1.getText());
    }
}
