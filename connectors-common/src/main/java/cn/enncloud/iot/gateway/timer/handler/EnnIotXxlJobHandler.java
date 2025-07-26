package cn.enncloud.iot.gateway.timer.handler;

import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.IJobHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class EnnIotXxlJobHandler extends IJobHandler {

    public EnnIotXxlJobHandler() {
    }

    public void execute() {
        try {
            XxlJobHelper.log("HttpPollJobHandler,start.");
            String jobParam = XxlJobHelper.getJobParam();
            this.doExecute(jobParam);
        } catch (Exception exception) {
            log.warn("执行器执行异常", exception);
        }
    }


     public abstract boolean doExecute(String jobParam) throws Exception;
}
