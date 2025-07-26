package com.ennewiot.gateway.industrialalarm.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author DongLi
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonBackData implements Serializable {
    private Boolean isFalse;
}
