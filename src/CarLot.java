import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

/*
Dylan Sprague
200368636
 */

public class CarLot {
    private TreeMap<String, TreeSet<Car>> menu = new TreeMap<>();

    public CarLot(TreeMap<String, TreeSet<Car>> menu) {
        this.menu = menu;
    }

    public ArrayList getBrands(){
        ArrayList<String> brands = new ArrayList<>();
        String all = "All Brands";

        brands.add(all);
        brands.addAll(menu.keySet());
        return brands;
    }

    public TreeSet<Car> getCars(String brand){
        TreeSet<Car> cars = new TreeSet<>();
        if (menu.containsKey(brand) && !brand.equals("All Brands")){
            cars.addAll(menu.get(brand));
            return cars;
        }else{
            cars.addAll(menu.get("All Brands"));
            return cars;
        }
    }

    public void sellCar(Car car){
        if (menu.containsKey(car.getBrand())){
            menu.remove(car);
        }
    }

    /*public double getInventoryValue(String brand){
        Double val;
        if (brand.equals("All Brands")){
            val = menu.values().stream()
                    .mapToDouble(c -> c.getPrice())
                    .sum();
        }else {
            val = menu.get(brand).stream()
                    .mapToDouble(c -> c.getPrice())
                .sum();
        }
        return val;
    }*/
}
