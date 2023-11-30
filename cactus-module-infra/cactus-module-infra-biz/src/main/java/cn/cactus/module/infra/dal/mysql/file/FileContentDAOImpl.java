package cn.cactus.module.infra.dal.mysql.file;

import cn.cactus.framework.file.core.client.db.DBFileContentFrameworkDAO;
import cn.cactus.module.infra.dal.dataobject.file.FileContentDO;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * Package: cn.cactus.module.infra.dal.mysql.file
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 15:53
 * @Github https://github.com/lixuanfengs
 */
@Repository
public class FileContentDAOImpl implements DBFileContentFrameworkDAO {

    @Resource
    private FileContentMapper fileContentMapper;

    @Override
    public void insert(Long configId, String path, byte[] content) {
        FileContentDO entity = new FileContentDO().setConfigId(configId)
                .setPath(path).setContent(content);
        fileContentMapper.insert(entity);
    }

    @Override
    public void delete(Long configId, String path) {
        fileContentMapper.delete(buildQuery(configId, path));
    }

    @Override
    public byte[] selectContent(Long configId, String path) {
        List<FileContentDO> list = fileContentMapper.selectList(
                buildQuery(configId, path).select(FileContentDO::getContent).orderByDesc(FileContentDO::getId));
        return Optional.ofNullable(CollUtil.getFirst(list))
                .map(FileContentDO::getContent)
                .orElse(null);
    }

    private LambdaQueryWrapper<FileContentDO> buildQuery(Long configId, String path) {
        return new LambdaQueryWrapper<FileContentDO>()
                .eq(FileContentDO::getConfigId, configId)
                .eq(FileContentDO::getPath, path);
    }

}
