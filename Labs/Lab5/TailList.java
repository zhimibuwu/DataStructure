public class TailList extends SList {
	private SListNode tail;

	public TailList() {
		//super();
		tail = null;
	}

	// public TailList(int x) {
	// 	super(x);
	// 	tail = null;
	// }

	public void insertEnd(Object obj) {
		System.out.println("insertEnd from TailList");
		if (head == null) {
      head = new SListNode(obj);
      tail = head;
    }
    else {
      SListNode l = new SListNode(obj);
      tail.next = l;
      tail = l;
    }
    size++;
	}

	public void insertFront (Object obj) {
		super.insertFront(obj);
		if (size == 1) {
			tail = head;
		}
	}

	public void eatList() {
		
	}

}