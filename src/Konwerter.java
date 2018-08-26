import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

public class Konwerter {

    public static void konwertuj(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter printWriter = response.getWriter();

        String metry = request.getParameter(TypJednostki.METRY.getNazwa());
        String centymetry = request.getParameter(TypJednostki.CENTRYMETRY.getNazwa());
        String milimetry = request.getParameter(TypJednostki.MILIMETRY.getNazwa());
        String kilogramy = request.getParameter(TypJednostki.KILOGRAMY.getNazwa());
        String gramy = request.getParameter(TypJednostki.GRAMY.getNazwa());
        String miligramy = request.getParameter(TypJednostki.MILIGRAMY.getNazwa());


        if (WalidacjaPol.walidujPola(metry, centymetry, milimetry)) {
            printWriter.print("Możesz podać tylko jedną wartosc ");
        } else if (Objects.nonNull(metry) && !metry.isEmpty()) {
            konwersjaNaMetry(printWriter, Double.parseDouble(metry));
        } else if (Objects.nonNull(centymetry) && !centymetry.isEmpty()) {
            konwersjaNaCentrymetry(printWriter, Double.parseDouble(centymetry));
        } else if (Objects.nonNull(milimetry) && !milimetry.isEmpty()) {
            konwersjaNaMilimetry(printWriter, Double.parseDouble(milimetry));
        } else if (Objects.nonNull(kilogramy) && !kilogramy.isEmpty()) {
            konwersjaNaKilogramy(printWriter, Double.parseDouble(kilogramy));
        } else if (Objects.nonNull(gramy) && !gramy.isEmpty()) {
            konwersjaNaGramy(printWriter, Double.parseDouble(gramy));
        } else if (Objects.nonNull(miligramy) && !miligramy.isEmpty()) {
            konwersjaNaMiligramy(printWriter, Double.parseDouble(miligramy));
        } else {
            throw new NieznanaJednostkaException();
        }

    }

    private static void konwersjaNaGramy(PrintWriter writer, Double wartosc) {
        writer.print("Podana wartosc w przeliczeniu na: ");
        writer.println("kilogramy: " + wartosc / 100);
        writer.println("gramy: " + wartosc);
        writer.println("miligramy: " + wartosc * 10);
    }

    private static void konwersjaNaMiligramy(PrintWriter writer, Double wartosc) {
        writer.println("Podana wartosc w przeliczeniu na: ");
        writer.println("kilogramy: " + wartosc / 1000);
        writer.println("gramy: " + wartosc / 10);
        writer.println("miligramy: " + wartosc);
    }

    private static void konwersjaNaKilogramy(PrintWriter writer, Double wartosc) {
        writer.println("Podana wartosc w przeliczeniu na: ");
        writer.println("kilogramy: " + wartosc);
        writer.println("gramy: " + wartosc * 100);
        writer.println("miligramy: " + wartosc * 1000);
    }

    private static void konwersjaNaCentrymetry(PrintWriter writer, Double wartosc) {
        writer.print("Podana wartosc w przeliczeniu na: ");
        writer.println("metry: " + wartosc / 100);
        writer.println("centymetry: " + wartosc);
        writer.println("milimetry: " + wartosc * 10);
    }

    private static void konwersjaNaMetry(PrintWriter writer, Double wartosc) {
        writer.println("Podana wartosc w przeliczeniu na: ");
        writer.println("metry: " + wartosc);
        writer.println("centymetry: " + wartosc * 100);
        writer.println("milimetry: " + wartosc * 1000);
    }

    private static void konwersjaNaMilimetry(PrintWriter writer, Double wartosc) {
        writer.println("Podana wartosc w przeliczeniu na: ");
        writer.println("metry: " + wartosc / 1000);
        writer.println("centymetry: " + wartosc / 10);
        writer.println("milimetry: " + wartosc);
    }

}
