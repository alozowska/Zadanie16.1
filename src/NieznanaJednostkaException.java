public class NieznanaJednostkaException extends RuntimeException {

    private static final String NIEZNANA_JEDNOSTKA = "Nierozpoznano podanej jednostki";

    public NieznanaJednostkaException() {
        super(NIEZNANA_JEDNOSTKA);
    }
}
