#编码规范
##命名规范
1. **包命名**  
包名所有部分都用 `小写`，前缀是一个顶级域名，通常是 **com net org cc**，第二域是 `公司名`，第三域是 `项目名`。  
*example*： **cc.thecampus.xiaoxiao**  
2. **类命名**：使用 [大驼峰式命名法](http://baike.baidu.com/link?url=Sa5pW2KrG5v21runD8gvGgKC9CBM04X2EYIeA2mgFL9NCb-XamrsczUro5o0Xk3pW_jBnT8o-olFmENfdZibz_)  
*example*： **BaseActivity**  
3. **方法命名**：使用 [小驼峰式命名法](http://baike.baidu.com/link?url=Sa5pW2KrG5v21runD8gvGgKC9CBM04X2EYIeA2mgFL9NCb-XamrsczUro5o0Xk3pW_jBnT8o-olFmENfdZibz_)  
类的获取方法前置 `get`，设置方法前置 `set`，布尔型判断方法不用 `get`，用 `is` 或者 `equal`；  
*example*： **getAge()** 、 **setAge(age)** 、 **isFemale()**  
方法的第一个单词尽可能采用动词  
*example*： **addHandler()**  
4. **变量命名**：使用 *小驼峰式命名法*  
`成员变量` 不带 **m** 字前缀！  
*example*： **imageLoader**  
5. **View命名**  
种类 + 名字，`layout id`的命名保持和变量一直，方便使用 **ButterKnife** 注解  
*example*： **textViewName** 、 **btnLoad** 、 **eidtTextAge**  
6. **常量命名**  
全部大写，单词间用下划线隔开  
*example*： **MAX_WIDTH**  
7. **xml资源文件命名** `layout` `drawable` `menu`  
所有文件名全部小写，单词间以下划线分割。
 - 图标前缀： **ic_**
 - 背景前缀： **bg_**
 - 选择器前缀： **selector_**
 - 列表View的子视图前缀： **item_**
 - 其他前缀： **activity_** 、 **fragment_** 、 **menu_**
 - 名称后缀应该为状态词： **_normal** 、 **_pressed**  
*example*： **bg_btn_done_normal**

##包路径规则
1. **\**：src 项目根目录下存放以下类
 - Activity
 - Application 可存放全局静态常量
2. **beans**
3. **fragments**
4. **widgets**
5. **adapters**
6. **utils**
7. **network**
8. **services**
9. **receivers**
10. **other...**  

*example：*  
```
- com.thecampus.xiaoxiao
    - adapters
        - ToolAdapter.java
    - beans
        - ToolBean.java
    - fragments
        - DiscoverFragment.java
    - lib
        - YiLib.java    //jni lib
    - network
        - API.java    //服务器端API
        - XiaoxiaoRequest.java
    - utils
        - ImageUtils.java
    - widgets
        - PoImageView.java
    - MyApplication.java
    - MainActivity.java
```

##BaseActivity
- [BaseActivity.java](http://git.oschina.net/nekocode/nekoblog/blob/master/category/android/src/BaseActivity.java)

##Note
- 网络调用用Runnable Callback

##避免一些坏习惯
1. **Duplicated Code**  
代码重复几乎是最常见的异味了。他也是Refactoring 的主要目标之一。代码重复往往来自于copy-and-paste 的编程风格。
2. **Long method**  
它是传统结构化的“遗毒“。一个方法应当具有自我独立的意图，不要把几个意图
放在一起。
3. **Large Class**  
大类就是你把太多的责任交给了一个类。这里的规则是One Class One Responsibility。
4. **Divergent Change**  
一个类里面的内容变化率不同。某些状态一个小时变一次，某些则几个月一年才变一次；某些状态因为这方面的原因发生变化，而另一些则因为其他方面的原因变一次。面向对象的抽象就是把相对不变的和相对变化相隔离。把问题变化的一方面和另一方面相隔离。这使得这些相对不变的可以重用。问题变化的每个方面都可以单独重用。这种相异变化的共存使得重用非常困难。
5. **Shotgun Surgery**  
这正好和上面相反。对系统一个地方的改变涉及到其他许多地方的相关改变。这些变化率和变化内容相似的状态和行为通常应当放在同一个类中。
6. **Feature Envy**  
对象的目的就是封装状态以及与这些状态紧密相关的行为。如果一个类的方法频繁用get 方法存取其他类的状态进行计算，那么你要考虑把行为移到涉及状态数目最多的那个类。
7. **Data Clumps**  
某些数据通常像孩子一样成群玩耍：一起出现在很多类的成员变量中，一起出现在许多方法的参数中…..，这些数据或许应该自己独立形成对象。
8. **Primitive Obsession**  
面向对象的新手通常习惯使用几个原始类型的数据来表示一个概念。譬如对于范围，他们会使用两个数字。对于Money，他们会用一个浮点数来表示。因为你没有使用对象来表达问题中存在的概念，这使得代码变的难以理解，解决问题的难度大大增加。好的习惯是扩充语言所能提供原始类型，用小对象来表示范围、金额、转化率、邮政编码等等。
9. **Switch Statement**  
基于常量的开关语句是OO 的大敌，你应当把他变为子类、state 或strategy。
10. **Parallel Inheritance Hierarchies**  
并行的继承层次是shotgun surgery 的特殊情况。因为当你改变一个层次中的某一个类时，你必须同时改变另外一个层次的并行子类。
11. **Lazy Class**  
一个干活不多的类。类的维护需要额外的开销，如果一个类承担了太少的责任，应当消除它。
12. **Speculative Generality**  
一个类实现了从未用到的功能和通用性。通常这样的类或方法唯一的用户是testcase。不要犹豫，删除它。
13. **Temporary Field**  
一个对象的属性可能只在某些情况下才有意义。这样的代码将难以理解。专门建立一个对象来持有这样的孤儿属性，把只和他相关的行为移到该类。最常见的是一个特定的算法需要某些只有该算法才有用的变量。
14. **Message Chain**  
消息链发生于当一个客户向一个对象要求另一个对象，然后客户又向这另一对象要求另一个对象，再向这另一个对象要求另一个对象，如此如此。这时，你需要隐藏分派。
15. **Middle Man**  
对象的基本特性之一就是封装，而你经常会通过分派去实现封装。但是这一步不能走得太远，如果你发现一个类接口的一大半方法都在做分派，你可能需要移去这个中间人。
16. **Inappropriate Intimacy**  
某些类相互之间太亲密，它们花费了太多的时间去砖研别人的私有部分。对人类而言，我们也许不应该太假正经，但我们应当让自己的类严格遵守禁欲主义。
17. **Alternative Classes with Different Interfaces**  
做相同事情的方法有不同的函数signature，一致把它们往类层次上移，直至协议一致。
18. **Incomplete Library Class**  
要建立一个好的类库非常困难。我们大量的程序工作都基于类库实现。然而，如此广泛而又相异的目标对库构建者提出了苛刻的要求。库构建者也不是万能的。有时候我们会发现库类无法实现我们需要的功能。而直接对库类的修改有非常困难。这时候就需要用各种手段进行Refactoring。
19. **Data Class**  
对象包括状态和行为。如果一个类只有状态没有行为，那么肯定有什么地方出问题了。
20. **Refused Bequest**  
超类传下来很多行为和状态，而子类只是用了其中的很小一部分。这通常意味着你的类层次有问题。
21. **Comments**  
经常觉得要写很多注释表示你的代码难以理解。如果这种感觉太多，表示你需要Refactoring。



 