package csaper6.michelwu.quizapp2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AnswerQuestions extends AppCompatActivity implements View.OnClickListener{
private Button previous,next, buttonTrue,buttonFalse,back;
    private TextView question;
    private ArrayList<Question> questionBank = new ArrayList<Question>();
    private int questionBankSize;
    private int currentQuestionIndex = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_questions);
        wireWidget();
        addListener();
        putStringBackToQuestionAndToquestionBank();
        questionBankSize = questionBank.size();
    }

    private void putStringBackToQuestionAndToquestionBank() {
        SharedPreferences sharedPreferences = getSharedPreferences(MakeQuestions.EXTRA_MESSAGE,MODE_PRIVATE);
        int tempSize = Integer.parseInt(sharedPreferences.getString("size",""+0));
        for (int i = 1;i<=tempSize;i++){
            Question tempQuestion = new Question(sharedPreferences.getString("key"+1,"Question Not Found"));
            questionBank.add(tempQuestion);
        }
    }

    private void wireWidget() {
        previous = (Button)findViewById(R.id.activity_answer_questions_previous_button);
        next = (Button)findViewById(R.id.activity_answer_questions_next_button);
        back = (Button)findViewById(R.id.activity_answer_questions_back_button);
        buttonTrue = (Button)findViewById(R.id.activity_answer_questions_true_button);
        buttonFalse=(Button)findViewById(R.id.activity_answer_questions_false_button);
        question = (TextView)findViewById(R.id.activity_answer_questions_question_textview);
    }

    private void addListener() {
        previous.setOnClickListener(this);
        next.setOnClickListener(this);
        back.setOnClickListener(this);
        buttonFalse.setOnClickListener(this);
        buttonTrue.setOnClickListener(this);
    }

    private Question getCurrentQuestion(int index){
        if(index >= questionBankSize){
            currentQuestionIndex=0;index=0;
            return questionBank.get(index);
        }
        else if(index<0){
            currentQuestionIndex=questionBankSize-1;index=questionBankSize-1;return questionBank.get(index);
        }
        else {
            return questionBank.get(index);
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.activity_answer_questions_back_button:
                startActivity(new Intent(this, MainActivity.class));break;
            case  R.id.activity_answer_questions_false_button:
                if(false == getCurrentQuestion(currentQuestionIndex).getAnswer()){
                    Toast.makeText(AnswerQuestions.this, "Congratulation", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(AnswerQuestions.this, "Too bad", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.activity_answer_questions_true_button:
                if(true == getCurrentQuestion(currentQuestionIndex).getAnswer()){
                    Toast.makeText(AnswerQuestions.this, "Congratulation", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(AnswerQuestions.this, "Too bad", Toast.LENGTH_SHORT).show();
                }
                break;



            case R.id.activity_answer_questions_next_button:
                currentQuestionIndex++;
                question.setText(getCurrentQuestion(currentQuestionIndex).getQuestion());
                Toast.makeText(AnswerQuestions.this, "Next" + questionBankSize, Toast.LENGTH_SHORT).show();
                break;


            case R.id.activity_answer_questions_previous_button:
                currentQuestionIndex--;
                question.setText(getCurrentQuestion(currentQuestionIndex).getQuestion());
                Toast.makeText(AnswerQuestions.this, "Previous", Toast.LENGTH_SHORT).show();
                break;


            default:
                Toast.makeText(AnswerQuestions.this, "ERROR", Toast.LENGTH_SHORT).show();break;
        }


    }
}
