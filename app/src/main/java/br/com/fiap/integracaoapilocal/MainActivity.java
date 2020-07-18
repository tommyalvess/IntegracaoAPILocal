package br.com.fiap.integracaoapilocal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView txtNome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNome = (TextView)findViewById(R.id.txtNome);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.20.22.41:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitDados api = retrofit.create(RetrofitDados.class);
        api.getDados().enqueue(new Callback<Contato>() {
            @Override
            public void onResponse(Call<Contato> call, Response<Contato> response) {
                Contato contato = response.body();
                Toast.makeText(MainActivity.this, contato.getNome(), Toast.LENGTH_SHORT).show();
                txtNome.setText(contato.getNome());
            }

            @Override
            public void onFailure(Call<Contato> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
