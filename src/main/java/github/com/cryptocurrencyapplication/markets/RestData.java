package github.com.cryptocurrencyapplication.markets;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RestData {

    @GET("trading/ticker")
    Call<ResponseBody> getMarkets();
}
