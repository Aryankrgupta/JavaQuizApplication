package QuizApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public interface QuestionService {

    public void addQuestion(Question question);
    public void removeQuestion(int id);
    public void updateQuestion(int id, String ques);
    public void updateOption(int id, String opt1, String opt2, String opt3, String ans);

    public List<Question> displayQuestion();

    public String password();
}
