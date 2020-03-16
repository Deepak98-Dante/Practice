Code: Core JAVA
DB:Oracle DB

Before Running , We need to Create TWO Tables (ITEMS,BOOK) and There is a Common DB Connection Function is there so we need Check User Name , Password We need to Change in that Funtion.
In Items Table Contains item_id, item_name and Available Quantity.
In Book Table Contains Order_id,item_name and Order Quantity
IF Order Quantity within Available Quantity we can order, at the same time once done order done available quantity will also reduce in DB.