package labs;

//Класс с ошибкой переполнения

public class PlanetOverflowException extends Exception {
	public PlanetOverflowException() {
		super("На планете нет свободных мест");
	}
}
