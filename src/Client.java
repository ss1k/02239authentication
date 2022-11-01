import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;


public class Client {
    public static void main(String[] args) throws Exception {
        int port = 8081;
        PrinterService service = (PrinterService) Naming.lookup("rmi://localhost:"+port+"/printer");        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String serverResponse = "incorrect user information.";

            while (serverResponse.equals("incorrect user information.")) {
                System.out.println("Input login username:");
                String username = reader.readLine();
                System.out.println("Input password:");
                String password = reader.readLine();

                String loginInfo = service.login(Security.encrypt(username), Security.encrypt(password));
                serverResponse = Security.decrypt(loginInfo);

                System.out.println(serverResponse);
            }

            System.out.println("Successfully Login.");
        }
    }
    

}
