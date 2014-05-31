import java.lang.reflect.Method;

public class PrintOutMethodName {

	public static void main(String[] args) {
		// any class will do
		for (Method method : FindDUP.class.getDeclaredMethods()) {
			System.out.println(method.getName() + ":");
			System.out.println(method);
		}
	}

}