package fr.dawan.javaintermediare.designspatterns.structure.facade;

import java.sql.Connection;

public class FacadeHelper {

    public enum DatabaseType{
        MYSQL,
        ORACLE
    }

    public enum ReportType{
        HTML,
        PDF
    }


    //Méthode pour chaque besoin de l'application
    public static void generateReport(DatabaseType dbType, ReportType reportType, String tableName){

        Connection cnx = null;
        switch (dbType){
            case MYSQL :
                cnx = MySqlHelper.getMySqlConnection();
                MySqlHelper mySqlHelper = new MySqlHelper();

                switch (reportType){
                    case HTML:
                        mySqlHelper.generateMySqlHtmlReport(tableName, cnx);
                        break;
                    case PDF:
                        mySqlHelper.generateMySqlPdfReport(tableName, cnx);
                }

                break;

            case ORACLE:
                cnx= OracleHelper.getOracleConnection();
                OracleHelper oracleHelper = new OracleHelper();
                switch (reportType){
                    case HTML:
                        oracleHelper.generateOraceHtmlReport(tableName,cnx);
                        break;
                    case PDF:
                        oracleHelper.generateOraceHtmlReport(tableName,cnx);
                        break;
                }
                break;
        }

    }
}
