public class test {
	public static void main(String args[]) {
		X x;
		Y y = new Y();
		x = y;
		// y = x; // Compiler Error
		x = new X(); 
		if (x instanceof Y)
		{
			y = (Y)x;   // will cause a run-time error if x references an object that isn't a Y.
		}
		X[] xa = new X[2];
		Y[] ya = new Y[2];

		xa = ya;
		xa = new X[2];
		if (xa instanceof Y[])
		{
			ya = (Y[])xa; 
		}
		xa = new Y[2];
		ya = (Y[])xa;
	}
}