package br.com.fiap.integracaoapilocal;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by rm77283 on 19/04/2017.
 */

public interface RetrofitDados {

    @GET("dados")
    Call<Contato> getDados();

}
