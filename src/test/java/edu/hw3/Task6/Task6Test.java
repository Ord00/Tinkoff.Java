package edu.hw3.Task6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task6Test {
    @Test
    @DisplayName("Проверка добавления элемента")
    void checkAdd() {
        StockMarket stockMarket = new Market();
        stockMarket.add(new Stock("Gazprom", 26.7));
        stockMarket.add(new Stock("TatNeft", 87.23));
        stockMarket.add(new Stock("Relax", 15.487));
        String actual = stockMarket.toString();
        String expected = "[(Relax, 15.487), (Gazprom, 26.7), (TatNeft, 87.23)]";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка удаления элемента")
    void checkRemove() {
        StockMarket stockMarket = new Market();
        Stock stock = new Stock("Gazprom", 26.7);
        stockMarket.add(stock);
        stockMarket.add(new Stock("TatNeft", 87.23));
        stockMarket.add(new Stock("Relax", 15.487));
        stockMarket.remove(stock);
        String actual = stockMarket.toString();
        String expected = "[(Relax, 15.487), (TatNeft, 87.23)]";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка поиска акции с максимальной стоимостью")
    void checkMostValuableStock() {
        StockMarket stockMarket = new Market();
        stockMarket.add(new Stock("Gazprom", 26.7));
        stockMarket.add(new Stock("TatNeft", 87.23));
        stockMarket.add(new Stock("Relax", 15.487));
        String actual = stockMarket.mostValuableStock().toString();
        String expected = "(TatNeft, 87.23)";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка удаления из пустой очереди")
    void checkEmpty() {
        StockMarket stockMarket = new Market();
        stockMarket.remove(new Stock("Gazprom", 26.7));
        Stock actual = stockMarket.mostValuableStock();
        Stock expected = null;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка удаления из пустой очереди")
    void checkNotExistedStock() {
        StockMarket stockMarket = new Market();
        stockMarket.add(new Stock("TatNeft", 87.23));
        stockMarket.remove(new Stock("Gazprom", 26.7));
        String actual = stockMarket.toString();
        String expected = "[(TatNeft, 87.23)]";
        assertEquals(expected, actual);
    }
}
