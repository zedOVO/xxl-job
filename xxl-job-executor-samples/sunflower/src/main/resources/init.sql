DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `nick_name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `mobile` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
INSERT INTO `user` (`id`,`nick_name`,`email`,`mobile`) VALUES ('1','东邪','111@qq.com','18100001234');
INSERT INTO `user` (`id`,`nick_name`,`email`,`mobile`) VALUES ('2','西毒','222@qq.com','18100007890');

DROP TABLE IF EXISTS `user_account`;
CREATE TABLE `user_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `user_id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `errors` int(11) NOT NULL default 0,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
INSERT INTO `user_account`(`user_id`,`username`,`password`) VALUES ('1','admin', 'c649d6185032697ada52a13e7ea75bf3');
INSERT INTO `user_account`(`user_id`,`username`,`password`) VALUES ('2','zhangsan', '64153508faba4b07b88da0c532940ca4');

DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `title` varchar(255) NOT NULL,
  `subtitle` varchar(255) NOT NULL DEFAULT '无',
  `author` varchar(255) NOT NULL DEFAULT '无',
  `content` varchar(4096) NOT NULL,
  `url` varchar(4096) ,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
INSERT INTO `news` (`title`,`subtitle`,`author`,`content`) VALUES ('东京不够热','跟着小东一起追追追。追剧，追番，追梦想。长期欢迎各路小伙伴加入我们！ ... 总有一天我将会变成你， 我将会喜欢上你， 到那时，你还会喜欢…','克莱西达','四位少年一起运营了一个SNS账号“克莱西达”
克莱西达会在众多委托中随机挑选一个委托，帮助他们解决烦恼。
同时赠与委托者一句台词......
2.5次元的剧即将上演。');
INSERT INTO `news` (`title`,`subtitle`,`author`,`content`) VALUES ('昨天的剧情简介','本片是对演员贾宏声在上世纪九十年代整十年不堪回首岁月的真实再现，并由贾宏声本人及其家人回归各自相应身份参与回首。','©豆瓣','本片是对演员贾宏声在上世纪九十年代整十年不堪回首岁月的真实再现，并由贾宏声本人及其家人回归各自相应身份参与回首。
　　贾宏声本是年轻有为的优秀演员，从1987年到1993年，他主演了《夏日的期待》、《银蛇谋杀案》、《北京你早》和《周末情人》等将近十部电影，渐渐小有名气。这期间，他接触并疯狂爱上了摇滚乐，视BEATLES乐队的约翰•列侬为精神之父，然而同时，他也接触了并非摇滚精神内核的大麻和软性毒品。自此，他不再接戏，性格变得极端、偏执和歇斯底里，无法再与其他人相处。其远在东北四平的父母为了不让儿子继续沉沦，提前退休把整个家搬到北京，随后的一切，都像一场似乎没有尽头的战争。
　　贾宏声于2010年7月5日下午坠楼身亡，时年43岁。');
INSERT INTO `news` (`title`,`subtitle`,`author`,`content`,`url`) VALUES ('昨天1','本片是......','@昨天1','昨天1昨天1昨天1昨天1','/5dd4cf1b1ec4fsdd.jpg');
INSERT INTO `news` (`title`,`subtitle`,`author`,`content`,`url`) VALUES ('昨天2','本片是......','@昨天2','昨天2昨天2昨天2昨天2','/5dd4cf1b1ec4fsdd.jpg');
INSERT INTO `news` (`title`,`subtitle`,`author`,`content`,`url`) VALUES ('昨天3','本片是......','@昨天3','昨天3昨天3昨天3昨天3','/5dd4cf1b1ec4fsdd.jpg');
INSERT INTO `news` (`title`,`subtitle`,`author`,`content`,`url`) VALUES ('昨天4','本片是......','@昨天4','昨天4昨天4昨天4昨天4','/5dd4cf1b1ec4fsdd.jpg');
INSERT INTO `news` (`title`,`subtitle`,`author`,`content`,`url`) VALUES ('昨天5','本片是......','@昨天5','昨天5昨天5昨天5昨天5','/5dd4cf1b1ec4fsdd.jpg');
INSERT INTO `news` (`title`,`subtitle`,`author`,`content`,`url`) VALUES ('昨天6','本片是......','@昨天6','昨天6昨天6昨天6昨天6','/5dd4cf1b1ec4fsdd.jpg');
INSERT INTO `news` (`title`,`subtitle`,`author`,`content`,`url`) VALUES ('昨天7','本片是......','@昨天7','昨天7昨天7昨天7昨天7','/5dd4cf1b1ec4fsdd.jpg');
INSERT INTO `news` (`title`,`subtitle`,`author`,`content`,`url`) VALUES ('昨天8','本片是......','@昨天8','昨天8昨天8昨天8昨天8','/5dd4cf1b1ec4fsdd.jpg');
INSERT INTO `news` (`title`,`subtitle`,`author`,`content`,`url`) VALUES ('昨天9','本片是......','@昨天9','昨天9昨天9昨天9昨天9','/5dd4cf1b1ec4fsdd.jpg');
INSERT INTO `news` (`title`,`subtitle`,`author`,`content`,`url`) VALUES ('魔戒1','本片是......','@魔戒1','魔戒1魔戒1魔戒1魔戒1','/5dd4cf1b1ec4fsdd.jpg');
INSERT INTO `news` (`title`,`subtitle`,`author`,`content`,`url`) VALUES ('魔戒2','本片是......','@魔戒2','魔戒2魔戒2魔戒2魔戒2','/5dd4cf1b1ec4fsdd.jpg');
INSERT INTO `news` (`title`,`subtitle`,`author`,`content`,`url`) VALUES ('魔戒3','本片是......','@魔戒3','魔戒3魔戒3魔戒3魔戒3','/5dd4cf1b1ec4fsdd.jpg');
INSERT INTO `news` (`title`,`subtitle`,`author`,`content`,`url`) VALUES ('魔戒4','本片是......','@魔戒4','魔戒4魔戒4魔戒4魔戒4','/5dd4cf1b1ec4fsdd.jpg');
INSERT INTO `news` (`title`,`subtitle`,`author`,`content`,`url`) VALUES ('魔戒5','本片是......','@魔戒5','魔戒5魔戒5魔戒5魔戒5','/5dd4cf1b1ec4fsdd.jpg');
INSERT INTO `news` (`title`,`subtitle`,`author`,`content`,`url`) VALUES ('魔戒6','本片是......','@魔戒6','魔戒6魔戒6魔戒6魔戒6','/5dd4cf1b1ec4fsdd.jpg');
INSERT INTO `news` (`title`,`subtitle`,`author`,`content`,`url`) VALUES ('魔戒7','本片是......','@魔戒7','魔戒7魔戒7魔戒7魔戒7','/5dd4cf1b1ec4fsdd.jpg');
INSERT INTO `news` (`title`,`subtitle`,`author`,`content`,`url`) VALUES ('魔戒8','本片是......','@魔戒8','魔戒8魔戒8魔戒8魔戒8','/5dd4cf1b1ec4fsdd.jpg');
INSERT INTO `news` (`title`,`subtitle`,`author`,`content`,`url`) VALUES ('魔戒9','本片是......','@魔戒9','魔戒9魔戒9魔戒9魔戒9','/5dd4cf1b1ec4fsdd.jpg');

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL DEFAULT '默认分类',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO `product`(`name`,`description`) VALUES ('智慧公园','智慧公园初步规划方案 一、项目背景 随着人们生活水平的提高，对旅游要求也越来越高，在旅游过程中，旅游 者追求更多的参与和交往性活动，旅游活动将朝着大众化发展，家庭旅游成为当 今旅游业总体趋势，旅游景区在节假日时，由于旅游人员流量大、车流量');
INSERT INTO `product`(`name`,`description`) VALUES ('智慧城市','智慧城市（英语：Smart City）起源于传媒领域，是指利用各种信息技术或创新概念，将城市的系统和服务打通、集成，以提升资源运用的效率，优化城市管理和服务，以及改善市民生活质量。智慧城市是把新一代信息技术充分运用在城市中各行各业 ..');
INSERT INTO `product`(`name`,`description`) VALUES ('智慧企业','智慧企业是在企业数字化改造和智能化应用之后的新型管理模式和组织形态，是先进信息技术、工业技术和管理技术的深度融合。通过智慧企业建设不仅可以促进企业内部生产关系的转型升级，完成与“互联网+”社会生产力的和谐对接，还能进一步释放 ...');
INSERT INTO `product`(`name`,`description`) VALUES ('智慧社区','智慧城区（社区）是指社区管理的一种新理念，是新形势下社会管理创新的一种新模式。充分借助互联网、物联网，涉及到智能楼宇、智能家居、路网监控、个人健康与数字生活等诸多领域，充分发挥信息通信（ICT）产业发达、电信业务及信息化基础设施 ...');
INSERT INTO `product`(`name`,`description`) VALUES ('智慧学校','智慧校园指的是以物联网为基础的智慧化的校园工作、学习和生活一体化环境，这个一体化环境以各种应用服务系统为载体，将教学、科研、管理和校园生活进行充分融合。2010年，在信息化“十二五”规划中，浙江大学提出建设一个“令人激动”的 ...');
INSERT INTO `product`(`name`,`description`) VALUES ('智慧医疗','智慧医疗英文简称WIT120，是最近兴起的专有医疗名词，通过打造健康档案区域医疗信息平台，利用最先进的物联网技术，实现患者与医务人员、医疗机构、医疗设备之间的互动，逐步达到信息化。');


DROP TABLE IF EXISTS `contact`;
CREATE TABLE `contact` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `name` varchar(255) NOT NULL,
  `contact` varchar(255) NOT NULL,
  `content` varchar(255) ,
  `type` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `picfile`;
CREATE TABLE `picfile` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `name` varchar(255) NOT NULL,
  `path` varchar(255) NOT NULL,
  `url` varchar(255) NOT NULL,
  `bytes` int(11) NOT NULL,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `recruit`;
CREATE TABLE `recruit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `name` varchar(255) NOT NULL,
  `contact` varchar(255) NOT NULL,
  `apply_for` varchar(255) ,
  `former_company` varchar(255),
  `gender` varchar(255),
  `age` int(11) ,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
INSERT INTO `test`.`recruit`(`id`, `create_time`, `name`, `contact`, `apply_for`, `former_company`, `gender`, `age`) VALUES (1, '2019-11-29 23:58:19', '张三', 'QQ：12345567', '产品经理', '阿里爸爸', '男', 13);
INSERT INTO `test`.`recruit`(`id`, `create_time`, `name`, `contact`, `apply_for`, `former_company`, `gender`, `age`) VALUES (2, '2019-11-29 23:59:24', '李四', '上海市浦东新区XX路XX号', 'CEO', '阿里', '女', 22);
