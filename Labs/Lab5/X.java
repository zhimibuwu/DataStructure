public class X {
	protected int var;
	public static final int c = 5;

	public X() {
		var = 0;
	}

	public X(int x) {
		var = x;
	}

	public int method() {
		System.out.println("method from X");
		return var;
	}
}