CREATE TABLE user (
  id        BIGINT auto_increment,
  name      VARCHAR(100) NOT NULL,
  password      VARCHAR(100) NOT NULL,
  email     VARCHAR(100),
  age       INT,
  gender    VARCHAR(10) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE french (
  id        BIGINT auto_increment,
  name      VARCHAR(100) NOT NULL,
  zip       INT          NOT NULL,
  line1     VARCHAR(100) NOT NULL,
  line2     VARCHAR(100),
  line3     VARCHAR(100),
  other     VARCHAR(100),
  PRIMARY KEY (id)
);

INSERT INTO user (name, password, email, age, gender) VALUES ('ichiro', 'b653f9375528e754aaa40e0b2b27ee2e2b58e1ca37caca378e019f990a6053c7b5d87a6fe2be6f26', 'shiken@ichiro.co.jp', '44', 'MAN');
INSERT INTO user (name, password, email, age, gender) VALUES ('jiro', 'b653f9375528e754aaa40e0b2b27ee2e2b58e1ca37caca378e019f990a6053c7b5d87a6fe2be6f26', 'shiken@jiro.co.jp', '26', 'MAN');
INSERT INTO user (name, password, email, age, gender) VALUES ('saburo', 'b653f9375528e754aaa40e0b2b27ee2e2b58e1ca37caca378e019f990a6053c7b5d87a6fe2be6f26', 'shiken@saburo.co.jp', '12', 'MAN');
INSERT INTO user (name, password, email, age, gender) VALUES ('uchitate', 'b653f9375528e754aaa40e0b2b27ee2e2b58e1ca37caca378e019f990a6053c7b5d87a6fe2be6f26', 'uchitate@ryosuke.co.jp', '26', 'MAN');

INSERT INTO french (name, zip, line1, line2, line3) VALUES ('tagbangers', 2210052, '神奈川県', '横浜市神奈川区', '栄町17-2' 'ポートサイドサクラビル2F');