package labs;

import java.io.Serializable;
import java.util.HashMap;

public class ClassArray<T extends ITransport> implements Serializable {
	private HashMap<Integer,T> places;
	private int maxCount;
	private T defaultValue;
	
	public ClassArray(int size, T defaultValue) {
		this.defaultValue = defaultValue;
		places = new HashMap<Integer, T>();
		this.maxCount = size;
	}

	//Метод кидающий ошибку переполнения
	public int addShip(T ship) throws PlanetOverflowException {
		for(int i = 0;i<maxCount;i++) {
			if(checkFreePlace(i)) {
				places.put(i, ship);
				return i;
			}
		}
		throw new PlanetOverflowException();
	}
	
	//Метод который кидает ошибку отсутсвтия тарелки по индексу
	public T getShip(int index) throws PlanetIndexOutOfRangeException {
		if(!checkFreePlace(index)) {
			T ship = places.get(index);
			places.remove(index);
			return ship;
		}
		throw new PlanetIndexOutOfRangeException();
	}
	
	//Второй метод который кидает ошибку отсутсвтия тарелки по индексу
	public T popShip(int index) throws PlanetIndexOutOfRangeException {
		if(!checkFreePlace(index)) {
			return places.get(index);
		}
		throw new PlanetIndexOutOfRangeException();
	}
	
	private boolean checkFreePlace(int index) {
		return !places.containsKey(index);
	}
}
