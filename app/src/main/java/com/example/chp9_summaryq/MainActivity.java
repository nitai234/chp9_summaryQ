package com.example.chp9_summaryq;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button game, highScore;
    TextView lastGamePoints, tvHighScore;
    Dialog highScoreD;

    SharedPreferences sp;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        game = findViewById(R.id.playGame);
        highScore = findViewById(R.id.highScore);
        lastGamePoints = findViewById(R.id.lastGamePoints);

        game.setOnClickListener(this);
        highScore.setOnClickListener(this);



    }


    @Override
    public void onClick(View view)
    {
        if (view == game)
        {
            Intent intent = new Intent(this, TriviaActivity.class);
           startActivityForResult(intent, 0);
        }
        else if (view == highScore)
        {
            highScoreD = new Dialog(this);
            highScoreD.setContentView(R.layout.high_score_dialog);
            highScoreD.setTitle("High Score");
            highScoreD.setCancelable(true);

            tvHighScore = highScoreD.findViewById(R.id.tvHighScore);
            tvHighScore.setText(sp.getInt("highScore", 0));
            highScoreD.show();


        }

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0)
        {
            int points = data.getExtras().getInt("points");
            tvHighScore.setText("ניקוד של המשחק האחרון: \n" + points);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.mine_menu, menu);
        menu.getItem(0).setShowAsActionFlags(MenuItem.SHOW_AS_ACTION_ALWAYS);

        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        super.onOptionsItemSelected(item);
        if (item.getItemId() == R.id.setting)
        {
            Intent intent = new Intent(this, Settins.class);
            startActivity(intent);
            return true;
        }
        return true;
    }
}