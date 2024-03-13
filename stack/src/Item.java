public class Item {
    private ItemType type;
    private int value = Integer.MAX_VALUE;
//testing
    public Item (ItemType t, int x){
        type = t;
        value = x;
    }

    public Item (ItemType t){
        type = t;
    }

    public static Item Value (int num){
        return new Item(ItemType.VALUE, num);
    }

    public static Item Add (){
        return new Item(ItemType.ADD);
    }

    public static Item Sub (){
      return new Item(ItemType.SUB);
    }

    public static Item Mul (){
      return new Item(ItemType.MUL);
    }

    public static Item Div (){
      return new Item(ItemType.DIV);
    }

    public ItemType type() {
        return type;
    }

    public int value() {
        return value;
    }
}

