package com.spark.accumulator.util;

import com.spark.accumulator.connection.SqlConnection;
import org.sql2o.Connection;

public class DBUtils {

    public static void insertTable(String ingestionId, int totalEventsReceived){
        String insertSql= "INSERT INTO ingestion_table (ingestion_id,total_events_received) " +
                "VALUES(:ingestion_id,:total_events_received) " +
                "ON DUPLICATE KEY UPDATE total_events_received = :total_events_received";


        try(Connection connection = SqlConnection.getSqlConnection()){

            connection.createQuery(insertSql)
                    .addParameter("ingestion_id",ingestionId)
                    .addParameter("total_events_received",totalEventsReceived)
                    .executeUpdate();
//                 connection.commit();


        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
