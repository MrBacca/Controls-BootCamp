
public class Fighter {
	protected int powerlevel;
	public void slap () {
		System.out.println("Kapow");
	}

}

class pewdiepie extends Fighter {
	pewdiepie() {
		powerlevel = 9000;
	}
}

class myclass {
	public static void main(String[] args) {
		pewdiepie d = new pewdiepie();
		d.slap();
	}
}