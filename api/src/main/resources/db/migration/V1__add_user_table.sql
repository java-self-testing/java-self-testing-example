CREATE TABLE user
(
    `id`   varchar(36) not null primary key,
    `name` varchar(36) not null,
    `role` varchar(36) not null,
    `email` varchar(50) not null,
    `password` varchar(400) not null,
    `created_at` timestamp(3) not null default current_timestamp(3),
    `updated_at` timestamp(3) not null default current_timestamp(3) on update current_timestamp(3)
);

INSERT INTO `user` (`id`,`name`,`role`,`email`,`password`,`created_at`,`updated_at`) VALUES ('admin-id','admin','ADMIN','admin@test.com','$2a$10$Q9xt3B2Ixe0tGnbCjVWAbunD4lYdf5PpMSYGyLNrD4S38FGUt4NMC','2020-12-17 05:45:41.147','2020-12-17 05:45:41.147');
