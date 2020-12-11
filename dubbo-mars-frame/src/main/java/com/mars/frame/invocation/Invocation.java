package com.mars.frame.invocation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author gang.chen
 * @description
 * @time 2020/12/11 11:34
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Invocation implements Serializable {

    private String interfaceName;
    private String methodName;
    private Object[] params;
    private Class[] paramTypes;
}
