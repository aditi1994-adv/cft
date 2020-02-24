package com.cft.util;

public enum Number {
	
	ONE(1),TWO(2),THREE(3),FOUR(4);

	 private final int id;
    Number(int id) { 
    	this.id = id;
    	}
    
    public int getValue() { return id; }
}
