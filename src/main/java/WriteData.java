import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Write {
    public void writeData(String data, String path){
        Path file = Paths.get(path);
        Files.write(file, data, StandardCharsets.UTF_8);

    }
}
