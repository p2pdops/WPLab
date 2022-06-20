import java.sql.*;
import java.util.Scanner;

class Scene2 {
    public static void main(String ar[]) throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "tiger");
        Statement st = con.createStatement();
        String query = "select * from student";
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            System.out.print(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
            System.out.println();
        }
    }
}
