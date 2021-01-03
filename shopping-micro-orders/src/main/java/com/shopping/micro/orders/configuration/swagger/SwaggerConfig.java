package com.shopping.micro.orders.configuration.swagger;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author ldc
 * @Date 2020/12/24 11:58
 * @Version 1.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

//  访问地址： http://localhost:8080/swagger-ui.html

    @Bean
     public Docket createRestApi() {
         return new Docket(DocumentationType.SWAGGER_2)
         .apiInfo(apiInfo())
         .select()
         // 设置basePackage会将包下的所有类的所有方法作为api
//                .apis(RequestHandlerSelectors.basePackage("com.example.demo2.controller"))
         //只有标记了@ApiOperation的方法才会暴露出给swagger
         .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
         .paths(PathSelectors.any())
         .build();
     }


     private ApiInfo apiInfo() {
         //swagger2中termsOfServiceUrl方法已经启用，且contact的参数时一个对象，弃用字符串了
//         Contact构造函数中3个参数依次是：作者，地址，邮箱
         Contact contact=new Contact("Gao",
                         "https://www.cnblogs.com/dz-boss/p/11729334.html","270589787@qq.com");
         return new ApiInfoBuilder()
         .title("xx项目说明文档")
         .description("xx系统说明")
         //.termsOfServiceUrl("https://www.cnblogs.com/dz-boss/p/11729334.html")
         .contact(contact)
         .version("1.0")
         .build();
     }


}
