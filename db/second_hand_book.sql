CREATE TABLE book (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
                      title VARCHAR(255) NOT NULL COMMENT '书名',
                      author VARCHAR(100) COMMENT '作者',
                      publisher VARCHAR(100) COMMENT '出版社',
                      isbn VARCHAR(20) COMMENT 'ISBN编号',
                      stock INT DEFAULT 0 COMMENT '库存数量',
                      price DECIMAL(10,2) COMMENT '价格（元）',
                      category VARCHAR(50) COMMENT '图书分类',
                      publish_date DATE COMMENT '出版日期',
                      created_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                      updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT='图书信息表';