-- 创建数据库
CREATE SCHEMA IF NOT EXISTS `forus` DEFAULT CHARACTER SET utf8 ;

-- 创建表
-- 用户表
DROP TABLE IF EXISTS `forus`.`users`;
CREATE TABLE IF NOT EXISTS `forus`.`users` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(50) NOT NULL,
  `nickname` VARCHAR(50) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `join_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` TINYINT NOT NULL DEFAULT 2,  -- 用户状态： 1：正常；2：未激活；3：禁止评论；4：禁止发帖；5：禁止登录
  `avatar` VARCHAR(200) NOT NULL,
  `bio` VARCHAR(250) NULL,  -- 用户简介
  `role` TINYINT NOT NULL DEFAULT 1,  -- 用户角色：0：游客；1：会员；2：管理员；3：超级管理员
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- 版块表
DROP TABLE IF EXISTS `forus`.`sections`;
CREATE TABLE IF NOT EXISTS `forus`.`sections` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(20) NOT NULL,
  `belong_to` INT NULL,
  PRIMARY KEY (`id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- 发帖表
DROP TABLE IF EXISTS `forus`.`posts`;
CREATE TABLE IF NOT EXISTS `forus`.`posts` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `author` INT UNSIGNED NOT NULL,
  `title` VARCHAR(100) NOT NULL,
  `content` LONGTEXT NOT NULL,
  `view_role` TINYINT NOT NULL DEFAULT 0,  -- 查看权限：0：游客及以上；1：正式会员及以上；3：仅管理员
  `pub_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `comment_status` TINYINT NOT NULL DEFAULT 1,  -- 评论状态：0：禁止评论；1：允许评论
  `comment_count` INT NOT NULL DEFAULT 0,
  `star_count` INT NOT NULL DEFAULT 0,
  `belong_to` INT UNSIGNED NOT NULL,  -- 所属版块
  PRIMARY KEY (`id`),
  UNIQUE INDEX `author_UNIQUE` (`author` ASC),
  INDEX `fk_posts_sections_idx` (`belong_to` ASC),
  CONSTRAINT `fk_posts_users`
  FOREIGN KEY (`author`)
  REFERENCES `forus`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_posts_sections`
  FOREIGN KEY (`belong_to`)
  REFERENCES `forus`.`sections` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- 评论表
DROP TABLE IF EXISTS `forus`.`comments`;
CREATE TABLE IF NOT EXISTS `forus`.`comments` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `post_id` INT UNSIGNED NOT NULL,
  `author_id` INT UNSIGNED NOT NULL,
  `at_id` INT UNSIGNED NULL, -- 所回复的用户的ID
  `content` TEXT NOT NULL,
  `pub_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX `fk_comments_posts_idx` (`post_id` ASC),
  INDEX `fk_comments_author_idx` (`author_id` ASC),
  INDEX `fk_comments_at_idx` (`at_id` ASC),
  CONSTRAINT `fk_comments_posts`
  FOREIGN KEY (`post_id`)
  REFERENCES `forus`.`posts` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comments_author`
  FOREIGN KEY (`author_id`)
  REFERENCES `forus`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comments_at`
  FOREIGN KEY (`at_id`)
  REFERENCES `forus`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- 关注表
DROP TABLE IF EXISTS `forus`.`followers`;
CREATE TABLE IF NOT EXISTS `forus`.`followers` (
  `user_id` INT UNSIGNED NOT NULL,
  `follower_id` INT UNSIGNED NOT NULL,
  `follow_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`, `follower_id`),
  INDEX `fk_followers_followers_idx` (`follower_id` ASC),
  CONSTRAINT `fk_followers_users`
  FOREIGN KEY (`user_id`)
  REFERENCES `forus`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_followers_followers`
  FOREIGN KEY (`follower_id`)
  REFERENCES `forus`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- 消息表
DROP TABLE IF EXISTS `forus`.`events`;
CREATE TABLE IF NOT EXISTS `forus`.`events` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` INT UNSIGNED NOT NULL,
  `type` TINYINT NOT NULL, -- 消息类型：0：系统消息；1：有人关注我；2：有人@我
  `message` VARCHAR(100) NOT NULL,
  `related_id` INT UNSIGNED NULL DEFAULT NULL,
  `unread` TINYINT NOT NULL DEFAULT 1, -- 消息是否已读：0：已读；1：未读
  `happen_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX `fk_events_users_idx` (`user_id` ASC),
  INDEX `fk_events_related_idx` (`related_id` ASC),
  CONSTRAINT `fk_events_users`
  FOREIGN KEY (`user_id`)
  REFERENCES `forus`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_events_related`
  FOREIGN KEY (`related_id`)
  REFERENCES `forus`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

