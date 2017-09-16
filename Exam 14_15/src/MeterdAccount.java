

/**
 * Created by grjka on 06/05/2017.
 */
public class MeterdAccount extends Account  {
    private double MeterdRate;

    public MeterdAccount(int MeterdRate ,String name, int id){
        super(id,name);
        this.MeterdRate=MeterdRate;
    }

    @Override
    public double calcBill(){
        return 5*(this.MeterdRate);
    }
}
