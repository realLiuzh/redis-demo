create table goods
(
	id int unsigned auto_increment
		primary key,
	goods_name varchar(100) not null comment '商品名称',
	brand_id int unsigned not null comment '品牌ID',
	cate_id int unsigned not null comment '分类ID',
	price bigint unsigned not null,
	original bigint unsigned not null comment '商品原价',
	tags varchar(255) not null comment '商品标签',
	content text not null comment '商品内容',
	summary text not null comment '商品描述',
	is_sale tinyint not null comment '上架状态: 1是0是',
	created_at timestamp null,
	updated_at timestamp null
)
collate=utf8mb4_unicode_ci;

