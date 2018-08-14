
public class counter 
	{
	public static int COUNT=10;
	counter() {
		COUNT++;
	}
	
	
public class counter2 {
	public void main(String[]args) {
		counter c1 = new counter();
		counter c2 = new counter();
		System.out.println(counter.COUNT);
	}
}
	}

