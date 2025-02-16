CREATE TABLE `demo_member` (
`id`  int(8) NOT NULL AUTO_INCREMENT ,
`account`  varchar(60) ,
`password`  varchar(60) ,
`status`  int(2) NOT NULL ,
`role`  varchar(12) NOT NULL ,
`update_By`  varchar(40) NOT NULL ,
`update_Date`  date NOT NULL ,
PRIMARY KEY (`id`)
)
;
