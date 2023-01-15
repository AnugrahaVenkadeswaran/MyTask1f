package com.example.mytask1;

public class ProductModel {
    private  String id;
    private String image;
    private String src;
    private String title;

    public ProductModel(String image, String title) {
        this.image=image;
        this.title=title;
        this.id=id;
        this.src=src;
    }

   // public int getImage() {
       // return image;
   // }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getImage() {
        return image;
    }
}