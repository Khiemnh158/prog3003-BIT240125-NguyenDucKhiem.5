
public class Bai1_Singleton {
    static class DatabaseConnection {
        private static DatabaseConnection instance;
        private DatabaseConnection() {}
        public static DatabaseConnection getInstance() {
            if (instance == null) instance = new DatabaseConnection();
            return instance;
        }
    }
    public static void main(String[] args) {
        DatabaseConnection a = DatabaseConnection.getInstance();
        DatabaseConnection b = DatabaseConnection.getInstance();
        System.out.println(a == b);
    }
}
