package di;

import java.util.List;

public class Sandwich {

    // 의존성 주입, 추상화 적용
    private Bread bread;
    private List<Ingredient> ingredients;
    private List<Sauce> sauces;

    public Sandwich(Bread bread, List<Ingredient> ingredients, List<Sauce> sauces) {
        this.bread = bread;
        this.ingredients = ingredients;
        this.sauces = sauces;
    }

    // 초기 작성 버전
    /*
    private RiceBread riceBread;
    private MozzarellaChease mozzarellaChease;
    private Lettuce lettuce;
    private ChiliSauce chiliSauce;

//    public Sandwich() {
//        riceBread = new RiceBread();
//        mozzarellaChease = new MozzarellaChease();
//        lettuce = new Lettuce();
//        chiliSauce = new ChiliSauce();
//    }

    public Sandwich(RiceBread riceBread, MozzarellaChease mozzarellaChease, Lettuce lettuce, ChiliSauce chiliSauce) {
        this.riceBread = riceBread;
        this.mozzarellaChease = mozzarellaChease;
        this.lettuce = lettuce;
        this.chiliSauce = chiliSauce;
    }
    */


}
