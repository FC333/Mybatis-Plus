package com.zkx;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * @author DESK0
 * @date 2022/10/18 10:39
 */
//官网所提供的代码模板
public class FastAutoGeneratorTest {

    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://127.0.0.1:3306/MP?" +
                        "characterEncoding=utf-8&userSSL=false",
                "root", "0505")
                .globalConfig(builder -> {
                    builder.author("DESK0") // 设置作者
                            //.enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("C://Users//DESK0//IdeaProjects///Mybatis-Plus" +
                                    "//Generator-Test//src//main//java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.zkx") // 设置父包名
                            .moduleName("mybatisplus") // 设置父包模块名
                            // 设置mapper.Xml生成路径
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml,
                                    "C://Users//DESK0//IdeaProjects//Mybatis-Plus//" +
                                            "Generator-Test//src//main//resources//mapper"));
                })
                .strategyConfig(builder -> {
                    builder.addInclude("t_user") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();//执行
    }

}
