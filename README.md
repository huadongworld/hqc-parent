# hqc-parent
High quality code demo

# 向导

建议3：三元操作符的类型务必一致

建议7：警惕自增陷阱

建议18：避免instanceof非预期结果

建议19：断言绝对不是鸡肋

建议21：用偶判断，不用奇判断

建议28：优先使用整形池

建议31：接口中可以存在实现代码，但是尽量不要在接口中写实现

建议47：在equals中使用getClass进行类型判断

建议52：推荐使用String直接量赋值，因为String字符串是最经常使用的类型，所以String有个常量池的概念

建议63：在明确的场景下，为集合指定初始容量

建议65：避开基本类型数组转换列表陷阱

建议66：asList产生的List对象不可更改

建议70：子列表只是原列表的一个视图

建议76：集合运算时使用更优雅的方式

建议77：使用shuffle打乱列表的顺序

建议81：TreeSet重排序，非稳定排序推荐使用List

建议96：不同场景使用不同的泛型通配符

建议97：警惕泛型是不能够协变和逆变的

建议98：采用顺序List<T>、List<?>、List<Object>

建议101：注意Class类的特殊性

建议106：动态代理可以使代理模式更加灵活（不太懂）

建议110：提倡异常封装

建议121：线程池的创建方式

建议124：异步运算考虑使用Callable接口

建议126：实时选择不同的线程池来实现

建议127：Lock与synchronized是不一样的

附录：本地实现代理转发
