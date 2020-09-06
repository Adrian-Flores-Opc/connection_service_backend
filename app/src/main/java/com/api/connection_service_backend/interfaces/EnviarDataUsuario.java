package com.api.connection_service_backend.interfaces;

import com.api.connection_service_backend.models.DatosUsuarioRequest;
import com.api.connection_service_backend.models.GenericResponse;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface EnviarDataUsuario {
    @POST("ApiServicioAndroid/RecibirDataAndroid")
    Call<ResponseBody> GenericResponse(@Body RequestBody requestBody);
}
