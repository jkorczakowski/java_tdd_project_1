import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Student {
    private String name;
    private String surname;
    private List<String> Notes = new LinkedList<>();
    private List<Float> grades = new LinkedList<>();
    private Map<String, List<Float>> subjectAndGrades = new LinkedHashMap<>();

    public Student (String name, String surname)
    {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<String> getNotes() {
        return Notes;
    }

    public void setNotes(List<String> notes) {
        Notes = notes;
    }

    public List<Float> getGrades() {
        return grades;
    }

    public void setGrades(List<Float> grades) {
        this.grades = grades;
    }

    public Map<String, List<Float>> getSubjectAndGrades() {
        return subjectAndGrades;
    }

    public void setSubjectAndGrades(Map <String, List<Float>> subjectAndGrades) {
        this.subjectAndGrades = subjectAndGrades;
    }
















    public String toString() {
        return name + " " + surname + " " + subjectAndGrades + " " + Notes;
    }

}
