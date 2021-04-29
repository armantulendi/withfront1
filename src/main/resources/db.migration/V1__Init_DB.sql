create table book
(
    id     int auto_increment
        primary key,
    booking_amount varchar(255) null,
    created_by     int          null,
    drop_address   varchar(255) null,
    pickup_address varchar(255) null
);

-- auto-generated definition
create table dr_gateways
(
    gwid        int          not null
        primary key,
    attrs       varchar(255) null,
    description varchar(255) null,
    address     varchar(255) null,
    pri_prefix  varchar(255) null,
    strip       int          not null,
    type        int          not null
);
-- auto-generated definition
create table dr_groups
(
    id          int          not null
        primary key,
    description varchar(255) null,
    domain      varchar(255) null,
    groupid     int          null,
    username    varchar(255) null
);
-- auto-generated definition
create table dr_rules
(
    ruleid      int          not null
        primary key,
    description varchar(255) null,
    groupid     varchar(255) null,
    gwlist      varchar(255) null,
    prefix      varchar(255) null,
    priority    int          not null,
    routeid     varchar(255) null,
    timerec     varchar(255) null
);
-- auto-generated definition
create table hibernate_sequence
(
    next_val bigint null
);

-- auto-generated definition
create table subscriber
(
    id       int          not null
        primary key,
    domain   varchar(255) null,
    ha1      varchar(255) null,
    ha1b     varchar(255) null,
    password varchar(255) null,
    username varchar(255) null
);

-- auto-generated definition
create table user_role
(
    user_id bigint       not null,
    roles   varchar(255) null,
    constraint FKfpm8swft53ulq2hl11yplpr5
        foreign key (user_id) references usr (id)
);

-- auto-generated definition
create table usr
(
    id              bigint       not null
        primary key,
    active          bit          not null,
    email           varchar(255) null,
    firstname       varchar(255) null,
    lastname        varchar(255) null,
    password        varchar(255) null,
    repeat_password varchar(255) null,
    username        varchar(255) null
);




