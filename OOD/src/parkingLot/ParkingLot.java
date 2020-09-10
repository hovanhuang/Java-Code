package parkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
	private List<Levels> levels;
	private final int capacity;
	ParkingLot(int numOfLevels, int capacity){
		this.capacity = capacity;
		levels = new ArrayList<>();
		for(int i = 0; i <= numOfLevels - 1; i++) {
			Levels newLevel = new Levels(i, capacity/numOfLevels);
			levels.add(newLevel);
			if(i == numOfLevels) {
				Levels newLevelLast = new Levels(i, capacity%numOfLevels);
				levels.add(newLevelLast);
			}
		}
	}
	// Check in Vehicle returns spot number where the Vehicle is parked at.
	public String checkIn(Vehicle V){
		for(int i = 0; i <= levels.size() - 1; i++) {
			Levels curL = levels.get(i);
			if(!curL.isFull()) {
				for(int j = 0; j <= curL.spots.size() -1; j++) {
					Spots curS = curL.spots.get(j);
					if(curS.canPark(V)) {
						curS.V = V;
						return new String(Integer.toString(curL.level) + Integer.toString(curS.number));
					}
				}
			}
		}
		return "Parking Lot is Full";
	}
}

class Levels{
	List<Spots> spots;
	int level;
	int spotsNum;
	Levels(int level, int spotsNum){
		this.level = level;
		this.spotsNum = spotsNum;
		spots = new ArrayList<Spots>(spotsNum);
		for(int i = 0; i <= spotsNum - 1; i++) {
			Spots newSpot = new Spots(i, Size.values()[i%3]);
			spots.add(newSpot);
		}
	}
	boolean isFull() {
		for(int i = 0; i <= spotsNum - 1; i++) {
			if(spots.get(i).V == null) {
				return false;
			}
		}
		return true;
	}
}

class Spots{
	int number;
	Vehicle V;
	Size spotSize;
	Spots(int number, Size spotSize){
		this.number = number;
		this.spotSize = spotSize;
	}
	boolean canPark(Vehicle V) {
		if(this.V == null && this.spotSize.length >= V.size.length){
			return true;
		}
		return false;
	}
}
