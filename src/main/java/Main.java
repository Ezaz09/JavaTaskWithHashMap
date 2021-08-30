/*
Создать HashMap и забить туда данные.
Пусть будет продуктовый склад у нас. и Ключ - id продукта, а значение Сам Продукт.
У продукта будут следующие поля. Имя. Производитель. Количество на складе.

Создай 5-10 продуктов и забей ими HashMap далее.
Выведи на экран все ключи продуктов, чье количество больше 5 на складе

2)Групповое изменение.
 Создай метод, который принимает на вход
 а) Хешмепу с Ключом - id продукта, а значение Сам Продукт, вторым параметром метод принимает список ключей
Тебе надо у продуктов входящий в этих список в этой поданной хешмепе увеличить их количество на складе на 10 единиц
*/


import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker();
        HashMap<String, Product> productWarehouse = generateNewProductWarehouse(faker);

        System.out.println("Первое задание");
        showKeysOfProductsWhichAmountMoreThan5(productWarehouse);

        System.out.println("Второе задание");
        System.out.println("До увеличения");
        HashMap<String, Product> secondProductWarehouse = generateSecondProductWarehouseForSecondTask(faker, productWarehouse);
        System.out.println(productWarehouse);
        System.out.println("После");
        increaseAmountOfProductInWarehouse(secondProductWarehouse, productWarehouse.keySet());

    }

    public static HashMap<String, Product> generateNewProductWarehouse(Faker faker) {
        HashMap<String, Product> productWarehouse = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            String id = 'A' + String.valueOf(i);
            productWarehouse.put(id, generateProduct(faker));
        }

        return productWarehouse;
    }

    public static HashMap<String, Product> generateSecondProductWarehouseForSecondTask(Faker faker, HashMap<String, Product> productWarehouse) {
        if(productWarehouse.isEmpty()){
            return new HashMap<>();
        }

        HashMap<String, Product> secondProductWarehouse = new HashMap<>();

        Product a0 = productWarehouse.get("A0");
        Product a1 = productWarehouse.get("A1");
        secondProductWarehouse.put("A0", a0);
        secondProductWarehouse.put("A1", a1);

        secondProductWarehouse.put("B2", generateProduct(faker));

        return  secondProductWarehouse;
    }

    public static void showKeysOfProductsWhichAmountMoreThan5(HashMap<String, Product> productWarehouse) {
        if(productWarehouse.isEmpty()){
            return;
        }

        Set<String> keys = productWarehouse.keySet();

        for (String key :
                keys) {
            Product product = productWarehouse.get(key);

            if(product.getAmount() > 5) {
                System.out.println(key);
            }
        }
    }

    public static void increaseAmountOfProductInWarehouse(HashMap<String, Product> mapOfProducts, Set<String> keysOfProducts) {
        if(mapOfProducts.isEmpty() || keysOfProducts.isEmpty()) {
            return;
        }

        for (String key :
                keysOfProducts) {
            Product product = mapOfProducts.get(key);

            if(product == null) {
                continue;
            }

            product.setAmount(product.getAmount() + 10);
        }

        System.out.println(mapOfProducts);

    }

    public static Product generateProduct(Faker faker) {
        return new Product(faker.food().ingredient(), faker.company().name(), getRandomNumber(1, 10));
    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
