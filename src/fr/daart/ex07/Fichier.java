package fr.daart.ex07;

public class Fichier {

    private String name;
    private long size;

    private int depth;

    public Fichier(String name, String size, int depth) {
        this.name = name;
        this.size = Long.valueOf(size);
        this.depth = depth;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("\t");
        }
        return sb.append("- ").append(name).append(" (file, size=").append(size).append(")").toString();
    }
}
