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