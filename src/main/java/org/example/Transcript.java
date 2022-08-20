package org.example;

public class Transcript {

    private String id;
    private String audio_url;
    private String language_code;
    private String status;
    private String text;
    private String audio_duration;
    private String audio_end_at;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAudio_url() {
        return audio_url;
    }

    public void setAudio_url(String audio_url) {
        this.audio_url = audio_url;
    }

    public String getLanguage_code() {
        return language_code;
    }

    public void setLanguage_code(String language_code) {
        this.language_code = language_code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAudio_duration() {
        return audio_duration;
    }

    public void setAudio_duration(String audio_duration) {
        this.audio_duration = audio_duration;
    }

    public String getAudio_end_at() {
        return audio_end_at;
    }

    public void setAudio_end_at(String audio_end_at) {
        this.audio_end_at = audio_end_at;
    }
}
