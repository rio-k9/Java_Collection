package binary;

import java.io.Serializable;

public class Stringify implements Serializable{

	    private String name;
	    private String surename;

	    public Stringify (String firstName, String secondName){
	        this.name = firstName;
	        this.surename = secondName;
	    }

	    @Override
	    public String toString(){
	        return "I Hope This Is Your Name: " + this.name + this.surename;
	    }
	    
}
