package csaper6.michelwu.quizapp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class AnswerQuestions extends AppCompatActivity implements View.OnClickListener{
private Button previous,next, buttonTrue,buttonFalse,back;
    private TextView question;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_questions);
        wireWidget();
        addListener();
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

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.activity_answer_questions_back_button:
                startActivity(new Intent(this, MainActivity.class));break;
            case  R.id.activity_answer_questions_false_button:
                Toast.makeText(AnswerQuestions.this, "You are ", Toast.LENGTH_SHORT).show();
                break;
            case R.id.activity_answer_questions_true_button:
                Toast.makeText(AnswerQuestions.this, "You are", Toast.LENGTH_SHORT).show();break;
            case R.id.activity_answer_questions_next_button:
                Toast.makeText(AnswerQuestions.this, "Next", Toast.LENGTH_SHORT).show();break;
            case R.id.activity_answer_questions_previous_button:
                Toast.makeText(AnswerQuestions.this, "Previous", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(AnswerQuestions.this, "ERROR", Toast.LENGTH_SHORT).show();break;
        }


    }
}
