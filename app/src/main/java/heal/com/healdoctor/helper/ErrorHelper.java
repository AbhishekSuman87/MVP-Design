package heal.com.healdoctor.helper;

import java.io.IOException;
import java.lang.annotation.Annotation;

import heal.com.healdoctor.network.BaseResponse;
import heal.com.healdoctor.network.RetrofitInstance;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

public class ErrorHelper {

    public static BaseResponse parseError(Response<?> response) {
        if (response != null) {
            Converter<ResponseBody, BaseResponse> converter =
                    RetrofitInstance.getRetrofitInstance().responseBodyConverter(BaseResponse.class, new Annotation[0]);

            BaseResponse error = null;

            try {
                if (response.errorBody() != null) {
                    error = converter.convert(response.errorBody());
                }
            } catch (IOException e) {
                return null;
            }

            return error;
        }
        return null;
    }
}