package fr.dawan.javaintermediare.designspatterns.structure.facade;

import java.sql.Connection;

public class MySqlHelper {

    public static Connection getMySqlConnection(){
        //étapes de connexion à MYSql
        return null;
    }

    public void generateMySqlHtmlReport(String tableName, Connection cnx){
        System.out.println("MySql Html report generated..............");
    }

    public void generateMySqlPdfReport(String tableName, Connection cnx){
        System.out.println("MySql Pdf report generated..............");
    }
}
