package csaper6.michelwu.quizapp2;

/**
 * Created by micha on 9/19/2016.
 */
public class Question {
    private String question;
    private boolean answer;

    public Question(String question, boolean answer){
        this.question=question;
        this.answer=answer;
    }

    public Question(String compiledInput){
        if(Integer.parseInt(compiledInput.substring(compiledInput.length()-1)) == 1){
            answer = true;
        }
        else{
            answer = false;
        }
        question = compiledInput.substring(0,compiledInput.length()-1);
    }
    public String getQuestion(){
        return question;
    }
    public boolean getAnswer(){
        return answer;
    }

    public String getStringExport(){
        int temp;
        if(answer == true){
            temp = 1;
        }
        else{
            temp=0;
        }
        return question+temp;
    }

}
