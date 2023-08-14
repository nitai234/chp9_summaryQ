package com.example.chp9_summaryq;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Settins extends AppCompatActivity implements View.OnClickListener {
    Button addBack, back, zero;
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    Bitmap bitmap;
    ImageView imv;
    MainActivity mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settins);

        addBack = findViewById(R.id.addBack);
        zero = findViewById(R.id.zeroHighScore);
        back = findViewById(R.id.back);
        imv = mainActivity.findViewById(R.id.imv);

        editor = sp.edit();

        addBack.setOnClickListener(this);
        zero.setOnClickListener(this);
        back.setOnClickListener(this);

    }

    @Override
    public void onClick(View view)
    {
        if (view == addBack)
        {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 1);
        }
        else if (view == zero)
        {
            YesNoDialog();
        }
        else if (view == back)
        {
            Toast.makeText(this,"חוזר לתפריט הראשית", Toast.LENGTH_LONG).show();
            finish();
        }
    }
    public void YesNoDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("אזהרה!!");
        builder.setMessage("האם אתה בטוח שאתה רוצה לאפס את הניקוד?");
        builder.setPositiveButton("כן", new HandleAlertDialogClickListener());
        builder.setNegativeButton("לא", new  HandleAlertDialogClickListener());
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private final class HandleAlertDialogClickListener implements DialogInterface.OnClickListener
    {
        public void onClick(DialogInterface dialog, int which)
        {
            if (which == -1)
            {
                editor.putInt("highScore", 0);
                editor.commit();
                Toast.makeText(Settins.this,"הניקוד הגבוה התאפס", Toast.LENGTH_LONG).show();
            }
            else if (which == -2)
            {
                Toast.makeText(Settins.this,"בוטל", Toast.LENGTH_LONG).show();
            }
        }
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1)
        {
            if (resultCode == RESULT_OK)
            {
                bitmap = (Bitmap) data.getExtras().get("data");
                imv.setImageBitmap(bitmap);
            }
        }
    }
}