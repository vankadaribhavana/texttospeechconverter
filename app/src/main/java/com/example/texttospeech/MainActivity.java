package com.example.texttospeech;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.Button;
import android.widget.EditText;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText Text;
    Button btnText;
    Button button2;
    TextToSpeech mTts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Text = findViewById(R.id.ettext);
        btnText = findViewById(R.id.button);
        button2=findViewById(R.id.button2);
        mTts = new TextToSpeech(getApplicationContext()
                , i -> {
                    if (i == TextToSpeech.SUCCESS) {
                        mTts.setLanguage(Locale.ENGLISH);
                    } //else { Toast.makeText(MainActivity.this, "Failed!", Toast.LENGTH_SHORT).show(); }//
                     });

        // Adding OnClickListener
        btnText.setOnClickListener(v -> {
            String s=Text.getText().toString();
             mTts.speak(s, TextToSpeech.QUEUE_FLUSH,null);
        });

        button2.setOnClickListener(view -> Text.setText(""));
    }
}