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
        SimpleTask simpleTask2 = new SimpleTask(6, "Позвонить пингвину");
        SimpleTask simpleTask3= new SimpleTask(7, "Позвонить");
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(simpleTask2);
        todos.add(simpleTask3);

        Task[] expected = {simpleTask};
        Task[] actual = todos.search("Позвонить родителям");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSearchSimpleTwice() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        SimpleTask simpleTask2 = new SimpleTask(6, "Позвонить пингвину");
        SimpleTask simpleTask3= new SimpleTask(7, "Позвонить родителям");
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(simpleTask2);
        todos.add(simpleTask3);

        Task[] expected = {simpleTask, simpleTask3};
        Task[] actual = todos.search("Позвонить родителям");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSearchSimple() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        SimpleTask simpleTask2 = new SimpleTask(6, "Позвонить попугаю");
        SimpleTask simpleTask3= new SimpleTask(7, "Позвонить родителям");
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(simpleTask2);
        todos.add(simpleTask3);

        Task[] expected = {};
        Task[] actual = todos.search("Позвонить пингвину");
        Assertions.assertArrayEquals(expected, actual);
    }

        @Test
    public void shouldSearchEpic() {
            String[] subtasks1 = {"Молоко", "Яйца", "Хлеб"};
            String[] subtasks2 = {"Корова", "Курица", "Пшеница"};
            String[] subtasks3 = {"Молоко", "Яйца", "Нехлеб"};
            Epic epic1 = new Epic(55, subtasks1);
            Epic epic2 = new Epic(66, subtasks2);
            Epic epic3 = new Epic(77, subtasks3);
            Todos todos = new Todos();
            todos.add(epic1);
            todos.add(epic2);
            todos.add(epic3);
        Task[] expected =  {epic1};
        Task[] actual = todos.search("Хлеб");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSearchEpicTwice() {
        String[] subtasks1 = {"Молоко", "Яйца", "Хлеб"};
        String[] subtasks2 = {"Корова", "Курица", "Пшеница"};
        String[] subtasks3 = {"Молоко", "Яйца", "Хлеб"};
        Epic epic1 = new Epic(55, subtasks1);
        Epic epic2 = new Epic(66, subtasks2);
        Epic epic3 = new Epic(77, subtasks3);
        Todos todos = new Todos();
        todos.add(epic1);
        todos.add(epic2);
        todos.add(epic3);
        Task[] expected =  {epic1, epic3};
        Task[] actual = todos.search("Хлеб");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldNotSearchEpic() {
        String[] subtasks1 = {"Молоко", "Яйца", "Хлеб"};
        String[] subtasks2 = {"Корова", "Курица", "Пшеница"};
        String[] subtasks3 = {"Молоко", "Яйца", "Хлеб"};
        Epic epic1 = new Epic(55, subtasks1);
        Epic epic2 = new Epic(66, subtasks2);
        Epic epic3 = new Epic(77, subtasks3);
        Todos todos = new Todos();
        todos.add(epic1);
        todos.add(epic2);
        todos.add(epic3);
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
        Meeting meeting2 = new Meeting(
                666,
                "Выкатка 4й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        Meeting meeting3 = new Meeting(
                777,
                "Выкатка 5й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();
        todos.add(meeting);
        todos.add(meeting2);
        todos.add(meeting3);
        todos.search("Выкатка 3й версии приложения");
        Task[] expected = {meeting};
        Task[] actual = todos.search("Выкатка 3й версии приложения");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchMeetingTwice() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        Meeting meeting2 = new Meeting(
                666,
                "Выкатка 4й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        Meeting meeting3 = new Meeting(
                777,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();
        todos.add(meeting);
        todos.add(meeting2);
        todos.add(meeting3);

        todos.search("Выкатка 3й версии приложения");
        Task[] expected = {meeting, meeting3};
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
        Meeting meeting2 = new Meeting(
                666,
                "Выкатка 4й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        Meeting meeting3 = new Meeting(
                777,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();
        todos.add(meeting);
        todos.add(meeting2);
        todos.add(meeting3);
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

