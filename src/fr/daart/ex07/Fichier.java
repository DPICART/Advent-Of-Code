package fr.daart.ex07;

public class Fichier {
    private final String name;
    private final long size;
    private final int depth;

    public Fichier(String name, String size, int depth) {
        this.name = name;
        this.size = Long.parseLong(size);
        this.depth = depth;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("\t".repeat(depth)).append("- ").append(name).append(" (file, size=").append(size).append(")").toString();
    }
}
