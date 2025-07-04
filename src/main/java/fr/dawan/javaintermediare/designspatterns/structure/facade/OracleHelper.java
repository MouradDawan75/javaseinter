package fr.dawan.javaintermediare.designspatterns.structure.facade;

import java.sql.Connection;

public class OracleHelper {

    public static Connection getOracleConnection(){
        //étapes de connexion à Oracle
        return null;
    }

    public void generateOraceHtmlReport(String tableName, Connection cnx){
        System.out.println("Oracle Html report generated..............");
    }

    public void generateOraclePdfReport(String tableName, Connection cnx){
        System.out.println("Oracle Pdf report generated..............");
    }
}
