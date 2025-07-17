CREATE TABLE user_info (
                           id BIGINT PRIMARY KEY AUTO_INCREMENT,
                           username VARCHAR(100) NOT NULL,
                           password VARCHAR(100),
                           kaoyan_code VARCHAR(50) NOT NULL COMMENT '用户考研代号',
                           subject_codes VARCHAR(255) COMMENT '选考科目代号，用逗号分隔',
                           team_id BIGINT COMMENT '加入的队伍ID',
                           created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE subject_mapping (
                                 id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                 kaoyan_code VARCHAR(50) NOT NULL COMMENT '考研代号',
                                 subject_code VARCHAR(50) NOT NULL COMMENT '单科代码',
                                 subject_name VARCHAR(100) COMMENT '科目名称'
);
CREATE TABLE team (
                      id BIGINT PRIMARY KEY AUTO_INCREMENT,
                      team_name VARCHAR(100) NOT NULL,
                      subject_code VARCHAR(50) NOT NULL COMMENT '绑定科目',
                      description TEXT,
                      created_by BIGINT COMMENT '创建人用户ID',
                      created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE meeting (
                         id BIGINT PRIMARY KEY AUTO_INCREMENT,
                         team_id BIGINT NOT NULL,
                         title VARCHAR(100) COMMENT '难点，问题，会议主题',
                         meeting_time DATETIME NOT NULL,
                         speaker_id BIGINT NOT NULL COMMENT '主讲人ID',
                         member_ids TEXT COMMENT '参会成员ID，用逗号分隔',
                         created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);
# 模拟数据添加
INSERT INTO user_info (username, password, kaoyan_code, subject_codes, team_id)
VALUES
    ('zhangsan', 'pass123', '11408', '101,201', 1),
    ('lisi', 'pass456', '11408', '101,202', 2),
    ('wangwu', 'pass789', '11407', '101', 1),
    ('zhaoliu', 'pass234', '11408', '202', 2);
INSERT INTO subject_mapping (kaoyan_code, subject_code, subject_name)
VALUES
    ('11408', '101', '思想政治理论'),
    ('11408', '201', '英语一'),
    ('11408', '202', '数学二'),
    ('11407', '101', '思想政治理论'),
    ('11407', '201', '英语一');
INSERT INTO team (team_name, subject_code, description, created_by)
VALUES
    ('11408政治组', '101', '11408的政治学习组', 1),
    ('11408数学组', '202', '11408的数学复习团队', 2);
INSERT INTO meeting (team_id, title, meeting_time, speaker_id, member_ids)
VALUES
    (1, '如何理解毛概重点', '2025-07-10 19:00:00', 1, '1,3'),
    (2, '高数压轴题讲解', '2025-07-11 20:00:00', 2, '2,4');