package net.kerba.demo.redis.main;

import java.io.Serializable;

/**
 * @user: kerb
 * @created: 04/06/2017.
 */
public class Person implements Serializable {

    private String firstName;

    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
