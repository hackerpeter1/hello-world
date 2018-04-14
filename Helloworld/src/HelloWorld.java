
import java.util.*;

class HelloWorld{
	public String message;
	public HelloWorld(String name){
		message = name;
	}

	public String getMessage(){
		return this.message;
	}	

	public static void main(String[] args){
		HelloWorld obj = new HelloWorld("HelloWorld");
		System.out.println(obj.getMessage());
	}
}
