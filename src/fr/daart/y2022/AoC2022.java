package fr.daart.y2022;

import fr.daart.AoC;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public abstract class AoC2022 extends AoC {

    @Override
    public int getYear() {
        return 2022;
    }
    protected Path getResourcePath(String filename) {
        try {

            String pathString = "./ex" + String.format("%02d", getDay()) + "/" + filename;
            var resource = AoC2022.class.getResource(pathString);
            var uri = resource.toURI();
            return Paths.get(uri);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
