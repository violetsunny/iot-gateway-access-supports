codec.decodeMulti(function(str, params){
    var data = JSON.parse(str);
    var topic = params[0];
    var topics = {
        'rtg': /\/edge\/(.+?)\/(.+?)\/rtg/
    };
    var topicParams = topic.split('/');
    var pKey = topicParams[3];
    var sn = topicParams[4];
    var requests = [];
    if(topics.rtg.test(topic)){
        var changeRpt = data.changeRpt;
        var array = data.devs;
        array.forEach(function(data1) {
            // 查询设备ID
            var deviceId = $ctx.getDeviceIdBySn(null, data1.dev);
            $log.info('设备ID:' + deviceId);
            var ack = data1.ack;
            var now = new Date().getTime();
            var time = Date.parse(data1.ts);
            time = time==null?now:time;
            var metrics = [];
            var payload = data1.payload;
            payload.forEach(function(data2) {
                if(data2.dq === 0){
                    metrics.push({code: data2.m, value: data2.v,ts: time});
                }
            });
            // 构建Message对象
            var messageId = data1.seq== null?deviceId+''+now:data1.seq;
            var result = {
                deviceId: deviceId,
                timeStamp: time,
                ingestionTime: now,
                messageId: messageId,
                changeRpt: changeRpt,
                resume: 'N',
                metrics: metrics,
                messageType: 'DEVICE_REPORT_REQ'
            }
            if(ack === '1'){
                result.response = JSON.stringify({
                    seq: messageId,
                    ts: now + '',
                    code: '200'
                });
            }
            requests.push(result);
        });
        return JSON.stringify(requests);
    }else{
        $log.warn('暂不支持该主题数据，' + topic);
    }
    return [];
});