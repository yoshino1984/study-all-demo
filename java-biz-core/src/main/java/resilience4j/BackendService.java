package resilience4j;


public class BackendService {
    private int count = 0;
    public String doSomething() {
        count++;
        if (count < 15 && (count % 2 == 0)) {
            //为了触发故障熔断
            throw new RuntimeException("错误调用次号:" + count);
        }
        if (count > 30 && (count % 2 == 0)) {
            try {
                //为了触发慢请求熔断
                Thread.sleep(550L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "成功调用次号(慢速):" + count;
        }
        else
            return "成功调用次号(快速):" + count;
    }
}