package utils;

public class DynamicDataGenerator {

    private DynamicDataGenerator() {
    }

    public static String getRandomEmail() {
        return RandomDataUtils.getEmail();
    }

    public static String getRandomFirstName() {
        return RandomDataUtils.getFirstName();
    }

    public static String getRandomLastName() {
        return RandomDataUtils.getLastName();
    }

    public static String getRandomPhone() {
        return RandomDataUtils.getPhoneNumber();
    }
}
