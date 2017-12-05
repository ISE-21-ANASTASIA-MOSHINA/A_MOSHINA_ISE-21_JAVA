package labs;

//Класс с ошибкой отсутсвия тарелки по индексу

public class PlanetIndexOutOfRangeException extends Exception {
	public PlanetIndexOutOfRangeException() {
		super("На это месте отсутсвует тарелка");
	}
}
