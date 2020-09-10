package parkingLot;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vehicle V1 = new Vehicle("abc123", Size.Compact);
		Vehicle V2 = new Vehicle("abc123", Size.Compact);
		Vehicle V3 = new Vehicle("abc123", Size.FullSize);
		Vehicle V4 = new Vehicle("abc123", Size.SUVTruck);
		ParkingLot PL = new ParkingLot(1, 3);
		System.out.println(PL.checkIn(V1));
		System.out.println(PL.checkIn(V2));
		System.out.println(PL.checkIn(V3));
		System.out.println(PL.checkIn(V4));
		
		
	}

}
