package cn.enncloud.iot.gateway.protocol.loader.script;

public interface ScriptFunction<M, P, R> {
    R execute(M msg, P params);
}
