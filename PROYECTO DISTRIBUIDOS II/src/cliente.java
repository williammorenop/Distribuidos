import java.rmi.Naming;

public class cliente {

	public cliente() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		try {
			
			
			InterfaceRemota i = (InterfaceRemota) Naming.lookup("rmi://localhost:5000//suma");
			
			int a=9,b=6;
			while(true)
			{
				System.out.println(i.suma(a, b));				
				a++;b++;
				Thread.sleep (2000);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
