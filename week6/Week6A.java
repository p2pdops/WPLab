
// Compile: javac -cp ".;sqlite-jdbc.jar" .\Week6A.java
// Execute: java -cp ".;sqlite-jdbc.jar" Week6A
// Both: javac -cp ".;sqlite-jdbc.jar" .\Week6A.java ; java -cp ".;sqlite-jdbc.jar" Week6A
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

class Week6A {
    public static void main(String ar[]) {
        Scanner sc = new Scanner(System.in);
        try {
            // Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:users.db");
            System.out.println("Driver Loaded successfully");

            System.out.println("Connected to Database");
            Statement stCreate = con.createStatement();
            stCreate.execute("CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT);");

            do {
                System.out.println("1. Add User\n2. Display Users\n3. Delete User\n4. Exit");
                System.out.print("--> Choose your option: ");
                int op = sc.nextInt();
                switch (op) {
                    case 1:
                        // ask name
                        System.out.print("**Adding name\n--> Choose user's name: ");
                        String newName = sc.next();
                        int newId = con.createStatement()
                                .executeUpdate("INSERT INTO users(name) VALUES('" + newName + "');");
                        System.out.println("Created user with id: " + newId);
                        break;
                    case 2:
                        System.out.println("****** Displaying users ******");
                        int count = con.createStatement().executeQuery("SELECT count(*) as count FROM users;")
                                .getInt("count");
                        if (count != 0) {
                            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM users;");
                            while (rs.next()) {
                                System.out.println("    " + rs.getInt("id") + "      |   " + rs.getString("name"));
                            }
                        } else
                            System.out.println("--> No users found!");
                        break;
                    case 3:
                        // ask id, "DELETE FROM users WHERE id = " + id ;
                        break;
                    default:
                        System.out.println("-> Invalid option");
                        return;
                }
            } while (true);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
