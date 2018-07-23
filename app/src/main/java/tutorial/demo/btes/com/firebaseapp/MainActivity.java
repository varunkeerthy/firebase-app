package tutorial.demo.btes.com.firebaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("message");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                TextView textView = (TextView) findViewById(R.id.textView);
                textView.setText(value);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }

    protected void buttonClicked(View view) {

        EditText editText = (EditText) findViewById(R.id.message);
        String incomingMessage = editText.getText().toString();

        myRef.setValue(incomingMessage);
    }
}
