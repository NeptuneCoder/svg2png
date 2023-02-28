### 项目名：SVG2PNG批量 [中文](https://github.com/HaiYangCode/svg2png/blob/main/README.md)
### 项目介绍
该项目用于将svg图片批量转成png格式的图片
#### 用法

```kotlin
public static void main (String[] args) {
    System.out.println("Hello world!");
    //输入svg目录和目标目录
    svgToPng("/Users/yh/AndroidStudioProjects/Icons/icons", "/Users/yh/Downloads/png");
}

```

#### 存在问题
1. 不能根据svg尺寸大小定义图片打下，解决思路为解析svg的xml文件得到宽高。


#### 项目构建思路
1. 借助new bing提供了解题思路
2. 然后根据谷歌搜索解决遇到的具体问题

参考资料：https://blog.csdn.net/xwu_09/article/details/89881509