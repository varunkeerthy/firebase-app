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
    }

    protected void buttonClicked(View view) {

        EditText name = (EditText) findViewById(R.id.name);
        EditText contact = (EditText) findViewById(R.id.contact);
        String childRecordName = name.getText().toString();
        myRef = database.getReference("users").child(childRecordName);

        myRef.child("name").setValue(childRecordName);
        myRef.child("contact").setValue(contact.getText().toString());


    }
}
