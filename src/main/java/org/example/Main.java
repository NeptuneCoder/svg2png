package org.example;

import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        svgToPng("/Users/yh/AndroidStudioProjects/Icons/icons", "/Users/yh/Downloads/png");
    }


    public static void svgToPng(String sourcePath, String targetPath) {
        // 创建一个 Transcoder 实例
        PNGTranscoder t = new PNGTranscoder();
        t.addTranscodingHint(PNGTranscoder.KEY_WIDTH, 60f);
        t.addTranscodingHint(PNGTranscoder.KEY_HEIGHT, 60f);

// 获取源文件夹和目标文件夹
        File sourceDir = new File(sourcePath); // 这里是你存放 SVG 文件的文件夹路径
        File targetDir = new File(targetPath); // 这里是你想要保存 PNG 文件的文件夹路径

// 判断源文件夹和目标文件夹是否存在，如果不存在则创建
        if (!sourceDir.exists()) {
            System.out.println("源文件夹不存在");
            return;
        }
        if (!targetDir.exists()) {
            targetDir.mkdirs();
        }

// 获取源文件夹中的所有 SVG 文件
        File[] files = sourceDir.listFiles((dir, name) -> {
            return name.endsWith(".svg"); // 只筛选出以 .svg 结尾的文件
        });

// 遍历所有的 SVG 文件，并转换为 PNG 文件
        for (File file : files) {
            try {
                // 创建输入源
                String svgPath = file.getAbsolutePath(); // 获取 SVG 文件的绝对路径
                TranscoderInput input = new TranscoderInput(new FileInputStream(svgPath));


                //        // 设置输出属性

                // 创建输出源
                String pngPath = targetDir.getAbsolutePath() + File.separator + "icon_" + file.getName().replace(".svg", ".png"); // 生成 PNG 文件的绝对路径，替换掉 .svg 后缀为 .png 后缀
                OutputStream ostream = new FileOutputStream(pngPath);
                TranscoderOutput output = new TranscoderOutput(ostream);

                // 执行转换
                t.transcode(input, output);

                // 关闭流
                ostream.flush();
                ostream.close();

                System.out.println("成功转换 " + svgPath + " 为 " + pngPath);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

