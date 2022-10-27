package exercise;

import java.sql.*;

public class P02_get_villains_name {

    private static final String GET_VILLAINS_NAMES = "SELECT v.name, COUNT(distinct mv.minion_id) AS 'count'" +
            " FROM villains AS v" +
            " JOIN minions_villains AS mv ON v.id = mv.villain_id" +
            " JOIN minions AS m ON mv.minion_id= m.id" +
            " GROUP BY v.name" +
            " HAVING `count` > ?" +
            " ORDER BY `count` DESC";
    private static final String COLUMN_LABEL_NAME = "name";
    private static final String COLUMN_LABEL_MINIONS_COUNT = "count";
    private static final String PRINT_FORMAT = "%s %d";


    public static void main(String[] args) throws SQLException {
        final Connection connection = Utils.getSQLConnection();
        final PreparedStatement query = connection.prepareStatement(GET_VILLAINS_NAMES);

        query.setInt(1, 15);
        final ResultSet result = query.executeQuery();

       while(result.next()){
           final String villainName = result.getString(COLUMN_LABEL_NAME);
           final int minionsCount = result.getInt(COLUMN_LABEL_MINIONS_COUNT);
           System.out.printf(PRINT_FORMAT, villainName, minionsCount);
       }
            connection.close();
    }
}
