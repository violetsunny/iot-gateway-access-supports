codec.decodeMulti(function(dataStr,params){
    var jsonObject=JSON.parse(dataStr);

    var s = '';
    if(params!=null){
        s = params[0];
        $log.info('params:{}',s);
    }

    var requests = [];
    if (s.equals('gps')){
        var array = jsonObject.data;
        if (array == null){
            $log.warn('data数据为空 {}',jsonObject);
            return null;
        }
        array.forEach(function(data) {
            var timestamp = Date.now();
            var reportRequest = {};
            var sn = data.vin;
            var deviceId = $ctx.getDeviceIdBySn('gpswv', sn);
            if (deviceId==null || deviceId==='') {
                //没有对应的恩牛设备
                $log.warn('{} 没有对应的恩牛设备',sn);
            } else {
                reportRequest.deviceId=deviceId;
                reportRequest.messageType='DEVICE_REPORT_REQ';
                reportRequest.timeStamp=timestamp;
                reportRequest.ingestionTime=timestamp;

                var metricData = {'lat':'Latitude','lng':'Longitude','gpsTime':'TimePosition'};
                var metrics = [];
                var array1 = data.deviceDetailBeanList;
                array1.forEach(function(data1) {
                    var isWireless = data1.isWireless;
                    if ('有线'.equals(isWireless)){
                        for (var key in metricData){
                            if (data1.hasOwnProperty(key)) {
                                metrics.push({ code: metricData[key], value: data1[key],ts: timestamp});
                            }
                        }
                        reportRequest.metrics =metrics;
                        requests.push(reportRequest);
                    }
                });
            }

        });
    }
   else
    if (s.equals('mileage')){
        var array = jsonObject.deviceList;
        if (array == null){
            $log.warn('data数据为空 {}',jsonObject);
            return null;
        }
        array.forEach(function(data) {
            var timestamp = Date.now();
            var reportRequest = {};
            var sn = data.imei;
            var deviceId = $ctx.getDeviceIdByImei(sn);
            if (deviceId==null || deviceId==='') {
                //没有对应的恩牛设备
                $log.warn('{} 没有对应的恩牛设备',sn);
            } else {
                reportRequest.deviceId=deviceId;
                reportRequest.messageType='DEVICE_REPORT_REQ';
                reportRequest.timeStamp=timestamp;
                reportRequest.ingestionTime=timestamp;

                var metricData = {'mileage':'MileageDailyDrive','duration':'TimeDailyDrive'};
                var metrics = [];
                for (var key in metricData){
                    if (data.hasOwnProperty(key)) {
                        metrics.push({ code: metricData[key], value: data[key],ts: timestamp});
                    }
                }
                reportRequest.metrics =metrics;
                requests.push(reportRequest);
            }

        });
    }
    else
    if (s.datatype!=null && s.datatype.equals('alarm')){
        var array = jsonObject;
        if (array == null){
            $log.warn('data数据为空 {}',jsonObject);
            return null;
        }

        array.forEach(function(data) {
            var timestamp = Date.now();
            var reportRequest = {};
            var sn = data.imei;
            var deviceId = $ctx.getDeviceIdByImei(sn);
            if (deviceId==null || deviceId==='') {
                //没有对应的恩牛设备
                $log.warn('{} 没有对应的恩牛设备',sn);
            } else {
                reportRequest.deviceId=deviceId;
                reportRequest.messageType='DEVICE_REPORT_REQ';
                reportRequest.timeStamp=timestamp;
                reportRequest.identifier='gps_alarm';
                reportRequest.type = 'alarm';
                reportRequest.version = '0.0.1';

                var metricData = {'alarmCode':'alarmCode'};
                var mappingData = {'AREAOUT':1,'AREAIN':2,'FENCEOUT':3,'FENCEIN':4,'RISKPLACE':5,'OFFLINETIMEOUT':6,'STAYTIMEOUT':7,'OVERSPEED':8,'ABNORMALACCUMULATION':9,'SEP':10,'HOME':11,'ROUTE_OFFSET':12,'TURNOVER':13,'CRASH':14,'SHAKE':14,'LOWVOT':15,'REMOVE':16,'REMOVECONTINUOUSLY':17,'FASTACCELERATION':18,'FASTDECELERATION':19,'SHARPTURN':20,'ALARM_MILES_INTEVAL':21,'ALARM_MILES_TIMEOU':21,'STATION_CHANGE':22};
                var metrics = [];
                for (var key in metricData){
                    if (data.hasOwnProperty(key)) {
                        if (mappingData[data[key]]!=null){
                            metrics.push({ code: metricData[key], value: mappingData[data[key]],ts: timestamp});
                        }
                    }
                }
                reportRequest.metrics =metrics;
                requests.push(reportRequest);
            }

        });
    }

    return JSON.stringify(requests);
});