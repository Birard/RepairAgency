package com.myCompany.RepairAgency.db.entity;

public class User {

    private int id;
    private String login;
    private String password;
    private int role_id;
    private int account;

    private User() {
    }

    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id=id;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public User setLogin(String login) {
        this.login=login;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password=password;
        return this;
    }

    public int getRole_id() {
        return role_id;
    }

    public User setRole_id(int role_id) {
        this.role_id=role_id;
        return this;
    }

    public int getAccount() {
        return account;
    }

    public User setAccount(int account) {
        this.account=account;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof User)) return false;
        return this.login.equals(((User) obj).login);
    }

    public static class UserBuilder {
        private User onConstructUser;

        public UserBuilder() {
            this.onConstructUser=new User();
        }

        public User build() {
            if (isReady()) {
                User ready=onConstructUser;
                this.onConstructUser=new User();
                return ready;
            } else {
                throw new IllegalArgumentException("User not ready");
            }

        }

        public boolean isReady() {
            return onConstructUser.login != null && !onConstructUser.login.isBlank() && onConstructUser.password != null
                    && !onConstructUser.password.isBlank() && onConstructUser.role_id != 0;
        }

        public int getId() {
            return onConstructUser.id;
        }

        public UserBuilder setId(int id) {
            this.onConstructUser.id=id;
            return this;
        }

        public String getLogin() {
            return onConstructUser.login;
        }

        public UserBuilder setLogin(String login) {
            this.onConstructUser.login=login;
            return this;
        }

        public String getPassword() {
            return onConstructUser.password;
        }

        public UserBuilder setPassword(String password) {
            this.onConstructUser.password=password;
            return this;
        }

        public int getRole_id() {
            return onConstructUser.role_id;
        }

        public UserBuilder setRole_id(int role_id) {
            this.onConstructUser.role_id=role_id;
            return this;
        }

        public int getAccount() {
            return onConstructUser.account;
        }

        public UserBuilder setAccount(int account) {
            this.onConstructUser.account=account;
            return this;
        }


    }
}