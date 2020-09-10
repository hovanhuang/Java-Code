package parkingLot;

public enum Size {
	Compact(100), FullSize(200), SUVTruck(300);
	int length;
	Size(int num){
		this.length = num;
	}
}
