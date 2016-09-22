package csaper6.michelwu.quizapp2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private TextView temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void activity_main_make_questions_button_clicked(View view) {
        startActivity(new Intent(this,MakeQuestions.class));
    }

    public void activity_main_answer_question_button_clicked(View view) {
        startActivity(new Intent(this, AnswerQuestions.class));
    }

    public void Toast_clicked(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences(MakeQuestions.EXTRA_MESSAGE,MODE_PRIVATE);
        Toast.makeText(MainActivity.this, sharedPreferences.getString("size","can't find any value"), Toast.LENGTH_SHORT).show();
    }
}
