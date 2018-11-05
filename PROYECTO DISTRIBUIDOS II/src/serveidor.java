import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class serveidor {
	
	public serveidor()
	{
		
		try {
			
			InterfaceRemota i =  new ObjetoRemoto();
			LocateRegistry.createRegistry(5000);
			
			Naming.rebind("rmi://localhost:5000//suma", i); 
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
 
	}

	public static void main(String[] args) {

		new serveidor();
	}

}
