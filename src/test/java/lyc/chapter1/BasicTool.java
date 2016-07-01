package lyc.chapter1;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import org.junit.Test;


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
        System.out.println(newStr);
    }


    /**
     * 将方法的返回类型指定为 Optional，也可以迫使调用者思考返回的引用缺失的情形
     */
    @Test
    public void optional() {
        Optional<Integer> optional = Optional.absent();
        System.out.println(optional.isPresent());
        System.out.println(optional.or(3));
        System.out.println(optional.orNull());
        optional = Optional.of(5);
        System.out.println(optional.or(3));
        System.out.println(optional.asSet());
    }


    @Test
    public void other() {
        /**减少直接用Object.equal的null判断*/
        System.out.println(Objects.equal(null, "333"));
        /**对传入的字段序列计算出合理的、顺序敏感的散列值。*/
        int hc = Objects.hashCode("bbbb", "aaaa");
        System.out.println(hc);

        // Returns "ClassName{x=1}"
        String str = MoreObjects.toStringHelper(this).add("x", 1).toString();
        System.out.println(str);
        // Returns "MyObject{x=1}"
        str = MoreObjects.toStringHelper("MyObject").add("x", 1).toString();
        System.out.println(str);
    }

}
