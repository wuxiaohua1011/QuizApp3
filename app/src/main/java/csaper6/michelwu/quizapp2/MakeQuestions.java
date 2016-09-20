package csaper6.michelwu.quizapp2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Set;

public class MakeQuestions extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
private Button back;
    private EditText text1;
    private Switch switch1;
    private String temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_questions);
        wireWidget();

    }

    private void wireWidget() {
        text1 = (EditText)findViewById(R.id.editText_1);
        switch1=(Switch)findViewById(R.id.switch_1);

    }

    public void activity_make_question_back_button_clicked(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void activity_make_question_done_button_clicked(View view) {
        if(switch1.isChecked() == true){
            temp = text1.getText().toString()+ 1;
        }
        else{
            temp = text1.getText().toString()+0;
        }
       SharedPreferences sharedPreferences = this.getPreferences(this.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(EXTRA_MESSAGE,temp);
        editor.commit();

        Toast.makeText(MakeQuestions.this, sharedPreferences.getString(EXTRA_MESSAGE,"Can't find any Value"), Toast.LENGTH_SHORT).show();
    }

}
