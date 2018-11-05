import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject; 

public class ObjetoRemoto extends UnicastRemoteObject implements InterfaceRemota 
{ 
    protected ObjetoRemoto() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public int suma(int a, int b)  throws RemoteException
    { 
        System.out.println ("sumando " + a + " + " + b + "..."); 
        return a+b; 
    }
}