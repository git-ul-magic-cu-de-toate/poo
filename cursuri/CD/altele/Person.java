public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    static public class Account {
        public String bank ;
        public String iban ;

        public Account(String bank, String iban) {
            this.bank = bank;
            this.iban = iban;
        }

        public String toString() {
            return "Person's account : "+ iban ;
        }
    }
}
