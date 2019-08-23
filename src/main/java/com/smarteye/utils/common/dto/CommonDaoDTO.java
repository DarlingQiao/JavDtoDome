package com.smarteye.utils.common.dto;

import lombok.Data;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 类实现描述：基类
 * yinjie 2018/11/2 10:42
 */
@Data
public abstract class CommonDaoDTO extends CommonDTO
{
    public CommonDaoDTO()
    {
        // 为了可以使用 @Data 注解而加
    }

    private transient LinkedHashMap<String, Object> source;
    public CommonDaoDTO(LinkedHashMap<String, Object> source)
    {
        this.source = source;
        commonConvertDTO();
        convertDTO();
    }

    // 唯一标识
    private Long id;

    /**
     * 如果有一些特殊的属性需要赋值, 可以在这个方法中处理
     */
    public abstract void convertDTO();

    public void commonConvertDTO()
    {
        for (String key : source.keySet())
        {
            try
            {
                String fieldName = convertName(key);
                Field field = this.getClass().getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(this, source.get(key));
            }
            catch (IllegalAccessException | NoSuchFieldException e)
            {
                e.printStackTrace();
            }
        }
    }

    private String convertName(String fieldName)
    {
        fieldName = fieldName.toLowerCase();
        char[] names = new char[fieldName.toCharArray().length];
        int i = 0;
        boolean upOff = false;
        for (char c : fieldName.toCharArray())
        {
            if (c == '_')
            {
                upOff = true;
                continue;
            }
            if (upOff)
            {
                upOff = false;
                names[i] = Character.toUpperCase(c);
            }
            else
            {
                names[i] = c;
            }
            i++;
        }
        return String.valueOf(names).trim();
    }
}
