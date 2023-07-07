package sg.edu.rp.c346.id22021798.l08ps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    Button insert, show;
    EditText sTitle, singers, yOr;
    RadioGroup rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insert = findViewById(R.id.insert);
        show = findViewById(R.id.display);
        sTitle = findViewById(R.id.title);
        singers = findViewById(R.id.singer);
        yOr = findViewById(R.id.year);
        rating = findViewById(R.id.star);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);
                int ratingID = rating.getCheckedRadioButtonId();
                String star = "";
                if(ratingID == R.id.one){
                    star = "1";
                }else if(ratingID == R.id.two){
                    star = "2";
                }else if(ratingID == R.id.three){
                    star = "3";
                }else if(ratingID == R.id.four){
                    star = "4";
                }else{
                    star = "5";
                }
                db.insertSong(sTitle.getText().toString(), singers.getText().toString(), Integer.parseInt(yOr.getText().toString()), star);
                db.close();
            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, list.class);
                startActivity(intent);
            }
        });

    }
}