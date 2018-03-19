package sortersTesterClasses;

import java.util.Comparator;

public class Entero implements Comparator<Entero>, Comparable<Entero>{ 
    private int value; 
    public Entero(int v) { value = v; }
    public int getValue() { return value; } 
    public String toString() { return value + ""; }
	@Override
	public int compare(Entero o1, Entero o2) {
			return o1.compareTo(o2);
	}
	@Override
	public int compareTo(Entero o) {
		return this.getValue()-o.getValue();
	}
} 
