package code.remove;

import lombok.Data;

/**
 * @author wangxin
 * 2020/5/2 14:27
 * @since
 **/
@API(url = "url/string")
@Data
public class Request extends BaseRequest<Response>{
    @RequestField(order = 2, maxLength = 10, required = true)
    private String action;
    @RequestField(order = 1, maxLength = 10, required = true)
    private String code;
}
