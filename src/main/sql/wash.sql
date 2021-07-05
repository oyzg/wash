USE clothes;

CREATE TABLE clothes (
                         `cid` BIGINT PRIMARY KEY AUTO_INCREMENT,
                         `ccount` BIGINT,
                         `mid` BIGINT,
                         `aid` BIGINT,
                         `date` DATE,
                         `tid` BIGINT
);

CREATE TABLE assistant (
                           `mid` BIGINT PRIMARY KEY AUTO_INCREMENT,
                           `mname` VARCHAR(200),
                           `pssword` VARCHAR(20)
);

CREATE TABLE member (
                        `mid` BIGINT PRIMARY KEY AUTO_INCREMENT,
                        `mname` VARCHAR(200),
                        `grade` INT,
                        `balance` BIGINT
);

CREATE TABLE typeprice (
                           `tid` BIGINT PRIMARY KEY AUTO_INCREMENT,
                           `tname` VARCHAR(200),
                           `unitprice` BIGINT
);