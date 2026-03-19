package modelo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Administra los records persistidos en un archivo de texto sencillo.
 */
public class RecordsManager {
    private static final Path FILE = Paths.get("records.txt");
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public List<Record> cargar() {
        if (!Files.exists(FILE)) {
            return Collections.emptyList();
        }
        List<String> lineas;
        try {
            lineas = Files.readAllLines(FILE, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            return Collections.emptyList();
        }
        List<Record> records = new ArrayList<>();
        for (String line : lineas) {
            Record r = Record.fromLine(line.trim());
            if (r != null) {
                records.add(r);
            }
        }
        records.sort(Comparator.comparingInt(Record::getPuntaje).reversed());
        return records;
    }

    public void guardar(String nombre, int puntaje, String dificultad) {
        Record record = new Record(nombre, puntaje, dificultad, LocalDateTime.now().format(FORMATTER));
        try {
            Files.write(FILE, Collections.singleton(record.toLine()), StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException ex) {
            // Si falla, se ignora silenciosamente para no romper el juego.
        }
    }
}
