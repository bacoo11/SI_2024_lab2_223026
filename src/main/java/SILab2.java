import java.util.List;

class Item {
    String name;
    String barcode; //numerical
    int price;
    float discount;

    public Item(String name, String code, int price, float discount) {
        this.name = name;
        this.barcode = code;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public String getBarcode() {
        return barcode;
    }

    public int getPrice() {
        return price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBarcode(String code) {
        this.barcode = code;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
}


public class SILab2 {
    public static boolean checkCart(List<Item> allItems, int payment){
        if (allItems == null){//A
            throw new RuntimeException("allItems list can't be null!"); //B
        }

        float sum = 0;//C

        for (int i = 0; i < allItems.size(); i++){ //C
            Item item = allItems.get(i);//D
            if (item.getName() == null || item.getName().length() == 0){//D
                item.setName("unknown");//E
            }
            if (item.getBarcode() != null){//F
                String allowed = "0123456789";
                char chars[] = item.getBarcode().toCharArray();
                for (int j = 0; j < item.getBarcode().length(); j++){//G
                    char c = item.getBarcode().charAt(j);
                    if (allowed.indexOf(c) == -1){//H
                        throw new RuntimeException("Invalid character in item barcode!");//I
                    }
                }
                if (item.getDiscount() > 0){//J
                    sum += item.getPrice()*item.getDiscount();//K
                }
                else {
                    sum += item.getPrice();//L
                }
            }
            else {
                throw new RuntimeException("No barcode!");//M
            }
            if (item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0'){//N
                sum -= 30;//O
            }
        }
        if (sum <= payment){//P
            return true;//Q
        }
        else {
            return false;//R
        }
    }
}
