import com.google.inject.Provider;

public class USDogProvider implements Provider<Dog> {

    public Dog get() {
        return new USDog();
    }
}
