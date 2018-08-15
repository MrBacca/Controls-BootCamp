
class cat {
    public void start() {
        System.out.println("meow");
    }
}

class Program {
    public static void main(String[ ] args) {
        cat m = new cat() {
            @Override public void start() {
                System.out.println("Boork");
            }
        };
        m.start();
    }
}