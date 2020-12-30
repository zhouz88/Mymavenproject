import annotations.ChinaDogIntercept;
import annotations.Unitesstates;
import com.google.inject.Inject;

public class DogSolutions {
    @Inject
    private Dog chinadog;

    @Inject
    private Dog germanydog;

    @Inject
    @Unitesstates
    private Dog usdog;

    @Inject
    private Age age;

    @ChinaDogIntercept
    public void chinavow() {
        chinadog.eat();
        germanydog.eat();
        System.out.println("china" + chinadog);
        System.out.println("germancy" + germanydog);
        System.out.println(age.getChinaage());
    }

    public void usvow() {
        usdog.eat();
        System.out.println(age.getUsage());
    }
}
