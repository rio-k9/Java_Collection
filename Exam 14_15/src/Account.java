

/**
 * Created by grjka on 06/05/2017.
 */
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
