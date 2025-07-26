package cn.enncloud.iot.gateway.entity.tsl;

import lombok.Data;

import java.util.List;

@Data
public class Function {
    String code;
    List<Paramter> paramters;
}
