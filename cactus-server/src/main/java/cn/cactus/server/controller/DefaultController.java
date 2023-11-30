package cn.cactus.server.controller;

import cn.cactus.framework.common.pojo.CommonResult;
import org.springframework.web.bind.annotation.RequestMapping;

import static cn.cactus.framework.common.exception.enums.GlobalErrorCodeConstants.NOT_IMPLEMENTED;

/**
 * Package: cn.cactus.server.controller
 * Description:
 * 默认 Controller，解决部分 module 未开启时的 404 提示。
 * 例如说，/bpm/** 路径，工作流
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/13 10:09
 * @Github https://github.com/lixuanfengs
 */
public class DefaultController {


    @RequestMapping("/admin-api/bpm/**")
    public CommonResult<Boolean> bpm404() {
        return null;
    }

    @RequestMapping("/admin-api/mp/**")
    public CommonResult<Boolean> mp404() {
        return CommonResult.error(NOT_IMPLEMENTED.getCode(),
                "[微信公众号 cactus-module-mp - 已禁用][参考 https://cactusli.net/ 开启]");
    }

    @RequestMapping(value = {"/admin-api/product/**", // 商品中心
            "/admin-api/trade/**", // 交易中心
            "/admin-api/promotion/**"})  // 营销中心
    public CommonResult<Boolean> mall404() {
        return CommonResult.error(NOT_IMPLEMENTED.getCode(),
                "[商城系统 cactus-module-mall - 已禁用][参考 https://cactusli.net/ 开启]");
    }

    @RequestMapping(value = {"/admin-api/report/**"})
    public CommonResult<Boolean> report404() {
        return CommonResult.error(NOT_IMPLEMENTED.getCode(),
                "[报表模块 cactus-module-report - 已禁用][参考 https://cactusli.net/ 开启]");
    }

    @RequestMapping(value = {"/admin-api/pay/**"})
    public CommonResult<Boolean> pay404() {
        return CommonResult.error(NOT_IMPLEMENTED.getCode(),
                "[支付模块 cactus-module-pay - 已禁用][参考 https://cactusli.net/ 开启]");
    }
}
