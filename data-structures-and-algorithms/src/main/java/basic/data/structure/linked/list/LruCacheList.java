package basic.data.structure.linked.list;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * LRU缓存淘汰算法链表实现
 *
 * @author wangxin
 * 2020/4/22 22:41
 * @since
 **/
@Getter
public class LruCacheList<T> {
    @JSONField(name = "lruCacheList")
    private final LinkedList<T> list;

    @JSONField(serialize = false)
    private final int capacity;

    public LruCacheList(int capacity) {
        list = new LinkedList<>();
        this.capacity = capacity;
    }

    public void add(T t) {
        list.remove(t);
        if (list.size() >= capacity) {
            System.out.println(list.removeLast());
        }
        list.addFirst(t);
    }

    public static void main(String[] args) {
        LruCacheList<Integer> list = new LruCacheList<>(2);
        list.add(1);
        list.add(2);
        list.add(1);
        list.add(3);
        System.out.println(JSON.toJSONString(list));
    }

}
