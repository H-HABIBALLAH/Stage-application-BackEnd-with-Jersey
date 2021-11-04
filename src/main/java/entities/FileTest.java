package entities;

import java.io.Serializable;

public class FileTest implements Serializable {
    Long id;
    byte[] data;

    public FileTest(byte[] data) {
        this.id = id;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
