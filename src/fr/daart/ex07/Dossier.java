package fr.daart.ex07;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Dossier {

    private String name;
    private long sizeFichiers = 0L;
    private long sizeUnder = 0L;

    private Dossier parent = null;

    private int depth;

    private Map<String, Fichier> fichiers = new HashMap();
    private Map<String, Dossier> dossiers = new HashMap();


    public Dossier(String name, int depth, Dossier parent) {
        this.name = name;
        this.depth = depth;
        this.parent = parent;
    }

    public void putFichier(String sizeString, String fichierName) {
        if (fichiers.containsKey(fichierName)) {
            return;
        }
        fichiers.put(fichierName, new Fichier(fichierName, sizeString, depth));
        var fileSize = Long.valueOf(sizeString);
        sizeFichiers += fileSize;
    }

    public void putDossier(String dirName) {
        if (dossiers.containsKey(dirName)) {
            return;
        }
        dossiers.put(dirName, new Dossier(dirName, depth + 1, this));
    }

    public long getSize() {
        return getSizeUnder() + sizeFichiers;
    }

    private long getSizeUnder() {
        return dossiers
                .values()
                .stream()
                .map(d -> d.getSize())
                .reduce((a, b) -> a + b)
                .orElse(0L);
    }


    public Dossier goToDir(String dirName) {
        if (dossiers.containsKey(dirName)) {
            return dossiers.get(dirName);
        }
        return this;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();

        for (int i = 0; i < depth; i++) {
            sb.append("\t");
        }

        sb.append("- ").append(name).append(" (dir, size=").append(this.getSize()).append(")").append("\n");

        for (var fi : fichiers.values()) {
            sb.append("\t").append(fi.toString()).append("\n");
        }

        for (var ds : dossiers.values()) {
            sb.append(ds.toString()).append("\n");
        }

        return sb.toString();
    }

    public Dossier getParent() {
        return this.parent;
    }

    public Collection<Dossier> getSubDirs() {
        return dossiers.values();
    }
}
