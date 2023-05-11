package com.xk.yupao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * 自定义 Swagger 接口文档的配置
 */
@Configuration
@EnableSwagger2WebMvc
@Profile({"dev", "test"})
public class SwaggerConfig {

    @Bean(value = "defaultApi2")
    public Docket defaultApi2(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("webApi")
                //调用apiInfo方法,创建一个ApiInfo实例,
                .apiInfo(webApiInfo())
                .select()
                //控制器controller的位置
                .apis(RequestHandlerSelectors.basePackage("com.xk.yupao.controller"))
                .paths(PathSelectors.any())
                .build();

    }


    // api文档的详细信息
    private ApiInfo webApiInfo(){

        return new ApiInfoBuilder()
                .title("AT用户中心")    //标题
                .description("AT用户中心接口文档")  //描述
                .termsOfServiceUrl("https://gitee.com/x-2022-k")
                .version("1.0")  //版本
                .contact(new Contact("ATT", "https://gitee.com/x-2022-k", "xiaoK202010@163.com  "))
                .build();
    }
}

