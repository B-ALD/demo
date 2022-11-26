package com.example.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class mybatisPlusGenerator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://127.0.0.1/mysql", "root", "123456")
                .globalConfig(builder -> {
                    builder.author("liuyl")//设置作者
                            .fileOverride()//覆盖已有文件
                            .outputDir(System.getProperty("user.dir") + "/src/main/java");//指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.example")
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, System.getProperty("user.dir") + "/src/main/java"));
                })
                .strategyConfig(builder -> {
                    builder.addInclude("mysql");
                })
                //使用Freemaker引擎模板，默认是Velocity模板
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}
