create table user_subscriptions(
            channel_id integer not null references usr,
            subscriber_id integer not null references usr,
            primary key (channel_id,subscriber_id)
);