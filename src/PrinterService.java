import java.rmi.Remote;

public interface PrinterService extends Remote{
    public String login (String username, String password) throws Exception;
}
