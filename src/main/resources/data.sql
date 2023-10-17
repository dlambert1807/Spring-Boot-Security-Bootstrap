INSERT INTO user (id, email, name, last_name, receive_emails, enabled, password, token_expired)
values (1001,
        "admin@admin.com",
        "Admin",
        "Test",
        true,
        false,
        "$2a$10$NAVjVScyrC0iR6q9o6oIbe2uT.s0hFKop/lgcLzc.iUraGu4UU5cy",
        false);
# Password is "password" with BCryot encoding.
INSERT INTO role (id, authority)
values (1,"ADMIN");
INSERT INTO role (id, authority)
values (2,"USER");

INSERT INTO users_roles (user_id, role_id)
values (1001,1);
INSERT INTO users_roles (user_id, role_id)
values (1001,2);

SELECT * FROM role;
/*DELETE FROm role WHERE id=1;
DELETE FROm role WHERE id=2;*/