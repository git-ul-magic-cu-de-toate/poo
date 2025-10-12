public class Main {
    public static void main(String[] args) {
        Text text = new Text();
        Invoker invoker = new Invoker();

        invoker.execute(new AddCharacter(text, 'a'));
        invoker.execute(new AddCharacter(text, 'b'));
        invoker.execute(new AddCharacter(text, 'c'));
        System.out.println(text.getValue());

        invoker.execute(new DeleteLastCharacter(text));
        System.out.println(text.getValue());

        // Undo la delete => abc
        invoker.undo();
        System.out.println(text.getValue());

        // Undo la add c => ab
        invoker.undo();
        System.out.println(text.getValue());

        // Redo la ultimul undo => add c => abc
        invoker.redo();
        System.out.println(text.getValue());
    }
}
