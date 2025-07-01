package fr.dawan.javaintermediare.demeter;

import java.util.List;

public class School {

    List<Grade> grades;

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public int countStudents(){
        int nb = 0;
        for(Grade grade : grades){
            for(StudentClass classe: grade.getclasses()){
                for(Student s : classe.getStudents()){
                    nb++;
                }
            }
        }

        return nb;
    }

    //méthode qui respecte Demeter

    public int countStudentDemeter(){
        int nb = 0;
        for(Grade grade : grades){
            nb = grade.countStudents();
        }

        return nb;
    }
}

/*
Loi Demeter:
Une classe ne doit interagir qu'avec les classes amies.
Une méthode définie dans une classe, ne peut utiliser:
- que ses propres paramètres
- que ses variables locales ou bien les attributs de la classe
 */