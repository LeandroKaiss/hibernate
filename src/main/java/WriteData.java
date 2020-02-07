import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WriteData {
    public void write(String data, String path){
        try {
            Path file = Paths.get(path);
            byte[] dataBytes = data.getBytes(StandardCharsets.UTF_8);
            Files.write(file, dataBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
