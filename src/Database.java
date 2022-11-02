import java.sql.*;
import java.lang.Class; 

public class Database {
    public Boolean userAuth(String Username, String Passwd) throws Exception {
        //加载驱动
        Class.forName("com.mysql.cj.jdbc.driver");
        String url = "jdbc:mysql://localhost:3306/user?useunicode=true&usejdbccomplianttimezoneshift=true&uselegacydatetimecode=false&servertimezone=utc";
        String user = "root";
        String password = "1111";
        try(
        //用 drivermanager 获取数据库连接
        //返回的 connection 就代表了 java 程序和数据库的连接
        Connection conn = DriverManager.getConnection(url, user, password);
        
        //使用 connection 来创建一个 statement 对象,要想执行sql就要有这个对象
        Statement stmt = conn.createStatement();
        )
        {
            //populate table
            //String selectSql = ("SELECT COUNT (*) FROM usertable WHERE dbo.Users.Username='"+username+"' AND dbo.Users.Password='"+password+"';");
            String sql = "insert into usertable values ('admin', 'admin', '1-11-2022:10:41xx')";
            stmt.executeUpdate(sql);        
	        stmt.close();
             
            //sql search
            String selectSql = ("select * from usertable where username = '"+ Username +"' and passwd = '"+Passwd+"';" );
            ResultSet rs = stmt.executeQuery(selectSql); //"select * from user"
            String username = "0";

            //使用结果集（ResultSet：包含符合条件的所有行）对象的访问方法获取数据
            while (rs.next()){
                username = rs.getString("username");
                String passwd = rs.getString("passwd");
                System.out.println(username + "---" + passwd + "---");

            }
            return (Integer.parseInt(username)!=0);

        }catch (SQLException e) {
            //System.out.println("fail to connect database！");   
            e.printStackTrace();
            return false;
        }
    }

}