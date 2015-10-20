public class Y extends X implements Z {
	private int walk;

	public Y() {
		super();
		walk = 0;
	}	

	public Y(int x) {
		super(x);
		walk = 0;
	}

	public Y(int x, int y) {
		super(x);
		walk = y;
	}

	public int method() {
		System.out.println("method from Y");
		return var * 2;
	}

	public static void main(String args[]) {
		System.out.println(X.c);       // both variable c in X and variable c in Z match. Same value for c doesn't matter.
		System.out.println(Z.c);
		Y y = new Y();
		int result = ((X) y).method();
		X x = new X();
		int result1 = (x).method();    // Don't think x can be cast to Y.
	}
}