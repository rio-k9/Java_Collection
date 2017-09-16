package interface_test;


abstract class abstractDoor {
    int doorName;
    int id;



    public abstract int openDoor();

    public abstract String closeDoor(int hours);

    public String doorBroke(){
        return "It Just broke";
    }
}
