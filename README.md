# Lcps
 
《第一行代码》第一版第14章中的实践项目。

从头开始抄一个，可以帮助更多的理解书中的内容。熟悉整个项目后可以加一些自己的想法。 现在已经遇到两个坑：
 
+ 由于代码中字符串输入存在错误，而且这个错误是在拼成访问www.weather.com.cn网址中出现的，造成无法获取访问数据。很费劲地才查找出来。
 
 
+ 由于自己调试用机是一部比较旧的智能机（小米公司出的红米 Note2），仅支持Android 4.4，对应的Android SDK版本为19。
而代码中使用一个SDK24中的方法:SimpleDateFormat，AS在编译时给出警告。虽然可以通过指定SDK版本号后通过编译，但在旧版本的手机上运行时就出现错误。找到问题后，解决方法很容易，就是不有这种方法。
