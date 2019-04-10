package test;

import beans.Greeting;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        /*
        Order of execution:
        -------------------
        1. Bean class loading
        2. Bean class instantiating (values are initialized with default values)
        3. Initialization through property tags (i.e. setter methods)
        4. Initialization through custom init() and destroy() method (update existing values)
        5. destroy() method before bean object destroy or deinitialization of bean object.

        Note:
        ----
        1. Bean objects are managed by Spring containers and not by JVM.
        2. System.gc method will not wipe out bean objects as it is stored and referred by living ApplicationContext
        3. Technically speaking, if object is referred by any reference, it can't be swept by GC.
         */
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("resources/applicationContext.xml");
        Greeting g = (Greeting) context.getBean("greeting");

        g.greetUser();

        //g = null;
        //System.gc();
        //The above code won't work in Spring Applications

        //This will deactivate and shutdown the application context container and all bean objects will be destroyed
        context.registerShutdownHook();
    }
}
