//package com.ennewiot.gateway.constants;
//
//public class ModelConst {
//
//
//    public static final String MODEL = "{\n" +
//            "  \"modelCodeList\": [\n" +
//            "    \"IACA-05H\",\n" +
//            "    \"IACA-4AH\",\n" +
//            "    \"IACA-49H\",\n" +
//            "    \"IACA-6AH\",\n" +
//            "    \"IACA-58H\",\n" +
//            "    \"IACA-09H\",\n" +
//            "    \"IACA-23H\",\n" +
//            "    \"IACA-23H-01-1#\",\n" +
//            "    \"IACA-22H-01-1#\",\n" +
//            "    \"4AH\",\n" +
//            "    \"CBAM-02H\",\n" +
//            "    \"08H\"\n" +
//            "  ],\n" +
//            "  \"modelMap\": {\n" +
//            "    \"08H\": [\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"0\",\n" +
//            "        \"byteLen\": 16,\n" +
//            "        \"byteOrder\": \"BIG_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"2号密钥\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 86090,\n" +
//            "        \"index\": 1,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"08H\",\n" +
//            "          \"id\": 28441,\n" +
//            "          \"orderCode\": \"08H\",\n" +
//            "          \"orderSign\": \"DOWNLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"HEX\",\n" +
//            "          \"createTime\": 1532505711000,\n" +
//            "          \"createUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"HEX\",\n" +
//            "          \"id\": 380,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"CODEkey2\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 0\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"0\",\n" +
//            "        \"byteLen\": 16,\n" +
//            "        \"byteOrder\": \"BIG_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"3号密钥\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 86091,\n" +
//            "        \"index\": 2,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"08H\",\n" +
//            "          \"id\": 28441,\n" +
//            "          \"orderCode\": \"08H\",\n" +
//            "          \"orderSign\": \"DOWNLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"HEX\",\n" +
//            "          \"createTime\": 1532505711000,\n" +
//            "          \"createUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"HEX\",\n" +
//            "          \"id\": 380,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"CODEkey3\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 0\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"0\",\n" +
//            "        \"byteLen\": 16,\n" +
//            "        \"byteOrder\": \"BIG_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"4号密钥\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 86092,\n" +
//            "        \"index\": 3,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"08H\",\n" +
//            "          \"id\": 28441,\n" +
//            "          \"orderCode\": \"08H\",\n" +
//            "          \"orderSign\": \"DOWNLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"HEX\",\n" +
//            "          \"createTime\": 1532505711000,\n" +
//            "          \"createUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"HEX\",\n" +
//            "          \"id\": 380,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"CODEkey4\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 0\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"0\",\n" +
//            "        \"byteLen\": 16,\n" +
//            "        \"byteOrder\": \"BIG_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"5号密钥\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 86093,\n" +
//            "        \"index\": 4,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"08H\",\n" +
//            "          \"id\": 28441,\n" +
//            "          \"orderCode\": \"08H\",\n" +
//            "          \"orderSign\": \"DOWNLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"HEX\",\n" +
//            "          \"createTime\": 1532505711000,\n" +
//            "          \"createUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"HEX\",\n" +
//            "          \"id\": 380,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"CODEkey5\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 0\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"0\",\n" +
//            "        \"byteLen\": 16,\n" +
//            "        \"byteOrder\": \"BIG_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"6号密钥\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 86094,\n" +
//            "        \"index\": 5,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"08H\",\n" +
//            "          \"id\": 28441,\n" +
//            "          \"orderCode\": \"08H\",\n" +
//            "          \"orderSign\": \"DOWNLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"HEX\",\n" +
//            "          \"createTime\": 1532505711000,\n" +
//            "          \"createUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"HEX\",\n" +
//            "          \"id\": 380,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"CODEkey6\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 0\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"0\",\n" +
//            "        \"byteLen\": 16,\n" +
//            "        \"byteOrder\": \"BIG_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"7号密钥\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 86095,\n" +
//            "        \"index\": 6,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"08H\",\n" +
//            "          \"id\": 28441,\n" +
//            "          \"orderCode\": \"08H\",\n" +
//            "          \"orderSign\": \"DOWNLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"HEX\",\n" +
//            "          \"createTime\": 1532505711000,\n" +
//            "          \"createUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"HEX\",\n" +
//            "          \"id\": 380,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"CODEkey7\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 0\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"0\",\n" +
//            "        \"byteLen\": 16,\n" +
//            "        \"byteOrder\": \"BIG_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"8号密钥\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 86096,\n" +
//            "        \"index\": 7,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"08H\",\n" +
//            "          \"id\": 28441,\n" +
//            "          \"orderCode\": \"08H\",\n" +
//            "          \"orderSign\": \"DOWNLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"HEX\",\n" +
//            "          \"createTime\": 1532505711000,\n" +
//            "          \"createUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"HEX\",\n" +
//            "          \"id\": 380,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"CODEkey8\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 0\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"0\",\n" +
//            "        \"byteLen\": 16,\n" +
//            "        \"byteOrder\": \"BIG_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"9号密钥\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 86097,\n" +
//            "        \"index\": 8,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"08H\",\n" +
//            "          \"id\": 28441,\n" +
//            "          \"orderCode\": \"08H\",\n" +
//            "          \"orderSign\": \"DOWNLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"HEX\",\n" +
//            "          \"createTime\": 1532505711000,\n" +
//            "          \"createUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"HEX\",\n" +
//            "          \"id\": 380,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"CODEkey9\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 0\n" +
//            "      }\n" +
//            "    ],\n" +
//            "    \"CBAM-02H\": [\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"CBAM\",\n" +
//            "        \"byteLen\": 6,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"采集时间\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 590379,\n" +
//            "        \"index\": 2,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"报警器状态信息上报（标准协议）\",\n" +
//            "          \"id\": 96342,\n" +
//            "          \"orderCode\": \"CBAM-02H\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"Time_BCD\",\n" +
//            "          \"createTime\": 1502214515000,\n" +
//            "          \"createUserId\": 4,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"Time_BCD\",\n" +
//            "          \"id\": 288,\n" +
//            "          \"type\": 3,\n" +
//            "          \"updateTime\": 1502214515000,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"TIME\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 3\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"CBAM\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"供电状态\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 590380,\n" +
//            "        \"index\": 3,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"报警器状态信息上报（标准协议）\",\n" +
//            "          \"id\": 96342,\n" +
//            "          \"orderCode\": \"CBAM-02H\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"HEX\",\n" +
//            "          \"createTime\": 1532505711000,\n" +
//            "          \"createUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"HEX\",\n" +
//            "          \"id\": 380,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"PowerStatus\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 1\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"CBAM\",\n" +
//            "        \"byteLen\": 20,\n" +
//            "        \"byteOrder\": \"BIG_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"ICCID\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 590381,\n" +
//            "        \"index\": 4,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"报警器状态信息上报（标准协议）\",\n" +
//            "          \"id\": 96342,\n" +
//            "          \"orderCode\": \"CBAM-02H\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"ASCII\",\n" +
//            "          \"createTime\": 1535612061000,\n" +
//            "          \"createUser\": \"李艳红(liyanhonga)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"ASCII\",\n" +
//            "          \"id\": 396,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"ICCID\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 1\n" +
//            "      }\n" +
//            "    ],\n" +
//            "    \"IACA-05H\": [\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"时间\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 605509,\n" +
//            "        \"index\": 1,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器-时钟校对\",\n" +
//            "          \"id\": 96508,\n" +
//            "          \"orderCode\": \"IACA-05H\",\n" +
//            "          \"orderSign\": \"DOWNLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"String\",\n" +
//            "          \"createTime\": 1502043610000,\n" +
//            "          \"createUserId\": 1,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"String\",\n" +
//            "          \"id\": 254,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"time\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 0\n" +
//            "      }\n" +
//            "    ],\n" +
//            "    \"IACA-49H\": [\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"上报方式\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 605502,\n" +
//            "        \"index\": 1,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器-设置采集周期\",\n" +
//            "          \"id\": 96506,\n" +
//            "          \"orderCode\": \"IACA-49H\",\n" +
//            "          \"orderSign\": \"DOWNLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"String\",\n" +
//            "          \"createTime\": 1502043610000,\n" +
//            "          \"createUserId\": 1,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"String\",\n" +
//            "          \"id\": 254,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"reportType\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 0\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"定时上报日次数\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 605503,\n" +
//            "        \"index\": 2,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器-设置采集周期\",\n" +
//            "          \"id\": 96506,\n" +
//            "          \"orderCode\": \"IACA-49H\",\n" +
//            "          \"orderSign\": \"DOWNLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"String\",\n" +
//            "          \"createTime\": 1502043610000,\n" +
//            "          \"createUserId\": 1,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"String\",\n" +
//            "          \"id\": 254,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"reportingTimes\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 0\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"定时上报时间\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 605504,\n" +
//            "        \"index\": 3,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器-设置采集周期\",\n" +
//            "          \"id\": 96506,\n" +
//            "          \"orderCode\": \"IACA-49H\",\n" +
//            "          \"orderSign\": \"DOWNLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"String\",\n" +
//            "          \"createTime\": 1502043610000,\n" +
//            "          \"createUserId\": 1,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"String\",\n" +
//            "          \"id\": 254,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"reportTimeStr\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 0\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"间隔上报的间隔时间\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 605505,\n" +
//            "        \"index\": 4,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器-设置采集周期\",\n" +
//            "          \"id\": 96506,\n" +
//            "          \"orderCode\": \"IACA-49H\",\n" +
//            "          \"orderSign\": \"DOWNLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"String\",\n" +
//            "          \"createTime\": 1502043610000,\n" +
//            "          \"createUserId\": 1,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"String\",\n" +
//            "          \"id\": 254,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"intervalReportingTime\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 0\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"间隔上报首次上报时间\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 605506,\n" +
//            "        \"index\": 5,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器-设置采集周期\",\n" +
//            "          \"id\": 96506,\n" +
//            "          \"orderCode\": \"IACA-49H\",\n" +
//            "          \"orderSign\": \"DOWNLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"String\",\n" +
//            "          \"createTime\": 1502043610000,\n" +
//            "          \"createUserId\": 1,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"String\",\n" +
//            "          \"id\": 254,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"intervalReportingFirstTime\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 0\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"采集的间隔时间\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 605507,\n" +
//            "        \"index\": 6,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器-设置采集周期\",\n" +
//            "          \"id\": 96506,\n" +
//            "          \"orderCode\": \"IACA-49H\",\n" +
//            "          \"orderSign\": \"DOWNLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"String\",\n" +
//            "          \"createTime\": 1502043610000,\n" +
//            "          \"createUserId\": 1,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"String\",\n" +
//            "          \"id\": 254,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"collectionInterval\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 0\n" +
//            "      }\n" +
//            "    ],\n" +
//            "    \"IACA-58H\": [\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"数据类型\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 605498,\n" +
//            "        \"index\": 1,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器-设置报警浓度\",\n" +
//            "          \"id\": 96504,\n" +
//            "          \"orderCode\": \"IACA-58H\",\n" +
//            "          \"orderSign\": \"DOWNLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"String\",\n" +
//            "          \"createTime\": 1502043610000,\n" +
//            "          \"createUserId\": 1,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"String\",\n" +
//            "          \"id\": 254,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"dataType1\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 0\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"低限报警值\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 605499,\n" +
//            "        \"index\": 2,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器-设置报警浓度\",\n" +
//            "          \"id\": 96504,\n" +
//            "          \"orderCode\": \"IACA-58H\",\n" +
//            "          \"orderSign\": \"DOWNLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"String\",\n" +
//            "          \"createTime\": 1502043610000,\n" +
//            "          \"createUserId\": 1,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"String\",\n" +
//            "          \"id\": 254,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"alarmLowLimit1\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 0\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"高限报警值\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 605500,\n" +
//            "        \"index\": 3,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器-设置报警浓度\",\n" +
//            "          \"id\": 96504,\n" +
//            "          \"orderCode\": \"IACA-58H\",\n" +
//            "          \"orderSign\": \"DOWNLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"String\",\n" +
//            "          \"createTime\": 1502043610000,\n" +
//            "          \"createUserId\": 1,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"String\",\n" +
//            "          \"id\": 254,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"alarmHighLimit1\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 0\n" +
//            "      }\n" +
//            "    ],\n" +
//            "    \"IACA-23H\": [\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"开始时间\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 605495,\n" +
//            "        \"index\": 1,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工业报警器-召读历史数据\",\n" +
//            "          \"id\": 96502,\n" +
//            "          \"orderCode\": \"IACA-23H\",\n" +
//            "          \"orderSign\": \"DOWNLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"String\",\n" +
//            "          \"createTime\": 1502043610000,\n" +
//            "          \"createUserId\": 1,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"String\",\n" +
//            "          \"id\": 254,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"startTime\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 0\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"结束时间\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 605496,\n" +
//            "        \"index\": 2,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工业报警器-召读历史数据\",\n" +
//            "          \"id\": 96502,\n" +
//            "          \"orderCode\": \"IACA-23H\",\n" +
//            "          \"orderSign\": \"DOWNLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"String\",\n" +
//            "          \"createTime\": 1502043610000,\n" +
//            "          \"createUserId\": 1,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"String\",\n" +
//            "          \"id\": 254,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"endTime\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 0\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"类型\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 605497,\n" +
//            "        \"index\": 3,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工业报警器-召读历史数据\",\n" +
//            "          \"id\": 96502,\n" +
//            "          \"orderCode\": \"IACA-23H\",\n" +
//            "          \"orderSign\": \"DOWNLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"String\",\n" +
//            "          \"createTime\": 1502043610000,\n" +
//            "          \"createUserId\": 1,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"String\",\n" +
//            "          \"id\": 254,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"type\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 0\n" +
//            "      }\n" +
//            "    ],\n" +
//            "    \"IACA-22H-01-1#\": [\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 6,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"采集时间\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598521,\n" +
//            "        \"index\": 3,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器采集上报（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96395,\n" +
//            "          \"orderCode\": \"IACA-22H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"Time_BCD\",\n" +
//            "          \"createTime\": 1502214515000,\n" +
//            "          \"createUserId\": 4,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"Time_BCD\",\n" +
//            "          \"id\": 288,\n" +
//            "          \"type\": 3,\n" +
//            "          \"updateTime\": 1502214515000,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"TIME\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 4\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 2,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"电池电压\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598522,\n" +
//            "        \"index\": 4,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器采集上报（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96395,\n" +
//            "          \"orderCode\": \"IACA-22H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"INT_DIVIDE_100\",\n" +
//            "          \"createTime\": 1559527562000,\n" +
//            "          \"createUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"INT_DIVIDE_100\",\n" +
//            "          \"id\": 470,\n" +
//            "          \"type\": 3,\n" +
//            "          \"updateTime\": 1559527562000,\n" +
//            "          \"updateUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"Ubat\",\n" +
//            "        \"unit\": {\n" +
//            "          \"createTime\": 1502045853000,\n" +
//            "          \"createUserId\": 4,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"V\",\n" +
//            "          \"id\": 264,\n" +
//            "          \"type\": 1,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"version\": 3\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"信号强度\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598523,\n" +
//            "        \"index\": 5,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器采集上报（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96395,\n" +
//            "          \"orderCode\": \"IACA-22H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"HEX\",\n" +
//            "          \"createTime\": 1532505711000,\n" +
//            "          \"createUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"HEX\",\n" +
//            "          \"id\": 380,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"SignalWiNetwo\",\n" +
//            "        \"unit\": {\n" +
//            "          \"createTime\": 1502067466000,\n" +
//            "          \"createUserId\": 4,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"bar\",\n" +
//            "          \"id\": 276,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570666000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 4\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 2,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"传感器1（CH4）浓度\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598524,\n" +
//            "        \"index\": 6,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器采集上报（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96395,\n" +
//            "          \"orderCode\": \"IACA-22H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"INT_DIVIDE_100\",\n" +
//            "          \"createTime\": 1559527562000,\n" +
//            "          \"createUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"INT_DIVIDE_100\",\n" +
//            "          \"id\": 470,\n" +
//            "          \"type\": 3,\n" +
//            "          \"updateTime\": 1559527562000,\n" +
//            "          \"updateUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"SensorConcentration\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 2\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"传感器1（CH4）状态\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598525,\n" +
//            "        \"index\": 7,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器采集上报（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96395,\n" +
//            "          \"orderCode\": \"IACA-22H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"HEX\",\n" +
//            "          \"createTime\": 1532505711000,\n" +
//            "          \"createUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"HEX\",\n" +
//            "          \"id\": 380,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"SensorStatus\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 2\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 2,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"传感器2（CH4）浓度\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598527,\n" +
//            "        \"index\": 9,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器采集上报（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96395,\n" +
//            "          \"orderCode\": \"IACA-22H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"INT_DIVIDE_100\",\n" +
//            "          \"createTime\": 1559527562000,\n" +
//            "          \"createUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"INT_DIVIDE_100\",\n" +
//            "          \"id\": 470,\n" +
//            "          \"type\": 3,\n" +
//            "          \"updateTime\": 1559527562000,\n" +
//            "          \"updateUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"SensorConcentration2\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 2\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"传感器2（CH4）状态\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598528,\n" +
//            "        \"index\": 10,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器采集上报（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96395,\n" +
//            "          \"orderCode\": \"IACA-22H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"HEX\",\n" +
//            "          \"createTime\": 1532505711000,\n" +
//            "          \"createUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"HEX\",\n" +
//            "          \"id\": 380,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"SensorStatus2\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 2\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 2,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"传感器3（CH4）浓度\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598529,\n" +
//            "        \"index\": 11,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器采集上报（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96395,\n" +
//            "          \"orderCode\": \"IACA-22H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"INT_DIVIDE_100\",\n" +
//            "          \"createTime\": 1559527562000,\n" +
//            "          \"createUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"INT_DIVIDE_100\",\n" +
//            "          \"id\": 470,\n" +
//            "          \"type\": 3,\n" +
//            "          \"updateTime\": 1559527562000,\n" +
//            "          \"updateUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"SensorConcentration3\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 2\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"传感器3（CH4）状态\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598530,\n" +
//            "        \"index\": 12,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器采集上报（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96395,\n" +
//            "          \"orderCode\": \"IACA-22H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"HEX\",\n" +
//            "          \"createTime\": 1532505711000,\n" +
//            "          \"createUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"HEX\",\n" +
//            "          \"id\": 380,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"SensorStatus3\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 2\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 2,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"传感器4（CH4）浓度\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598531,\n" +
//            "        \"index\": 13,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器采集上报（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96395,\n" +
//            "          \"orderCode\": \"IACA-22H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"INT_DIVIDE_100\",\n" +
//            "          \"createTime\": 1559527562000,\n" +
//            "          \"createUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"INT_DIVIDE_100\",\n" +
//            "          \"id\": 470,\n" +
//            "          \"type\": 3,\n" +
//            "          \"updateTime\": 1559527562000,\n" +
//            "          \"updateUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"SensorConcentration4\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 2\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"传感器4（CH4）状态\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598532,\n" +
//            "        \"index\": 14,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器采集上报（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96395,\n" +
//            "          \"orderCode\": \"IACA-22H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"HEX\",\n" +
//            "          \"createTime\": 1532505711000,\n" +
//            "          \"createUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"HEX\",\n" +
//            "          \"id\": 380,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"SensorStatus4\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 2\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 2,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"传感器5（CH4）浓度\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598533,\n" +
//            "        \"index\": 15,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器采集上报（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96395,\n" +
//            "          \"orderCode\": \"IACA-22H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"INT_DIVIDE_100\",\n" +
//            "          \"createTime\": 1559527562000,\n" +
//            "          \"createUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"INT_DIVIDE_100\",\n" +
//            "          \"id\": 470,\n" +
//            "          \"type\": 3,\n" +
//            "          \"updateTime\": 1559527562000,\n" +
//            "          \"updateUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"SensorConcentration5\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 2\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"传感器5（CH4）状态\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598534,\n" +
//            "        \"index\": 16,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器采集上报（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96395,\n" +
//            "          \"orderCode\": \"IACA-22H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"HEX\",\n" +
//            "          \"createTime\": 1532505711000,\n" +
//            "          \"createUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"HEX\",\n" +
//            "          \"id\": 380,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"SensorStatus5\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 2\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 2,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"传感器6（CH4）浓度\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598535,\n" +
//            "        \"index\": 17,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器采集上报（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96395,\n" +
//            "          \"orderCode\": \"IACA-22H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"INT_DIVIDE_100\",\n" +
//            "          \"createTime\": 1559527562000,\n" +
//            "          \"createUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"INT_DIVIDE_100\",\n" +
//            "          \"id\": 470,\n" +
//            "          \"type\": 3,\n" +
//            "          \"updateTime\": 1559527562000,\n" +
//            "          \"updateUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"SensorConcentration6\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 2\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"传感器6（CH4）状态\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598536,\n" +
//            "        \"index\": 18,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器采集上报（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96395,\n" +
//            "          \"orderCode\": \"IACA-22H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"HEX\",\n" +
//            "          \"createTime\": 1532505711000,\n" +
//            "          \"createUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"HEX\",\n" +
//            "          \"id\": 380,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"SensorStatus6\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 2\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 2,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"传感器7（CH4）浓度\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598537,\n" +
//            "        \"index\": 19,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器采集上报（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96395,\n" +
//            "          \"orderCode\": \"IACA-22H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"INT_DIVIDE_100\",\n" +
//            "          \"createTime\": 1559527562000,\n" +
//            "          \"createUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"INT_DIVIDE_100\",\n" +
//            "          \"id\": 470,\n" +
//            "          \"type\": 3,\n" +
//            "          \"updateTime\": 1559527562000,\n" +
//            "          \"updateUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"SensorConcentration7\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 2\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"传感器7（CH4）状态\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598538,\n" +
//            "        \"index\": 20,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器采集上报（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96395,\n" +
//            "          \"orderCode\": \"IACA-22H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"HEX\",\n" +
//            "          \"createTime\": 1532505711000,\n" +
//            "          \"createUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"HEX\",\n" +
//            "          \"id\": 380,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"SensorStatus7\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 2\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 2,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"传感器8（CH4）浓度\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598539,\n" +
//            "        \"index\": 21,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器采集上报（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96395,\n" +
//            "          \"orderCode\": \"IACA-22H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"INT_DIVIDE_100\",\n" +
//            "          \"createTime\": 1559527562000,\n" +
//            "          \"createUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"INT_DIVIDE_100\",\n" +
//            "          \"id\": 470,\n" +
//            "          \"type\": 3,\n" +
//            "          \"updateTime\": 1559527562000,\n" +
//            "          \"updateUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"SensorConcentration8\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 2\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"传感器8（CH4）状态\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598540,\n" +
//            "        \"index\": 22,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器采集上报（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96395,\n" +
//            "          \"orderCode\": \"IACA-22H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"HEX\",\n" +
//            "          \"createTime\": 1532505711000,\n" +
//            "          \"createUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"HEX\",\n" +
//            "          \"id\": 380,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"SensorStatus8\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 2\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 2,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"传感器9（CH4）浓度\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598541,\n" +
//            "        \"index\": 23,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器采集上报（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96395,\n" +
//            "          \"orderCode\": \"IACA-22H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"INT_DIVIDE_100\",\n" +
//            "          \"createTime\": 1559527562000,\n" +
//            "          \"createUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"INT_DIVIDE_100\",\n" +
//            "          \"id\": 470,\n" +
//            "          \"type\": 3,\n" +
//            "          \"updateTime\": 1559527562000,\n" +
//            "          \"updateUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"SensorConcentration9\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 2\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"传感器9（CH4）状态\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598542,\n" +
//            "        \"index\": 24,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器采集上报（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96395,\n" +
//            "          \"orderCode\": \"IACA-22H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"HEX\",\n" +
//            "          \"createTime\": 1532505711000,\n" +
//            "          \"createUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"HEX\",\n" +
//            "          \"id\": 380,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"SensorStatus9\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 2\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 2,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"传感器10（CH4）浓度\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598543,\n" +
//            "        \"index\": 25,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器采集上报（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96395,\n" +
//            "          \"orderCode\": \"IACA-22H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"INT_DIVIDE_100\",\n" +
//            "          \"createTime\": 1559527562000,\n" +
//            "          \"createUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"INT_DIVIDE_100\",\n" +
//            "          \"id\": 470,\n" +
//            "          \"type\": 3,\n" +
//            "          \"updateTime\": 1559527562000,\n" +
//            "          \"updateUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"SensorConcentration10\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 2\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"传感器10（CH4）状态\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598544,\n" +
//            "        \"index\": 26,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器采集上报（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96395,\n" +
//            "          \"orderCode\": \"IACA-22H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"HEX\",\n" +
//            "          \"createTime\": 1532505711000,\n" +
//            "          \"createUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"HEX\",\n" +
//            "          \"id\": 380,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"SensorStatus10\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 2\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"输出模块状态1\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598545,\n" +
//            "        \"index\": 27,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器采集上报（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96395,\n" +
//            "          \"orderCode\": \"IACA-22H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"HEX\",\n" +
//            "          \"createTime\": 1532505711000,\n" +
//            "          \"createUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"HEX\",\n" +
//            "          \"id\": 380,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"OutputStatus1\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 2\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"输出模块状态2\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598546,\n" +
//            "        \"index\": 28,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器采集上报（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96395,\n" +
//            "          \"orderCode\": \"IACA-22H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"HEX\",\n" +
//            "          \"createTime\": 1532505711000,\n" +
//            "          \"createUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"HEX\",\n" +
//            "          \"id\": 380,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"OutputStatus2\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 2\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"输出模块状态3\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598547,\n" +
//            "        \"index\": 29,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器采集上报（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96395,\n" +
//            "          \"orderCode\": \"IACA-22H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"HEX\",\n" +
//            "          \"createTime\": 1532505711000,\n" +
//            "          \"createUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"HEX\",\n" +
//            "          \"id\": 380,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"OutputStatus3\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 2\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"输出模块状态4\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598548,\n" +
//            "        \"index\": 30,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器采集上报（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96395,\n" +
//            "          \"orderCode\": \"IACA-22H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"HEX\",\n" +
//            "          \"createTime\": 1532505711000,\n" +
//            "          \"createUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"HEX\",\n" +
//            "          \"id\": 380,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"OutputStatus4\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 2\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"输出模块状态5\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598549,\n" +
//            "        \"index\": 31,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器采集上报（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96395,\n" +
//            "          \"orderCode\": \"IACA-22H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"HEX\",\n" +
//            "          \"createTime\": 1532505711000,\n" +
//            "          \"createUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"HEX\",\n" +
//            "          \"id\": 380,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"OutputStatus5\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 2\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"输出模块状态6\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598550,\n" +
//            "        \"index\": 32,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器采集上报（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96395,\n" +
//            "          \"orderCode\": \"IACA-22H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"HEX\",\n" +
//            "          \"createTime\": 1532505711000,\n" +
//            "          \"createUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"HEX\",\n" +
//            "          \"id\": 380,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"OutputStatus6\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 2\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"输出模块状态7\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598551,\n" +
//            "        \"index\": 33,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器采集上报（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96395,\n" +
//            "          \"orderCode\": \"IACA-22H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"HEX\",\n" +
//            "          \"createTime\": 1532505711000,\n" +
//            "          \"createUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"HEX\",\n" +
//            "          \"id\": 380,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"OutputStatus7\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 2\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"输出模块状态8\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598552,\n" +
//            "        \"index\": 34,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器采集上报（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96395,\n" +
//            "          \"orderCode\": \"IACA-22H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"HEX\",\n" +
//            "          \"createTime\": 1532505711000,\n" +
//            "          \"createUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"HEX\",\n" +
//            "          \"id\": 380,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"OutputStatus8\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 2\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"输出模块状态9\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598553,\n" +
//            "        \"index\": 35,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器采集上报（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96395,\n" +
//            "          \"orderCode\": \"IACA-22H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"HEX\",\n" +
//            "          \"createTime\": 1532505711000,\n" +
//            "          \"createUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"HEX\",\n" +
//            "          \"id\": 380,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"OutputStatus9\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 2\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"输出模块状态10\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598554,\n" +
//            "        \"index\": 36,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器采集上报（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96395,\n" +
//            "          \"orderCode\": \"IACA-22H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"HEX\",\n" +
//            "          \"createTime\": 1532505711000,\n" +
//            "          \"createUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"HEX\",\n" +
//            "          \"id\": 380,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"OutputStatus10\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 2\n" +
//            "      }\n" +
//            "    ],\n" +
//            "    \"IACA-23H-01-1#\": [\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 6,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"采集时间\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598555,\n" +
//            "        \"index\": 3,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器历史数据补调（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96396,\n" +
//            "          \"orderCode\": \"IACA-23H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"String\",\n" +
//            "          \"createTime\": 1502043610000,\n" +
//            "          \"createUserId\": 1,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"String\",\n" +
//            "          \"id\": 254,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"TIME\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 2\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 2,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"电池电压\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598556,\n" +
//            "        \"index\": 4,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器历史数据补调（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96396,\n" +
//            "          \"orderCode\": \"IACA-23H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"String\",\n" +
//            "          \"createTime\": 1502043610000,\n" +
//            "          \"createUserId\": 1,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"String\",\n" +
//            "          \"id\": 254,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"Ubat\",\n" +
//            "        \"unit\": {\n" +
//            "          \"createTime\": 1502045853000,\n" +
//            "          \"createUserId\": 4,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"V\",\n" +
//            "          \"id\": 264,\n" +
//            "          \"type\": 1,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"version\": 2\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"信号强度\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598557,\n" +
//            "        \"index\": 5,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器历史数据补调（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96396,\n" +
//            "          \"orderCode\": \"IACA-23H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"String\",\n" +
//            "          \"createTime\": 1502043610000,\n" +
//            "          \"createUserId\": 1,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"String\",\n" +
//            "          \"id\": 254,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"SignalWiNetwo\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 2\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 2,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"传感器1（CH4）浓度\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598558,\n" +
//            "        \"index\": 6,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器历史数据补调（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96396,\n" +
//            "          \"orderCode\": \"IACA-23H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"String\",\n" +
//            "          \"createTime\": 1502043610000,\n" +
//            "          \"createUserId\": 1,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"String\",\n" +
//            "          \"id\": 254,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"SensorConcentration\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 1\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"传感器1（CH4）状态\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598559,\n" +
//            "        \"index\": 7,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器历史数据补调（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96396,\n" +
//            "          \"orderCode\": \"IACA-23H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"String\",\n" +
//            "          \"createTime\": 1502043610000,\n" +
//            "          \"createUserId\": 1,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"String\",\n" +
//            "          \"id\": 254,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"SensorStatus\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 1\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 2,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"传感器2（CH4）浓度\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598560,\n" +
//            "        \"index\": 9,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器历史数据补调（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96396,\n" +
//            "          \"orderCode\": \"IACA-23H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"String\",\n" +
//            "          \"createTime\": 1502043610000,\n" +
//            "          \"createUserId\": 1,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"String\",\n" +
//            "          \"id\": 254,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"SensorConcentration2\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 1\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"传感器2（CH4）状态\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598561,\n" +
//            "        \"index\": 10,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器历史数据补调（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96396,\n" +
//            "          \"orderCode\": \"IACA-23H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"String\",\n" +
//            "          \"createTime\": 1502043610000,\n" +
//            "          \"createUserId\": 1,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"String\",\n" +
//            "          \"id\": 254,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"SensorStatus2\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 1\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 2,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"传感器3（CH4）浓度\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598562,\n" +
//            "        \"index\": 11,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器历史数据补调（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96396,\n" +
//            "          \"orderCode\": \"IACA-23H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"String\",\n" +
//            "          \"createTime\": 1502043610000,\n" +
//            "          \"createUserId\": 1,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"String\",\n" +
//            "          \"id\": 254,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"SensorConcentration3\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 1\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"传感器3（CH4）状态\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598563,\n" +
//            "        \"index\": 12,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器历史数据补调（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96396,\n" +
//            "          \"orderCode\": \"IACA-23H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"String\",\n" +
//            "          \"createTime\": 1502043610000,\n" +
//            "          \"createUserId\": 1,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"String\",\n" +
//            "          \"id\": 254,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"SensorStatus3\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 1\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 2,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"传感器4（CH4）浓度\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598564,\n" +
//            "        \"index\": 13,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器历史数据补调（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96396,\n" +
//            "          \"orderCode\": \"IACA-23H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"String\",\n" +
//            "          \"createTime\": 1502043610000,\n" +
//            "          \"createUserId\": 1,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"String\",\n" +
//            "          \"id\": 254,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"SensorConcentration4\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 1\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"传感器4（CH4）状态\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598565,\n" +
//            "        \"index\": 14,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器历史数据补调（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96396,\n" +
//            "          \"orderCode\": \"IACA-23H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"String\",\n" +
//            "          \"createTime\": 1502043610000,\n" +
//            "          \"createUserId\": 1,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"String\",\n" +
//            "          \"id\": 254,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"SensorStatus4\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 1\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 2,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"传感器5（CH4）浓度\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598566,\n" +
//            "        \"index\": 15,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器历史数据补调（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96396,\n" +
//            "          \"orderCode\": \"IACA-23H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"String\",\n" +
//            "          \"createTime\": 1502043610000,\n" +
//            "          \"createUserId\": 1,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"String\",\n" +
//            "          \"id\": 254,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"SensorConcentration5\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 1\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"传感器5（CH4）状态\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598567,\n" +
//            "        \"index\": 16,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器历史数据补调（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96396,\n" +
//            "          \"orderCode\": \"IACA-23H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"String\",\n" +
//            "          \"createTime\": 1502043610000,\n" +
//            "          \"createUserId\": 1,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"String\",\n" +
//            "          \"id\": 254,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"SensorStatus5\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 1\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 2,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"传感器6（CH4）浓度\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598568,\n" +
//            "        \"index\": 17,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器历史数据补调（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96396,\n" +
//            "          \"orderCode\": \"IACA-23H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"String\",\n" +
//            "          \"createTime\": 1502043610000,\n" +
//            "          \"createUserId\": 1,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"String\",\n" +
//            "          \"id\": 254,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"SensorConcentration6\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 1\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"传感器6（CH4）状态\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598569,\n" +
//            "        \"index\": 18,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器历史数据补调（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96396,\n" +
//            "          \"orderCode\": \"IACA-23H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"String\",\n" +
//            "          \"createTime\": 1502043610000,\n" +
//            "          \"createUserId\": 1,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"String\",\n" +
//            "          \"id\": 254,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"SensorStatus6\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 1\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 2,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"传感器7（CH4）浓度\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598570,\n" +
//            "        \"index\": 19,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器历史数据补调（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96396,\n" +
//            "          \"orderCode\": \"IACA-23H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"String\",\n" +
//            "          \"createTime\": 1502043610000,\n" +
//            "          \"createUserId\": 1,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"String\",\n" +
//            "          \"id\": 254,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"SensorConcentration7\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 1\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"传感器7（CH4）状态\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598571,\n" +
//            "        \"index\": 20,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器历史数据补调（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96396,\n" +
//            "          \"orderCode\": \"IACA-23H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"String\",\n" +
//            "          \"createTime\": 1502043610000,\n" +
//            "          \"createUserId\": 1,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"String\",\n" +
//            "          \"id\": 254,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"SensorStatus7\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 1\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 2,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"传感器8（CH4）浓度\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598572,\n" +
//            "        \"index\": 21,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器历史数据补调（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96396,\n" +
//            "          \"orderCode\": \"IACA-23H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"String\",\n" +
//            "          \"createTime\": 1502043610000,\n" +
//            "          \"createUserId\": 1,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"String\",\n" +
//            "          \"id\": 254,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"SensorConcentration8\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 1\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"传感器8（CH4）状态\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598573,\n" +
//            "        \"index\": 22,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器历史数据补调（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96396,\n" +
//            "          \"orderCode\": \"IACA-23H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"String\",\n" +
//            "          \"createTime\": 1502043610000,\n" +
//            "          \"createUserId\": 1,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"String\",\n" +
//            "          \"id\": 254,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"SensorStatus8\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 1\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 2,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"传感器9（CH4）浓度\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598574,\n" +
//            "        \"index\": 23,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器历史数据补调（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96396,\n" +
//            "          \"orderCode\": \"IACA-23H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"String\",\n" +
//            "          \"createTime\": 1502043610000,\n" +
//            "          \"createUserId\": 1,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"String\",\n" +
//            "          \"id\": 254,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"SensorConcentration9\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 1\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"传感器9（CH4）状态\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598575,\n" +
//            "        \"index\": 24,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器历史数据补调（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96396,\n" +
//            "          \"orderCode\": \"IACA-23H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"String\",\n" +
//            "          \"createTime\": 1502043610000,\n" +
//            "          \"createUserId\": 1,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"String\",\n" +
//            "          \"id\": 254,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"SensorStatus9\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 1\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 2,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"传感器10（CH4）浓度\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598576,\n" +
//            "        \"index\": 25,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器历史数据补调（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96396,\n" +
//            "          \"orderCode\": \"IACA-23H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"String\",\n" +
//            "          \"createTime\": 1502043610000,\n" +
//            "          \"createUserId\": 1,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"String\",\n" +
//            "          \"id\": 254,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"SensorConcentration10\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 1\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"传感器10（CH4）状态\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598577,\n" +
//            "        \"index\": 26,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器历史数据补调（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96396,\n" +
//            "          \"orderCode\": \"IACA-23H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"String\",\n" +
//            "          \"createTime\": 1502043610000,\n" +
//            "          \"createUserId\": 1,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"String\",\n" +
//            "          \"id\": 254,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"SensorStatus10\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 1\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"输出模块状态1\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598578,\n" +
//            "        \"index\": 27,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器历史数据补调（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96396,\n" +
//            "          \"orderCode\": \"IACA-23H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"String\",\n" +
//            "          \"createTime\": 1502043610000,\n" +
//            "          \"createUserId\": 1,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"String\",\n" +
//            "          \"id\": 254,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"OutputStatus1\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 1\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"输出模块状态2\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598579,\n" +
//            "        \"index\": 28,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器历史数据补调（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96396,\n" +
//            "          \"orderCode\": \"IACA-23H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"String\",\n" +
//            "          \"createTime\": 1502043610000,\n" +
//            "          \"createUserId\": 1,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"String\",\n" +
//            "          \"id\": 254,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"OutputStatus2\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 1\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"输出模块状态3\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598580,\n" +
//            "        \"index\": 29,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器历史数据补调（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96396,\n" +
//            "          \"orderCode\": \"IACA-23H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"String\",\n" +
//            "          \"createTime\": 1502043610000,\n" +
//            "          \"createUserId\": 1,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"String\",\n" +
//            "          \"id\": 254,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"OutputStatus3\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 1\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"输出模块状态4\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598581,\n" +
//            "        \"index\": 30,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器历史数据补调（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96396,\n" +
//            "          \"orderCode\": \"IACA-23H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"String\",\n" +
//            "          \"createTime\": 1502043610000,\n" +
//            "          \"createUserId\": 1,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"String\",\n" +
//            "          \"id\": 254,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"OutputStatus4\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 1\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"输出模块状态5\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598582,\n" +
//            "        \"index\": 31,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器历史数据补调（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96396,\n" +
//            "          \"orderCode\": \"IACA-23H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"String\",\n" +
//            "          \"createTime\": 1502043610000,\n" +
//            "          \"createUserId\": 1,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"String\",\n" +
//            "          \"id\": 254,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"OutputStatus5\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 1\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"输出模块状态6\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598583,\n" +
//            "        \"index\": 32,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器历史数据补调（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96396,\n" +
//            "          \"orderCode\": \"IACA-23H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"String\",\n" +
//            "          \"createTime\": 1502043610000,\n" +
//            "          \"createUserId\": 1,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"String\",\n" +
//            "          \"id\": 254,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"OutputStatus6\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 1\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"输出模块状态7\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598584,\n" +
//            "        \"index\": 33,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器历史数据补调（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96396,\n" +
//            "          \"orderCode\": \"IACA-23H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"String\",\n" +
//            "          \"createTime\": 1502043610000,\n" +
//            "          \"createUserId\": 1,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"String\",\n" +
//            "          \"id\": 254,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"OutputStatus7\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 1\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"输出模块状态8\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598585,\n" +
//            "        \"index\": 34,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器历史数据补调（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96396,\n" +
//            "          \"orderCode\": \"IACA-23H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"String\",\n" +
//            "          \"createTime\": 1502043610000,\n" +
//            "          \"createUserId\": 1,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"String\",\n" +
//            "          \"id\": 254,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"OutputStatus8\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 1\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"输出模块状态9\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598586,\n" +
//            "        \"index\": 35,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器历史数据补调（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96396,\n" +
//            "          \"orderCode\": \"IACA-23H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"String\",\n" +
//            "          \"createTime\": 1502043610000,\n" +
//            "          \"createUserId\": 1,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"String\",\n" +
//            "          \"id\": 254,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"OutputStatus9\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 1\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"输出模块状态10\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 598587,\n" +
//            "        \"index\": 36,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器历史数据补调（标准协议-安可信单体设备）\",\n" +
//            "          \"id\": 96396,\n" +
//            "          \"orderCode\": \"IACA-23H-01-1#\",\n" +
//            "          \"orderSign\": \"UPLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"String\",\n" +
//            "          \"createTime\": 1502043610000,\n" +
//            "          \"createUserId\": 1,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"String\",\n" +
//            "          \"id\": 254,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"OutputStatus10\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 1\n" +
//            "      }\n" +
//            "    ],\n" +
//            "    \"4AH\": [\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"CBAM\",\n" +
//            "        \"byteLen\": 2,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"上报方式\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 590492,\n" +
//            "        \"index\": 1,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"上报周期查询（标准协议）\",\n" +
//            "          \"id\": 96375,\n" +
//            "          \"orderCode\": \"4AH\",\n" +
//            "          \"orderSign\": \"DOWNLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"HEX\",\n" +
//            "          \"createTime\": 1532505711000,\n" +
//            "          \"createUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"HEX\",\n" +
//            "          \"id\": 380,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"ReportingMethod\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 2\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"CBAM\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"定时上报日次数\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 590493,\n" +
//            "        \"index\": 2,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"上报周期查询（标准协议）\",\n" +
//            "          \"id\": 96375,\n" +
//            "          \"orderCode\": \"4AH\",\n" +
//            "          \"orderSign\": \"DOWNLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"HEX\",\n" +
//            "          \"createTime\": 1532505711000,\n" +
//            "          \"createUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"HEX\",\n" +
//            "          \"id\": 380,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"ReportingTimes\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 1\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"CBAM\",\n" +
//            "        \"byteLen\": 2,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"定时上报1\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 590494,\n" +
//            "        \"index\": 3,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"上报周期查询（标准协议）\",\n" +
//            "          \"id\": 96375,\n" +
//            "          \"orderCode\": \"4AH\",\n" +
//            "          \"orderSign\": \"DOWNLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"Time_BCD\",\n" +
//            "          \"createTime\": 1502214515000,\n" +
//            "          \"createUserId\": 4,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"Time_BCD\",\n" +
//            "          \"id\": 288,\n" +
//            "          \"type\": 3,\n" +
//            "          \"updateTime\": 1502214515000,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"ReportingTime1\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 1\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"CBAM\",\n" +
//            "        \"byteLen\": 2,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"定时上报2\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 590495,\n" +
//            "        \"index\": 4,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"上报周期查询（标准协议）\",\n" +
//            "          \"id\": 96375,\n" +
//            "          \"orderCode\": \"4AH\",\n" +
//            "          \"orderSign\": \"DOWNLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"Time_BCD\",\n" +
//            "          \"createTime\": 1502214515000,\n" +
//            "          \"createUserId\": 4,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"Time_BCD\",\n" +
//            "          \"id\": 288,\n" +
//            "          \"type\": 3,\n" +
//            "          \"updateTime\": 1502214515000,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"ReportingTime2\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 1\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"CBAM\",\n" +
//            "        \"byteLen\": 2,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"定时上报3\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 590496,\n" +
//            "        \"index\": 5,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"上报周期查询（标准协议）\",\n" +
//            "          \"id\": 96375,\n" +
//            "          \"orderCode\": \"4AH\",\n" +
//            "          \"orderSign\": \"DOWNLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"Time_BCD\",\n" +
//            "          \"createTime\": 1502214515000,\n" +
//            "          \"createUserId\": 4,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"Time_BCD\",\n" +
//            "          \"id\": 288,\n" +
//            "          \"type\": 3,\n" +
//            "          \"updateTime\": 1502214515000,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"ReportingTime3\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 1\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"CBAM\",\n" +
//            "        \"byteLen\": 2,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"定时上报4\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 590497,\n" +
//            "        \"index\": 6,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"上报周期查询（标准协议）\",\n" +
//            "          \"id\": 96375,\n" +
//            "          \"orderCode\": \"4AH\",\n" +
//            "          \"orderSign\": \"DOWNLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"Time_BCD\",\n" +
//            "          \"createTime\": 1502214515000,\n" +
//            "          \"createUserId\": 4,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"Time_BCD\",\n" +
//            "          \"id\": 288,\n" +
//            "          \"type\": 3,\n" +
//            "          \"updateTime\": 1502214515000,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"ReportingTime4\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 1\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"CBAM\",\n" +
//            "        \"byteLen\": 2,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"定时上报5\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 590498,\n" +
//            "        \"index\": 7,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"上报周期查询（标准协议）\",\n" +
//            "          \"id\": 96375,\n" +
//            "          \"orderCode\": \"4AH\",\n" +
//            "          \"orderSign\": \"DOWNLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"Time_BCD\",\n" +
//            "          \"createTime\": 1502214515000,\n" +
//            "          \"createUserId\": 4,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"Time_BCD\",\n" +
//            "          \"id\": 288,\n" +
//            "          \"type\": 3,\n" +
//            "          \"updateTime\": 1502214515000,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"ReportingTime5\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 1\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"CBAM\",\n" +
//            "        \"byteLen\": 2,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"定时上报6\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 590499,\n" +
//            "        \"index\": 8,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"上报周期查询（标准协议）\",\n" +
//            "          \"id\": 96375,\n" +
//            "          \"orderCode\": \"4AH\",\n" +
//            "          \"orderSign\": \"DOWNLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"Time_BCD\",\n" +
//            "          \"createTime\": 1502214515000,\n" +
//            "          \"createUserId\": 4,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"Time_BCD\",\n" +
//            "          \"id\": 288,\n" +
//            "          \"type\": 3,\n" +
//            "          \"updateTime\": 1502214515000,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"ReportingTime6\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 1\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"CBAM\",\n" +
//            "        \"byteLen\": 2,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"定时上报7\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 590500,\n" +
//            "        \"index\": 9,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"上报周期查询（标准协议）\",\n" +
//            "          \"id\": 96375,\n" +
//            "          \"orderCode\": \"4AH\",\n" +
//            "          \"orderSign\": \"DOWNLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"Time_BCD\",\n" +
//            "          \"createTime\": 1502214515000,\n" +
//            "          \"createUserId\": 4,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"Time_BCD\",\n" +
//            "          \"id\": 288,\n" +
//            "          \"type\": 3,\n" +
//            "          \"updateTime\": 1502214515000,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"ReportingTime7\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 1\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"CBAM\",\n" +
//            "        \"byteLen\": 2,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"定时上报8\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 590501,\n" +
//            "        \"index\": 10,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"上报周期查询（标准协议）\",\n" +
//            "          \"id\": 96375,\n" +
//            "          \"orderCode\": \"4AH\",\n" +
//            "          \"orderSign\": \"DOWNLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"Time_BCD\",\n" +
//            "          \"createTime\": 1502214515000,\n" +
//            "          \"createUserId\": 4,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"Time_BCD\",\n" +
//            "          \"id\": 288,\n" +
//            "          \"type\": 3,\n" +
//            "          \"updateTime\": 1502214515000,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"ReportingTime8\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 1\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"CBAM\",\n" +
//            "        \"byteLen\": 2,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"定时上报9\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 590502,\n" +
//            "        \"index\": 11,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"上报周期查询（标准协议）\",\n" +
//            "          \"id\": 96375,\n" +
//            "          \"orderCode\": \"4AH\",\n" +
//            "          \"orderSign\": \"DOWNLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"Time_BCD\",\n" +
//            "          \"createTime\": 1502214515000,\n" +
//            "          \"createUserId\": 4,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"Time_BCD\",\n" +
//            "          \"id\": 288,\n" +
//            "          \"type\": 3,\n" +
//            "          \"updateTime\": 1502214515000,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"ReportingTime9\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 1\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"CBAM\",\n" +
//            "        \"byteLen\": 2,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"定时上报10\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 590503,\n" +
//            "        \"index\": 12,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"上报周期查询（标准协议）\",\n" +
//            "          \"id\": 96375,\n" +
//            "          \"orderCode\": \"4AH\",\n" +
//            "          \"orderSign\": \"DOWNLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"Time_BCD\",\n" +
//            "          \"createTime\": 1502214515000,\n" +
//            "          \"createUserId\": 4,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"Time_BCD\",\n" +
//            "          \"id\": 288,\n" +
//            "          \"type\": 3,\n" +
//            "          \"updateTime\": 1502214515000,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"ReportingTime10\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 1\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"CBAM\",\n" +
//            "        \"byteLen\": 2,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"定时上报11\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 590504,\n" +
//            "        \"index\": 13,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"上报周期查询（标准协议）\",\n" +
//            "          \"id\": 96375,\n" +
//            "          \"orderCode\": \"4AH\",\n" +
//            "          \"orderSign\": \"DOWNLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"Time_BCD\",\n" +
//            "          \"createTime\": 1502214515000,\n" +
//            "          \"createUserId\": 4,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"Time_BCD\",\n" +
//            "          \"id\": 288,\n" +
//            "          \"type\": 3,\n" +
//            "          \"updateTime\": 1502214515000,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"ReportingTime11\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 1\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"CBAM\",\n" +
//            "        \"byteLen\": 2,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"定时上报12\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 590505,\n" +
//            "        \"index\": 14,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"上报周期查询（标准协议）\",\n" +
//            "          \"id\": 96375,\n" +
//            "          \"orderCode\": \"4AH\",\n" +
//            "          \"orderSign\": \"DOWNLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"Time_BCD\",\n" +
//            "          \"createTime\": 1502214515000,\n" +
//            "          \"createUserId\": 4,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"Time_BCD\",\n" +
//            "          \"id\": 288,\n" +
//            "          \"type\": 3,\n" +
//            "          \"updateTime\": 1502214515000,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"ReportingTime12\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 1\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"CBAM\",\n" +
//            "        \"byteLen\": 2,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"上报时间间隔\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 590506,\n" +
//            "        \"index\": 15,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"上报周期查询（标准协议）\",\n" +
//            "          \"id\": 96375,\n" +
//            "          \"orderCode\": \"4AH\",\n" +
//            "          \"orderSign\": \"DOWNLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"HEX\",\n" +
//            "          \"createTime\": 1532505711000,\n" +
//            "          \"createUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"HEX\",\n" +
//            "          \"id\": 380,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"IntervalTime\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 1\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"CBAM\",\n" +
//            "        \"byteLen\": 2,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"间隔上报首次上报时间\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 590507,\n" +
//            "        \"index\": 16,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"上报周期查询（标准协议）\",\n" +
//            "          \"id\": 96375,\n" +
//            "          \"orderCode\": \"4AH\",\n" +
//            "          \"orderSign\": \"DOWNLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"Time_BCD\",\n" +
//            "          \"createTime\": 1502214515000,\n" +
//            "          \"createUserId\": 4,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"Time_BCD\",\n" +
//            "          \"id\": 288,\n" +
//            "          \"type\": 3,\n" +
//            "          \"updateTime\": 1502214515000,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"FirstreportTime\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 1\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"CBAM\",\n" +
//            "        \"byteLen\": 2,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"采集的间隔时间\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 590508,\n" +
//            "        \"index\": 17,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"上报周期查询（标准协议）\",\n" +
//            "          \"id\": 96375,\n" +
//            "          \"orderCode\": \"4AH\",\n" +
//            "          \"orderSign\": \"DOWNLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"HEX\",\n" +
//            "          \"createTime\": 1532505711000,\n" +
//            "          \"createUser\": \"李翠琼(licuiqiong)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"HEX\",\n" +
//            "          \"id\": 380,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"Acquisition interval\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 1\n" +
//            "      }\n" +
//            "    ],\n" +
//            "    \"IACA-4AH\": [\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"参数\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 605508,\n" +
//            "        \"index\": 1,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器-读取采集上报周期\",\n" +
//            "          \"id\": 96507,\n" +
//            "          \"orderCode\": \"IACA-4AH\",\n" +
//            "          \"orderSign\": \"DOWNLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"String\",\n" +
//            "          \"createTime\": 1502043610000,\n" +
//            "          \"createUserId\": 1,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"String\",\n" +
//            "          \"id\": 254,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"param\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 0\n" +
//            "      }\n" +
//            "    ],\n" +
//            "    \"IACA-6AH\": [\n" +
//            "      {\n" +
//            "        \"attrGroup\": \"IACA\",\n" +
//            "        \"byteLen\": 1,\n" +
//            "        \"byteOrder\": \"LITTLE_ENDIAN\",\n" +
//            "        \"controlFlag\": false,\n" +
//            "        \"dataType\": {},\n" +
//            "        \"deleted\": false,\n" +
//            "        \"depict\": \"数据类型\",\n" +
//            "        \"frequency\": 0,\n" +
//            "        \"funCode\": 0,\n" +
//            "        \"id\": 605501,\n" +
//            "        \"index\": 1,\n" +
//            "        \"model\": {\n" +
//            "          \"accessWay\": \"AGREEMENTACCESS\",\n" +
//            "          \"baudRate\": \"9600\",\n" +
//            "          \"checkBit\": \"None\",\n" +
//            "          \"dataBit\": \"8\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"工商业报警器-读取报警浓度值\",\n" +
//            "          \"id\": 96505,\n" +
//            "          \"orderCode\": \"IACA-6AH\",\n" +
//            "          \"orderSign\": \"DOWNLINK\",\n" +
//            "          \"parseMode\": \"TCP\",\n" +
//            "          \"status\": false,\n" +
//            "          \"stopBit\": \"2\"\n" +
//            "        },\n" +
//            "        \"protocolDataType\": {\n" +
//            "          \"code\": \"String\",\n" +
//            "          \"createTime\": 1502043610000,\n" +
//            "          \"createUserId\": 1,\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"String\",\n" +
//            "          \"id\": 254,\n" +
//            "          \"type\": 3,\n" +
//            "          \"version\": 0\n" +
//            "        },\n" +
//            "        \"targetPath\": \"dataType\",\n" +
//            "        \"unit\": {\n" +
//            "          \"code\": \"null\",\n" +
//            "          \"createTime\": 1506754024000,\n" +
//            "          \"createUser\": \"刘广璐(liuguanglu)\",\n" +
//            "          \"deleted\": false,\n" +
//            "          \"depict\": \"null\",\n" +
//            "          \"id\": 319,\n" +
//            "          \"type\": 1,\n" +
//            "          \"updateTime\": 1595570673000,\n" +
//            "          \"updateUser\": \"外部测试账号(test123)\",\n" +
//            "          \"version\": 1\n" +
//            "        },\n" +
//            "        \"version\": 0\n" +
//            "      }\n" +
//            "    ]\n" +
//            "  }\n" +
//            "}";
//
//}
