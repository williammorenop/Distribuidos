import java.rmi.Remote; 
public interface InterfaceRemota extends Remote 
{ 
    public int suma (int a, int b) throws java.rmi.RemoteException; 
    
}