package com.example.kfcglobaloperationsapp.Uzair_2521139;

import com.example.kfcglobaloperationsapp.Uzair_2521139.Model.*;

import javax.print.attribute.standard.OrientationRequested;
import java.util.ArrayList;
import java.util.List;

public class Database {


    public static ArrayList<User> usersLoginInfo = new ArrayList<>(
            List.of(
                    new Cashier(
                            1, "Binod", "binod", "123", "Cashier"
                    ),
                    new Cashier(
                            2, "Champa", "champa", "123", "Cashier"
                    ),
                    new Cashier(
                            3, "Trump", "trump", "123", "Cashier"
                    ) ,
                     new KitchenSupervisor(
                            4, "Hasina", "hasina", "123", "KitchenSupervisor"
    ),
                    new KitchenSupervisor(
                            5, "Putin", "putin", "123", "KitchenSupervisor"
    ),
                    new KitchenSupervisor(
                            6, "Yunus", "yunusSorkar", "123", "KitchenSupervisor"
    )
            )
    );


    public static Cashier currentCashier = new Cashier(
            2521139, "Uzair"
    );
    public static CashierSession currentSession;

    public static ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>(List.of(
        new MenuItem(1, "18 pcs Crispy Chicken", "Chicken", 1799, true),
        new MenuItem(2, "10 pcs Crispy Chicken", "Chicken", 1249, true),
        new MenuItem(3, "8 pcs Smoky Chicken", "Chicken", 1249, true),
        new MenuItem(4, "Chicken Popcorn", "Chicken", 299, true),
        new MenuItem(5, "6 pcs Chicken Strips", "Chicken", 599, true),
        new MenuItem(6, "Classic Zinger Burger", "Burger", 329, true),
        new MenuItem(7, "Classic Zinger Burger with Cheese", "Burger", 399, true),
        new MenuItem(8, "Spicy Zinger", "Burger", 399, true),
        new MenuItem(9, "Spicy Zinger Burger with Cheese", "Burger", 499, true)
    ));
    public static ArrayList<Order> orderList = new ArrayList<Order>();

    public static int orderCount = 1;

    public static Order currentOrder;

    public static ArrayList<RefillRequest> refillRequestsList = new ArrayList<RefillRequest>();

    public static ArrayList<Order> paidOrders = new ArrayList<>();


    static {
        Order ord = new Order(
                1000,
                Database.currentSession,
                "Paid"
        );

        ArrayList<OrderItem> orderItemLsit = new ArrayList<>();
        orderItemLsit.add(new OrderItem(
                menuItems.get(0).getMenuItemID(), 2, ord, menuItems.get(0)
        ));
        orderItemLsit.add(new OrderItem(
                menuItems.get(1).getMenuItemID(), 1, ord, menuItems.get(1)
        ));

        ord.setOrderItemsList(orderItemLsit);
        ord.setOrderType("Dine-in");
        ord.setStatus("In-Queue");
        paidOrders.add(ord);
    }


    public static KitchenSupervisor currentKitchenSupervisor = new KitchenSupervisor(
            2521139, "Uzair"
    );

    public static ArrayList<ConsumableRequest> consumableRequests = new ArrayList<>();

    public static ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>(List.of(
            new Ingredient(1, "Chicken Thighs", "pcs", 50, 5),
            new Ingredient(2, "Lettuce", "heads", 20, 5),
            new Ingredient(3, "Buns", "pcs", 30, 3),
            new Ingredient(4, "Potatoes", "pcs", 100, 10),
            new Ingredient(5, "Secret Sauce", "litres", 10, 1),
            new Ingredient(6, "Mysterious White Sauce", "litres", 5, 1)
    ));

    public static ArrayList<Staff> staffList = new ArrayList<>(
            List.of(
                    new Staff((int)(Math.random()*1000), "Kuddus"),
                    new Staff((int)(Math.random()*1000), "Kajol"),
                    new Staff((int)(Math.random()*1000), "Rupa"),
                    new Staff((int)(Math.random()*1000), "Gopi")
            )
    );

    public static ArrayList<Staff> assignedStaff = new ArrayList<>();

    public static ArrayList<Coupon> coupons = new ArrayList<>(
            List.of(
                    new Coupon("KFC101", 15d, true
                    ),
                    new Coupon("KFC100", 10d, true)
            )
    );

}
