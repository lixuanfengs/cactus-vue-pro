package cn.cactus.framework.excel.core.convert;


import cn.cactus.framework.common.util.json.JsonUtils;
import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

/**
 * Package: cn.cactus.framework.excel.core.convert
 * Description:
 * Excel Json 转换器
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/15 9:41
 * @Github https://github.com/lixuanfengs
 */
public class JsonConvert implements Converter<Object> {
    @Override
    public Class<?> supportJavaTypeKey() {
        throw new UnsupportedOperationException("暂不支持，也不需要");
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        throw new UnsupportedOperationException("暂不支持，也不需要");
    }

    @Override
    public WriteCellData<String> convertToExcelData(Object value, ExcelContentProperty contentProperty,
                                                    GlobalConfiguration globalConfiguration) {
        // 生成 Excel 小表格
        return new WriteCellData<>(JsonUtils.toJsonString(value));
    }

}
