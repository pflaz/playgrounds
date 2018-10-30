INSERT INTO playgrounds.users (name, login, password, email) VALUES ('test user 1 name', 'login1', 'pass1', 'test1@test.pl');
INSERT INTO playgrounds.users (name, login, password, email) VALUES ('test user 2 name', 'login2', 'pass2', 'test2@test.pl');
INSERT INTO playgrounds.users (name, login, password, email) VALUES ('test user 3 name', 'login3', 'pass3', 'test3@test.pl');

INSERT INTO playgrounds.attractions_types(name) VALUES ('attr type 1');
INSERT INTO playgrounds.attractions_types(name) VALUES ('attr type 2');
INSERT INTO playgrounds.attractions_types(name) VALUES ('attr type 3');

INSERT INTO playgrounds.playgrounds(address, city, description, latitude, longitude, postal_code, user_id) VALUES ('address 1', 'City 1', 'Desc 1', '51.11', '31.11', '11-111', 1);
INSERT INTO playgrounds.playgrounds(address, city, description, latitude, longitude, postal_code, user_id) VALUES ('address 2', 'City 2', 'Desc 2', '52.22', '32.22', '22-222', 2);
INSERT INTO playgrounds.playgrounds(address, city, description, latitude, longitude, postal_code, user_id) VALUES ('address 3', 'City 3', 'Desc 3', '53.33', '33.33', '33-333', 3);

INSERT INTO playgrounds.attractions(description, quantity, attraction_type_id, playground_id) VALUES ('desc1', 1, 1, 1);
INSERT INTO playgrounds.attractions(description, quantity, attraction_type_id, playground_id) VALUES ('desc2', 2, 2, 2);
INSERT INTO playgrounds.attractions(description, quantity, attraction_type_id, playground_id) VALUES ('desc3', 3, 3, 3);

INSERT INTO playgrounds.rates(comment, rate, rated_date_time, playground_id, user_id) VALUES ('comm 1', 1, NOW(), 1, 1);
INSERT INTO playgrounds.rates(comment, rate, rated_date_time, playground_id, user_id) VALUES ('comm 2', 1, NOW(), 2, 2);
INSERT INTO playgrounds.rates(comment, rate, rated_date_time, playground_id, user_id) VALUES ('comm 3', 1, NOW(), 3, 3);