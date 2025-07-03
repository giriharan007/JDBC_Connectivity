import java.util.*;
import java.sql.*;

public class StudentDBMS {
    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String user = "root";
        String password = "Giri";
        
        Class.forName("com.mysql.cj.jdbc.Driver");//(in new version it done automatically)
        Connection con = DriverManager.getConnection(url, user, password);
        System.out.println("Connection successful");

        System.out.println("Enter ID of Student: ");
        int id=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter NAME of Student: ");
        String name=sc.nextLine();
        System.out.println("Enter the GRADE of Student");
        String grades=sc.nextLine();

        String sql="INSERT INTO student VALUES (?, ?, ?)";
        PreparedStatement st =con.prepareStatement(sql);
        st.setInt(1, id);
        st.setString(2, name);
        st.setString(3, grades);
        int result=st.executeUpdate();
        System.out.println(result);

        String DQL="select * from student";
        Statement st1 = con.createStatement();
        ResultSet rs=st1.executeQuery(DQL);
        System.out.println("Student Records");
        while(rs.next()){
           System.out.println(rs.getInt(1)+" - "+rs.getString(2)+" - "+rs.getString(3));
        }
        rs.close();
        st.close();
        st1.close();
        sc.close();
        con.close();
    }
}
