package fr.dawan.javaintermediare.demeter;

import java.util.List;

public class StudentClass {

    private List<Student> studentsListe;

    public List<Student> getStudentsListe() {
        return studentsListe;
    }

    public void setStudentsListe(List<Student> students) {
        this.studentsListe = students;
    }

    public int countStudents() {
        return (int)studentsListe.stream().count();
    }
}
