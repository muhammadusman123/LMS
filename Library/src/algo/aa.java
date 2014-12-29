package algo;

public class aa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int y1=100;
		int y2=150;
		int y3=200;
		int y4=400;
		double F1=100;
		double F2;
		double F3;
		double F4;

	double F=0;
	double alpha=0.877;

	F2=F1+alpha*(y1-F1);
	System.out.println(F2);
	
	F3=F2+alpha*(y2-F2);
	System.out.println(F3);
	
	F4=F3+alpha*(y3-F3);
	System.out.println(F4);
	}

}
