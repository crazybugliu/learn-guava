package lyc.chapter1;

import com.google.common.collect.ComparisonChain;

public class ExampleBean implements Comparable {
    private int id;
    private String name;

    public ExampleBean(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int compareTo(Object o) {
        if (!(o instanceof ExampleBean)) {
            return -1;
        }
        ExampleBean that = (ExampleBean) o;

        /**流式写法，简化代码*/
        return ComparisonChain.start()
                .compare(this.id, that.id)
                .compare(this.name, that.name)
                .result();
    }
}
