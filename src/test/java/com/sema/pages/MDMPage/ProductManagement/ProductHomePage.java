package com.sema.pages.MDMPage.ProductManagement;

import com.sema.pages.BasePage;

public class ProductHomePage extends BasePage {
    public ProductHomePage() {
    }
    public void onTheUserPage(){
        driver.navigate().to("https://diageo.efectura.com/Enrich/Items?itemType=Product");
    }
}

