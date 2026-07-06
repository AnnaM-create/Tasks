import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TodosTest {

    @Test
    public void testSearch() {
        Todos todos = new Todos();


        todos.add(new SimpleTask(1, "Купить молоко"));
        todos.add(new SimpleTask(2, "Купить хлеб"));

        String[] subtasks = {"Сходить в магазин", "Купить молоко"};
        todos.add(new Epic(3, subtasks));

        todos.add(new meeting(4, "Планерка по продажам", "Отдел продаж", "09:00"));


        Task[] results = todos.search("молоко");




        assertEquals(2, results.length);


        assertEquals(1, results[0].getId());
        assertEquals(3, results[1].getId());
    }

    @Test
    public void testSearchEmptyResult() {
        Todos todos = new Todos();
        todos.add(new SimpleTask(1, "Купить молоко"));

        Task[] results = todos.search("космос");

        assertEquals(0, results.length);
    }
}