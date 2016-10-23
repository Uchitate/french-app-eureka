-- 1->2
ALTER TABLE user ADD password VARCHAR(500) after name;
UPDATE user SET password = 'b653f9375528e754aaa40e0b2b27ee2e2b58e1ca37caca378e019f990a6053c7b5d87a6fe2be6f26';
ALTER TABLE user modify password VARCHAR(500) NOT NULL;