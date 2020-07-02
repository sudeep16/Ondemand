package com.agile.ondemand;

import com.agile.ondemand.api.UsersApi;
import com.agile.ondemand.serverresponse.SignUpResponse;
import com.agile.ondemand.url.Url;

import org.hamcrest.core.IsNull;
import org.junit.Test;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class testAPI {

    @Test
    public void testCon() throws IOException

    {
        UsersApi ondemandAPI= Url.getInstance().create(UsersApi.class);
        Call<SignUpResponse> call =ondemandAPI.checkUser("nischalshk","nischal123");
            try{
                    Response<SignUpResponse> response=call.execute();
                    SignUpResponse loginSignupResponse=response.body();
                    assertTrue(response.isSuccessful() );

    }
            catch (Exception ex)
            {
                ex.printStackTrace();

            }
    }


    @Test
    public void testTokenFail()
    {
        UsersApi ondemandAPI=Url.getInstance().create(UsersApi.class);
        Call<SignUpResponse> call =ondemandAPI.checkUser("Maxx","Maxx");
            try{
                Response<SignUpResponse> response=call.execute();
              Url.token=response.headers().get("Set Token");
                assertThat(Url.token,is(IsNull.notNullValue()));


    }
            catch (Exception ex)
            {
                ex.printStackTrace();

            }



    }

    @Test
    public void testTokenPass()
    {

    //    OndemandAPI ondemandAPI=Url.getInstance().create(OndemandAPI.class);
//        Call<LoginSignupResponse> call =ondemandAPI.checkUser("Maxx,"Maxx");
//            try{
//                Response<LoginSignupResponse> response=-call.execute();
//              Url.Token=response.headers().get("Set Token");
//                assertThat(Url.Token,is(IsNull.notNullValue()));
//
//
//    }
//            catch (Exception ex)
//            {
//                ex.printStackTrace();
//
//            }
    }





}
