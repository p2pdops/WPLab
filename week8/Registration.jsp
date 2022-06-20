<html>

<body>
    <%@ page import="java.sql.*" %>
        <%
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","1288");
        String rollno=request.getParameter("rollno");
        String username=request.getParameter("uname");
        String mobileno=request.getParameter("mobno"); 
        String query="insert into student1 values('"+rollno+"','"+username+"','"+mobileno+"')";
            
        Statement st=con.createStatement(); 
            
        int n=st.executeUpdate(query);
            
        if(n>0){
            out.println("Data Inserted");
        } else{
            out.println("Data Not inserted");
        }
        %>
</body>

</html>