CREATE TABLE french (
  id        BIGINT auto_increment,
  name      VARCHAR(100) NOT NULL,
  password      VARCHAR(100) NOT NULL,
  email     VARCHAR(100),
  address     VARCHAR(100),
  PRIMARY KEY (id)
);

INSERT INTO french (name, password, email, age, gender) VALUES ('ichiro', 'b653f9375528e754aaa40e0b2b27ee2e2b58e1ca37caca378e019f990a6053c7b5d87a6fe2be6f26', 'shiken@ichiro.co.jp', '44', 'MAN');
INSERT INTO french (name, password, email, age, gender) VALUES ('jiro', 'b653f9375528e754aaa40e0b2b27ee2e2b58e1ca37caca378e019f990a6053c7b5d87a6fe2be6f26', 'shiken@jiro.co.jp', '26', 'MAN');
INSERT INTO french (name, password, email, age, gender) VALUES ('saburo', 'b653f9375528e754aaa40e0b2b27ee2e2b58e1ca37caca378e019f990a6053c7b5d87a6fe2be6f26', 'shiken@saburo.co.jp', '12', 'MAN');
INSERT INTO french (name, password, email, age, gender) VALUES ('uchitate', 'b653f9375528e754aaa40e0b2b27ee2e2b58e1ca37caca378e019f990a6053c7b5d87a6fe2be6f26', 'uchitate@ryosuke.co.jp', '26', 'MAN');