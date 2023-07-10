import java.sql.*;

public class VulnerableCode {
    public static void main(String[] args) {
        String username = args[0];
        String password = args[1];

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/mydatabase", username, password);
            Statement stmt = conn.createStatement();

            String id = "1 OR 1=1";
            String query = "SELECT * FROM users WHERE id = " + id;

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");

                System.out.println("Name: " + name + ", Email: " + email);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
