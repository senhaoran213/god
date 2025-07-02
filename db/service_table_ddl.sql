
drop table god_db.question

create table god_db.question
(
    id          bigint auto_increment comment '问题ID'
        primary key,
    title       varchar(200)                                                  not null comment '问题标题',
    subject     varchar(100)                                                  null comment '学科',
    content     text                                                          null comment '问题内容',
    difficulty  tinyint                                                       null comment '难度',
    heat        int                                 default 0                 null comment '热度',
    status      enum ('未分配', '攻坚中', '已解决') default '未分配'          null,
    create_by   bigint                                                        null comment '创建者',
    create_time datetime                            default CURRENT_TIMESTAMP null comment '创建时间',
    del_flag    char                                default '0'               null comment '删除标志'
)
    comment '考研问题表';

