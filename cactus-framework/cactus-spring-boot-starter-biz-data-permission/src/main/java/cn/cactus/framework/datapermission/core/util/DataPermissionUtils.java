package cn.cactus.framework.datapermission.core.util;

import cn.cactus.framework.datapermission.core.annotation.DataPermission;
import cn.cactus.framework.datapermission.core.aop.DataPermissionContextHolder;
import lombok.SneakyThrows;

/**
 * Package: cn.cactus.framework.datapermission.core.util
 * Description:
 * 数据权限 Util
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/23 16:40
 * @Github https://github.com/lixuanfengs
 */
public class DataPermissionUtils {

    private static DataPermission DATA_PERMISSION_DISABLE;

    @DataPermission(enable = false)
    @SneakyThrows
    private static DataPermission getDisableDataPermissionDisable() {
        if (DATA_PERMISSION_DISABLE == null) {
            DATA_PERMISSION_DISABLE = DataPermissionUtils.class
                    .getDeclaredMethod("getDisableDataPermissionDisable")
                    .getAnnotation(DataPermission.class);
        }
        return DATA_PERMISSION_DISABLE;
    }

    /**
     * 忽略数据权限，执行对应的逻辑
     *
     * @param runnable 逻辑
     */
    public static void executeIgnore(Runnable runnable) {
        DataPermission dataPermission = getDisableDataPermissionDisable();
        DataPermissionContextHolder.add(dataPermission);
        try {
            // 执行 runnable
            runnable.run();
        } finally {
            DataPermissionContextHolder.remove();
        }
    }

}

