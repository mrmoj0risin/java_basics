public class Basket {

    private static int basketCount = 0;
    private String items = "";
    private int totalPrice = 0;
    private double totalWeight = 0;
    private int limit;
    private static int sumPrice;
    private static int itemsCount;

    public Basket() {
        increaseCount(1);
        items = "Список товаров:";
        this.limit = 1000000;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }


    public Basket(String items, int totalPrice) {
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;
    }

    public static int getBasketCount() {
        return basketCount;
    }

    public static int calcSumPrice(int price, int count ){
        return Basket.sumPrice += price * count;
    }

    public static int getSumPrice(){ return Basket.sumPrice;}


    public static int calcItemsCount(int item){
        return Basket.itemsCount += item;
    }

    public static float calcRoundPrice() {return Basket.sumPrice / Basket.itemsCount;}

    public static int getItemsCount(){ return Basket.itemsCount;}


    public double getTotalWeight() { return totalWeight; }

    public static void increaseCount(int count) {
        Basket.basketCount = Basket.basketCount + count;
    }

    public void add(String name, int price) {

        add(name, price, 1);
    }

    public void add(String name, int price, int count) {
        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (totalPrice + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }

        items = items + "\n" + name + " - " +
            count + " шт. - " + price;
        totalPrice = totalPrice + count * price;

        calcSumPrice(price, count);

        calcItemsCount(count);

    }

    public void add(String name, int price, int count, double weight) {
        add(name, price, count);

        this.totalWeight += weight;

    }

    public void clear() {
        items = "";
        totalPrice = 0;
    }

    public int getTotalPrice() {
        return totalPrice;
    }


    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
        }
    }
}
