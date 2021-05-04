
INSERT INTO users (username, password, emailaddress, firstname, lastname) VALUES ('user', '$2a$10$a1/6XZfjoXwP5Dc7kvwNyeHIxFTkA.YU2WX0lVGEGyDhGNYr4jTS2', 'user@puzzled.nl', 'User', 'Userson');
INSERT INTO users (username, password, emailaddress, firstname, lastname) VALUES ('admin', '$2a$10$a1/6XZfjoXwP5Dc7kvwNyeHIxFTkA.YU2WX0lVGEGyDhGNYr4jTS2', 'admin@puzzled.nl', 'Admin', 'Admiraal');

INSERT INTO authorities (username, authority) VALUES ('user', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');

