package code.remove;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wangxin
 * 2020/5/2 14:44
 * @since
 **/
public class Application {

    public static <T extends BaseResponse> T remoteCall(Request request) {
        String finalUrl = request.getFinalUrl("base/url/");
        System.out.println(finalUrl);
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(request.getClass().getDeclaredFields())
            .filter(field -> field.isAnnotationPresent(RequestField.class))
            .sorted(Comparator.comparingInt(a -> a.getAnnotation(RequestField.class).order()))
            .peek(field -> field.setAccessible(true))
            .forEach(field -> {
                Object value = null;
                try {
                    value = field.get(request);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                if (stringBuilder.length() != 0) {
                    stringBuilder.append("&");
                }
                stringBuilder.append(field.getName()).append("=").append(value);
            });
        System.out.println(stringBuilder);
        String res = stringBuilder.toString();

        Type type = request.getClass().getGenericSuperclass();
        //ParameterizedType参数化类型，即泛型
        ParameterizedType p = (ParameterizedType)type;
        //getActualTypeArguments获取参数化类型的数组，泛型可能有多个
        Class<Object> c = (Class<Object>) p.getActualTypeArguments()[0];
        return (T)JSON.parseObject("{}", c);
    }
    public static void main(String[] args) {
        Request request = new Request();
        request.setAction("action");
        request.setCode("code");
        Response response = remoteCall(request);
        System.out.println(JSON.toJSONString(response));

    }
}
