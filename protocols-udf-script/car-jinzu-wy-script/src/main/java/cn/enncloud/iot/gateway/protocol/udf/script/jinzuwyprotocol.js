codec.decodeMulti(function(dataStr,params){
    var jsonObject=JSON.parse(dataStr);

    var s = '';
    if(params!=null){
        s = params[0];
        $log.info('params:{}',s);
    }

    var requests = [];
    var array = jsonObject.datas.content;
    if (array == null){
        $log.warn('data数据为空 {}',jsonObject);
        return null;
    }

    array.forEach(function(data) {
        var timestamp = Date.now();
        var sn = data.imei;
        var deviceId = $ctx.getDeviceIdByImei(sn);
        if (deviceId==null || deviceId==='') {
            //没有对应的恩牛设备
            $log.warn('{} 没有对应的恩牛设备',sn);
        } else {
            if (s.equals('asset')||s.equals('device')){
                var reportRequest = {};
                reportRequest.deviceId=deviceId;
                reportRequest.messageType='DEVICE_REPORT_REQ';
                reportRequest.timeStamp=timestamp;
                reportRequest.ingestionTime=timestamp;

                var metricData = {'electricity':'electricity','workTimeSeconds':'workTimeSeconds','voltage':'voltage','electricLevel':'electricLevel','signalNum':'signalNum','current':'current','position':'position'};
                var metrics = [];
                for (var key in metricData){
                    if (data.hasOwnProperty(key)) {
                        metrics.push({ code: metricData[key], value: data[key],ts: timestamp});
                    }
                }
                reportRequest.metrics =metrics;
                requests.push(reportRequest);
            }
            if (s.equals('alarm')){
                var reportRequest = {};
                reportRequest.deviceId=deviceId;
                reportRequest.messageType='DEVICE_EVENT_REQ';
                reportRequest.timeStamp=timestamp;
                reportRequest.identifier='alarm';
                reportRequest.type='alarm';
                reportRequest.version='0.0.1';

                var alarmMapping = {'alarmType':'alarmType','deviceTime':'deviceTime','alarmId':'alarmId','serialNumber':'serialNumber','alarmInfo':'alarmInfo','endTime':'endTime','posinfo':'posinfo'};
                var metrics = [];
                for (var key in alarmMapping){
                    if (data.hasOwnProperty(key)){
                        metrics.push({ code: alarmMapping[key], value: data[key],ts: timestamp});
                    }
                }
                reportRequest.metrics =metrics;
                requests.push(reportRequest);
            }
        }

    });
    return JSON.stringify(requests);
});