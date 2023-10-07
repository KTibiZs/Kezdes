package hu.ak_akademia.oop.piresian.general;

public class InvalidInput extends Exception {

    public InvalidInput(String string) {
        super(string);
		System.out.println("Semmi sem rosszab az összezavarodottságnál")
    }

}
