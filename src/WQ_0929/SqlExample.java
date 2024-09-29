package WQ_0929;

import java.sql.*;

public class SqlExample {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/test_db";
            String username = "root";
            String password = "0000";

            String sql = "SELECT name, age, address FROM students WHERE age BETWEEN 30 AND 39";

            conn = DriverManager.getConnection(url, username, password);
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            System.out.println("Name\tAge\tAddress");
            System.out.println("-----------------------------");
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String address = rs.getString("address");
                System.out.println(name + "\t" + age + "\t" + address);
            }
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
