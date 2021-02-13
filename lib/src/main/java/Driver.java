public class Driver {

    public static void main(String[] args) {

        PushbackTokenizer i = new PushbackTokenizerImpl("This is a test!");

        System.out.println("Calling Pushback()");
        i.pushback(); // Testing if nextToken hasn't been called.

        System.out.println("Printing i.nextToken(): ");
        System.out.println(i.nextToken()); // should be "This"

        System.out.println("Calling Pushback()");
        i.pushback();

        System.out.println("Printing i.nextToken(): ");
        System.out.println(i.nextToken()); // should be "This"

        System.out.println("Printing i.nextToken(): ");
        System.out.println(i.nextToken()); // should be "is"

    }
}
