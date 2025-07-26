codec.decodeMulti(function(dataStr,params) {
    var jsonObject = JSON.parse(dataStr);
    var req1 = jsonObject.data;
    if(req1==null){
        $log.warn('data数据为空 {}',jsonObject);
        return null;
    }
    var sn = req1.ie;
    var deviceId = $ctx.getDeviceIdBySn('yunyangaiot', sn);
    if (deviceId==null || deviceId==='') {
        //没有对应的恩牛设备
        $log.warn('{} 没有对应的恩牛设备',sn);
        return null;
    }

    var requests = [];
    var timestamp = Date.now();
    var reportRequest = {};
    reportRequest.deviceId=deviceId;
    reportRequest.messageType='DEVICE_REPORT_REQ';
    reportRequest.timeStamp=timestamp;
    reportRequest.ingestionTime=timestamp;

    var datatime = Date.parse(req1.onlineTimeStr);
    var data = req1.data;

    var metrics = [];
    var modelRef = null;
    if (params[1]!=null){
        modelRef = $ctx.modelRef(null,params[1]);
    }

    if (modelRef!=null){
        for (var key in modelRef){
            if (data.hasOwnProperty(key)) {
                var measureRef = modelRef[key];
                if('online'.equals(key)){
                    metrics.push({ code: measureRef.ennMeasureCode, value: req1[key],ts: datatime});
                } else if (data.hasOwnProperty(key)) {
                    metrics.push({ code: measureRef.ennMeasureCode, value: data[key],ts: datatime});
                }
            }
        }
    } else {
        var metricData = {'wec':'ECwaterQuality','ah':'H','wph':'PHwaterQuality','at':'Tair','online':'Online'};
        for (var key in metricData){
            if('online'.equals(key)){
                metrics.push({ code: metricData[key], value: req1[key],ts: datatime});
            } else if (data.hasOwnProperty(key)) {
                metrics.push({ code: metricData[key], value: data[key],ts: datatime});
            }
        }
    }

    reportRequest.metrics =metrics;
    requests.push(reportRequest);
    return JSON.stringify(requests);
});