package com.example.firebase;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText etcarnet, etnombre, etcarrera, etsemestre;
    CheckBox cbactivo;
    Button btadicionar, btmodificar, btanular, bteliminar;
    String carnet, nombre, carrera, semestre,colecion="Estudiante";
    FirebaseFirestore db = FirebaseFirestore.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Asociar objetos Java on objetos Xml
        etcarnet=findViewById(R.id.etcarnet);
        etnombre=findViewById(R.id.etnombre);
        etcarrera=findViewById(R.id.etcarrera);
        etsemestre=findViewById(R.id.etsemestre);
        cbactivo=findViewById(R.id.cbactivo);
        btadicionar=findViewById(R.id.btadicionar);
        btmodificar=findViewById(R.id.btmodificar);
        btanular=findViewById(R.id.btanular);
        bteliminar=findViewById(R.id.bteliminar);
        etcarnet.requestFocus();
    }//fin metodo onCreate

    public void Adicionar(View view){
        //Validar que todos los datos se ingresen
        carnet=etcarnet.getText().toString();
        nombre=etnombre.getText().toString();
        carrera=etcarrera.getText().toString();
        semestre=etsemestre.getText().toString();
        if(!nombre.isEmpty() && !carnet.isEmpty() && !carrera.isEmpty() && !semestre.isEmpty()){

            // Create a new user with a first and last name
            Map<String, Object> alumno = new HashMap<>();
            alumno.put("Carnet", "carnet");
            alumno.put("Nombre", "nombre");
            alumno.put("Carrera", "carrera");
            alumno.put("Semestre", "semestre");

            alumno.put("Activo", "Si");

// Add a new document with a generated ID
            db.collection(colecion)
                    .add(alumno)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                         //   Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                            Toast.makeText(MainActivity.this, "Documento guardado", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                          //  Log.w(TAG, "Error adding document", e);
                        }
                    });

        }else {
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
            etcarnet.requestFocus();
        }

    }//fin metodo Adicionar


    private void Consultar documento (){
        carnet=etcarnet.getText().toString();
        if (!carnet.isEmpty())
           db.collection("users")
                   .get()
        {

        }else{
            T
        }
    }//fin metodo consultar documento


}

