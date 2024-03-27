import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import ru.netology.*;


import java.util.Objects;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSimple() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        Todos todos = new Todos();
        todos.add(simpleTask);
        //simpleTask.matches("Позвонить родителям");
        todos.search("Позвонить родителям");


        Task[] expected = {simpleTask};
        Task[] actual = todos.search("Позвонить родителям");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSearchSimple() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        Todos todos = new Todos();
        todos.add(simpleTask);

        Task[] expected = {};
        Task[] actual = todos.search("Позвонить пингвину");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        Todos todos = new Todos();
        todos.add(epic);
        Task[] expected =  {epic};
        Task[] actual = todos.search("Хлеб");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldNotSearchEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        Todos todos = new Todos();
        todos.add(epic);
        Task[] expected = {};
        Task[] actual = todos.search("Паста");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();
        todos.add(meeting);
        todos.search("Выкатка 3й версии приложения");
        Task[] expected = {meeting};
        Task[] actual = todos.search("Выкатка 3й версии приложения");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldNotSearchMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();
        todos.add(meeting);
        Task[] expected = {};
        Task[] actual = todos.search("Что-то там");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldMatchedSimple() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        Todos todos = new Todos();
        todos.add(simpleTask);
        boolean expected = true;
        boolean actual = simpleTask.matches("Позвонить родителям");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldMatchedEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        Todos todos = new Todos();
        todos.add(epic);
        boolean expected = true;
        boolean actual = epic.matches("Хлеб");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldMatchedMeetingTo() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();
        todos.add(meeting);
        boolean expected = true;
        boolean actual = meeting.matches("Выкатка 3й версии приложения");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldMatchedMeetingPr() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();
        todos.add(meeting);
        boolean expected = true;
        boolean actual = meeting.matches("Приложение НетоБанка");
        Assertions.assertEquals(expected, actual);
    }
}

