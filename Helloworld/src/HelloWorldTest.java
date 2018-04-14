
  
import junit.framework.TestCase;
  
  
public class HelloWorldTest extends TestCase{  
    @test
    public void testMain(){  
        HelloWorld testobj = new HelloWorld();  
        assertEquals("HelloWorld",testobj.printMessage());   
    }  
}