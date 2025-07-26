codec.decodeMulti(function(dataStr,params) {
    var jsonObject = JSON.parse(dataStr);
    var requests = [];
    var array = jsonObject.data;
    if (array == null){
        $log.warn('data数据为空 {}',jsonObject);
        return null;
    }
    var modelRef = {
        'ia': 'Ia',
        'ib': 'Ib',
        'ic': 'Ic',
        'ua': 'Ua',
        'ub': 'Ua',
        'uc': 'Uc',
        'fha': 'fha',
        'fhb': 'fhb',
        'fhc': 'fhc',
        'pfa': 'pfa',
        'pfb': 'pfb',
        'pfc': 'pfc',
        'qa': 'qa',
        'qb': 'qb',
        'qc': 'qc',
        'i0': 'i0',
        'zyggl': 'P',
        'zglys': 'COS',
        'zwggl': 'Q',
        'f': 'f',
        'uab': 'uab',
        'ubc': 'ubc',
        'uca': 'uca',
        'uxja': 'uxja',
        'uxjb': 'uxjb',
        'uxjc': 'uxjc',
        'ixja': 'ixja',
        'ixjb': 'ixjb',
        'ixjc': 'ixjc',
        'fhl': 'fhl',
        'sa': 'sa',
        'sb': 'sb',
        'sc': 'sc',
        'zszgl': 'S',
        'x': 'x',
        'uacf': 'uacf',
        'ubcf': 'ubcf',
        'uccf': 'uccf',
        'iakf': 'iakf',
        'ibkf': 'ibkf',
        'ickf': 'ickf',
        'i+': 'iPositive',
        'i-': 'iNegative',
        'u0': 'u0',
        'u+': 'uPositive',
        'u-': 'uNegative',
        'ig': 'ig',
        'pa': 'pa',
        'pb': 'pb',
        'pc': 'pc',
        'temp': 'temp',
        'rh': 'rh',
        'smoke': 'smoke',
        'press': 'press',
        'u': 'u',
        'i': 'i',
        'xsz': 'xsz',
        'xdd': 'xdd',
        'ysz': 'ysz',
        'ydd': 'ydd',
        'zygsz': 'zygsz',
        'zwgsz': 'zwgsz',
        'fygsz': 'fygsz',
        'fwgsz': 'fwgsz',
        'zygdd': 'zygdd',
        'zwgdd': 'Eqtp',
        'fygdd': 'fygdd',
        'fwgdd': 'fwgdd',
        'zyjsz': 'zyjsz',
        'zyfsz': 'zyfsz',
        'zyvsz': 'zyvsz',
        'zypsz': 'zypsz',
        'zyrsz': 'zyrsz',
        'zwjsz': 'zwjsz',
        'zwfsz': 'zwfsz',
        'zwvsz': 'zwvsz',
        'zwpsz': 'zwpsz',
        'zwrsz': 'zwrsz',
        'fyjsz': 'fyjsz',
        'fyfsz': 'fyfsz',
        'fyvsz': 'fyvsz',
        'fypsz': 'fypsz',
        'fyrsz': 'fyrsz',
        'fwjsz': 'fwjsz',
        'fwfsz': 'fwfsz',
        'fwvsz': 'fwvsz',
        'fwpsz': 'fwpsz',
        'fwrsz': 'fwrsz',
        'zyjdd': 'zyjdd',
        'zyfdd': 'Eptp',
        'zyvdd': 'zyvdd',
        'zypdd': 'zypdd',
        'zyrdd': 'zyrdd',
        'zwjdd': 'zwjdd',
        'zwfdd': 'zwfdd',
        'zwvdd': 'zwvdd',
        'zwpdd': 'zwpdd',
        'zwrdd': 'zwrdd',
        'fyjdd': 'fyjdd',
        'fyfdd': 'fyfdd',
        'fyvdd': 'fyvdd',
        'fypdd': 'fypdd',
        'fyrdd': 'fyrdd',
        'fwjdd': 'fwjdd',
        'fwfdd': 'fwfdd',
        'fwvdd': 'fwvdd',
        'fwpdd': 'fwpdd',
        'fwrdd': 'fwrdd',
        'wgsz': 'wgsz',
        'ygsz': 'ygsz',
        'wgdd': 'wgdd',
        'ygdd': 'ygdd'
    };
    modelRef = $ctx.modelRef('futiancompere',params[1],modelRef);

    array.forEach(function(data) {
        var timestamp = Date.now();
        var sn = data.deviceid;
        var deviceId = $ctx.getDeviceIdBySn('futiancompere', sn);
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
                    metrics.push({code: metric, value: data[key],ts: Date.parse(data.readdate)});
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