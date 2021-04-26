INSERT INTO users (username, password) VALUES ('user', 'password');
INSERT INTO users (username, password) VALUES ('admin', 'password');

INSERT INTO authorities (username, authority) VALUES ('user', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');