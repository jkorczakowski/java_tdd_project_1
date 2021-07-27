import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

public class JU5LibrusTest {

    private Librus librus;
    final static String fSubject = "Historia";
    final static float fgrade = (float) 3.5;
    final static int fStudentId = 0;

    static Logger log = Logger.getLogger(JU5LibrusTest.class.getName());

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        log.info("Before all");
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
        log.info("After all");
    }

    @BeforeEach
    void setUp() throws Exception {
        log.info("Before each");
        librus = new Librus();
        String fName = "Michal";
        String fSurname = "Kowalski";
        librus.addStudent(fName, fSurname);
    }

    @AfterEach
    void tearDown() throws Exception {
        log.info("After each");
        librus = null;
    }

    @Test
    @DisplayName("Test addStudent method positive alpha")
    void testAddStudentPositiveAlpha(){

        assertEquals(librus.obj.get(fStudentId), librus.findStudent(fStudentId));
    }

    @Test
    @DisplayName("Test addStudent method negative alpha")
    void testAddStudentNegativeAlpha(){
        librus.addStudent("Ewa", "Celmer");
        assertNotEquals(librus.obj.get(fStudentId + 1), librus.findStudent(fStudentId));
    }

    @Test
    @DisplayName("Test addStudent method null negative alpha")
    void testAddStudentNullNegativeAlpha(){
        assertNotNull(librus.findStudent(fStudentId));
    }

    @Test
    @DisplayName("Test addStudent method null exception positive alpha")
    void testAddStudentNullExceptionPositiveAlpha(){
        assertThrows(NullPointerException.class, () -> librus.addStudent(null, null));
    }

    @Test
    @DisplayName("Test addStudent method null exception negative alpha")
    void testAddStudentNullExceptionNegativeAlpha(){
        assertDoesNotThrow(() -> librus.addStudent("Ewa", "Celmer"));
    }

    @Test
    @DisplayName("Test editStudentName method positive alpha")
    void testEditStudentNamePositiveAlpha(){
        librus.editStudentName(fStudentId, "Mateusz");
        assertEquals("Mateusz", librus.findStudent(fStudentId).getName());
    }

    @Test
    @DisplayName("Test editStudentName method negative alpha")
    void testEditStudentNameNegativeAlpha(){
        librus.editStudentName(fStudentId, "Mateusz");
        assertNotEquals("Michal", librus.findStudent(fStudentId).getName());
    }

    @Test
    @DisplayName("Test editStudentName method null exception positive alpha")
    void testEditStudentNameNullExceptionPositiveAlpha(){
        assertThrows(NullPointerException.class, () -> librus.editStudentName(fStudentId, null));
    }

    @Test
    @DisplayName("Test editStudentName method null exception negative alpha")
    void testEditStudentNameNullExceptionNegativeAlpha(){
        assertDoesNotThrow(() -> librus.editStudentName(fStudentId, "Ewa"));
    }

    @Test
    @DisplayName("Test editStudentSurname method positive alpha")
    void testEditStudentSurnamePositiveAlpha(){
        librus.editStudentSurname(fStudentId, "Celmer");
        assertEquals("Celmer", librus.findStudent(fStudentId).getSurname());
    }

    @Test
    @DisplayName("Test editStudentSurname method negative alpha")
    void testEditStudentSurnameNegativeAlpha(){
        librus.editStudentSurname(fStudentId, "Celmer");
        assertNotEquals("Kowalski", librus.findStudent(fStudentId).getSurname());
    }

    @Test
    @DisplayName("Test editStudentSurname method null exception positive alpha")
    void testEditStudentSurnameNullExceptionPositiveAlpha(){
        assertThrows(NullPointerException.class, () -> librus.editStudentSurname(fStudentId, null));
    }

    @Test
    @DisplayName("Test editStudentSurname method null exception negative alpha")
    void testEditStudentSurnameNullExceptionNegativeAlpha(){
        assertDoesNotThrow(() -> librus.editStudentSurname(fStudentId, "Celmer"));
    }

    @Test
    @DisplayName("Test delete student method positive alpha")
    void testDeleteStudentPositiveAlpha() {
        librus.addStudent("Ewa", "Celmer");
        librus.deleteStudent(fStudentId);
        assertEquals("Ewa", librus.findStudent(fStudentId).getName());
    }

    @Test
    @DisplayName("Test delete student method exception positive alpha")
    void testDeleteStudentExceptionPositiveAlpha() {
        librus.deleteStudent(fStudentId);
        assertThrows(IndexOutOfBoundsException.class, () -> librus.findStudent(fStudentId));

    }

    @Test
    @DisplayName("Test deleteStudent method negative alpha")
    void testDeleteStudentNegativeAlpha()
    {
        librus.addStudent("Ewa", "Celmer");
        librus.deleteStudent(0);
        assertNotEquals("Michal", librus.findStudent(fStudentId).getName());
    }

    @Test
    @DisplayName("Test delete student method exception negative alpha")
    void testDeleteStudentExceptionNegativeAlpha() {
        librus.addStudent("Ewa", "Celmer");
        librus.deleteStudent(fStudentId);
        assertDoesNotThrow(() -> librus.findStudent(fStudentId));

    }

    @Test
    @DisplayName("Test findStudent method positive alpha")
    void testFindStudentPositiveAlpha() {
        assertNotNull(librus.findStudent(fStudentId));
    }

    @Test
    @DisplayName("Test findStudent method positive alpha")
    void testFindStudentPositiveBeta() {
        librus.addStudent("Ewa", "Celmer");
        assertNotNull(librus.findStudent(fStudentId + 1));
    }

    @Test
    @DisplayName("Test findStudent method positive exception alpha")
    void testFindStudentPositiveExceptionAlpha() {
        assertDoesNotThrow(() -> librus.findStudent(fStudentId));
    }

    @Test
    @DisplayName("Test findStudent method negative exception alpha")
    void testFindStudentExceptionNegativeAlpha() {
        assertThrows(IndexOutOfBoundsException.class, () -> librus.findStudent(fStudentId + 1));
    }

    @Test
    @DisplayName("Test addSubject method positive alpha")
    void testAddSubjectPositiveAlpha(){
        librus.addSubject(fStudentId, fSubject);
        assertTrue(librus.findStudent(fStudentId).getSubjectAndGrades().containsKey(fSubject));
    }

    @Test
    @DisplayName("Test addSubject method negative alpha")
    void testAddSubjectNegativeAlpha(){
        librus.addSubject(fStudentId, fSubject);
        assertFalse(librus.findStudent(fStudentId).getSubjectAndGrades().containsKey("Chemia"));
    }

    @Test
    @DisplayName("Test addSubject method exception positive alpha")
    void testAddSubjectExceptionPositiveAlpha(){
        assertThrows(NullPointerException.class, () -> librus.addSubject(fStudentId, null));
    }

    @Test
    @DisplayName("Test addSubject method exception negative alpha")
    void testAddSubjectExceptionNegativeAlpha(){
        assertDoesNotThrow(() -> librus.addSubject(fStudentId, fSubject));
    }

    @Test
    @DisplayName("Test editSubject method positive alpha")
    void testEditSubjectPositiveAlpha(){
        librus.addSubject(fStudentId, fSubject);
        librus.editSubject(fStudentId, fSubject,"Chemia");
        assertTrue(librus.findStudent(fStudentId).getSubjectAndGrades().containsKey("Chemia"));
    }

    @Test
    @DisplayName("Test editSubject method negative alpha")
    void testEditSubjectNegativeAlpha(){
        librus.addSubject(fStudentId, "fSubject");
        librus.editSubject(fStudentId, fSubject,"Chemia");
        assertFalse(librus.findStudent(fStudentId).getSubjectAndGrades().containsKey(fSubject));
    }

    @Test
    @DisplayName("Test editSubject method exception positive alpha")
    void testEditSubjectExceptionPositiveAlpha(){
        assertThrows(NullPointerException.class, () -> librus.editSubject(fStudentId, null, null));
    }

    @Test
    @DisplayName("Test editSubject method exception positive beta")
    void testEditSubjectExceptionPositiveBeta(){
        assertThrows(NullPointerException.class, () -> librus.editSubject(fStudentId, fSubject, null));
    }

    @Test
    @DisplayName("Test editSubject method exception positive gamma")
    void testEditSubjectExceptionPositiveGamma(){
        assertThrows(NullPointerException.class, () -> librus.editSubject(fStudentId, null, "Chemia"));
    }

    @Test
    @DisplayName("Test editSubject method exception negative alpha")
    void testEditSubjectExceptionNegativeAlpha(){
        assertDoesNotThrow(() -> librus.editSubject(fStudentId, fSubject, "Chemia"));
    }

    @Test
    @DisplayName("Test editSubject method exception negative beta")
    void testEditSubjectExceptionNegativeBeta(){
        assertDoesNotThrow(() -> librus.editSubject(fStudentId, fSubject, "Fizyka"));
    }

    @Test
    @DisplayName("Test deleteSubject method negative alpha")
    void testDeleteSubjectPositiveAlpha(){
        librus.addSubject(fStudentId, fSubject);
        librus.deleteSubject(fStudentId, fSubject);
        assertFalse(librus.findStudent(fStudentId).getSubjectAndGrades().containsKey(fSubject));
    }

    @Test
    @DisplayName("Test deleteSubject method exception positive alpha")
    void testDeleteSubjectExceptionPositiveAlpha(){
        librus.addSubject(fStudentId, fSubject);
        assertThrows(NullPointerException.class, () -> librus.deleteSubject(fStudentId, null));

    }

    @Test
    @DisplayName("Test deleteSubject method exception negative alpha")
    void testDeleteSubjectExceptionNegativeAlpha(){
        librus.addSubject(fStudentId, fSubject);
        assertDoesNotThrow(() -> librus.deleteSubject(fStudentId, fSubject));
    }

    @Test
    @DisplayName("test addGrade method positive alpha")
    void testAddGradePositiveAlpha(){
        librus.addSubject(fStudentId, fSubject);
        librus.addGrade(fStudentId, fSubject, fgrade);
        assertEquals((float) 3.5, (float) librus.findStudent(fStudentId).getSubjectAndGrades().get(fSubject).get(0));
    }

    @Test
    @DisplayName("test addGrade method positive beta")
    void testAddGradePositiveBeta(){
        librus.addSubject(fStudentId, fSubject);
        librus.addGrade(fStudentId, fSubject, fgrade);
        librus.addGrade(fStudentId, fSubject, (float) 4.5);
        assertTrue( librus.findStudent(fStudentId).getSubjectAndGrades().get(fSubject).contains((float) 4.5));
    }

    @Test
    @DisplayName("test addGrade method negative alpha")
    void testAddGradeNegativeAlpha(){
        librus.addSubject(fStudentId, fSubject);
        librus.addGrade(fStudentId, fSubject, fgrade);
        librus.addGrade(fStudentId, fSubject, (float) 4.5);
        assertFalse( librus.findStudent(fStudentId).getSubjectAndGrades().get(fSubject).contains((float) 3.0));
    }

    @Test
    @DisplayName("test addGrade method exception positive alpha")
    void testAddGradeExceptionPositiveAlpha(){
        assertThrows(NullPointerException.class, () -> librus.addGrade(fStudentId, fSubject, fgrade));
    }

    @Test
    @DisplayName("test addGrade method exception negative alpha")
    void testAddGradeExceptionNegativeAlpha(){
        librus.addSubject(fStudentId, fSubject);
        assertDoesNotThrow(() -> librus.addGrade(fStudentId, fSubject, fgrade));
    }

    @Test
    @DisplayName("test editGrade method positive alpha")
    void testEditGradePositiveAlpha(){
        librus.addSubject(fStudentId, fSubject);
        librus.addGrade(fStudentId, fSubject, fgrade);
        librus.editGrade(fStudentId, fSubject, 0, (float) 4.5);
        assertEquals((float) 4.5, (float) librus.findStudent(fStudentId).getSubjectAndGrades().get(fSubject).get(0));
    }

    @Test
    @DisplayName("test editGrade method negative alpha")
    void testEditGradeNegativeAlpha(){
        librus.addSubject(fStudentId, fSubject);
        librus.addGrade(fStudentId, fSubject, fgrade);
        librus.editGrade(fStudentId, fSubject, 0, (float) 4.5);
        assertNotEquals(fgrade, (float) librus.findStudent(fStudentId).getSubjectAndGrades().get(fSubject).get(0));
    }

    @Test
    @DisplayName("test editGrade method exception positive alpha")
    void testEditGradeExceptionPositiveAlpha(){
        librus.addSubject(fStudentId, fSubject);
        librus.addGrade(fStudentId, fSubject, fgrade);
        assertThrows(NullPointerException.class, () -> librus.editGrade(fStudentId, "Chemia", 0, (float) 4.5));

    }

    @Test
    @DisplayName("test editGrade method exception negative alpha")
    void testEditGradeExceptionNegativeAlpha(){
        librus.addSubject(fStudentId, "Chemia");
        librus.addGrade(fStudentId, "Chemia", fgrade);
        assertDoesNotThrow(() -> librus.editGrade(fStudentId, "Chemia", 0, (float) 4.5));
    }

    @Test
    @DisplayName("test deleteGrade method negative alpha")
    void testDeleteGradeNegativeAlpha(){
        librus.addSubject(fStudentId, fSubject);
        librus.addGrade(fStudentId, fSubject, fgrade);
        librus.addGrade(fStudentId, fSubject, (float) 4.5);
        librus.deleteGrade(fStudentId, fSubject, 0);
        assertNotEquals(fgrade, (float) librus.findStudent(fStudentId).getSubjectAndGrades().get(fSubject).get(0));

    }

    @Test
    @DisplayName("test deleteGrade method exception positive alpha")
    void testDeleteGradeExceptionPositiveAlpha(){
        librus.addSubject(fStudentId, fSubject);
        librus.addGrade(fStudentId, fSubject, fgrade);
        librus.deleteGrade(fStudentId, fSubject, 0);
        assertThrows(IndexOutOfBoundsException.class, () -> librus.findStudent(fStudentId).getSubjectAndGrades().get(fSubject).get(0));
    }

    @Test
    @DisplayName("test getAverageOfSubject method positive")
    void testGetAverageOfSubjectPositiveAlpha(){
        librus.addSubject(fStudentId, fSubject);
        librus.addGrade(fStudentId, fSubject, (float) 2.0 );
        librus.addGrade(fStudentId, fSubject, (float) 5.0);
        librus.addGrade(fStudentId, fSubject, (float) 2.0);
        librus.addGrade(fStudentId, fSubject, (float) 1.0);
        assertEquals((float) 2.5,  librus.getAverageOfSubject(fStudentId, fSubject));
    }

    @Test
    @DisplayName("test getAverageOfAllSubject method positive")
    void testGetAverageOfAllSubjectPositiveAlpha(){
        librus.addSubject(fStudentId, fSubject);
        librus.addSubject(fStudentId, "Chemia");
        librus.addGrade(fStudentId, fSubject, (float) 2.0 );
        librus.addGrade(fStudentId, fSubject, (float) 5.0);
        librus.addGrade(fStudentId, fSubject, (float) 3.0);
        librus.addGrade(fStudentId, fSubject, (float) 2.0);

        librus.addGrade(fStudentId, "Chemia", (float) 4.0);
        librus.addGrade(fStudentId, "Chemia", (float) 4.0);
        librus.addGrade(fStudentId, "Chemia", (float) 3.0);
        librus.addGrade(fStudentId, "Chemia", (float) 1.0);

        assertEquals((float) 3.0,  librus.getAverageOfAllSubjects(fStudentId));
    }


    @Test
    @DisplayName("test addNote method positive alpha")
    void testAddNotePositiveAlpha(){
        librus.addNote(fStudentId, "Czemu mam nieobecnosc za 30 marca skoro utworzylem repo?");
        assertEquals("Czemu mam nieobecnosc za 30 marca skoro utworzylem repo?", librus.findStudent(fStudentId).getNotes().get(0));

    }

    @Test
    @DisplayName("test editNote method positive alpha")
    void testEditNotePositiveAlpha(){
        librus.addNote(fStudentId, "Czemu mam nieobecnosc za 30 marca skoro utworzylem repo?");
        librus.editNote(fStudentId, 0, "Czemu nie mam policzych pkt za zadania 2 skoro jest usprawiedliowana nieboecnosc");
        assertEquals("Czemu nie mam policzych pkt za zadania 2 skoro jest usprawiedliowana nieboecnosc", librus.findStudent(fStudentId).getNotes().get(0));
    }

    @Test
    @DisplayName("test deleteNote method positive alpha")
    void testDeleteNotePositiveAlpha(){
        librus.addStudent("Ewa", "Celmer");
        librus.addNote(1, "Note 1");
        librus.addNote(1, "Note 2");
        librus.addNote(1, "Note 3");
        librus.deleteNote(1, 1);
        assertEquals("Note 3", librus.findStudent(1).getNotes().get(1));
    }

    @ParameterizedTest
    @DisplayName("test checkIfNull method parametrized")
    @ValueSource(strings = {"also not null", "not null"})
    void testCheckIfNullParametrized(String temp)
    {
        assertFalse(librus.checkIfNull(temp));
    }







}
