package playground;

public class JavaPlayground {

    public static void main(String args[]){
        System.out.println("Hello, java");

        // Notice: we are accessing the N_EYES field of a CLASS Person, not from an instance of the class Person
        // This is called ** class-level functionality **, one of the fundamental aspects of OOP!
        System.out.println(Person.N_EYES);
    }
}

class Person {
    // This is how we define a constant that does not rely on an instance
    // of the class Person to access it
    public static final int N_EYES = 2;
}