package other.bitmap;

import org.junit.Assert;
import org.roaringbitmap.IntConsumer;
import org.roaringbitmap.RoaringBitmap;

/**
 * RoaringBitMap 的 demo
 *
 * @author wangxin
 * 2021/1/9 00:24
 * @since
 **/
public class RoaringBitMapDemo {

    public static void main(String[] args) {
        RoaringBitmap rr = RoaringBitmap.bitmapOf(1, 2, 3, 1000);
        RoaringBitmap rr2 = new RoaringBitmap();
        // add 4000-4255
        rr2.add(4000L, 4255L);

        // new bitmap
        RoaringBitmap rror = RoaringBitmap.or(rr, rr2);
        // in-place computation
        rr.or(rr2);
        Assert.assertEquals(rror, rr);
        // number of values stored?
        long cardinality = rr.getLongCardinality();
        System.out.println("cardinality=" + cardinality);
        rr.forEach((IntConsumer) System.out::println);
    }
}
