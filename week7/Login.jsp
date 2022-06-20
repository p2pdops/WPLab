<html>

<body>
    <%@ page import="java.sql.*" %>
    <%! int n=5;%>
    <%=n %>
        <% 
        String username=request.getParameter("uname");
        String password=request.getParameter("passwd");
        out.println("Username:"+username);
        out.println("Password:"+password);
        Class.forName("oracle.jdbc.driver.OracleDriver"); 
        out.println("Driver Loaded");
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","1288");
        out.println("Connected to Database"); String
        query="select * from logincheck where username=? and password=?" ; PreparedStatement
        ps=con.prepareStatement(query); ps.setString(1,username); ps.setString(2,password); ResultSet
        rs=ps.executeQuery();
        
        if(rs.next())
            out.println("Valid user");
         else 
            out.println("Invalid user");
         %>
</body>

</html>