import services.SystemService;

public class Main {
    public static void main(String[] args) {
        SystemService system = new SystemService();
        system.seedData();   
        system.mainMenu();   
    }
}
