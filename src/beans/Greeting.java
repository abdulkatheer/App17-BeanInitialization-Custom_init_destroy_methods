package beans;

public class Greeting {
    static {
        System.out.println("Greeting bean class loading...");
    }

    public Greeting() {
        System.out.println("Greeting bean class instantiating...");
    }

    private String name;
    private String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("Initializing 'name' using setName() method...");
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        System.out.println("Initializing 'message' using setMessage() method...");
        this.message = message;
    }

    public void init() {
        System.out.println("Initializing 'name' and 'message' using init() method...");
        this.name = "Abdul";
        this.message = "Good Night. Sleep tight...";
    }

    public void destroy(){
        System.out.println("destroy() method...");
    }

    public void greetUser(){
        System.out.println("Hello " + this.getName() + ". " + this.getMessage());
    }
}
