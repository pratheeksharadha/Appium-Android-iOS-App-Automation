package utils;

import net.datafaker.Faker;

public class RandomDataUtils {

    private static final Faker faker = new Faker();

    private RandomDataUtils() {
    }

    /**
     * Generate random first name.
     */
    public static String getFirstName() {
        return faker.name().firstName();
    }

    /**
     * Generate random last name.
     */
    public static String getLastName() {
        return faker.name().lastName();
    }

    /**
     * Generate random full name.
     */
    public static String getFullName() {
        return faker.name().fullName();
    }

    /**
     * Generate random email.
     */
    public static String getEmail() {
        return faker.internet().emailAddress();
    }

    /**
     * Generate random phone number.
     */
    public static String getPhoneNumber() {
        return faker.phoneNumber().cellPhone();
    }

    /**
     * Generate random number.
     */
    public static int getNumber(int min, int max) {
        return faker.number().numberBetween(min, max);
    }
}
