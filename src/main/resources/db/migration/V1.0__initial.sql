CREATE TABLE user (
  id        BIGINT auto_increment,
  name      VARCHAR(100) NOT NULL,
  email     VARCHAR(100),
  age       INT,
  PRIMARY KEY (id)
);

INSERT INTO user (name, email, age) VALUES ('ichiro', 'shiken@ichiro.co.jp', '44');
INSERT INTO user (name, email, age) VALUES ('jiro', 'shiken@jiro.co.jp', '26');
INSERT INTO user (name, email, age) VALUES ('saburo', 'shiken@saburo.co.jp', '12');
INSERT INTO user (name, email, age) VALUES ('uchitate', 'uchitate@ryosuke.co.jp', '26');