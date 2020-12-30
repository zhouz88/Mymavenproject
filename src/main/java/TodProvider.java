import com.google.inject.Provider;

public class TodProvider implements Provider<Dog> {
    public Dog get() {
        return new ChinaDog();
    }
}
