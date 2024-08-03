create table reminders
(
    id          uuid      not null,
    title       varchar   not null,
    description varchar,
    ends_at     timestamp not null,
    done        boolean   not null,
    primary key (id)
);