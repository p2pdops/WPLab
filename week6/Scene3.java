import java.sql.*;

class Scene3 {
    public static void main(String ar[]) throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "1288");
        PreparedStatement ps1 = con.prepareStatement("update student set mobno=? where rno=?");
        ps1.setString(1, "987654321");
        ps1.setInt(2, 1202);
        ps1.executeUpdate();
        ps1.close();
        con.close();
    }
}
