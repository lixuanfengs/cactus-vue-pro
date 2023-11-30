package cn.cactus.module.infra.service.file;

import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.framework.common.util.io.FileUtils;
import cn.cactus.framework.file.core.client.FileClient;
import cn.cactus.framework.file.core.utils.FileTypeUtils;
import cn.cactus.module.infra.controller.admin.file.vo.file.FilePageReqVO;
import cn.cactus.module.infra.dal.dataobject.file.FileDO;
import cn.cactus.module.infra.dal.mysql.file.FileMapper;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static cn.cactus.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.cactus.module.infra.enums.ErrorCodeConstants.FILE_NOT_EXISTS;

/**
 * Package: cn.cactus.module.infra.service.file
 * Description:
 * 文件 Service 实现类
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/28 10:27
 * @Github https://github.com/lixuanfengs
 */
@Service
public class FileServiceImpl implements FileService {

    @Resource
    private FileConfigService fileConfigService;

    @Resource
    private FileMapper fileMapper;

    @Override
    public PageResult<FileDO> getFilePage(FilePageReqVO pageReqVO) {
        return fileMapper.selectPage(pageReqVO);
    }

    @Override
    @SneakyThrows
    public String createFile(String name, String path, byte[] content) {
        // 计算默认的 path 名
        String type = FileTypeUtils.getMineType(content, name);
        if (StrUtil.isEmpty(path)) {
            path = FileUtils.generatePath(content, name);
        }
        // 如果 name 为空，则使用 path 填充
        if (StrUtil.isEmpty(name)) {
            name = path;
        }

        // 上传到文件存储器
        FileClient client = fileConfigService.getMasterFileClient();
        Assert.notNull(client, "客户端(master) 不能为空");
        String url = client.upload(content, path, type);

        // 保存到数据库
        FileDO file = new FileDO();
        file.setConfigId(client.getId());
        file.setName(name);
        file.setPath(path);
        file.setUrl(url);
        file.setType(type);
        file.setSize(content.length);
        fileMapper.insert(file);
        return url;
    }

    @Override
    public void deleteFile(Long id) throws Exception {
        // 校验存在
        FileDO file = validateFileExists(id);

        // 从文件存储器中删除
        FileClient client = fileConfigService.getFileClient(file.getConfigId());
        Assert.notNull(client, "客户端({}) 不能为空", file.getConfigId());
        client.delete(file.getPath());

        // 删除记录
        fileMapper.deleteById(id);
    }

    private FileDO validateFileExists(Long id) {
        FileDO fileDO = fileMapper.selectById(id);
        if (fileDO == null) {
            throw exception(FILE_NOT_EXISTS);
        }
        return fileDO;
    }

    @Override
    public byte[] getFileContent(Long configId, String path) throws Exception {
        FileClient client = fileConfigService.getFileClient(configId);
        Assert.notNull(client, "客户端({}) 不能为空", configId);
        return client.getContent(path);
    }

}
