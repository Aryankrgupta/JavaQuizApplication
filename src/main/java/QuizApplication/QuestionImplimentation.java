package QuizApplication;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionImplimentation implements QuestionService{
    private static Connection conn;

    static {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/questiondb?user=root&password=");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addQuestion(Question question) {
        String qry = "insert into question_info2 (question, opt1, opt2, opt3, ans) values(?, ?, ?, ?, ?)";
        try {
            PreparedStatement stat = conn.prepareStatement(qry);
            stat.setString(1, question.getQuestion());
            stat.setString(2, question.getOption1());
            stat.setString(3, question.getOption2());
            stat.setString(4, question.getOption3());
            stat.setString(5, question.getAnswer());
            stat.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Insert error");
        }
    }

    @Override
    public void removeQuestion(int id) {
        String qry = "delete from question_info2 where question_id = ?";

        try {
            PreparedStatement stat = conn.prepareStatement(qry);
            stat.setInt(1, id);
            stat.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateQuestion(int id, String ques) {
        String qry = "update question_info2 set question = ? where question_id = ?";

        try {
            PreparedStatement stat = conn.prepareStatement(qry);
            stat.setString(1, ques);
            stat.setInt(2, id);
            stat.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateOption(int id, String opt1, String opt2, String opt3, String ans) {
        String qry = "update question_info2 set opt1 = ?, opt2 = ?, opt3 = ?, ans = ? where question_id = ?";

        try{
            PreparedStatement stat = conn.prepareStatement(qry);
            stat.setString(1, opt1);
            stat.setString(2, opt2);
            stat.setString(3, opt3);
            stat.setString(4, ans);
            stat.setInt(5, id);
            stat.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public List<Question> displayQuestion() {
        String qry = "select * from question_info2";
        List<Question> list = new ArrayList<>();
        try {
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(qry);

            while (rs.next()) {
                Question ques = new Question(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                list.add(ques);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;

    }
    @Override
    public String password() {
        String qry = "select password from password2";
        String pass = "";
        Statement stat = null;
        try {
            stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(qry);
            while (rs.next()) {
                pass = rs.getString(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pass;
    }
}
