package interface_test;

public class PersonEnterDoor implements interfacePerson {

    private int name;
    private String number;

    public PersonEnterDoor(int nameOfDoor, String idNumber){
        this.number = idNumber;
        this.name = nameOfDoor;

    }


    @Override
    public String eat() {
        return null;
    }

    @Override
    public String walk() {
        return null;
    }

    @Override
    public String sleep(int hours) {
        return null;
    }


    public String doall() {

        return name + "  ==== " +   number;
    }
}
