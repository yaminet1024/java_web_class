use ccsu_class;

create table user(
    `id` bigint(20) not null comment '用户id,手机号码',
    `nick_name` varchar(255) not null ,
    `password` varchar(322) default null comment '加密密码',
    `head_pic` varchar(255) default null comment '头像链接',
    `register_date` datetime default null comment '注册时间',
    `last_login_date` datetime default null comment '上次登陆时间',
    `login_count` int(11) default '0' comment '登陆次数',
    `user_sex` varchar(3) default '未知' comment '性别',
    `address` varchar(255) default null comment '地址',
    primary key (id)
)engine = InnoDB default CHARSET utf8MB4;


create table goods(
    `id` bigint(20) not null auto_increment comment '商品id',
    `title` varchar(50) not null comment '商品名称',
    `images` text default null comment  '商品照片',
    `description` text default null comment '商品描述',
    `price` float not null comment '商品价格',
    `stock` int not null comment '商品库存',
    primary key (id)
)engine = InnoDB default CHARSET utf8MB4;


CREATE TABLE `orders` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_user_id` (`user_id`),
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `orders_detail` (
  `orderId` bigint(20) NOT NULL,
  `goods_id` bigint(20) NOT NULL,
  `numbers` bigint(20) NOT NULL,
  KEY `fk_goods` (`goods_id`),
  CONSTRAINT `fk_goods` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


drop table if exists `comment`;
create table comment (
    `id` bigint(20) not null auto_increment comment '评论id',
    `user_id` bigint(20) not null comment '用户id',
    `content` LONGTEXT default null comment '评论内容',
    `title` varchar(256)  not null comment '评论标题',
    `goods_id` bigint not null  comment '商品id',
    `create_date` datetime not null comment '评论时间',
    `status` int not null default 1 comment '存在状态1-存在、0-删除',
    primary key (id),
    foreign key (goods_id) references goods(id)
) engine = InnoDB default CHARSET utf8MB4;

create table cart(
  `id` bigint(20) not null auto_increment comment '购物车id',
  `user_id` bigint(20) not null comment '用户id',
  `goods_id` bigint not null comment '商品id',
  `images` varchar (256) default null comment '商品图片',
  `goods_name` varchar(256) not null comment '冗余数据-商品名称',
  `numbers` int not null comment '商品数量',
  `goods_price` float not null comment '冗余数据-商品价格',
  primary key (id),
  foreign key (user_id) references user(id),
  foreign key (goods_id) references goods(id)
)engine = InnoDB default CHARSET utf8MB4;

