package pages;

import pages.PageComponents.*;

public class PageFactoryManager {

    private PageFactoryManager() {
    }

    public static LoginPage getLoginPage() {
        return new LoginPage();
    }

    public static ProductsPage getProductsPage() {
        return new ProductsPage();
    }

    public static ProductDetailsPage getProductDetailsPage() {
        return new ProductDetailsPage();
    }

    public static CartPage getCartPage() {
        return new CartPage();
    }

    public static CheckoutPage getCheckoutPage() {
        return new CheckoutPage();
    }

    public static CheckoutInformationPage getCheckoutInformationPage() {
        return new CheckoutInformationPage();
    }

    public static CheckoutOverviewPage getCheckoutOverviewPage() {
        return new CheckoutOverviewPage();
    }

    public static CheckoutCompletePage getCheckoutCompletePage() {
        return new CheckoutCompletePage();
    }

    public static MenuPage getMenuPage() {
        return new MenuPage();
    }
}
