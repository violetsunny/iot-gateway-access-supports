codec.decodeMulti(function(dataStr,params) {
    var jsonObject = JSON.parse(dataStr);
    var res = jsonObject.result;
    if (res == null){
        $log.warn('data数据为空 {}',jsonObject);
        return null;
    }

    var array = res.items;
    if (array == null){
        $log.warn('res数据为空 {}',res);
        return null;
    }

    var requests = [];
    var modelRef = $ctx.modelRef('futianruiwo',params[1],null);

    array.forEach(function(data) {
        var timestamp = Date.now();
        var sn = data.deviceId + '';
        var deviceId = $ctx.getDeviceIdBySn('futianruiwo', sn);
        if (deviceId==null || deviceId==='' || !$ctx.validSnBelongProduct(sn,params[1])) {
            //没有对应的恩牛设备
            $log.warn('{} {} 没有对应的恩牛设备',sn,params[1]);
        } else {
            var reportRequest = {};
            reportRequest.deviceId=deviceId;
            reportRequest.messageType='DEVICE_REPORT_REQ';
            reportRequest.timeStamp=timestamp;
            reportRequest.ingestionTime=timestamp;

            var metrics = [];
            for (var key in data){
                if(data[key]!=null){
                    var metric = $ctx.modelRefMetric(key, modelRef);
                    var value = 'STrunning'.equals(metric)?'在线'.equals(data[key])?1:0:data[key];
                    metrics.push({code: metric, value: value,ts: Date.parse(data.updateTime)});
                }
            }

            if (metrics.length !== 0){
                reportRequest.metrics = metrics;
                requests.push(reportRequest);
            }

        }

    });
    return JSON.stringify(requests);
});