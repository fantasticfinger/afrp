create table user (
id VARCHAR(256),
pw VARCHAR(256),
name VARCHAR(256),
phone VARCHAR(256),
email VARCHAR(256),
type_au VARCHAR(256),
team_name VARCHAR(256)
);

create table info_team (
team_name VARCHAR(256),
coach_name VARCHAR(256),
remark VARCHAR(256),
num_member INTEGER,
captain VARCHAR(256)
);

create table info_game(
num INTEGER,
home_team VARCHAR(256),
away_team VARCHAR(256),
gameday VARCHAR(256)
);