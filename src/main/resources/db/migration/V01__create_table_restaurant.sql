CREATE TABLE restaurant
(
restaurant_id INT PRIMARY KEY,
restaurant_name VARCHAR(60),
restaurant_category VARCHAR(60),
restaurant_description VARCHAR(60)
);

INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_category, restaurant_description)
VALUES (1, 'Feijão de Corda', 'Comidas Tipicas', 'Comida Nordestina');