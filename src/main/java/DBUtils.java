import org.h2.tools.Server;

import java.sql.*;

/**
 * Created by jackg on 6/23/2017.
 */
public class DBUtils {

    private static Connection con;

    public static void openConnection(String dbType){
        if (dbType.equalsIgnoreCase("hive")){
            //openHiveConnection();
        }else if(dbType.equalsIgnoreCase("h2")){
            openH2Connection();
        }
    }



    public static void openH2Connection() {

        try {
            Server.createTcpServer("-tcpPort", "9092", "-tcpAllowOthers").start();
            Class.forName("org.h2.Driver");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //System.out.println("Before trying to connect");
        try{
            con = DriverManager.getConnection("jdbc:h2:tcp://localhost:9092/~/myTable", "sa", "");
        } catch (SQLException e){
            e.printStackTrace();
        }
        //System.out.println("Connected");
    }

    public static void dropTable(String dbType, String dropStatement) throws SQLException {
        Statement stmt = con.createStatement();
        if(dbType.equalsIgnoreCase("h2")){
            stmt.execute(dropStatement);
        }
        stmt.close();
    }

    public static void createTable(String dbType, String createStatement) throws SQLException{
        //create the appropriate database table using another class which produces all the sql statments
        Statement stmt = con.createStatement();
        if(dbType.equalsIgnoreCase("h2")){
            stmt.execute(createStatement);
        }
        stmt.close();
    }

    public static void insertData(String dbType, String insertStmt) throws SQLException {
        Statement stmt = con.createStatement();
        if(dbType.equalsIgnoreCase("h2")){
            stmt.execute(insertStmt);
        }
        stmt.close();
    }

    public static ResultSet executeSQLQuery(String query) throws Exception{
        Statement stmt = con.createStatement();
        return stmt.executeQuery(query);
    }

    public static void closeConnection(String dbType) throws Exception{
        if(dbType.equalsIgnoreCase("h2")){
            closeH2Connection();
        }
    }

    private static void closeH2Connection() throws Exception{
        Server.shutdownTcpServer("tcp://localhost:9092", "", true, true);
        //con.close();
    }
}
