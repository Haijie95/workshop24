# Workshop 24

## Dependency
1. Dev tools
2. Spring Web
3. Lombok
4. JDBC API
5. TheymeLeaf
6. MYSQL driver
7.SPringdata JPA
8. JSON p
```
        <dependency>
			<groupId>org.glassfish</groupId>
			<artifactId>jakarta.json</artifactId>
			<version>2.0.1</version>
		</dependency>
```

## Creating
CREATE SCHEMA `shensang` ;

CREATE TABLE `shensang`.`purchase_order` (
  `order_id` CHAR(8) NOT NULL,
  `name` VARCHAR(128) NOT NULL,
  `order_date` DATE NOT NULL,
  PRIMARY KEY (`order_id`));

CREATE TABLE `shensang`.`line_item` (
  `item_id` INT NOT NULL AUTO_INCREMENT,
  `description` TEXT NOT NULL,
  `quantity` INT NULL,
  `order_id` CHAR(8) NOT NULL,
  PRIMARY KEY (`item_id`),
  INDEX `fk_order_id_idx` (`order_id` ASC) VISIBLE,
  CONSTRAINT `fk_order_id`
    FOREIGN KEY (`order_id`)
    REFERENCES `shensang`.`purchase_order` (`order_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

## Notes
transactional for insert, update, delete and select(seeing the bank acc)
example would be ibanking, selecting the bank to see the balance for the acc
before keying in the amt to transfer

# Step for railway
1. railway login
2. after login railway init
3. give a name
4. wait for service to be created in railway
5. new add database -> mysql
6. it will create a mysql
7. railway up
8. change url user and pw in application.properties to
```this one add in railway variables
MYSQL_APP_URL = 
```
MYSQL_APP_USER
MYSQL_APP_PORT
MYSQL_APP_PW
MYSQL_APP_HOST
MYSQL_APP_DATABASE
to create in mysql

create new user
change the pw
change the url -> in the link change the root to user named name

setting generate domain
and you are done



