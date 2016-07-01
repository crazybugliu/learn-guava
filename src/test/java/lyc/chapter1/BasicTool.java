package lyc.chapter1;

import com.google.common.base.*;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import org.junit.Test;

import java.util.Collections;
import java.util.List;


public class BasicTool {

    /**
     * checkNotNull 直接返回检查的参数，让你可以在构造函数中保持字段的单行赋值风格
     * 简单的、参数可变的 printf 风格异常信息
     */
    @Test
    public void preconditions() {
        int i = -1;
        Preconditions.checkArgument(i >= 0, "Argument was %s but expected nonnegative", i);
    }

    @Test
    public void preconditions2() {
        String str = null;//"d";
        String newStr = Preconditions.checkNotNull(str, "str was expected not null");
        println(newStr);
    }


    /**
     * 将方法的返回类型指定为 Optional，也可以迫使调用者思考返回的引用缺失的情形
     */
    @Test
    public void optional() {
        Optional<Integer> optional = Optional.absent();
        println(optional.isPresent());
        println(optional.or(3));
        println(optional.orNull());
        optional = Optional.of(5);
        println(optional.or(3));
        println(optional.asSet());
    }


    @Test
    public void ordering() {
        List<ExampleBean> list = Lists.newArrayList(new ExampleBean(1, "dd"), new ExampleBean(3, "aa"));
        /** 排序  流式调用， 指定排序类型、字段 */
        Ordering<ExampleBean> ordering = Ordering.natural().nullsFirst().onResultOf(new Function<ExampleBean, String>() {
            public String apply(ExampleBean foo) {
                return foo.getName();
            }
        });

        Collections.sort(list, ordering);
    }


    @Test
    public void other() {
        /**减少直接用Object.equal的null判断*/
        println(Objects.equal(null, "333"));
        /**对传入的字段序列计算出合理的、顺序敏感的散列值。*/
        int hc = Objects.hashCode("bbbb", "aaaa");
        println(hc);

        /**toStringHelper ， 没看出怎么好用*/
        // Returns "ClassName{x=1}"
        String str = MoreObjects.toStringHelper(this).add("x", 1).toString();
        println(str);
        // Returns "MyObject{x=1}"
        str = MoreObjects.toStringHelper("MyObject").add("x", 1).toString();
        println(str);

        ExampleBean bean = new ExampleBean(123, "yourName");
        str = MoreObjects.toStringHelper(bean).toString();
        println(str);
    }


    public void println(Object obj) {
        System.out.println(obj);
    }

}
