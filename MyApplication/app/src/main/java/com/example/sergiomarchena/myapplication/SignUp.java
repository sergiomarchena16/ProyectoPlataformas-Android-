package com.example.sergiomarchena.myapplication;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.sergiomarchena.myapplication.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class SignUp extends AppCompatActivity {

    MaterialEditText edtUserId, edtPassword, edtName;
    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edtName = (MaterialEditText)findViewById(R.id.edtName);
        edtUserId = (MaterialEditText)findViewById(R.id.edtPhone);
        edtPassword = (MaterialEditText)findViewById(R.id.edtPassword);
        btnSignUp = (Button)findViewById(R.id.btnSingUp);

        //INICIAR FIRE DATABSE
        FirebaseDatabase basedatos = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = basedatos.getReference("User");

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final ProgressDialog dialogo = new ProgressDialog(SignUp.this);
                dialogo.setMessage("Waiting...");
                dialogo.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // COMPROBAR SI USUARIO YA EXISTE
                        if (dataSnapshot.child(edtUserId.getText().toString()).exists()) {
                            dialogo.dismiss();
                            Toast.makeText(SignUp.this, "USER ALREADY EXISTS", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            dialogo.dismiss();
                            User usuario = new User(edtName.getText().toString(),edtPassword.getText().toString());
                            table_user.child(edtUserId.getText().toString()).setValue(usuario);
                            dialogo.show();
                            dialogo.dismiss();
                            Toast.makeText(SignUp.this, "NUEVO USUARIO CREADO", Toast.LENGTH_SHORT).show();
                            finish();
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
