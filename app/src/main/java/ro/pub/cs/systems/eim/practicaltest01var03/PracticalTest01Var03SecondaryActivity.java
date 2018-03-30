package ro.pub.cs.systems.eim.practicaltest01var03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01Var03SecondaryActivity extends AppCompatActivity {

    EditText studId;
    EditText grupaId;

    Button okButton;
    Button cancelButton;
    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.okBtn:
                    setResult(RESULT_OK, null);
                    break;
                case R.id.cancelBtn:
                    setResult(RESULT_CANCELED, null);
                    break;
            }
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var03_secondary);
        studId = (EditText)findViewById(R.id.studId);
        grupaId = (EditText)findViewById(R.id.grupaId);

        Intent intent = getIntent();

        if (intent != null && intent.getExtras().containsKey("grupa") && intent.getExtras().containsKey("student")) {
            String grupa = intent.getStringExtra("grupa");
            String student = intent.getStringExtra("student");

            studId.setText(student);
            grupaId.setText(grupa);

        }

        okButton = (Button)findViewById(R.id.okBtn);
        okButton.setOnClickListener(buttonClickListener);
        cancelButton = (Button)findViewById(R.id.cancelBtn);
        cancelButton.setOnClickListener(buttonClickListener);


    }
}
