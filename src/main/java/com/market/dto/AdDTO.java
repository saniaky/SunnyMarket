package com.market.dto;

import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

/**
 * Created by saniaky on 7/3/14.
 */
public class AdDTO {

    private String title;
    private String text;
    private Set<String> tags;
    private Set<MultipartFile> images;

    public AdDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public Set<MultipartFile> getImages() {
        return images;
    }

    public void setImages(Set<MultipartFile> images) {
        this.images = images;
    }
}
