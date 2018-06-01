package com.example.sergiomarchena.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sergiomarchena.myapplication.Common.Common;
import com.example.sergiomarchena.myapplication.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LogIn extends AppCompatActivity {

    EditText edtId, edtPassword;
    Button btnLogIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        edtId = (EditText)findViewById(R.id.edtPhone);
        edtPassword = (EditText)findViewById(R.id.edtPassword);
        btnLogIn = (Button)findViewById(R.id.btnLogIn);

        //INICIAR DATABSE FIREBASE
        FirebaseDatabase basedatos = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = basedatos.getReference("User");

        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final ProgressDialog dialogo = new ProgressDialog(LogIn.this);
                dialogo.setMessage("Waiting...");
                dialogo.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        // COMPROBAR QUE USUARIO EXISTE EN LA DB
                        if (dataSnapshot.child(edtId.getText().toString()).exists()) {
                            // OBTENER DATOS DEL USUARIO
                            dialogo.dismiss();
                            User ususario = dataSnapshot.child(edtId.getText().toString()).getValue(User.class);
                            ususario.setPhone(edtId.getText().toString());
                            if (ususario.getPassword().equals(edtPassword.getText().toString())) {
                                {
                                    Intent goHome = new Intent(LogIn.this,Home.class);
                                    Common.currentUser = ususario;
                                    startActivity(goHome);
                                    finish();
                                }
                            } else {
                                Toast.makeText(LogIn.this, "WRONG PASSWORD ", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            dialogo.dismiss();
                            Toast.makeText(LogIn.this, "USER DOESN'T EXIST", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
