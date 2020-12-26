package code.remove;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * @author wangxin
 * 2020/5/2 14:27
 * @since
 **/
@Setter
@Getter
public abstract class BaseRequest<T extends BaseResponse> {

    public String getFinalUrl(String baseUrl) {
        API api = getClass().getAnnotation(API.class);
        Objects.requireNonNull(api, "api url is null");
        return baseUrl + api.url();
    }

}
