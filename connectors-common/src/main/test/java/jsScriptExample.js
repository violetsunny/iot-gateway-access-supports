codec.decoder(function(byteArray){
    var dataStr='';
    for(var i=0;i<byteArray.length;i++){
        dataStr+=String.fromCharCode(byteArray[i]);
    }
    var jsonObject=JSON.parse(dataStr);
    var map =jsonObject.metrics;

    var timestamp = Date.now()
    var myList = [];
    for (var key in map) {
         if (map.hasOwnProperty(key)) {
             myList.push({ code: key, value: map[key],ts: timestamp});
         }
    }
    jsonObject.metrics =myList;

    var result = JSON.stringify(jsonObject)
    logger.info('res:{}', result);
    return result;});



codec.encoder(function(msg){
    var map={deviceId: msg.deviceId,
             messageId: msg.messageId,
             messageType: msg.messageType+'',
             transport: msg.transport};
    if(map.messageType=='LOGIN_RSP' || map.messageType=='REPORT_RSP'){
        map.result=msg.result;map.timeStamp=msg.timeStamp}
     var dataStr = JSON.stringify(map);
    logger.info('dataStr:'+dataStr);
    return dataStr;});