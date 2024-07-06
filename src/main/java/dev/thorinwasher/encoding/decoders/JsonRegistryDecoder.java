package dev.thorinwasher.encoding.decoders;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import dev.thorinwasher.Main;
import dev.thorinwasher.Registry;
import dev.thorinwasher.namespace.Keyed;
import dev.thorinwasher.namespace.ReversedNamespace;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.util.Collections;
import java.util.stream.Stream;

public class JsonRegistryDecoder {

    public static <T extends Keyed> Registry<T> parse(String location, Decoder<T> decoder) {
        try {
            Registry<T> registry = new Registry<>(ReversedNamespace.fromKey(location));
            URI uri = Main.class.getResource(location).toURI();
            if (uri.getScheme().equals("jar")) {
                try (FileSystem fileSystem = FileSystems.newFileSystem(uri, Collections.emptyMap())) {
                    try (Stream<Path> pathStream = Files.walk(fileSystem.getPath(location), 1)) {
                        insertIntoRegistry(pathStream, location, registry, decoder);
                    }
                }
            } else {
                try (Stream<Path> pathStream = Files.walk(Paths.get(uri), 1)) {
                    insertIntoRegistry(pathStream, location, registry, decoder);
                }
            }
            System.out.println(registry.keySet());
            return registry;
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static <T extends Keyed> T parseElement(String path, Decoder<T> decoder) {
        try (InputStream inputStream = Main.class.getResourceAsStream(path)) {
            if (inputStream == null) {
                throw new IOException("Could not find resource: " + path);
            }
            JsonElement element = JsonParser.parseReader(new InputStreamReader(inputStream));
            return decoder.parse(element.getAsJsonObject());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static <T extends Keyed> void insertIntoRegistry(Stream<Path> pathStream, String location, Registry<T> registry, Decoder<T> decoder) {
        pathStream.filter(path1 -> path1.toString().endsWith(".json"))
                .map(path1 -> location + "/" + path1.getFileName().toString())
                .forEach(pathString -> {
                    T keyed = parseElement(pathString, decoder);
                    registry.put(keyed.key(), keyed);
                });
    }

}
