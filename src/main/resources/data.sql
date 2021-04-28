INSERT INTO users (username, password) VALUES ('user', '$2a$10$a1/6XZfjoXwP5Dc7kvwNyeHIxFTkA.YU2WX0lVGEGyDhGNYr4jTS2');
INSERT INTO users (username, password) VALUES ('admin', '$2a$10$a1/6XZfjoXwP5Dc7kvwNyeHIxFTkA.YU2WX0lVGEGyDhGNYr4jTS2');

INSERT INTO authorities (username, authority) VALUES ('user', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');