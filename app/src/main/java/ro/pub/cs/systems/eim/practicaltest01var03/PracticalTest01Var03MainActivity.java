package ro.pub.cs.systems.eim.practicaltest01var03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var03MainActivity extends AppCompatActivity {
    Button sndBtn;
    Button dispBtn;

    EditText studId;
    EditText grupaId;
    EditText fullId;

    CheckBox check1;
    CheckBox check2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var03_main);

        dispBtn = (Button)findViewById(R.id.dispBtn);
        sndBtn = (Button)findViewById(R.id.sndBtn);

        check1 = (CheckBox)findViewById(R.id.check1);
        check2 = (CheckBox)findViewById(R.id.check2);

        studId = (EditText)findViewById(R.id.studId);
        grupaId = (EditText)findViewById(R.id.grupaId);
        fullId = (EditText)findViewById(R.id.fullId);

        dispBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullData = "";
                String student = "";
                String grupa = "";

                student = studId.getText().toString();
                grupa = grupaId.getText().toString();

                if(check1.isChecked())
                    if ( student.length() > 0)
                        fullData += student;
                    else
                        Toast.makeText(PracticalTest01Var03MainActivity.this, "Campul Student trebuie  completat!", Toast.LENGTH_LONG).show();


                if(check2.isChecked() )
                    if (grupa.length() > 0)
                        fullData += grupa;
                    else
                        Toast.makeText(PracticalTest01Var03MainActivity.this, "Campul Grupa trebuie  completat!", Toast.LENGTH_LONG).show();


                fullId.setText(fullData);
                fullId.setVisibility(View.VISIBLE);
            }
        });

        sndBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String student = "";
                String grupa = "";

                student = studId.getText().toString();
                grupa = grupaId.getText().toString();

                Intent intent = new Intent(getApplicationContext(), PracticalTest01Var03SecondaryActivity.class);


                if (grupa.length() > 0) {
                    intent.putExtra("grupa", grupa);
                }

                if (student.length() > 0) {
                    intent.putExtra("student", student);
                }

                startActivity(intent);
            }
        });



    }
//
//        @Override
//        protected void onDestroy() {
//            Intent intent = new Intent(this, PracticalTest01Var03MainActivity.class);
//            stopService(intent);
//            super.onDestroy();
//        }

        @Override
        public void onSaveInstanceState(Bundle savedInstanceState) {

            //super.onSaveInstanceState(savedInstanceState);
            savedInstanceState.putString("name", studId.getText().toString());
            savedInstanceState.putString("grupa", grupaId.getText().toString());
            savedInstanceState.putString("full", fullId.getText().toString());
        }

        @Override
        public void onRestoreInstanceState(Bundle savedInstanceState) {

            if(savedInstanceState.containsKey("name"))
                studId.setText(savedInstanceState.getString("name"));

            if(savedInstanceState.containsKey("grupa"))
                grupaId.setText(savedInstanceState.getString("grupa"));

            if(savedInstanceState.containsKey("full"))
                fullId.setText(savedInstanceState.getString("full"));

        }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
       // if (requestCode == RESULT_OK) {
            Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
      //  }
    }

    }
