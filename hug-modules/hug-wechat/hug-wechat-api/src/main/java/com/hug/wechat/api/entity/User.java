package com.hug.wechat.api.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-04-11 13:29
 */
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "t_user")
public class User extends Model {
    @TableId("id")
    private String id;
    @TableField("name")
    private String name;
    @TableField("age")
    private int age;

}
