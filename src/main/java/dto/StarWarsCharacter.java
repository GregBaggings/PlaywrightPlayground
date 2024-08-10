package dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StarWarsCharacter {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("height")
    @Expose
    private String height;
    @SerializedName("mass")
    @Expose
    private String mass;
    @SerializedName("hair_color")
    @Expose
    private String hairColor;
    @SerializedName("skin_color")
    @Expose
    private String skinColor;
    @SerializedName("eye_color")
    @Expose
    private String eyeColor;
    @SerializedName("birth_year")
    @Expose
    private String birthYear;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("homeworld")
    @Expose
    private String homeworld;
    @SerializedName("films")
    @Expose
    private List<String> films;
    @SerializedName("species")
    @Expose
    private List<String> species;
    @SerializedName("vehicles")
    @Expose
    private List<String> vehicles;
    @SerializedName("starships")
    @Expose
    private List<String> starships;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("edited")
    @Expose
    private String edited;
    @SerializedName("url")
    @Expose
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    public List<String> getFilms() {
        return films;
    }

    public void setFilms(List<String> films) {
        this.films = films;
    }

    public List<String> getSpecies() {
        return species;
    }

    public void setSpecies(List<String> species) {
        this.species = species;
    }

    public List<String> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<String> vehicles) {
        this.vehicles = vehicles;
    }

    public List<String> getStarships() {
        return starships;
    }

    public void setStarships(List<String> starships) {
        this.starships = starships;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getEdited() {
        return edited;
    }

    public void setEdited(String edited) {
        this.edited = edited;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(StarWarsCharacter.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null) ? "<null>" : this.name));
        sb.append(',');
        sb.append("height");
        sb.append('=');
        sb.append(((this.height == null) ? "<null>" : this.height));
        sb.append(',');
        sb.append("mass");
        sb.append('=');
        sb.append(((this.mass == null) ? "<null>" : this.mass));
        sb.append(',');
        sb.append("hairColor");
        sb.append('=');
        sb.append(((this.hairColor == null) ? "<null>" : this.hairColor));
        sb.append(',');
        sb.append("skinColor");
        sb.append('=');
        sb.append(((this.skinColor == null) ? "<null>" : this.skinColor));
        sb.append(',');
        sb.append("eyeColor");
        sb.append('=');
        sb.append(((this.eyeColor == null) ? "<null>" : this.eyeColor));
        sb.append(',');
        sb.append("birthYear");
        sb.append('=');
        sb.append(((this.birthYear == null) ? "<null>" : this.birthYear));
        sb.append(',');
        sb.append("gender");
        sb.append('=');
        sb.append(((this.gender == null) ? "<null>" : this.gender));
        sb.append(',');
        sb.append("homeworld");
        sb.append('=');
        sb.append(((this.homeworld == null) ? "<null>" : this.homeworld));
        sb.append(',');
        sb.append("films");
        sb.append('=');
        sb.append(((this.films == null) ? "<null>" : this.films));
        sb.append(',');
        sb.append("species");
        sb.append('=');
        sb.append(((this.species == null) ? "<null>" : this.species));
        sb.append(',');
        sb.append("vehicles");
        sb.append('=');
        sb.append(((this.vehicles == null) ? "<null>" : this.vehicles));
        sb.append(',');
        sb.append("starships");
        sb.append('=');
        sb.append(((this.starships == null) ? "<null>" : this.starships));
        sb.append(',');
        sb.append("created");
        sb.append('=');
        sb.append(((this.created == null) ? "<null>" : this.created));
        sb.append(',');
        sb.append("edited");
        sb.append('=');
        sb.append(((this.edited == null) ? "<null>" : this.edited));
        sb.append(',');
        sb.append("url");
        sb.append('=');
        sb.append(((this.url == null) ? "<null>" : this.url));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
