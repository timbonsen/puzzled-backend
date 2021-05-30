INSERT INTO addresses (id, city, country, housenumber, postalcode, streetname) VALUES ('5b53da60-a921-4245-8b47-de67d47abc82', 'Teststad', 'Testland', '123', '1234 AB', 'teststraat');

INSERT INTO users (username, password, email, firstname, lastname, address_id) VALUES ('user', '$2a$10$sRvXFMZ67Bo85Dh.jO7KJ.LMlmLa0T3HdTsuCpp8dDs0r/gCBR20i', 'user@puzzled.nl', 'User', 'Userson', '5b53da60-a921-4245-8b47-de67d47abc82');
INSERT INTO users (username, password, email, firstname, lastname) VALUES ('admin', '$2a$10$sRvXFMZ67Bo85Dh.jO7KJ.LMlmLa0T3HdTsuCpp8dDs0r/gCBR20i', 'admin@puzzled.nl', 'Admin', 'Admiraal');

INSERT INTO authorities (username, authority) VALUES ('user', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');



