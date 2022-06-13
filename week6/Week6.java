// Compile & Execute: javac .\Week6A.java ; java Week6A
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
// import oracle.jdbc.driver.OracleDriver;

class Week6 {
    public static void main(String ar[]) {
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            // Class.forName("org.sqlite.JDBC");
            // Connection con = DriverManager.getConnection("jdbc:sqlite:users.db");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","tiger");
            System.out.println("Driver Loaded successfully");

            System.out.println("Connected to Database");
            // Statement stCreate = con.createStatement();
            // stCreate.execute("CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT);");

            do {
                System.out.println("1. Add User\n2. Display Users\n3. Update User\n4. Delete User\n5. Exit");
                System.out.print("--> Choose your option: ");
                int op = sc.nextInt();
                switch (op) {
                    case 1:
                        System.out.print("****** Adding new user\n--> Choose user's name: ");
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
                    System.out.print("****** Updating user\n--> Enter id to update: ");
                        int idToUpdate = sc.nextInt();
                        System.out.print("****** Enter name to update: ");
                        String updateName = sc.next();
                        int updateId = con.createStatement()
                        .executeUpdate("UPDATE users set name='"+updateName+"' WHERE id = " + idToUpdate+";");
                        System.out.println("Updated user with id: " + updateId);
                        break;
                    case 4:
                        System.out.print("****** Enter id to delete: ");
                        int idToDelete = sc.nextInt();
                        int deleteId = con.createStatement()
                        .executeUpdate("DELETE FROM users WHERE id = " + idToDelete+";");
                        System.out.println("Deleted user with id: " + deleteId);
                        break;
                    default:
                        System.out.println("-> Invalid option");
                        return;
                }
            } while (true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
