public enum  TypJednostki {

    METRY("metry"),
    CENTRYMETRY("centymetry"),
    MILIMETRY("milimetry"),
    KILOGRAMY("kilogramy"),
    GRAMY("gramy"),
    MILIGRAMY("miligramy");

    private String nazwa;

    TypJednostki(String nazwa){
        this.nazwa = nazwa;
    }

    public String getNazwa() {
        return nazwa;
    }
}
