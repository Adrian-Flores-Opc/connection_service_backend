package com.api.connection_service_backend;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.api.connection_service_backend.interfaces.EnviarDataUsuario;
import com.api.connection_service_backend.models.DatosUsuarioRequest;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_enviar;
    EditText name,pass,email,cellular,user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_enviar = (Button) findViewById(R.id.btn_enviar);
        user = (EditText) findViewById(R.id.txt_user);
        pass = (EditText) findViewById(R.id.txt_pass);
        email = (EditText) findViewById(R.id.txt_email);
        cellular = (EditText) findViewById(R.id.txt_cellular);
        name = (EditText) findViewById(R.id.txt_name);


        btn_enviar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.15/WebApiAndroid/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        EnviarDataUsuario api = retrofit.create(EnviarDataUsuario.class);
        Gson Serializer = new Gson();

        DatosUsuarioRequest dmo = new  DatosUsuarioRequest();
        dmo.setPassCanal("Demian4545k!");
        dmo.setCanal("ADMIN");

        dmo.setUsuario(user.getText().toString());
        dmo.setPassword(pass.getText().toString());
        dmo.setCorreo_electronico(email.getText().toString());
        dmo.setCelular(cellular.getText().toString());
        dmo.setNombre(name.getText().toString());

        String json = Serializer.toJson(dmo);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),json);
        api.GenericResponse(requestBody).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    Toast.makeText(MainActivity.this, "Datos Ingresados Correctamente" + response.toString(), Toast.LENGTH_LONG).show();
                } catch (Exception EX){
                    Toast.makeText(MainActivity.this, EX.getMessage(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
        Limpiar();
    }
    public void Limpiar(){
        user.setText("");
        pass.setText("");
        email.setText("");
        cellular.setText("");
        name.setText("");
    }
}