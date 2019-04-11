package com.hug.demo.api.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-04-11 13:29
 */
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private int age;

}
