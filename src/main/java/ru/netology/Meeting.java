package ru.netology;
import java.util.Objects;
public class Meeting extends Task{
    protected String topic;
    protected String project;
    protected String start;

    public Meeting(int id,String topic, String project, String start) {
        super(id); // вызов родительского конструктора
        this.project = project;
        this.start=start;
        this.topic=topic;
    }

        public String getTopic() {
        return topic;
    }

         public String getProject() {
         return project;
    }
    public String getStart() {
        return start;
    }
//    public void contains() {
//
//    }
    @Override
    public boolean matches(String query) {
        if (topic.contains(query)) {
            return true;
        }
        if (project.contains(query)) {
            return true;
        }else {
        return false;}
    }
}
