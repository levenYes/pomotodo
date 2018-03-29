create table pomos(
   uuid VARCHAR(100) NOT NULL ,
   created_at DATETIME NOT NULL,
   updated_at DATETIME NOT NULL,
   description VARCHAR(100) CHARACTER SET  utf8 NOT NULL,
   started_at DATETIME NOT NULL,
   ended_at DATETIME NOT NULL,
   local_started_at DATETIME NOT NULL,
   local_ended_at DATETIME NOT NULL,
   length INT NOT NULL,
   abandoned tinyint(1) NOT NULL,
   manual tinyint(1) NOT NULL	
);
