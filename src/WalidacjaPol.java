import java.util.Objects;

public class WalidacjaPol {

    public static boolean walidujPola(String pole1, String pole2, String pole3) {
        int licznik = 0;

        if (Objects.nonNull(pole1) && !pole1.isEmpty()) {
            licznik++;
        }

        if (Objects.nonNull(pole2) && !pole2.isEmpty()) {
            licznik++;
        }

        if (Objects.nonNull(pole3) && !pole3.isEmpty()) {
            licznik++;
        }

        return licznik > 1;
    }
}
