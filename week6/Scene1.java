import java.sql.*;
import java.util.Scanner;

class Scene1 {
    public static void main(String ar[]) throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "tiger");
        Statement st = con.createStatement();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter your details");
        int rno = s.nextInt();
        String name = s.next();
        int mobno = s.nextInt();
        String query = "insert into student values(" + rno + ",'" + name + "'," + mobno + ")";
        int n = st.executeUpdate(query);
        if (n > 0) {
            System.out.println("1 row inserted");
        } else {
            System.out.println("Unsucessful");
        }
        st.close();
        con.close();
    }
}
