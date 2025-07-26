codec.decodeMulti(function(dataStr,params) {
    var jsonObject1 = JSON.parse(dataStr);
    var array = jsonObject1.data;
    if (array == null){
        $log.warn('{} {} {} data数据为空 {}',params[2],params[0],params[1],jsonObject1);
        return null;
    }
    var requests = [];
    var modelRef = $ctx.modelRef(params[2],params[1],null);
    array.forEach(function(data) {
        var timestamp = Date.now();
        var sn = data.shutterDoorCode;
        var deviceId = $ctx.getDeviceIdBySn(params[2], sn);
        if (deviceId==null || deviceId==='' || !$ctx.validSnBelongProduct(sn,params[1])) {
            //没有对应的恩牛设备
            $log.warn('{} {} {} {} 没有对应的恩牛设备',params[2],params[0],params[1],sn);
        } else {
            var reportRequest = {};
            reportRequest.deviceId=deviceId;
            reportRequest.messageType='DEVICE_REPORT_REQ';
            reportRequest.timeStamp=timestamp;
            reportRequest.ingestionTime=timestamp;

            var metrics = [];
            var time = Date.parse(data.shutterDoorStatusTime);
            time = time==null?timestamp:time;
            for (var key in data){
                if(data[key]!=null){
                    var metric = $ctx.modelRefMetric(key, modelRef);
                    metrics.push({code: metric, value: data[key],ts: time});
                }
            }
            if (metrics.length !== 0){
                reportRequest.metrics = metrics;
                requests.push(reportRequest);
            } else {
                $log.warn('{} {} {} {} 没有对应的测点',params[2],params[0],params[1],sn);
            }
        }
    });
    return JSON.stringify(requests);
});
