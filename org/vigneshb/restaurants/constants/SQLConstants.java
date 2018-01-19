package org.vigneshb.restaurants.constants;

public class SQLConstants {
	public static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/restaurant";
	public static final String USER_NAME = "root";
	public static final String PASSWORD = "zilkeradmin";
	public static final String INSERT_FOOD_ITEM = "insert into restaurant.food_item values(?,?,?,?,?)";
	public static final String FIND_FOOD_COUNT = "select max(food_id) from restaurant.food_item";
	public static final String FIND_NO_OF_FOODS_ORDERED = "select food_count from restaurant.food_item where food_name=?";
	public static final String UPDATE_FOOD_COUNT = "update restaurant.food_item set food_count=?,last_updated=? where food_name=?";
	public static final String UPDATE_DELIVERY_STATUS = "update restaurant.take_outs set delivered_on=?, is_delivered=true where user_id=(select user_id from user where user_name=?) and is_delivered=false";
	public static final String FIND_UNPOPULAR_FOOD = "select food_name from restaurant.food_item where food_count=(select min(food_count) from restaurant.food_item)";
	public static final String FIND_POPULAR_FOOD = "select food_name from restaurant.food_item where food_count=(select max(food_count) from restaurant.food_item)";
	public static final String FIND_CUSTOMER_COUNT = "select max(user_id) from restaurant.user";
	public static final String INSERT_CUSTOMER_DETAILS = "insert into restaurant.user values(?,?,?,?,?,?,?)";
	public static final String FIND_LATE_PARCELS = "select count(*) from restaurant.take_outs where order_type='parcel' and UNIX_TIMESTAMP(delivered_on)-UNIX_TIMESTAMP(ordered_on)>600 and is_delivered=true";
	public static final String FIND_LATE_DELIVERIES = "select count(*) from restaurant.take_outs where order_type='delivery' and UNIX_TIMESTAMP(delivered_on)-UNIX_TIMESTAMP(ordered_on)>1800 and is_delivered=true";
	public static final String FIND_ORDERS_COUNT = "select max(order_id) from restaurant.take_outs";
	public static final String INSERT_ORDER = "insert into restaurant.take_outs values(?,?,(select user_id from user where user_name=?),?,'2019/12/12 12:00:00',false)";
	public static final String INSERT_DINE_IN = "insert into restaurant.take_outs values(?,?,(select user_id from user where user_name=?),?,null,true)";
	public static final String INCREMENT_FOOD_COUNT = "update restaurant.food_item set food_count=food_count+? where food_name=?";
	public static final String FIND_ORDER_COUNT = "select count(*) from take_outs where take_outs.is_delivered=false AND take_outs.user_id=(select user_id from user where user.user_name=?)";
	public static final String GET_FOOD_MENU = "select food_name,food_cost from food_item";
	public static final String INSERT_NEW_OFFER = "insert into offers values(?,?,?)";
	public static final String FIND_MAX_ORDER_ID = "select max(offer_id) from offers";
	public static final String GET_NEW_OFFER = "select food_1,food_2 from offers where offer_id=(select max(offer_id) from offers)";
	public static final String GET_FOODS_OF_CUSTOMER = "select food_name from food_item where food_item.food_id in(select food_id from orders where order_id in(select order_id from take_outs where is_delivered=false and order_type='delivery' and user_id=(select user_id from user where user_name=?)))";
	public static final String GET_FOOD_QUANTITIES_OF_CUSTOMER = "select food_quantity from orders where order_id in(select order_id from take_outs where is_delivered=false and order_type='delivery' and user_id=(select user_id from user where user_name=?))";
	public static final String DELETE_CURRENT_OFFER = "truncate table offers";
	public static final String CHECK_USER_TYPE = "select user_type from restaurant.user where user_name=? and user_password=?";
	public static final String UPDATE_USER_ORDERS = "update restaurant.user set user_orders=user_orders+? where user_name= ?";
	public static final String INSERT_FOOD_ORDERS_WITH_QUANTITY = "insert into orders values(?,(select food_id from food_item where food_name = ?),?)";
}
