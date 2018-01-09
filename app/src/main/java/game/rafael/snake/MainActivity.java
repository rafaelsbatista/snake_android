package game.rafael.snake;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    public static final String NIVEL_MESSAGE = "game.rafael.snake.NIVELMESSAGE";
    public static final String SCORE_MESSAGE = "game.rafael.snake.SCOREMESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel_chooser);
    }

    public void onButtonClick(View view) {
        RadioButton radio2 = (RadioButton) this.findViewById(R.id.radioButton2);
        RadioButton radio3 = (RadioButton) this.findViewById(R.id.radioButton3);

        Intent intent = new Intent(this, SnakeActivity.class);
        int nivel = 1;
        if (radio2.isChecked()) {
            nivel = 2;
        } else if (radio3.isChecked()) {
            nivel = 3;
        }
        intent.putExtra(NIVEL_MESSAGE, nivel);
        startActivity(intent);
    }
}
