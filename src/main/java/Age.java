import com.google.inject.Inject;
import com.google.inject.name.Named;
import lombok.Getter;

public class Age {
    @Inject
    @Getter
    @Named("chinadog")
    private int chinaage;

    @Inject
    @Getter
    @Named("usdog")
    private int usage;
}
