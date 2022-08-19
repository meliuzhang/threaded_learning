

## 7-1 什么是CAS
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200614143716587.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzI1MjkyNDE5,size_16,color_FFFFFF,t_70)

### 模拟CAS操作，等价代码
```java
package cas;

/**
 * 描述：     模拟CAS操作，等价代码
 */
public class SimulatedCAS {
    private volatile int value;

    public synchronized int compareAndSwap(int expectedValue, int newValue) {
        int oldValue = value;
        if (oldValue == expectedValue) {
            value = newValue;
        }
        return oldValue;
    }
}

```

### CAS的缺点
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200614145413817.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzI1MjkyNDE5,size_16,color_FFFFFF,t_70)
ABA问题：
认为V的值应该是A，如果是的话那我就把他改成B，如果不是A（说明被别人修改过了），那我就不修改了。但是存在其他人把值改为了C再改为A的情况。这样就出现了ABA问题。

