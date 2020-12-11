package com.mars.frame.register;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gang.chen
 * @description
 * @time 2020/12/11 9:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class URL {
    private String hostname;
    private Integer port;
}
