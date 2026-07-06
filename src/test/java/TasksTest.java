import org.junit.jupiter.api.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class TasksTest {

    @Test
    public void testSimpleTaskMatches() {

        SimpleTask task = new SimpleTask(1, "Купить молоко");



        assertTrue(task.matches("молоко"));




        assertFalse(task.matches("хлеб"));
    }
    @Test
    public void testEpicMatches() {
        String[] subtasks = {"Позвонить врачу", "Купить лекарства", "Сделать зарядку"};
        Epic epic = new Epic(2, subtasks);

        assertTrue(epic.matches("врачу"));
        assertTrue(epic.matches("лекарства"));
        assertFalse(epic.matches("спорт"));
    }

    @Test
    public void testMeetingMatches() {
        meeting meeting = new meeting(3, "Обсуждение дизайна", "Проект Х", "10:00");

        assertTrue(meeting.matches("дизайна"));
        assertTrue(meeting.matches("Проект Х"));
        assertFalse(meeting.matches("10:00"));
    }
}