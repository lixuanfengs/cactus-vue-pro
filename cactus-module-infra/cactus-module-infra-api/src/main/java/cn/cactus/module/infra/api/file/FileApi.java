package cn.cactus.module.infra.api.file;

/**
 * Package: cn.cactus.module.infra.api.file
 * Description:
 * 文件 API 接口
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/23 16:42
 * @Github https://github.com/lixuanfengs
 */
public interface FileApi {

    /**
     * 保存文件，并返回文件的访问路径
     *
     * @param content 文件内容
     * @return 文件路径
     */
    default String createFile(byte[] content) {
        return createFile(null, null, content);
    }

    /**
     * 保存文件，并返回文件的访问路径
     *
     * @param path 文件路径
     * @param content 文件内容
     * @return 文件路径
     */
    default String createFile(String path, byte[] content) {
        return createFile(null, path, content);
    }

    /**
     * 保存文件，并返回文件的访问路径
     *
     * @param name 文件名称
     * @param path 文件路径
     * @param content 文件内容
     * @return 文件路径
     */
    String createFile(String name, String path, byte[] content);

}

