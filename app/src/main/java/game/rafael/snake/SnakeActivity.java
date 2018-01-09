package game.rafael.snake;

import android.content.Intent;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;

public class SnakeActivity extends AppCompatActivity {

    SnakeEngine snakeEngine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        int nivel = intent.getIntExtra(MainActivity.NIVEL_MESSAGE, 0);

        Display display = getWindowManager().getDefaultDisplay();

        Point size = new Point();
        display.getSize(size);

        snakeEngine = new SnakeEngine(this, size, nivel);
        setContentView(snakeEngine);
    }

    @Override
    protected void onResume() {
        super.onResume();
        snakeEngine.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        snakeEngine.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        snakeEngine.destroy();
    }

    public void showScoreActivity(int nivel, int score) {
        Intent intent = new Intent(this, ScoreActivity.class);
        intent.putExtra(MainActivity.NIVEL_MESSAGE, nivel);
        intent.putExtra(MainActivity.SCORE_MESSAGE, score);
        startActivity(intent);
    }
}
