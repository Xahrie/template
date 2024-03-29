package net.mmm.mc.template.util.reflections.vfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class SystemFile implements File {
  private final SystemDir root;
  private final java.io.File file;

  SystemFile(final SystemDir root, java.io.File file) {
    this.root = root;
    this.file = file;
  }

  public String getName() {
    return file.getName();
  }

  public String getRelativePath() {
    final String filepath = file.getPath().replace("\\", "/");
    if (filepath.startsWith(root.getPath())) {
      return filepath.substring(root.getPath().length() + 1);
    }

    return null;
  }

  public InputStream openInputStream() {
    try {
      return new FileInputStream(file);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public String toString() {
    return file.toString();
  }
}
