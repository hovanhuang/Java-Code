package BlackJack;

public enum FaceValue {
	A(1), Two(2), Three(3), Four(4), Five(5), Six(6), Seven(7), Eight(8), Nine(9), Ten(10), 
	J(10), Q(10), K(10);
	int value;
	FaceValue(int value){
		this.value = value;
	}
}
