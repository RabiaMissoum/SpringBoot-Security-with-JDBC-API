
INSERT INTO users (username,password, enabled) values ('rabia','123',true)

INSERT INTO users(username,password, enabled) values ('foo','foo',true)

INSERT INTO authorities(username, authority) values('rabia', 'ROLE_USER')

INSERT INTO authorities(username, authority) values('foo', 'ROLE_ADMIN')
