package abstract_test;

public abstract class Account {

    private String name;
    private int id;

    public Account(int id, String name){
        this.id=id;
        this.name = name;
    }

    public String getname() {
        return name;
    }

    public abstract double calcBill();
}
