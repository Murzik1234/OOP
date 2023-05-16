package org.base32;
import org.example.Plugin;
import org.apache.commons.codec.binary.Base32;
public class Base32Plugin implements Plugin {

    @Override
    public String getExtension() {
        return ".base32";
    }

    @Override
    public String getName() {
        return "Base 32";
    }

    @Override
    public byte[] encode(byte[] value) {
        return new Base32().encode(value);
    }

    @Override
    public byte[] decode(byte[] value) {
        return new Base32().decode(value);
    }
}
