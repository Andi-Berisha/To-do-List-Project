drop table if exists task_domain CASCADE ;
drop table if exists user_domain CASCADE ;
create table task_domain (id bigint auto_increment not null, has_task_been_completed_check boolean not null, task_name varchar(255) not null, user_id bigint, primary key (id));
create table user_domain (id bigint auto_increment not null, user_name varchar(255), user_surname varchar(255), primary key (id));
alter table task_domain add constraint FKj7odm2792jkgbne8tea5jd8iu foreign key (user_id) references user_domain on delete cascade;