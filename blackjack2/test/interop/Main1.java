package interop;

public class Main1 {
    public static void main(String[] args) {
        Foo f = new Foo(2, 2);
        System.err.println(f.getAaa());
        System.err.println(f.getBbb());
        String s = Foo.mkHand();


    }
}
