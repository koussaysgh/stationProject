package com.models;

import java.util.List;

public class InputFile {
  private   List<Tap> taps;

    public InputFile() {
    }

    public List<Tap> getTaps() {
        return taps;
    }

    public void setTaps(List<Tap> taps) {
        this.taps = taps;
    }

    public InputFile(List<Tap> taps) {
        this.taps = taps;
    }

    @Override
    public String toString() {
        return "InputFile{" +
                "taps=" + taps +
                '}';
    }
}
