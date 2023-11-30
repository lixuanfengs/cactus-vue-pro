package cn.cactus.server;

import cn.cactus.framework.common.pojo.CommonResult;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static cn.cactus.framework.common.exception.enums.GlobalErrorCodeConstants.NOT_IMPLEMENTED;

/**
 * Package: cn.cactus.server
 * Description:
 * 项目的启动类
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/13 10:06
 * @Github https://github.com/lixuanfengs
 */
@SuppressWarnings("SpringComponentScan") // 忽略 IDEA 无法识别 ${cactus.info.base-package}
@SpringBootApplication(scanBasePackages = {"${cactus.info.base-package}.server", "${cactus.info.base-package}.module"})
public class CactusServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CactusServerApplication.class, args);
    }

}
