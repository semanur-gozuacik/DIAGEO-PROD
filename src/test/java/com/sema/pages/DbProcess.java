package com.sema.pages;



import com.sema.utilities.Database;
import com.sema.utilities.DatabaseManager;
import com.sema.utilities.DbConfigs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbProcess extends BasePage {
    public String getUserLocale(String username) {
        String query = "Select UI_Locale From [User] WHERE UserName = '" + username + "'";

        String locale = null;
        try (Connection conn = Database.getInstance();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                // İlk kolondaki tarih bilgisini al
                locale = rs.getString("UI_Locale");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(username + " user locale: " + locale);
        return locale;

    }

    public List<String> getRequiredAttributes(String itemType, String importItemFamilies, String locale) {
        locale = locale.replace("-", "_");
        String query = "SELECT DISTINCT a.Code as AttributeCode From Attributes a \n" +
                "Join ItemTypeColumns itc On a.ItemType = itc.Type\n" +
                "JOIN AttributeFamilies af On a.Id = af.Attribute_Id \n" +
                "Join Families f On af.Family_Id = f.Id\n" +
                "WHERE itc.TypeName = '" + itemType + "' AND a.is_required = 1 And f.[" + locale + "] IN " + importItemFamilies;

        List<String> requiredAttributes = new ArrayList<>();

        try (Connection conn = Database.getInstance();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                // İlk kolondaki tarih bilgisini al
                requiredAttributes.add(rs.getString("AttributeCode"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(itemType + " required attributes: " + requiredAttributes);
        return requiredAttributes;
    }

    public List<String> getFamiliesOfImportItem(String itemType, String locale) {
        locale = locale.replace("-", "_");
        String query = "SELECT " + locale + " FROM Families f \n" +
                "WHERE ItemType = (SELECT Type From ItemTypeColumns WHERE TypeName = '" + itemType + "')";

        List<String> familiesOfImportItem = new ArrayList<>();

        try (Connection conn = Database.getInstance();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                // İlk kolondaki tarih bilgisini al
                familiesOfImportItem.add(rs.getString(locale));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(itemType + " families: " + familiesOfImportItem);

        return familiesOfImportItem;

    }

    public List<String> getCategoriesOfImportItem(String itemType, String locale) {
        locale = locale.replace("-", "_");
        String query = "SELECT " + locale + " FROM Categories \n" +
                "WHERE ItemType = (SELECT Type From ItemTypeColumns WHERE TypeName = '" + itemType + "')";

        System.out.println("kategori query: \n" + query);

        List<String> categoriesOfImportItem = new ArrayList<>();

        try (Connection conn = Database.getInstance();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                // İlk kolondaki tarih bilgisini al
                categoriesOfImportItem.add(rs.getString(locale));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(itemType + " categories: " + categoriesOfImportItem);

        return categoriesOfImportItem;

    }

    public String getAttributeType(String attributeCode) {
        String query = "SELECT attribute_type FROM Attributes WHERE Code = '" + attributeCode + "'";

        String attributeType = null;

        try (Connection conn = Database.getInstance();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                // İlk kolondaki tarih bilgisini al
                attributeType = rs.getString("attribute_type");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(attributeCode + " type: " + attributeType);

        return attributeType;

    }

    public List<String> getAttributeOptions(String attributeCode, String locale) {
        locale = locale.replace("-", "_");
        String query = "SELECT ao.[" + locale + "] FROM AttributeOptions ao \n" +
                "Join Attributes a On ao.AttributeId = a.Id\n" +
                "WHERE a.Code = '" + attributeCode + "'";

        List<String> attributeOptions = new ArrayList<>();

        try (Connection conn = Database.getInstance();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                // İlk kolondaki tarih bilgisini al
                attributeOptions.add(rs.getString(locale));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(attributeCode + " options: " + attributeOptions);

        return attributeOptions;

    }


    public List<String> getSkuOfImportedItems(String newSKUsAsString) {
        String query = "SELECT * FROM Items WHERE SKU IN " + newSKUsAsString;

        List<String> actualSKUsOfImportedItems = new ArrayList<>();

        try (Connection conn = Database.getInstance();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                actualSKUsOfImportedItems.add(rs.getString("SKU"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("actualSKUsOfImportedItems: " + actualSKUsOfImportedItems);

        return actualSKUsOfImportedItems;

    }

    public String getTopCategoryOfImportItem(String itemType, String locale) {
        locale = locale.replace("-", "_");
        String query = "SELECT " + locale + " FROM Categories \n" +
                "WHERE ItemType = (SELECT Type From ItemTypeColumns WHERE TypeName = '" + itemType + "') AND ParentId Is Null";

        System.out.println("query: \n" + query);

        String topCategory = null;

        try (Connection conn = Database.getInstance();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                topCategory = rs.getString(locale);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(itemType + " top category: " + topCategory);

        return topCategory;

    }

    public String getDefaultImportFamily(String itemType) {
        String query = "SELECT tr_TR as family FROM Families\n" +
                "WHERE Id = (SELECT TOP 1 FamilyId FROM Items i\n" +
                "WHERE [Type] = (SELECT [Type] FROM ItemTypeColumns\n" +
                "WHERE TypeName = '" + itemType + "')\n" +
                "ORDER BY CreatedOn)";

        System.out.println("query: \n" + query);

        String defaultFamily = null;

        try (Connection conn = Database.getInstance();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                defaultFamily = rs.getString("family");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(itemType + " defaultFamily: " + defaultFamily);

        return defaultFamily;

    }

    public Map<String, String> getCategories(String itemType) {
        String query = "SELECT Code, tr_TR as category FROM Categories\n" +
                "WHERE ItemType = (SELECT [Type] FROM ItemTypeColumns\n" +
                "WHERE TypeName = '" + itemType + "')";

        System.out.println("query: \n" + query);
        Map<String,String> categoriesInfo = new HashMap<>();

        try (Connection conn = Database.getInstance();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                categoriesInfo.put(rs.getString("Code"),rs.getString("category"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(itemType + " categoriesInfo: " + categoriesInfo.toString());

        return categoriesInfo;


    }

    public Map<String, String> getFamilies(String itemType) {
        String query = "SELECT Code, tr_TR as family FROM Families\n" +
                "WHERE ItemType = (SELECT [Type] FROM ItemTypeColumns\n" +
                "WHERE TypeName = '" + itemType + "')";


        System.out.println("query: \n" + query);
        Map<String,String> familiesInfo = new HashMap<>();

        try (Connection conn = Database.getInstance();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                familiesInfo.put(rs.getString("Code"),rs.getString("family"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(itemType + " familiesInfo: " + familiesInfo.toString());

        return familiesInfo;

    }

    public String getCategoryOfImportedItem(String randomSku) {
        String query = """
                        SELECT [Code]
                        FROM DIA_PREPROD.dbo.Categories
                        WHERE Id = (
                            SELECT TOP 1 Category_Id
                            FROM DIA_PREPROD.dbo.CategoryItems
                            WHERE Item_Id = (
                                SELECT Id
                                FROM DIA_PREPROD.dbo.Items
                                WHERE SKU = '%s'
                            )
                            ORDER BY Category_Id DESC
                        )
                """.formatted(randomSku.trim());

        String debugCatSql = """
    SELECT COUNT(*) AS cnt
    FROM DIA_PREPROD.dbo.CategoryItems
    WHERE Item_Id = (
        SELECT Id
        FROM DIA_PREPROD.dbo.Items
        WHERE SKU = '%s'
    )
    """.formatted(randomSku);

//        System.out.println("randomSku: >" + randomSku + "< len=" + randomSku.length());
//        for (int i = 0; i < randomSku.length(); i++) {
//            char ch = randomSku.charAt(i);
//            System.out.println(i + " -> '" + ch + "' (" + (int) ch + ")");
//        }

        System.out.println("query: \n" + query);

        String category = null;

        try (Connection conn = Database.getInstance();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)
        ) {
//            if (rs.next()) {
//                int cnt = rs.getInt("cnt");
//                System.out.println("CategoryItems'da bu Item için satır sayısı: " + cnt);
//            }

            while (rs.next()) {
                category = rs.getString("Code");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("actualCategory: " + category);

        return category;

    }

    public String getFamilyOfImportedItem(String randomSku) {
        String query = "SELECT tr_TR as familyLabel FROM Families\n" +
                "WHERE Id = (SELECT FamilyId FROM Items WHERE SKU = '" + randomSku + "')";

        System.out.println("query: \n" + query);

        String family = null;

        try (Connection conn = Database.getInstance();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                family = rs.getString("familyLabel");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("actualFamily: " + family);

        return family;

    }

    public String getFamilyOfImportedItemWithName(String randomSku3) {
        String query = "SELECT tr_TR as familyLabel FROM Families \n" +
                "WHERE Id = (\n" +
                "SELECT FamilyId FROM Items\n" +
                "WHERE Id = (SELECT ItemId FROM ItemValues\n" +
                "WHERE AttributeId = (SELECT Id FROM Attributes\n" +
                "WHERE Code = 'DIA_FirstName') AND ValueString = '" + randomSku3 + "'))";

        System.out.println("query: \n" + query);

        String familyLabel = null;

        try (Connection conn = Database.getInstance();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                familyLabel = rs.getString("familyLabel");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("familyLabel: " + familyLabel);

        return familyLabel;

    }

    public String getCategoryOfImportedItemWithName(String randomSku3) {
        String query = "SELECT Code FROM DIA_PREPROD.dbo.Categories\n" +
                "WHERE Id = (\n" +
                "SELECT TOP 1 Category_Id\n" +
                "FROM DIA_PREPROD.dbo.CategoryItems\n" +
                "WHERE Item_Id = (\n" +
                "SELECT ItemId FROM ItemValues\n" +
                "WHERE AttributeId = (SELECT Id FROM Attributes\n" +
                "WHERE Code = 'DIA_FirstName') AND ValueString = '" + randomSku3 + "')\n" +
                ")";

        System.out.println("query: \n" + query);

        String actualCategory = null;

        try (Connection conn = Database.getInstance();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                actualCategory = rs.getString("Code");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("actualCategory: " + actualCategory);

        return actualCategory;

    }

    public String getImportTimeWithName(String randomSku3) {
        String query = "SELECT CreatedOn FROM Items\n" +
                "WHERE Id = (SELECT ItemId FROM ItemValues\n" +
                "WHERE AttributeId = (SELECT Id FROM Attributes\n" +
                "WHERE Code = 'DIA_FirstName') AND ValueString = '" + randomSku3 + "')";


        System.out.println("query: \n" + query);

        String time = null;

        try (Connection conn = Database.getInstance();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                time = rs.getString("CreatedOn");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("import time: " + time);

        return time;
    }

    public String getName(String randomSku5) {
        String query = "SELECT ValueString FROM ItemValues\n" +
                "WHERE AttributeId = (SELECT Id FROM Attributes\n" +
                "WHERE Code = 'DIA_FirstName') AND ItemId = (SELECT Id FROM Items WHERE SKU = '" + randomSku5 + "')";

        String query2 = "SELECT ValueString FROM ItemValues\n" +
                "WHERE AttributeId = (SELECT Id FROM Attributes WHERE Code = 'DIA_FirstName') \n" +
                "AND ItemId = (\n" +
                "SELECT Id FROM Items WHERE SKU = '" + randomSku5 + "' AND Type = (SELECT Type FROM ItemTypeColumns WHERE TypeName = 'Contact')\n" +
                ")";

        System.out.println("name query: \n" + query2);

        String name = null;

        try (Connection conn = Database.getInstance();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query2)) {

            while (rs.next()) {
                name = rs.getString("ValueString");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("name: " + name);

        return name;

    }

    public String getAnySku(String itemType,String count) {
        String query = "SELECT TOP " + count + " SKU FROM Items\n" +
                "        WHERE Type = (SELECT Type FROM ItemTypeColumns\n" +
                "        WHERE TypeName = '" + itemType + "')";

        System.out.println("query: \n" + query);

        String sku = null;

        try (Connection conn = Database.getInstance();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                sku = rs.getString("SKU");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("name: " + sku);

        return sku;

    }

    public String getCategoryOfImportedItemWithEventName(String randomSku3) {
        String query = "SELECT Code FROM DIA_PREPROD.dbo.Categories\n" +
                "WHERE Id = (\n" +
                "SELECT TOP 1 Category_Id\n" +
                "FROM DIA_PREPROD.dbo.CategoryItems\n" +
                "WHERE Item_Id = (\n" +
                "SELECT ItemId FROM ItemValues\n" +
                "WHERE AttributeId = (SELECT Id FROM Attributes\n" +
                "WHERE Code = 'DIA_Event_Name') AND ValueString = '" + randomSku3 + "')\n" +
                ")";

        System.out.println("query: \n" + query);

        String actualCategory = null;

        try (Connection conn = Database.getInstance();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                actualCategory = rs.getString("Code");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("actualCategory: " + actualCategory);

        return actualCategory;
    }

    public String getFamilyOfImportedItemWithEventName(String randomSku3) {
        String query = "SELECT tr_TR as familyLabel FROM Families \n" +
                "WHERE Id = (\n" +
                "SELECT FamilyId FROM Items\n" +
                "WHERE Id = (SELECT ItemId FROM ItemValues\n" +
                "WHERE AttributeId = (SELECT Id FROM Attributes\n" +
                "WHERE Code = 'DIA_Event_Name') AND ValueString = '" + randomSku3 + "'))";

        System.out.println("query: \n" + query);

        String familyLabel = null;

        try (Connection conn = Database.getInstance();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                familyLabel = rs.getString("familyLabel");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("familyLabel: " + familyLabel);

        return familyLabel;
    }

    public String getImportTimeWithEventName(String randomSku3) {
        String query = "SELECT CreatedOn FROM Items\n" +
                "WHERE Id = (SELECT ItemId FROM ItemValues\n" +
                "WHERE AttributeId = (SELECT Id FROM Attributes\n" +
                "WHERE Code = 'DIA_Event_Name') AND ValueString = '" + randomSku3 + "')";


        System.out.println("query: \n" + query);

        String time = null;

        try (Connection conn = Database.getInstance();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                time = rs.getString("CreatedOn");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("import time: " + time);

        return time;
    }

    public String getEventName(String randomSku5,String itemType) {
        String query = "SELECT ValueString FROM ItemValues\n" +
                "WHERE AttributeId = (SELECT Id FROM Attributes\n" +
                "WHERE Code = 'DIA_FirstName') AND ItemId = (SELECT Id FROM Items WHERE SKU = '" + randomSku5 + "')";

        String query2 = "SELECT ValueString FROM ItemValues\n" +
                "WHERE AttributeId = (SELECT Id FROM Attributes WHERE Code = 'DIA_Event_Name') \n" +
                "AND ItemId = (\n" +
                "SELECT Id FROM Items WHERE SKU = '" + randomSku5 + "' AND Type = (SELECT Type FROM ItemTypeColumns WHERE TypeName = '" + itemType + "')\n" +
                ")";

        System.out.println("name query: \n" + query2);

        String name = null;

        try (Connection conn = Database.getInstance();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query2)) {

            while (rs.next()) {
                name = rs.getString("ValueString");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("name: " + name);

        return name;
    }

    public String getFamilyOfImportedItemWithProductName(String randomSku3) {
        String query = "SELECT tr_TR as familyLabel FROM Families \n" +
                "WHERE Id = (\n" +
                "SELECT FamilyId FROM Items\n" +
                "WHERE Id = (SELECT ItemId FROM ItemValues\n" +
                "WHERE AttributeId = (SELECT Id FROM Attributes\n" +
                "WHERE Code = 'DIA_URUNGRUPKOD') AND ValueString = '" + randomSku3 + "'))";

        System.out.println("query: \n" + query);

        String familyLabel = null;

        try (Connection conn = Database.getInstance();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                familyLabel = rs.getString("familyLabel");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("familyLabel: " + familyLabel);

        return familyLabel;
    }

    public String getCategoryOfImportedItemWithProductName(String randomSku3) {
        String query = "SELECT Code FROM DIA_PREPROD.dbo.Categories\n" +
                "WHERE Id = (\n" +
                "SELECT TOP 1 Category_Id\n" +
                "FROM DIA_PREPROD.dbo.CategoryItems\n" +
                "WHERE Item_Id = (\n" +
                "SELECT ItemId FROM ItemValues\n" +
                "WHERE AttributeId = (SELECT Id FROM Attributes\n" +
                "WHERE Code = 'DIA_URUNGRUPKOD') AND ValueString = '" + randomSku3 + "')\n" +
                ")";

        System.out.println("query: \n" + query);

        String actualCategory = null;

        try (Connection conn = Database.getInstance();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                actualCategory = rs.getString("Code");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("actualCategory: " + actualCategory);

        return actualCategory;
    }

    public String getImportTimeWithProductName(String randomSku3) {
        String query = "SELECT CreatedOn FROM Items\n" +
                "WHERE Id = (SELECT ItemId FROM ItemValues\n" +
                "WHERE AttributeId = (SELECT Id FROM Attributes\n" +
                "WHERE Code = 'DIA_URUNGRUPKOD') AND ValueString = '" + randomSku3 + "')";


        System.out.println("query: \n" + query);

        String time = null;

        try (Connection conn = Database.getInstance();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                time = rs.getString("CreatedOn");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("import time: " + time);

        return time;
    }

    public String getProductName(String randomSku5, String itemType) {
        String query = "SELECT ValueString FROM ItemValues\n" +
                "WHERE AttributeId = (SELECT Id FROM Attributes\n" +
                "WHERE Code = 'DIA_FirstName') AND ItemId = (SELECT Id FROM Items WHERE SKU = '" + randomSku5 + "')";

        String query2 = "SELECT ValueString FROM ItemValues\n" +
                "WHERE AttributeId = (SELECT Id FROM Attributes WHERE Code = 'DIA_URUNGRUPKOD') \n" +
                "AND ItemId = (\n" +
                "SELECT Id FROM Items WHERE SKU = '" + randomSku5 + "' AND Type = (SELECT Type FROM ItemTypeColumns WHERE TypeName = '" + itemType + "')\n" +
                ")";

        System.out.println("name query: \n" + query2);

        String name = null;

        try (Connection conn = Database.getInstance();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query2)) {

            while (rs.next()) {
                name = rs.getString("ValueString");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("name: " + name);

        return name;
    }

    public boolean isSupportMailSent(String uniqueMailBody) {
        String query = "SELECT * FROM NotificationLogs\n" +
                "WHERE Body LIKE '%" + uniqueMailBody + "%'\n" +
                "AND [To] = 'dia.support.internal@efectura.com'\n" +
                "AND NotificationType = 'Email'\n" +
                "ORDER BY Id DESC";

        String body = null;

        try (Connection conn = DatabaseManager.getConnection(
                DbConfigs.DIA_SQLSERVER, DbConfigs.DIA_SQLSERVER_USERNAME, DbConfigs.DB_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                body = rs.getString("Body");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("body: " + body);

        if (body == null) {
            return false;
        }

        return body.contains(uniqueMailBody);

    }
}
