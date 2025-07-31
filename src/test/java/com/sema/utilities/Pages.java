package com.sema.utilities;

import com.sema.pages.Analysis.Cocpit.CocpitGeneralDashboard;
import com.sema.pages.Analysis.RFM.RFM;
import com.sema.pages.Analysis.SalesDashboards;
import com.sema.pages.HomePage;
import com.sema.pages.LoginPage;
import com.sema.pages.MDMPage.AccountManagement.AccountHomePage;
import com.sema.pages.MDMPage.AssetManagement.Asset;
import com.sema.pages.MDMPage.AssetManagement.AssetEditPage;
import com.sema.pages.MDMPage.CampaignManagement.CampaignHomePage;
import com.sema.pages.MDMPage.ConnectorManagement4.ConnectorHomePage;
import com.sema.pages.MDMPage.ContactManagement.ContactEditPage;
import com.sema.pages.MDMPage.ContactManagement.ContactHomePage;
import com.sema.pages.MDMPage.ContactManagement.ContactHomePageMyContactPage;
import com.sema.pages.MDMPage.ContractManagement.Contract;
import com.sema.pages.MDMPage.EventManagement.EventHomePage;
import com.sema.pages.MDMPage.GiftManagement.Gift;
import com.sema.pages.MDMPage.GiftManagement.GiftHomePage;
import com.sema.pages.MDMPage.KPIManagement.KPIHomePage;
import com.sema.pages.MDMPage.ProductManagement.ProductHomePage;
import com.sema.pages.MDMPage.UserManagement.UserHomePage;
import com.sema.pages.SettingsPage.Attributes;
import com.sema.pages.SettingsPage.Families;
import com.sema.pages.SettingsPage.Import;
import com.sema.pages.SettingsPage.TagsPage;
import com.sema.pages.SystemPage.CurrenciesPage;
import com.sema.pages.SystemPage.UserManagement.Users;
import com.sema.pages.SystemPage.UserManagement.UsersLogs;



public class Pages {

    private HomePage homePage;
    private LoginPage loginPage;
    private Contract contract;
    private Asset asset;
    private Gift gift;
    private GiftHomePage giftHomePage;
    private ContactHomePage contactHomePage;
    private ContactHomePageMyContactPage contactHomePageMyContactPage;
    private ContactEditPage contactEditPage;
    private AssetEditPage assetEditPage;
    private EventHomePage  eventHomePage;
    private CampaignHomePage campaignHomePage;
    private KPIHomePage kpiHomePage;
    private Families families;
    private Attributes attributes;
    private Users users;
    private ConnectorHomePage connectorHomePage;
    private UserHomePage userHomePage;
    private UsersLogs usersLogs;
    private AccountHomePage accountHomePage;
    private ProductHomePage productHomePage;
    private CurrenciesPage currenciesPage;
    private TagsPage tagsPage;
    private Import importPage;
    private CocpitGeneralDashboard cocpitGeneralDashboard;
    private RFM rfm;
    private SalesDashboards salesDashboards;


    public Pages() {
            this.homePage =new HomePage();
            this.loginPage =new LoginPage();
            this.contract=new Contract();
            this.asset= new Asset();
            this.gift=new Gift();
            this.contactHomePage=new ContactHomePage();
            this.contactHomePageMyContactPage= new ContactHomePageMyContactPage();
            this.contactEditPage= new ContactEditPage();
            this.assetEditPage= new AssetEditPage();
            this.eventHomePage=new EventHomePage();
            this.campaignHomePage=new CampaignHomePage();
            this.kpiHomePage=new KPIHomePage();
            this.families=new Families();
            this.attributes=new Attributes();
            this.users=new Users();
            this.connectorHomePage= new ConnectorHomePage();
            this.userHomePage= new UserHomePage();
            this.usersLogs= new UsersLogs();
            this.accountHomePage=new AccountHomePage();
            this.productHomePage=new ProductHomePage();
            this.giftHomePage=new GiftHomePage();
            this.currenciesPage = new CurrenciesPage();
            this.giftHomePage=new GiftHomePage();
            this.tagsPage=new TagsPage();
            this.importPage=new Import();
             this.cocpitGeneralDashboard = new CocpitGeneralDashboard();
             this.rfm= new RFM();
             this.salesDashboards = new SalesDashboards();

    }
    // Getter metotları
    public HomePage homePage() {
        return homePage;
    }
    public LoginPage loginPage(){
        return loginPage;
    }
    public Contract contract(){ return contract;}
    public Asset asset() {return asset;}
    public Gift gift(){return gift;}
    public ContactHomePage contactHomePage(){ return contactHomePage;}
    public ContactHomePageMyContactPage contactHomePageMyContactPage(){return contactHomePageMyContactPage;}
    public ContactEditPage contactEditPage(){return contactEditPage;}
    public AssetEditPage assetEditPage(){return assetEditPage;}
    public EventHomePage eventHomePage(){return eventHomePage;}
    public CampaignHomePage campaignHomePage(){return campaignHomePage;}
    public KPIHomePage kpiHomePage(){return kpiHomePage;}
    public Families families(){return families;}
    public Attributes attributes(){return attributes;}
    public  Users users(){return users;}
    public ConnectorHomePage connectorHomePage(){return connectorHomePage;}
    public UserHomePage userHomePage(){return userHomePage;}
    public UsersLogs userLogs(){return usersLogs;}
    public AccountHomePage accountHomePage(){return accountHomePage;}
    public ProductHomePage productHomePage(){return productHomePage;}
    public GiftHomePage giftHomePage(){return giftHomePage;}
    public CurrenciesPage currenciesPage(){return currenciesPage;}
    public TagsPage tagsPage(){return tagsPage;}
    public Import importPage(){return importPage;}
    public CocpitGeneralDashboard cocpit() {return cocpitGeneralDashboard;}
    public RFM rfm() {return rfm;}
    public SalesDashboards salesDashboards() {return  salesDashboards;}


}



