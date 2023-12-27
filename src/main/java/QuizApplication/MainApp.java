package QuizApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    final static QuestionService service = new QuestionImplimentation();
    static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Select Option :");
        System.out.println("1. Add Question");
        System.out.println("2. Remove Question");
        System.out.println("3. Update Question");
        System.out.println("4. Display Question");
        System.out.println("5. Take Quiz");
        System.out.println("6. Exit");

        int ch = sc.nextInt();
        sc.nextLine();

        if (ch < 5) {
            System.out.println("Enter Password : ");
            String password = service.password();
            String pass = sc.nextLine();
            if (!pass.equals(password)) {
                System.exit(0);
            }
        }

        switch (ch) {
            case 1:
                addQuestion();
                break;
            case 2:
                removeQuestion();
                break;
            case 3:
                updateQuestion();
                break;
            case 4:
                displayQuestion();
                break;
            case 5:
                takeQuiz();
                break;
            case 6:
                System.exit(1);
                break;
            default:
                System.out.println("Invalid Option!!!");
        }
        main(args);

    }

    private static void takeQuiz() {
        List<Question> ques = service.displayQuestion();
        int marks = 0;
        for (Question q : ques) {
            System.out.println("Q" + q.getQuestionId() + " . " + q.getQuestion());
            System.out.println("1. " + q.getOption1());
            System.out.println("2. " + q.getOption2());
            System.out.println("3. " + q.getOption3());
            System.out.print("Enter Your Answer : ");
            String ans = sc.nextLine();

            if (ans.equals(q.getAnswer())) {
                marks += 5;
            } else {
                marks -= 2;
            }
        }

        System.out.println("\n\n\n----------------------------------");
        System.out.println("Your Total Marks : " + marks);
        System.exit(0);

    }

    private static void displayQuestion() {
        List<Question> ques = service.displayQuestion();


        for (Question q : ques) {
            System.out.println("Q" + q.getQuestionId() + " . " + q.getQuestion());
            System.out.println("1. " + q.getOption1());
            System.out.println("2. " + q.getOption2());
            System.out.println("3. " + q.getOption3());
            System.out.println("---->" + q.getAnswer());

        }
    }

    private static void updateQuestion() {
        System.out.println("Select Option : ");
        System.out.println("1. Modify option");
        System.out.println("2. Modify Question");
        int ch = sc.nextInt();
        switch (ch) {
            case 1 :
                modifyOption();
                break;
            case 2 :
                modifyQuestion();
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid option !!!");
        }

    }

    private static void modifyOption() {
        System.out.println("Enter Question Id : ");
        int id = sc.nextInt();
        System.out.println("Enter Option 1 : ");
        String opt1 = sc.nextLine();
        opt1 = sc.nextLine();
        System.out.println("Enter Option 2 : ");
        String opt2 = sc.nextLine();
        System.out.println("Enter Option 3 : ");
        String opt3 = sc.nextLine();
        System.out.println("Enter Answer : ");
        String ans = sc.nextLine();
        service.updateOption(id, opt1, opt2, opt3, ans);

    }

    private static void modifyQuestion() {
        System.out.println("Enter Question Id : ");
        int id = sc.nextInt();
        System.out.println("Enter Question : ");
        String ques = sc.nextLine();
        ques = sc.nextLine();

        service.updateQuestion(id, ques);
    }

    private static void removeQuestion() {
        System.out.println("Enter Question Id : ");
        int id = sc.nextInt();
        service.removeQuestion(id);
    }

    private static void addQuestion() {
        System.out.println("Enter Question : ");
        String question = sc.nextLine();

        System.out.println("Enter Option1 : ");
        String opt1 = sc.nextLine();
        System.out.println("Enter Option2 : ");
        String opt2 = sc.nextLine();
        System.out.println("Enter Option3 : ");
        String opt3 = sc.nextLine();
        System.out.println("Enter Answer : ");
        String ans = sc.nextLine();

        Question ques = new Question(question, opt1, opt2, opt3, ans);
        service.addQuestion(ques);
    }
}
