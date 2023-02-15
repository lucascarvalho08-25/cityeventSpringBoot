package br.pucpr.cityevent.model;

public enum Category {

    MUSIC(1, "music"),
    SPORT(2, "sport"),
    FOOD(3, "food");



    private int id;
    private String title;

    Category(int id, String title) {
        this.id = id;
        this.title = title;
    }
}
