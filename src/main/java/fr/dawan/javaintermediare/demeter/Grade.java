package fr.dawan.javaintermediare.demeter;

import java.util.List;

public class Grade {

    List<StudentClass> classes;

    public List<StudentClass> getclasses() {
        return classes;
    }

    public void setGrades(List<StudentClass> classes) {
        this.classes = classes;
    }

    public int countStudents() {
        int nb = 0;
        for(StudentClass classe: classes){
            nb = classe.countStudents();
        }

        return nb;
    }
}
