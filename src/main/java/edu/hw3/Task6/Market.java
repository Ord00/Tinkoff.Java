package edu.hw3.Task6;

import java.util.Comparator;
import java.util.PriorityQueue;

@SuppressWarnings({"RegexpSinglelineJava", "uncommentedmain"})
public class Market implements StockMarket {
    private PriorityQueue<Stock> stocks;

    Market() {
        stocks = new PriorityQueue<>(new Comparator<Stock>() {
            @Override
            public int compare(Stock o1, Stock o2) {
                return o1.cost().compareTo(o2.cost());
            }
        });
    }

    public void add(Stock stock) {
        stocks.add(stock);
    }

    public void remove(Stock stock) {
        stocks.remove(stock);
    }

    public Stock mostValuableStock() {
        Stock result = null;
        PriorityQueue<Stock> source = new PriorityQueue<>(stocks);
        while (!source.isEmpty()) {
            result = source.poll();
        }
        return result;
    }

    public String toString() {
        String result = "[";
        PriorityQueue<Stock> source = new PriorityQueue<>(stocks);
        while (!source.isEmpty()) {
            result += "(" + source.peek().companyName() + ", " + source.peek().cost() + "), ";
            source.poll();
        }
        return result.substring(0, result.length() - 2) + "]";
    }
}
