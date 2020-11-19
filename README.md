## <font color='purple'>1. 引言</font>
最近在网上找MyBatisPlus代码生成工具类，找到的都不太满意，所以自己重写并开源到了Github，里面的代码实现细节不用过多的关注，只需要知道怎么配置和使用就可以了，下面来讲解下。

## <font color='purple'>2. 效果演示</font>
### <font color='purple'> Step1：首先配置数据库信息</font>
把项目clone到本地，打开工程可以看到目录的结构如下图，其它的内容不用去看，只需要配置下图的数据库连接信息即可。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201119171307879.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzIwMDQyOTM1,size_16,color_FFFFFF,t_70#pic_center)


### <font color='purple'> Step2：运行项目，生成代码</font>
好了，我们启动项目（CodeGeneratorApp）：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201119171410209.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzIwMDQyOTM1,size_16,color_FFFFFF,t_70#pic_center)
运行成功后，在浏览器打开swagger：[http://127.0.0.1:52013/swagger-ui.html](http://127.0.0.1:52013/swagger-ui.html)，可以看到有三个方法，可以把指定的表生成到不同的目录：

![在这里插入图片描述](https://img-blog.csdnimg.cn/20201119171739973.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzIwMDQyOTM1,size_16,color_FFFFFF,t_70#pic_center)

#### <font color='purple'>功能1： 生成代码到指定的目录</font>
在swagger这样配置，描述如下：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201119172737167.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzIwMDQyOTM1,size_16,color_FFFFFF,t_70#pic_center)


Excute执行之后，可以在指定的路径里看到生成了文件夹：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201119172811692.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzIwMDQyOTM1,size_16,color_FFFFFF,t_70#pic_center)
里面有相应的mapper文件：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201119172842652.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzIwMDQyOTM1,size_16,color_FFFFFF,t_70#pic_center)
也有相应的controller、mapper、model、service的代码：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201119172907587.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzIwMDQyOTM1,size_16,color_FFFFFF,t_70#pic_center)

#### <font color='purple'>功能2： 生成代码到target</font>
都是在swagger操作，流程与上图大致相同，效果图如下：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201119173417707.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzIwMDQyOTM1,size_16,color_FFFFFF,t_70#pic_center)
#### <font color='purple'>功能3： 生成zip</font>
都是在swagger操作，流程一样：
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020111917353476.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzIwMDQyOTM1,size_16,color_FFFFFF,t_70#pic_center)
下载后解压就能看到里面的内容了：
![在这里插入图片描述](https://img-blog.csdnimg.cn/202011191736254.png#pic_center)

## <font color='purple'>3. 其它细节</font>
当然有些细节还需要我们去配置的，比如说生成的包名和注释作者的名称等，具体可以在`generator.properties`文件里配置，如下图：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201119173740350.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzIwMDQyOTM1,size_16,color_FFFFFF,t_70#pic_center)
还有就是如果模板不符合自己的要求，可以自己配置vm模板，里面都写好了，看了就知道如何配置了

![在这里插入图片描述](https://img-blog.csdnimg.cn/20201119173936444.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzIwMDQyOTM1,size_16,color_FFFFFF,t_70#pic_center)


好了，本文讲解到此讲解完毕，希望能帮助到大家！