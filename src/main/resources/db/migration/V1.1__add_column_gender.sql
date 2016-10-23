ALTER TABLE user ADD gender VARCHAR(10) after age;
UPDATE user SET gender = 'MAN';
ALTER TABLE USER modify gender VARCHAR(10) NOT NULL;