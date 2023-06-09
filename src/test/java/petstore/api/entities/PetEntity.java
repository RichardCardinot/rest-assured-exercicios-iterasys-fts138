package petstore.api.entities;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PetEntity {
    private int id;
    private CategoryEntity category;
    private String name;
    private ArrayList<String> photoUrls;
    private ArrayList<TagEntity> tags;
    private String status;

    public PetEntity() {
    }

    public PetEntity(int id, CategoryEntity category, String name, ArrayList<String> photoUrls, ArrayList<TagEntity> tags, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(ArrayList<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public ArrayList<TagEntity> getTags() {
        return tags;
    }

    public void setTags(ArrayList<TagEntity> tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
