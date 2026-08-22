package utils;

import models.LoginData;

public final class TestDataBuilder {

    private TestDataBuilder() {
    }

    public static LoginData getLoginData() {

        return JsonUtil.read(
                "src/test/resources/testdata/loginData.json",
                LoginData.class);

    }
}
