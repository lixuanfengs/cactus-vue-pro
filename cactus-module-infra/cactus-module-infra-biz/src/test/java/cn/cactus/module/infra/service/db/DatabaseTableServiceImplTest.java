package cn.cactus.module.infra.service.db;

import cn.cactus.framework.test.core.ut.BaseDbUnitTest;
import cn.cactus.module.infra.dal.dataobject.db.DataSourceConfigDO;
import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import org.apache.ibatis.type.JdbcType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;
import java.util.List;

import static cn.cactus.framework.test.core.util.RandomUtils.randomLongId;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

/**
 * Package: cn.cactus.module.infra.service.db
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/28 11:14
 * @Github https://github.com/lixuanfengs
 */
@Import(DatabaseTableServiceImpl.class)
public class DatabaseTableServiceImplTest extends BaseDbUnitTest {

    @Resource
    private DatabaseTableServiceImpl databaseTableService;

    @MockBean
    private DataSourceConfigService dataSourceConfigService;

    @Test
    public void testGetTableList() {
        // 准备参数
        Long dataSourceConfigId = randomLongId();
        // mock 方法
        DataSourceConfigDO dataSourceConfig = new DataSourceConfigDO().setUsername("sa").setPassword("")
                .setUrl("jdbc:h2:mem:testdb");
        when(dataSourceConfigService.getDataSourceConfig(eq(dataSourceConfigId)))
                .thenReturn(dataSourceConfig);

        // 调用
        List<TableInfo> tables = databaseTableService.getTableList(dataSourceConfigId,
                "config", "参数");
        // 断言
        assertEquals(1, tables.size());
        assertTableInfo(tables.get(0));
    }

    @Test
    public void testGetTable() {
        // 准备参数
        Long dataSourceConfigId = randomLongId();
        // mock 方法
        DataSourceConfigDO dataSourceConfig = new DataSourceConfigDO().setUsername("sa").setPassword("")
                .setUrl("jdbc:h2:mem:testdb");
        when(dataSourceConfigService.getDataSourceConfig(eq(dataSourceConfigId)))
                .thenReturn(dataSourceConfig);

        // 调用
        TableInfo tableInfo = databaseTableService.getTable(dataSourceConfigId, "infra_config");
        // 断言
        assertTableInfo(tableInfo);
    }

    private void assertTableInfo(TableInfo tableInfo) {
        assertEquals("infra_config", tableInfo.getName());
        assertEquals("参数配置表", tableInfo.getComment());
        assertEquals(13, tableInfo.getFields().size());
        // id 字段
        TableField idField = tableInfo.getFields().get(0);
        assertEquals("id", idField.getName());
        assertEquals(JdbcType.BIGINT, idField.getMetaInfo().getJdbcType());
        assertEquals("编号", idField.getComment());
        assertFalse(idField.getMetaInfo().isNullable());
        assertTrue(idField.isKeyFlag());
        assertTrue(idField.isKeyIdentityFlag());
        assertEquals(DbColumnType.LONG, idField.getColumnType());
        assertEquals("id", idField.getPropertyName());
        // name 字段
        TableField nameField = tableInfo.getFields().get(3);
        assertEquals("name", nameField.getName());
        assertEquals(JdbcType.VARCHAR, nameField.getMetaInfo().getJdbcType());
        assertEquals("名字", nameField.getComment());
        assertFalse(nameField.getMetaInfo().isNullable());
        assertFalse(nameField.isKeyFlag());
        assertFalse(nameField.isKeyIdentityFlag());
        assertEquals(DbColumnType.STRING, nameField.getColumnType());
        assertEquals("name", nameField.getPropertyName());
    }
}
