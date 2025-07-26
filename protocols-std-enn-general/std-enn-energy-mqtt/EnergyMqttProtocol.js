codec.decodeMulti(function(str, params){
    var data = JSON.parse(str);
    var topic = params[0];
    var topics = {
        'rtg': /\/edge\/single\/(.+?)\/(.+?)\/rtg/
    };
    if(topics.rtg.test(topic)){
        var topicParams = topic.split('/');
        var pKey = topicParams[3];
        var sn = topicParams[4];
        // 查询设备ID
        var deviceId = $ctx.getDeviceIdBySn(null, sn);
        $log.info('设备ID:' + deviceId);
        var ack = data.ack;
        var time = parseInt(data.ts);
        var metrics = [];
        var payload = data.payload;
        var ks = Object.getOwnPropertyNames(payload);
        var now = new Date().getTime();
        for(var i = 0; i < ks.length; i++){
            var key = ks[i];
            var value = payload[key];
            var mertic =  {code: key, value: value, ts: time};
            metrics.push(mertic);
        }
        // 构建Message对象
        var result = {
            deviceId: deviceId,
            timeStamp: time,
            ingestionTime: now,
            messageId: data.seq,
            metrics: metrics,
            messageType: 'DEVICE_REPORT_REQ'
        }
        if(ack === '1'){
            result.response = JSON.stringify({
                devtype: data.devtype,
                seq: data.seq,
                ts: now + '',
                code: '200'
            });
        }
        return JSON.stringify([result]);
    }else{
        $log.warn('暂不支持该主题数据，' + topic);
    }
    return [];
});