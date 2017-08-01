import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by jackg on 6/23/2017.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        int[] numbers = {83, 90, 140, 10, 139, 11};
        int target = 150;
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for(int i=0; i<numbers.length; i++){
            nums.add(numbers[i]);
        }
        SumSet.sum_up(nums,target);

    }
}


/*
private static String dbType = "h2";
createTable();
        ResultSet rs = DBUtils.executeSQLQuery("select * from myTable where id = 2");
        rs.next();
        String name = rs.getString(2);
        rs.close();
        DBUtils.closeConnection(dbType);
        System.out.println(name);

        public static void createTable(){
        DBUtils.openConnection(dbType);
        try {
            DBUtils.dropTable(dbType,"Drop table myTable if exists");
            DBUtils.createTable(dbType,"Create table myTable(id int, name varchar)");
            DBUtils.insertData(dbType, "Insert into myTable values(1, 'Jack')");
            DBUtils.insertData(dbType, "Insert into myTable values(2, 'Julia')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 */