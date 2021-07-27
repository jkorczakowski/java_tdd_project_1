import java.util.*;

public class Librus {
    List<Student> obj = new LinkedList<>();

    public Student findStudent(int id){
        try {
        return obj.get(id);
        }
        catch (IndexOutOfBoundsException e) {
           throw new IndexOutOfBoundsException();
        }
    }


    void addStudent (String name, String surname)
    {
        if (name == null || surname == null) throw new NullPointerException();

        Student student = new Student(name, surname);
        obj.add(student);
    }

    void editStudentName (int id, String name)
    {
        if (name == null) throw new NullPointerException();

        Student student = findStudent(id);
        student.setName(name);
    }

    void editStudentSurname (int id, String surname)
    {
        if (surname == null) throw new NullPointerException();
        Student student = findStudent(id);
        student.setSurname(surname);
    }

    void deleteStudent (int id)
    {
        Student student = findStudent(id);
        obj.remove(id);
    }


    void addSubject (int studentId, String subject)
    {
        if (subject == null) throw new NullPointerException();
        Student student = findStudent(studentId);
        student.getSubjectAndGrades().put(subject, new LinkedList<>());

    }

    void editSubject (int studentId, String oldSubject, String newSubject)
    {
        if (oldSubject == null || newSubject == null) throw new NullPointerException();
        Student student = findStudent(studentId);
        student.getSubjectAndGrades().remove(oldSubject);
        student.getSubjectAndGrades().put(newSubject, new LinkedList<>());

    }

    void deleteSubject (int studentId, String subject)
    {
        if (subject == null) throw new NullPointerException();
        Student student = findStudent(studentId);
        student.getSubjectAndGrades().remove(subject);

    }


    void addGrade (int studentId, String subject, float grade)
    {
        if (subject == null) throw new NullPointerException();
        Student student = findStudent(studentId);
        student.getSubjectAndGrades().get(subject).add(grade);
    }

    void editGrade (int studentId, String subject, int indexOfOldGrade, float newGrade)
    {
        if (subject == null) throw new NullPointerException();
        Student student = findStudent(studentId);
        student.getSubjectAndGrades().get(subject).set(indexOfOldGrade, newGrade);
    }

    void deleteGrade (int studentId, String subject, int indexOfOldGrade)
    {
        if (subject == null) throw new NullPointerException();
        Student student = findStudent(studentId);
        student.getSubjectAndGrades().get(subject).remove(indexOfOldGrade);

    }


    float getAverageOfSubject (int studentId, String subject)
    {
        if (subject == null) throw new NullPointerException();

        Student student = findStudent(studentId);

        float avg = 0;
        int size = student.getSubjectAndGrades().get(subject).size();

        for (int i = 0; i < size; ++i)
        {
            avg += student.getSubjectAndGrades().get(subject).get(i);
        }

        return avg / size;
    }

    float getAverageOfAllSubjects (int studentId)
    {

        Student student = findStudent(studentId);
        List<String> subjects = new ArrayList<>(student.getSubjectAndGrades().keySet());
        float avg = 0;
        int sum = 0;

        int subjectsSize = student.getSubjectAndGrades().size();
        int gradesSize;


        for (int i = 0; i < subjectsSize; ++i)
        {
            gradesSize = student.getSubjectAndGrades().get(subjects.get(i)).size();

            for (int k = 0; k < gradesSize; ++k)
            {
                ++sum;
                avg += student.getSubjectAndGrades().get(subjects.get(i)).get(k);
            }
        }

        return avg / sum;
    }

    void addNote (int studentId, String note)
    {
        if (note == null) throw new NullPointerException();
        Student student = findStudent(studentId);
        student.getNotes().add(note);

    }

    void editNote (int studentId, int indexOfNote, String newNote)
    {
        if (newNote == null) throw new NullPointerException();
        Student student = findStudent(studentId);
        student.getNotes().remove(indexOfNote);
        student.getNotes().add(newNote);
    }

    void deleteNote (int studentId, int indexOfNote)
    {
        Student student = findStudent(studentId);
        student.getNotes().remove(indexOfNote);

    }

    boolean checkIfNull(String temp)
    {
        if (temp == null) return true;
        else return false;
    }

     static void printAll(Librus librus) {
         int counter = 0;
         for (Student element : librus.obj) {
             System.out.println(counter + " " + element + " ");
             ++counter;
         }
     }

}
