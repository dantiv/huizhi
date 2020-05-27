package shop.cowa.huizhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;

/**
 * @author huyuchang
 */
@SpringBootApplication
@EnableCaching
// @DubboComponentScan(basePackages = "shop.cowa.huizhi.service.impl")
public class HuizhiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HuizhiApplication.class, args);
	}

}
