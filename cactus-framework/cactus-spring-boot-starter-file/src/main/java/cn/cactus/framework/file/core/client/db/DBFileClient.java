package cn.cactus.framework.file.core.client.db;

import cn.cactus.framework.file.core.client.AbstractFileClient;
import cn.hutool.extra.spring.SpringUtil;

/**
 * Package: cn.cactus.framework.file.core.client.db
 * Description:
 * 基于 DB 存储的文件客户端的配置类
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/24 15:55
 * @Github https://github.com/lixuanfengs
 */
public class DBFileClient extends AbstractFileClient<DBFileClientConfig> {

    private DBFileContentFrameworkDAO dao;

    public DBFileClient(Long id, DBFileClientConfig config) {
        super(id, config);
    }

    @Override
    protected void doInit() {
    }

    @Override
    public String upload(byte[] content, String path, String type) {
        getDao().insert(getId(), path, content);
        // 拼接返回路径
        return super.formatFileUrl(config.getDomain(), path);
    }

    @Override
    public void delete(String path) {
        getDao().delete(getId(), path);
    }

    @Override
    public byte[] getContent(String path) {
        return getDao().selectContent(getId(), path);
    }

    private DBFileContentFrameworkDAO getDao() {
        // 延迟获取，因为 SpringUtil 初始化太慢
        if (dao == null) {
            dao = SpringUtil.getBean(DBFileContentFrameworkDAO.class);
        }
        return dao;
    }

}
