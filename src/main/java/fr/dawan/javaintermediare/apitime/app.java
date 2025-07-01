package fr.dawan.javaintermediare.apitime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Set;

public class app {
    public static void main(String[] args) {
        /*
        Avant Java 8: package java.util.*
         */
        Date d1 = new Date();

        /*
        Classes liées à la manipulation des dates récupérées depuis une BD
        java.util.sql
        java.util.time
        java.util.timestamp
         */

        /*
        A partir de Java 8: ajout du package java.time: LocalDateTime, LocalDate, LocalTime + un certains nombre d'enum
        Nouvelles classes à utiliser
         */

        System.out.println(">>>>>>> LocalDateTime:");
        LocalDateTime ldt1 = LocalDateTime.now();
        System.out.println("LocalDateTime.now(): "+ldt1);

        LocalDateTime ldt2 = LocalDateTime.of(2019,11,15,14,55,33);
        System.out.println("LocalDateTime.of(): "+ldt2);

        LocalDateTime ldt3 = LocalDateTime.parse("2015-12-12T14:35:45");
        System.out.println("LocalDateTime.parse(): "+ldt3);

        System.out.println(">>>>>>>>>>>> LocalDate:");
        LocalDate ld1 = LocalDate.now();
        System.out.println("LocalDate.now(): "+ld1);

        LocalDate ld2 = LocalDate.of(2012,5,25);
        System.out.println("LocaDate.of(): "+ld2);

        LocalDate ld3 = LocalDate.parse("2015-06-05");
        System.out.println("LocalDate.parse(): "+ld3);

        System.out.println(">>>>>>> LocalTime:");
        LocalTime lt1 = LocalTime.now();
        System.out.println("LocalTime.now(): "+lt1);

        LocalTime lt2 = LocalTime.of(16,35);
        System.out.println("LocalTime.of(): "+lt2);

        LocalTime lt3 = LocalTime.parse("06:30");
        System.out.println("LocalTime.parse(): "+lt3);

        ldt1.toLocalDate(); //conversion en localDate
        ldt2.toLocalTime(); //conversion en locaTime

        //Enums:,
        Month janvier = Month.JANUARY;

        LocalDate ld = LocalDate.of(2015,Month.APRIL,15);

        DayOfWeek lundi = DayOfWeek.MONDAY;

        //fuseaux horaires:

        Set<String> zoneIds = ZoneId.getAvailableZoneIds();

        ZoneId zoneId = ZoneId.of("Europe/Paris");

        //Possibilité de créer un objet LOcalDateTime avec un fuseau horaire
        ZonedDateTime zdt = ZonedDateTime.of(ldt1, zoneId);
        System.out.println("Fuseau Horaire: "+zdt);

        System.out.println(">>>>>>>>>>>>< Formattage de dates:");
        LocalDateTime localDateTime = LocalDateTime.now();
        String dateFormatted = localDateTime.format(DateTimeFormatter.ISO_DATE_TIME); //soit choisir un format prédéfinis dans l'enum DateTimeFormatter

        System.out.println(dateFormatted);

        //Soit appliquer un format personnalisé

        String formatPerso = localDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println(formatPerso);

        //D'autres formats sont définis dans l'enum DateTimeFormatter: Long, moyen, court
        System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(localDateTime));
        System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).format(localDateTime));
        System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).format(localDateTime));
        System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(localDateTime));

        localDateTime.minusDays(2);
        localDateTime.plusHours(5);

    }
}
