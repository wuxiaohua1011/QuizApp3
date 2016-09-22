package csaper6.michelwu.quizapp2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Set;

public class MakeQuestions extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    private int numberOfEntry;
    private int editTextId = 1000;
    private int switchId = 2000;
    private LinearLayout verticalLayout;
    private ArrayList<Question> questionBank = new ArrayList<Question>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_questions);
        wireInitialWidget();
        numberOfEntry=0;

    }

    private void wireInitialWidget() {
        verticalLayout = (LinearLayout)findViewById(R.id.activity_make_question_vertical_linearlayout);

    }

    public void activity_make_question_back_button_clicked(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void activity_make_question_done_button_clicked(View view) {
        loadQuestions();

        SharedPreferences sharedPreferences = this.getSharedPreferences(EXTRA_MESSAGE,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        for(int i = 1; i <= numberOfEntry; i ++){
            editor.putString("key" + i, questionBank.get(i-1).getStringExport());
        }
        editor.putString("size","" + numberOfEntry);
        editor.commit();
        Toast.makeText(MakeQuestions.this, ""+numberOfEntry, Toast.LENGTH_SHORT).show();
    }

    private void loadQuestions() {
        for(int i = 1; i <= numberOfEntry; i ++)
        {
            EditText textTemp; int textId = editTextId + i;
            Switch switchTemp; int switchId2 = switchId + i;

            textTemp = (EditText)findViewById(textId);
            switchTemp = (Switch)findViewById(switchId2);

            Question questionTemp = new Question(textTemp.getText().toString(),switchTemp.isChecked());
            questionBank.add(questionTemp);
        }
    }


    public void activity_make_question_more_button_clicked(View view) {
        numberOfEntry++;
        LinearLayout horizontal = new LinearLayout(this);
        horizontal.setOrientation(LinearLayout.HORIZONTAL);
        horizontal.setMinimumHeight(16);
        horizontal.setId(numberOfEntry);
        verticalLayout.addView(horizontal);
        addQuestionAndAnswer(horizontal);
    }
    public void addQuestionAndAnswer(LinearLayout horizontal){
        EditText editText = new EditText(this);
        editText.setId(editTextId+numberOfEntry);
        editText.setMinimumWidth(128);
        editText.setMaxHeight(8);
        horizontal.addView(editText);

        Switch answer = new Switch(this);
        answer.setId(switchId+numberOfEntry);
        answer.setMinHeight(64);
        answer.setTextSize((float)16);
        answer.setText("False/True");
        horizontal.addView(answer);
    }
}
