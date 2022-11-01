public class PrinterServant implements PrinterService{

    @Override
    public String login(String username, String password) throws Exception {
        Database db = new Database();
        Boolean b = db.userAuth(Security.decrypt(username), Security.decrypt(password));
        if(b) {
            return Security.encrypt(Security.decrypt(username));
        } else return Security.encrypt("incorrect user information.");
    }
}
