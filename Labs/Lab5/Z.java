public interface Z {
	public abstract int method();         // works
	// public abstract void method();     // return type incompatible
	// public abstract int method(int x);      // Y is not abstract and does not override abstract method.
	// public abstract int method(int y);       // works
	public static final int c = 6;
}