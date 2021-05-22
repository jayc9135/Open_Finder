package com.jayc.opensource;

public class DescriptionModel {

    private String heading;
    private String description;
    private String descriptionImage;
    private String sourcecode;
    private String downloadlink;

    public DescriptionModel(String heading, String description, String image, String sourcecode, String downloadlink) {
        this.heading = heading;
        this.description = description;
        this.descriptionImage = image;
        this.sourcecode = sourcecode;
        this.downloadlink = downloadlink;
    }

    public DescriptionModel(String heading, String description) {
        this.heading = heading;
        this.description = description;
    }

    public DescriptionModel(String heading) {
        this.heading = heading;
    }

    public DescriptionModel() {
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionImage() {
        return descriptionImage;
    }

    public void setDescriptionImage(String descriptionImage) {
        this.descriptionImage = descriptionImage;
    }

    public String getSourcecode() {
        return sourcecode;
    }

    public void setSourcecode(String sourcecode) {
        this.sourcecode = sourcecode;
    }

    public String getDownloadlink() {
        return downloadlink;
    }

    public void setDownloadlink(String downloadlink) {
        this.sourcecode = downloadlink;
    }
}
