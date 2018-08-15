
public class overriding {
	class Meme {
		protected String caption;
	    public void read() {
	        System.out.println("OOOOOOOOF");
	    }
	}

	class Program extends overriding {
		Program() {
			 
		}
	    public void main(String[ ] args) {
	        Meme m = new Meme() {
	            @Override public void read() {
	                System.out.println("I know da wae");
	            }
	        };
	        m.read();
	    }
	}
}
