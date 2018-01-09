package game.rafael.snake;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        int nivel = intent.getIntExtra(MainActivity.NIVEL_MESSAGE, 0);
        int score = intent.getIntExtra(MainActivity.SCORE_MESSAGE, 0);


        setContentView(R.layout.activity_score);

        TextView nivelText = (TextView)this.findViewById(R.id.niveltext);
        nivelText.setText(getString(R.string.nivel_label) + " " + nivel);

        TextView scoreText = (TextView)this.findViewById(R.id.scoretext);
        scoreText.setText(getString(R.string.score_label) + " " + score);

    }

    public void onButtonClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
