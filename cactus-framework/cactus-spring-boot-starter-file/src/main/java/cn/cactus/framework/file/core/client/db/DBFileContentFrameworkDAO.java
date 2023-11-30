package cn.cactus.framework.file.core.client.db;

/**
 * Package: cn.cactus.framework.file.core.client.db
 * Description:
 * 文件内容 Framework DAO 接口
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/24 15:55
 * @Github https://github.com/lixuanfengs
 */
public interface DBFileContentFrameworkDAO {

    /**
     * 插入文件内容
     *
     * @param configId 配置编号
     * @param path 路径
     * @param content 内容
     */
    void insert(Long configId, String path, byte[] content);

    /**
     * 删除文件内容
     *
     * @param configId 配置编号
     * @param path 路径
     */
    void delete(Long configId, String path);

    /**
     * 获得文件内容
     *
     * @param configId 配置编号
     * @param path 路径
     * @return 内容
     */
    byte[] selectContent(Long configId, String path);

}
