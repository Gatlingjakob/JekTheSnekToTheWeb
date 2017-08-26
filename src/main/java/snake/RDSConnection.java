import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class RDSConnection implements RequestHandler<String, String> {
    Statement statement;
    ResultSet resultSet;

    @Override
    public String handleRequest(String input, Context context) {

        // String abc=database.database(input);
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://Endpoint/DB_Name", "User_Name", "password");

            context.getLogger().log("Test Started");
            String query = "select * from Table_Name where id=" + input;
            Statement statement = con.createStatement();
            resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                String output = "Hello, " + resultSet.getString("name") + "!";

                context.getLogger()
                        .log(resultSet.getString("id") + "Console: Hello " + resultSet.getString("name") + " !");
                return output;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

}