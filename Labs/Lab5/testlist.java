public class testlist {
	public static void main(String args[]) {
		SList s = new TailList();
		// TailList t = new SList();   // Compiler error
		s.insertEnd(new Integer(1));   // Calls TailList.insertEnd();
		s = new SList();
		s.insertEnd(new Integer(2));   // Calls SList.insertEnd();

		TailList t = new TailList();
		t.eatList();
		SList s2 = new TailList(); // Static Type: SList, Dynamic Type: TailList.
		// x.eatList();          // Compiler-time error. Not every SList has an "eatList()" method.

		SList s1;
		TailList t1 = new TailList();
		s1 = t1;
		// t1 = s1;               // Compiler error
		t1 = (TailList)s1;
		s1 = new SList();
		if (s1 instanceof TailList){   // false if s is null or doesn't refence a TailList or subclass
			t1 = (TailList)s1;        // Run-time error	
		}

		// int x = t.nth(1).intValue();   // Compiler-time error
		int y = ((Integer)t.nth(1)).intValue();
		String z = t.nth(1).toString();
	}
}